package com.helper;

import com.data.enums.ClickOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Actions extends BaseHelp {
  public Actions(final WebDriver driver) {
    super(driver);
  }

  public void clickOnElement(By locator) {
    find(locator).click();
  }

  public void clickJS(By locator) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", find(locator));
  }

  public void scrollToElementJS(By locator) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", find(locator));
  }

  public void scrollToElementAndClick(By locator, ClickOptions option) {
    scrollToElementJS(locator);
    switch (option) {
      case JAVASCRIPT -> clickJS(locator);
      case SELENIUM -> clickOnElement(locator);
    }
  }

  public void clickOnCheckBox(By locator) {
    if (!find(locator).isSelected()) {
      scrollToElementAndClick(locator, ClickOptions.JAVASCRIPT);
    }
  }

  public void unClickOnCheckBox(By locator) {
    if (find(locator).isSelected()) {
      scrollToElementAndClick(locator, ClickOptions.JAVASCRIPT);
    }
  }

  public void setValueInField(By locator, String text) {
    find(locator).clear();
    find(locator).sendKeys(text);
  }

  public void selectByVisibleText(By locator, String visibleText) {
    scrollToElementJS(locator);
    findDropDown(locator).selectByContainsVisibleText(visibleText);
  }

  public void selectByHiddenValue(By locator, String hiddenValue) {
    scrollToElementJS(locator);
    findDropDown(locator).selectByValue(hiddenValue);
  }

  public void selectByIndex(By locator, Integer index) {
    scrollToElementJS(locator);
    findDropDown(locator).selectByIndex(index);
  }

  public void deSelectByVisibleText(By locator, String visibleText) {
    scrollToElementJS(locator);
    findDropDown(locator).deSelectByContainsVisibleText(visibleText);
  }

  public void deSelectByHiddenValue(By locator, String hiddenValue) {
    scrollToElementJS(locator);
    findDropDown(locator).deselectByValue(hiddenValue);
  }

  public void deSelectByIndex(By locator, Integer index) {
    scrollToElementJS(locator);
    findDropDown(locator).deselectByIndex(index);
  }
}
