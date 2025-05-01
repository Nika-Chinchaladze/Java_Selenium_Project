package com.demoqa.pages;

import com.base.page.BasePage;
import com.data.enums.ClickOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
  // Locators
  public By cards = By.className("category-cards");
  public By practiceForm = By.xpath("//span[text()='Practice Form']");
  public By webTables = By.xpath("//span[text()='Web Tables']");
  public By links = By.xpath("//span[text()='Links']");
  public By selectMenu = By.xpath("//span[text()='Select Menu']");
  public By datePicker = By.xpath("//span[text()='Date Picker']");
  public By modalDialogs = By.xpath("//span[text()='Modal Dialogs']");

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
