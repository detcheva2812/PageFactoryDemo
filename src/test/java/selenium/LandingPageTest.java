package selenium;

import com.mentormate.pages.LandingPage;
import com.mentormate.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest {
    public WebDriver driver;
    //    public Actions actions;
//    public WebDriverWait wait;
    LandingPage landingPage;
    LoginPage loginPage;



    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1600x900");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLandingPage() throws InterruptedException {

        Assert.assertTrue(landingPage.isLoginLinkDisplayed());

        landingPage.loginLinkClick();

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isSignInTxtDisplayed());
    }

}


