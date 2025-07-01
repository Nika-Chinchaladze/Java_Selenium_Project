package com.helper;

import com.data.enums.ClickOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

public class Actions extends BaseHelp {
  public Actions(final WebDriver driver) {
    super(driver);
  }

  public void navigateToUrl(String url) {
    driver.get(url);
  }

  public void clickOnElement(By locator) {
    wait.until(ExpectedConditions.elementToBeClickable(locator));
    find(locator).click();
  }

  public void clickJS(By locator) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", find(locator));
  }

  public void scrollToElementJS(By locator) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(locator));
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
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

  public void acceptAlert() {
    alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
  }

  public void dismissAlert() {
    alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.dismiss();
  }

  public void sendKeysToAlert(String promptText) {
    alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.sendKeys(promptText);
  }

  public void switchToFrameByStringId(String nameId) {
    driver.switchTo().frame(nameId);
  }

  public void switchToFrameByIndex(Integer index) {
    driver.switchTo().frame(index );
  }

  public void switchToFrameByWebElement(By locator) {
    driver.switchTo().frame(find(locator));
  }

  public void switchFromFrameToDocument() {
    driver.switchTo().parentFrame();
  }

  public String storeOriginalWindow() {
    return driver.getWindowHandle();
  }

  public void switchToNewWindow(String originalWindow) {
    Set<String> windowHandles = driver.getWindowHandles();
    for (String handle : windowHandles) {
      if (!handle.equals(originalWindow)) {
        driver.switchTo().window(handle);
        break;
      }
    }
  }

  public void switchBackToOriginalWindow(String originalWindow) {
    driver.switchTo().window(originalWindow);
  }

  public String getElementAttributeValue(By locator, String attributeName) {
    return find(locator).getDomAttribute(attributeName);
  }
}
