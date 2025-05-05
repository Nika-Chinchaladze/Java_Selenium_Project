package com.helper;

import java.util.List;
import java.util.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Assertions extends BaseHelp {
  public Assertions(final WebDriver driver) {
    super(driver);
  }

  public boolean verifyPageUrl(String url) {
    return driver.getCurrentUrl() == url;
  }

  public boolean verifyElementIsDisplayed(By locator) {
    return find(locator).isDisplayed();
  }

  public boolean verifyMultipleElementsAreDisplayed(By[] locators) {
    boolean result = true;
    for (By locator : locators) {
      result = verifyElementIsDisplayed(locator);
    }
    return result;
  }

  public boolean verifyElementIsNotDisplayed(By locator) {
    return findMultiple(locator).isEmpty();
  }

  public boolean verifyElementIsEnabled(By locator) {
    return find(locator).isEnabled();
  }

  public boolean verifyElementHasText(By locator, String text) {
    return find(locator).getText().contains(text);
  }

  public boolean verifyElementHasValue(By locator, String value) {
    return Objects.requireNonNull(find(locator).getDomAttribute("value")).contains(value);
  }

  public boolean verifyElementIsSelected(By locator) {
    return find(locator).isSelected();
  }

  public boolean verifyDropDownSelectedElement(By dropDownLocator, String elementContent) {
    List<WebElement> allSelectedElement = findDropDown(dropDownLocator).getAllSelectedOptions();
    List<String> allSelectedTextContent =
        allSelectedElement.stream().map(WebElement::getText).toList();
    return allSelectedTextContent.contains(elementContent);
  }

  public boolean verifyAlertByTextContent(String alertText) {
    alert = wait.until(ExpectedConditions.alertIsPresent());
    return alert.getText().contains(alertText);
  }
}
