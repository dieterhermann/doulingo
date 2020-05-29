package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.cssSelector("div._2MFWT [autocomplete=\"email\"]");
    private By passwordField = By.cssSelector("div._2MFWT [autocomplete=\"current-password\"]");
    private By submitButton = By.cssSelector("[data-test=\"register-button\"]");
    private String pageTitle = "Duolingo - The world's best way to learn German";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public MainPage clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.titleIs(pageTitle));
        return new MainPage(driver);
    }
}
