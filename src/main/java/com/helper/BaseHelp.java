package com.helper;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelp {
  public static WebDriver driver;
  public static WebDriverWait wait;
  public static Alert alert;

  public BaseHelp(WebDriver driver) {
    BaseHelp.driver = driver;
    BaseHelp.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public WebElement find(By locator) {
    return driver.findElement(locator);
  }

  public List<WebElement> findMultiple(By locator) {
    return driver.findElements(locator);
  }

  public Select findDropDown(By locator) {
    return new Select(find(locator));
  }
}
