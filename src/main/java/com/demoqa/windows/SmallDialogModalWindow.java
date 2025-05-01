package com.demoqa.windows;

import com.demoqa.pages.ModalDialogPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SmallDialogModalWindow extends ModalDialogPage  {
    // Constructor
    public SmallDialogModalWindow(WebDriver driver) {
        super(driver);
    }

    // Locators
    By window = By.className("modal-content");
    By title = By.className("modal-title");
    By body = By.className("modal-body");
    By closeBtn = By.id("closeSmallModal");

    // Assertions
    public boolean verifySmallDialogModalWindow() {
        By[] locators = { window, title, body, closeBtn };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
