package com.demoqa.tests;

import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.DatePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DatePageTest extends BaseTest {
  private DatePage datePage;

  @BeforeMethod(description = "Navigate user to Date Picker Page")
  public void testDatePage() {
    assertTrue(homePage.verifyHomePage());
    datePage = homePage.transferToSpecificPage("Widgets", homePage.datePicker, DatePage.class);
    assertTrue(datePage.verifyDatePage());
  }

  @Test(description = "Test date functionality")
  public void testDateFunctionality() {
    datePage.actions.scrollToElementAndClick(datePage.date, ClickOptions.SELENIUM);
    assertTrue(datePage.assertions.verifyElementIsDisplayed(datePage.calendar));
    datePage.actions.selectByVisibleText(datePage.monthDropDown, "May");
    datePage.actions.selectByVisibleText(datePage.yearDropDown, "1997");
    datePage.chooseDayFromCalendar(31);
    assertTrue(datePage.assertions.verifyElementIsNotDisplayed(datePage.calendar));
    assertTrue(datePage.assertions.verifyElementHasValue(datePage.date, "05/31/1997"));
    datePage.waiters.delay(2000);
  }
}
