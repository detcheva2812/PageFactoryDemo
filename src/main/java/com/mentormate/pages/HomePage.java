package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    //By logoutLinkBy = By.xpath("//i[@class = 'fas fa-sign-out-alt fa-lg");
    @FindBy(xpath = "//i[@class = 'fas fa-sign-out-alt fa-lg']")
    public
    WebElement logoutLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        //logoutLink = driver.findElement(logoutLinkBy);
        PageFactory.initElements(driver, this);

    }

    //init web elements methods

    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }


}
