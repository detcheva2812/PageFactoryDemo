package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//p[text()='Sign in']")
    WebElement signInTxt;

    @FindBy(xpath = "//input[@id = 'defaultLoginFormUsername']")
    WebElement username;

    @FindBy(xpath = "//input[@id = 'defaultLoginFormPassword']")
    WebElement password;

    @FindBy(xpath = "//button[@id = 'sign-in-button']")
    WebElement signInBtn;


    public LoginPage(WebDriver driver) {
        super(driver);

        driver.get("http://training.skillo-bg.com/users/login");

        PageFactory.initElements(driver, this);

    }

    //init web elements methods
    public void fillUsername(String userName) {
        username.click();
        username.clear();
        username.sendKeys(userName);
    }

    public void fillPassword(String pass) {
        password.click();
        password.clear();
        password.sendKeys(pass);

    }

    public void signInBtnClick() {
        //fluentWait.until(ExpectedConditions.elementToBeClickable(signInBtn)); //just an example that we can use that with Fluent wait or explicit wait
        signInBtn.click();
    }

    public void login(String userName, String pass) {
        fillUsername(userName);
        fillPassword(pass);
        signInBtnClick();
    }


    //Verification methods
    public boolean isSignInTxtDisplayed() {
        return signInTxt.isDisplayed();
    }


}
