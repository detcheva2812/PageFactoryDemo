package selenium;

import com.mentormate.pages.HomePage;
import com.mentormate.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public HomePage homePage;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--window-size=1600x900");
        //стандартно се използва 1920x1080

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Можем да използваме и това:
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //explicit wait
        actions = new Actions(driver); //actions --> няколко actions едно след друго с точки

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginPage() {

        loginPage.login("dilianadet", "123456");

        homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
    }

}


