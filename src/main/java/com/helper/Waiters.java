package com.helper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class Waiters extends BaseHelp {
  private WebDriverWait explicitWaiter(int seconds) {
    return new WebDriverWait(driver, Duration.ofSeconds(seconds));
  }

  private FluentWait<WebDriver> fluentWaiter(int seconds) {
    return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(seconds))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);
  }

  public Waiters(final WebDriver driver) {
    super(driver);
  }

  public void delay(int milliSeconds) {
    try {
      Thread.sleep(milliSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitForNewTab() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(driver -> driver.getWindowHandles().size() > 1);
  }

  public void explicitWaitUntilVisible(By locator, int seconds) {
    explicitWaiter(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void explicitWaitUntilAttributeValue(By locator, String attributeName, String attributeValue, int seconds) {
    explicitWaiter(seconds).until(ExpectedConditions.attributeToBe(locator, attributeName, attributeValue));
  }

  public void fluentWaitUntilVisible(By locator, int seconds) {
    fluentWaiter(seconds).until(driver -> find(locator));
  }

  public void fluentWaitUntilAttributeValue(By locator, String attributeName, String attributeValue, int seconds) {
    fluentWaiter(seconds).until(ExpectedConditions.attributeToBe(locator, attributeName, attributeValue));
  }
}
