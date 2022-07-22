package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {
    @FindBy(id="nav-link-login")
    WebElement loginLink;

    public LandingPage(WebDriver driver) {
        super(driver);

        driver.get("http://training.skillo-bg.com");
        PageFactory.initElements(driver, this);
    }
    //init web elements methods
    public void loginLinkClick(){
        fluentWait.until(ExpectedConditions.elementToBeClickable(loginLink)); //just an example that we can use that with Fluent wait or explicit wait
        loginLink.click();
    }

    //Verification methods
    public boolean isLoginLinkDisplayed (){
        return loginLink.isDisplayed();
    }





}
