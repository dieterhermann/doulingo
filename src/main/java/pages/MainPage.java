package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private By stories = By.cssSelector("a[data-test=\"stories-nav\"]");
    private By storyList = By.className("story");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public StoriesPage gotoStories() {
        driver.navigate().to("https://stories.duolingo.com/?referrer=web_tab");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(storyList));
        return new StoriesPage(driver);
    }

}
