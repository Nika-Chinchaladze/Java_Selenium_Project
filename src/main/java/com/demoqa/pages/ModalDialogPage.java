package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ModalDialogPage extends BasePage {
    // Constructor
    public ModalDialogPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By smallModalBtn = By.id("showSmallModal");
    public By largeModalBtn = By.id("showLargeModal");

    // Assertions
    public boolean verifyModalDialogPage() {
        By[] locators = { title, smallModalBtn, largeModalBtn };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
