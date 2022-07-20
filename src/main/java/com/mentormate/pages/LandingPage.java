package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    By loginLinkBy = By.id("nav-link-login");
    WebElement loginLink;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //explicit wait
        actions = new Actions(driver); //actions --> няколко actions едно след друго с точки

        driver.get("http://training.skillo-bg.com");
        loginLink = driver.findElement(loginLinkBy);
    }
    //init web elements methods
    public void loginLinkClick(){
        loginLink.click();
    }


    //Verification methods
    public boolean isLoginLinkDisplayed (){
        return loginLink.isDisplayed();
    }





}
