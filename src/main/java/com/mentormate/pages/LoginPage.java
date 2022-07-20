package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    // By signInTxtBy = By.xpath("//p[text()='Sign in']");
    @FindBy(xpath = "//p[text()='Sign in']")
    WebElement signInTxt;

    //By usernameBy = By.xpath("//input[@id = 'defaultLoginFormUsername']");
    @FindBy(xpath = "//input[@id = 'defaultLoginFormUsername']")
    WebElement username;

    //By passwordBy = By.xpath("//input[@id = 'defaultLoginFormPassword']");
    @FindBy(xpath = "//input[@id = 'defaultLoginFormPassword']")
    WebElement password;

    //By signInBtnBy = By.xpath("//button[@id = 'sign-in-button']");
    @FindBy(xpath = "//button[@id = 'sign-in-button']")
    WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //explicit wait

        actions = new Actions(driver); //actions --> няколко actions едно след друго с точки

        driver.get("http://training.skillo-bg.com/users/login");
        //signInTxt = driver.findElement(signInTxtBy);

        PageFactory.initElements(driver, this);

    }

    //init web elements methods
    public void fillUsername(String userName){
        username.click();
        username.clear();
        username.sendKeys(userName);
    }

    public void fillPassword(String pass){
        password.click();
        password.clear();
        password.sendKeys(pass);

    }

    public void signInBtnClick() {
        signInBtn.click();
    }

    public void login(String userName, String pass){
        fillUsername(userName);
        fillPassword(pass);
        signInBtnClick();
    }


    //Verification methods
    public boolean isSignInTxtDisplayed() {
        return signInTxt.isDisplayed();
    }


}
