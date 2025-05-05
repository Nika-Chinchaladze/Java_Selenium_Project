package com.demoqa.pages;

import com.base.page.BasePage;
import com.data.enums.ClickOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
  // Locators
  public By cards = By.className("category-cards");
  public String url = "https://demoqa.com/";

  // Constructor
  public HomePage(WebDriver driver) {
    super(driver);
  }

  // Assertions
  public boolean verifyHomePage() {
    return assertions.verifyElementIsDisplayed(cards);
  }

  // Actions
  protected By getCardLocator(String cardName) {
    return By.xpath("//h5[contains(text(), '" + cardName + "')]");
  }

  public By getSectionLocator(String sectionName) {
    return By.xpath("//span[text()='" + sectionName + "']");
  }

  public <T> T transferToSpecificPage(String cardName, By element, Class<T> pageClassName) {
    actions.scrollToElementAndClick(getCardLocator(cardName), ClickOptions.SELENIUM);
    actions.scrollToElementAndClick(element, ClickOptions.SELENIUM);
    try {
      return pageClassName.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    } catch (Exception e) {
      throw new RuntimeException("Failed to instantiate page: " + pageClassName.getSimpleName(), e);
    }
  }
}
