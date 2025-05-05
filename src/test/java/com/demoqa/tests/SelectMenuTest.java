package com.demoqa.tests;

import static org.testng.Assert.*;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.SelectMenuPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTest extends BaseTest {
  private SelectMenuPage selectMenuPage;

  @BeforeMethod(description = "transferToSelectMenuPage")
  public void testUserIsRedirectedToSelectMenuPage() {
    homePage.actions.navigateToUrl(homePage.url);
    assertTrue(homePage.verifyHomePage());
    selectMenuPage =
        homePage.transferToSpecificPage("Widgets", homePage.getSectionLocator("Select Menu"), SelectMenuPage.class);
    assertTrue(selectMenuPage.verifySelectMenuPage());
  }

  @AfterMethod(description = "slow downs the test execution")
  public void slowDownExecution() {
    selectMenuPage.waiters.delay(3000);
  }

  @Test(description = "Test - select by visible text")
  public void testSelectByTextOld() {
    selectMenuPage.actions.selectByVisibleText(selectMenuPage.oldSelect, "Blue");
    assertTrue(
        selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue"));
  }

  @Test(description = "Test - select by hidden value")
  public void testSelectByValueOld() {
    selectMenuPage.actions.selectByHiddenValue(selectMenuPage.oldSelect, "1");
    assertTrue(
        selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue"));
  }

  @Test(description = "Test - select by index")
  public void testSelectByIndexOld() {
    selectMenuPage.actions.selectByIndex(selectMenuPage.oldSelect, 1);
    assertTrue(
        selectMenuPage.assertions.verifyDropDownSelectedElement(selectMenuPage.oldSelect, "Blue"));
  }

  @Test(description = "Test - Select & Deselect & Verify")
  public void testSelectDeSelectVerify() {
    // By Visible Text - Done
    selectMenuPage.actions.selectByVisibleText(selectMenuPage.multiSelect, "Opel");
    assertTrue(
        selectMenuPage.assertions.verifyDropDownSelectedElement(
            selectMenuPage.multiSelect, "Opel"));
    selectMenuPage.actions.deSelectByVisibleText(selectMenuPage.multiSelect, "Opel");
    assertFalse(
        selectMenuPage.assertions.verifyDropDownSelectedElement(
            selectMenuPage.multiSelect, "Opel"));

    // By Hidden Value
    selectMenuPage.actions.selectByHiddenValue(selectMenuPage.multiSelect, "opel");
    assertTrue(
        selectMenuPage.assertions.verifyDropDownSelectedElement(
            selectMenuPage.multiSelect, "Opel"));
    selectMenuPage.actions.deSelectByHiddenValue(selectMenuPage.multiSelect, "opel");
    assertFalse(
        selectMenuPage.assertions.verifyDropDownSelectedElement(
            selectMenuPage.multiSelect, "Opel"));

    // By Index
    selectMenuPage.actions.selectByIndex(selectMenuPage.multiSelect, 2);
    assertTrue(
        selectMenuPage.assertions.verifyDropDownSelectedElement(
            selectMenuPage.multiSelect, "Opel"));
    selectMenuPage.actions.deSelectByIndex(selectMenuPage.multiSelect, 2);
    assertFalse(
        selectMenuPage.assertions.verifyDropDownSelectedElement(
            selectMenuPage.multiSelect, "Opel"));
  }

  @Test(description = "Test that value is not selected from drop-down list")
  public void testDropDownIsDeselected() {
    selectMenuPage.waiters.delay(2000);
  }
}
