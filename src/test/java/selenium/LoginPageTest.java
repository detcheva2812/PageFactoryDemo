package selenium;

import com.mentormate.common.RetryAnalyzer;
import com.mentormate.common.Screenshot;
import com.mentormate.pages.HomePage;
import com.mentormate.pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    public LoginPage loginPage;
    public HomePage homePage;

    @BeforeMethod
    public void setUpInTest() {
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "target/surefire-reports", result.getName());
        }
    }
    @Test(retryAnalyzer =RetryAnalyzer.class)
    public void testLoginPage() {

        loginPage.login("dilianadet", "1234567"); //correct password is 123456, to make the test fail, change it

        homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
    }

//    @Test(retryAnalyzer =RetryAnalyzer.class)
//    public void Test1()
//    {
//        Assert.assertEquals(false, true);
//    }
//
//    @Test
//    public void Test2()
//    {
//        Assert.assertEquals(false, true);
//    }

}


