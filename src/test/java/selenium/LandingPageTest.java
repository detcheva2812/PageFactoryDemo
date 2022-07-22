package selenium;

import com.mentormate.pages.LandingPage;
import com.mentormate.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUpInTest() {

        landingPage = new LandingPage(driver);
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void testLandingPage(){

        Assert.assertTrue(landingPage.isLoginLinkDisplayed());

        landingPage.loginLinkClick();

        loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isSignInTxtDisplayed());
    }

}


