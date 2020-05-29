package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class StoriesPage {
    private WebDriver driver;
    private By storyTitle = By.className("story");

     public StoriesPage(WebDriver driver){
         this.driver =  driver;
     }

     public StoryPage storyClick(int storyNr) throws IOException, ParseException {
         List<WebElement> storyList = driver.findElements(storyTitle);
         storyList.get(storyNr).click();
         return new StoryPage(driver, storyNr);
     }
}
