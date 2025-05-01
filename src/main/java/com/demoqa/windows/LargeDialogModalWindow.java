package com.demoqa.windows;

import com.demoqa.pages.ModalDialogPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LargeDialogModalWindow extends ModalDialogPage {
    // Constructor
    public LargeDialogModalWindow(WebDriver driver) {
        super(driver);
    }

    // Locators
    By window = By.className("modal-content");
    By title = By.className("modal-title");
    By body = By.className("modal-body");
    By closeBtn = By.id("closeLargeModal");

    // Assertions
    public boolean verifyLargeDialogModalWindow() {
        By[] locators = { window, title, body, closeBtn };
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }
}
