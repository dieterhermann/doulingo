package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoryPage {

    private WebDriver driver;
    private JSONObject worter;
    private By continueButton = By.className("continue");
    private String selector = "div>div.phrase>span:nth-child";
    private By ansverlist = By.cssSelector( "ul.challenge-answers li");
    private By tokenlist = By.cssSelector("ul.tokens li button");


    public StoryPage(WebDriver driver, int nrLesson) throws IOException, ParseException {
        this.driver = driver;
        initDictionar(nrLesson);
    }

    public void clickContinue(int nrClick){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        int i =0;
        for (i=1; i<=nrClick; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            driver.findElement(continueButton).click();
        }
    }

    public void clickCorrectAnsver(String ansver, int nthChild){
        List<WebElement> choises = driver.findElements(ansverlist);

        String spanChild = selector + "(" + nthChild + ")";
        By correct =  By.cssSelector(spanChild);

        for (WebElement choise : choises){

            try{
                if (choise.findElement(correct).getText().equals(ansver)) {
                    choise.findElement(correct).click();
                }
            }catch(NoSuchElementException e){
                System.out.println("no child 13");
            }catch(TimeoutException e){
                System.out.println("WebDriver couldn’t locate the element");
            }
        }
    }

    public void cklickButtonList(String [] buttons){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"phrase\"]/span[contains(text(),'" + buttons[0] + "')]")));

        for (String button : buttons){
            driver.findElement(By.xpath("//div[@class=\"phrase\"]/span[contains(text(),'" + button + "')]")).click();
        }
    }


    public void cklickPairs(){
        List<WebElement> tokens = driver.findElements(tokenlist);
        for (WebElement token : tokens) {
            String word = token.getText();
            if (worter.containsKey(word)){
                String wordTranslated = (String) worter.get(word);
                driver.findElement(By.xpath("//button[contains(text(),'" + word + "')]")).click();
                driver.findElement(By.xpath("//button[contains(text(),'" + wordTranslated + "')]")).click();
            }else{
                System.out.println(word );
            }
        }
    }

    private void initDictionar(int nrLesson) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/home/dieter/IdeaProjects/doulingo/src/test/java/resource/dictionar.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray lessonsList = (JSONArray)jsonObject.get("lessons");
        worter = (JSONObject) lessonsList.get(nrLesson);

    }
}
