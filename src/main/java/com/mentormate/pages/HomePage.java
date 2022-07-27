package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(xpath = "//i[@class = 'fas fa-sign-out-alt fa-lg']")
    public
    WebElement logoutLink;

    public HomePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
        //PageFactory.initElements(driver, HomePage.this); //other option (same thing)
    }

    //init web elements methods


    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }

}
