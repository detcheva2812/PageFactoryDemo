package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;
    public FluentWait fluentWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //explicit wait

        fluentWait = new FluentWait(driver);
        fluentWait.pollingEvery(Duration.ofMillis(250)); //рефрешинг
        fluentWait.withTimeout(Duration.ofSeconds(15));
        //fluentWait.ignoring(NoSuchElementException.class);

        actions = new Actions(driver); //actions --> няколко actions едно след друго с точки
    }

//    public void waitVisibility(By elementBy){
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
//    }
//
//    public void click(By elementBy){
//        waitVisibility(elementBy);
//        driver.findElement(elementBy).click();
//    }
}
