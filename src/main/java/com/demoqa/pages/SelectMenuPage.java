package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectMenuPage extends BasePage {
  // Locators
  public By title = By.cssSelector("h1.text-center");
  public By oldSelect = By.id("oldSelectMenu");
  public By multiSelect = By.id("cars");

  // Constructor
  public SelectMenuPage(WebDriver driver) {
    super(driver);
  }

  // Assertions
  public boolean verifySelectMenuPage() {
    By[] locators = {title, oldSelect};
    return assertions.verifyMultipleElementsAreDisplayed(locators);
  }
}
