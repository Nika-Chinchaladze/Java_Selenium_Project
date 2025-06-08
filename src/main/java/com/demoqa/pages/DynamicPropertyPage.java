package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class DynamicPropertyPage extends BasePage {
    public DynamicPropertyPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By visibleBtn = By.id("visibleAfter");

    // Methods
    public boolean verifyDynamicPropertyPage() {
        By[] locators = {title, visibleBtn};
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
