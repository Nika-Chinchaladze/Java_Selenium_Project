package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BasePage {
    // Constructor
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By newTabBtn = By.id("tabButton");
    public By newWindowBtn = By.id("windowButton");
    public By newWindowMessageBtn = By.id("messageWindowButton");

    // Assertions
    public boolean verifyBrowserWindowsPage() {
        By[] locators = { title, newTabBtn, newWindowBtn, newWindowMessageBtn };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
