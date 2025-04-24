package com.helper;

import org.openqa.selenium.WebDriver;

public class Waiters extends BaseHelp {
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
}
