package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By haveAccountclick = By.linkText("I ALREADY HAVE AN ACCOUNT");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage haveAccountclick(){
        driver.findElement(haveAccountclick).click();
        return new LoginPage(driver);
    }
}
