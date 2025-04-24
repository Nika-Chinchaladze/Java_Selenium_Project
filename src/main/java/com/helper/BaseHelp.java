package com.helper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseHelp {
  public static WebDriver driver;

  public BaseHelp(WebDriver driver) {
    Actions.driver = driver;
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
