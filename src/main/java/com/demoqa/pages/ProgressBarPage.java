package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgressBarPage extends BasePage {
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    // Variables
    public String attributeName = "aria-valuenow";
    public String attributeValue = "100";

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By progressBar = By.cssSelector("div[role='progressbar']");
    public By startBtn = By.id("startStopButton");

    // Methods
    public boolean verifyProgressBarPage() {
        By[] locators = { title, startBtn };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
