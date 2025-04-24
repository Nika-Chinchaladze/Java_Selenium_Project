package com.demoqa.tests;

import static org.testng.Assert.*;

import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.PracticeFormPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("PracticeFormPageTest")
public class PracticeFormPageTest extends BaseTest {
  private PracticeFormPage practiceFormPage;

  @BeforeMethod(description = "navigateToPracticeFormPage")
  public void navigateToPracticeFormPage() {
    assertTrue(homePage.verifyHomePage());
    practiceFormPage =
        homePage.transferToSpecificPage("Forms", homePage.practiceForm, PracticeFormPage.class);
    assertTrue(
        practiceFormPage.assertions.verifyElementIsDisplayed(practiceFormPage.practiceFormTitle));
  }

  @Test(description = "testRadioButton")
  public void testRadioButton() {
    // Radio Button
    practiceFormPage.actions.scrollToElementAndClick(
        practiceFormPage.femaleRadioBtn, ClickOptions.JAVASCRIPT);
    assertTrue(
        practiceFormPage.assertions.verifyElementIsSelected(practiceFormPage.femaleRadioBtn));
  }

  @Test(description = "testCheckBox")
  public void testCheckBox() {
    // Check-Box
    practiceFormPage.actions.clickOnCheckBox(practiceFormPage.sportsCheckBox);
    assertTrue(
        practiceFormPage.assertions.verifyElementIsSelected(practiceFormPage.sportsCheckBox));
    practiceFormPage.actions.unClickOnCheckBox(practiceFormPage.sportsCheckBox);
    assertFalse(
        practiceFormPage.assertions.verifyElementIsSelected(practiceFormPage.sportsCheckBox));
  }
}
