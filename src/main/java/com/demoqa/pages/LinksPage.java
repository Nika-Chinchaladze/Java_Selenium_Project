package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksPage extends BasePage {
  // Test Data
  public Integer statusCode = 400;
  public String message = "Bad Request";
  // Locators
  public By title = By.cssSelector("h1.text-center");
  public By badRequest = By.id("bad-request");
  public By linkResponse = By.id("linkResponse");

  public LinksPage(WebDriver driver) {
    super(driver);
  }
}
