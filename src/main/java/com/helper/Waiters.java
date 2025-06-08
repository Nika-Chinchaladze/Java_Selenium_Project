package com.helper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class Waiters extends BaseHelp {
  private WebDriverWait explicitWaiter() {
    return new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  private FluentWait<WebDriver> fluentWaiter() {
    return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
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

  public void explicitWaitUntilVisible(By locator) {
    explicitWaiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void fluentWaitUntilVisible(By locator) {
    fluentWaiter().until(driver -> find(locator));
  } // Progress Bar
}
