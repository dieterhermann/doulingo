package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions chrome_option = new ChromeOptions();
        chrome_option.addArguments("--disable-notifications");

        driver = new ChromeDriver(chrome_option);
        driver.get("https://www.duolingo.com");
        homePage = new HomePage(driver);
    }
/*
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
*/
}
