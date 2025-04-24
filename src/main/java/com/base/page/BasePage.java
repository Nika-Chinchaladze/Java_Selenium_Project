package com.base.page;

import com.helper.Actions;
import com.helper.Assertions;
import com.helper.Waiters;
import org.openqa.selenium.WebDriver;

public class BasePage {
  public WebDriver driver;
  public Actions actions;
  public Assertions assertions;
  public Waiters waiters;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
    this.assertions = new Assertions(driver);
    this.waiters = new Waiters(driver);
  }
}
