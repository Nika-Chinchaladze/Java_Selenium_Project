package com.demoqa.windows;

import com.base.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTabWindow extends BasePage {
    // Constructor
    public NewTabWindow(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.id("sampleHeading");
}
