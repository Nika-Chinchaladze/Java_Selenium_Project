package com.demoqa.pages;

import com.base.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage {
  // Locators
  public By practiceFormTitle = By.xpath("//h1[text()=\"Practice Form\"]");
  public By femaleRadioBtn = By.cssSelector("input#gender-radio-2.custom-control-input");
  public By sportsCheckBox = By.cssSelector("input#hobbies-checkbox-1.custom-control-input");

  public PracticeFormPage(WebDriver driver) {
    super(driver);
  }
}
