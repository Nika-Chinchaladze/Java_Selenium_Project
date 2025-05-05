package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {
    // Constructor
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By simpleAlertBtn = By.id("alertButton");
    public By confirmAlertBtn = By.id("confirmButton");
    public By promptAlertBtn = By.id("promtButton");
    public By confirmationResult = By.id("confirmResult");
    public By promptResult = By.id("promptResult");

    // Assertions
    public boolean verifyAlertPage() {
        By[] locators = { title, simpleAlertBtn, confirmAlertBtn, promptAlertBtn };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
