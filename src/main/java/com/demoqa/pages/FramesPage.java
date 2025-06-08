package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class FramesPage extends BasePage {
    // Constructor
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By frame1 = By.id("frame1");
    public By frame2 = By.id("frame2");
    public By frameTitle = By.id("sampleHeading");

    // Assertions
    public boolean verifyFramesPage() {
        By[] locators = { title, frame1, frame2 };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
