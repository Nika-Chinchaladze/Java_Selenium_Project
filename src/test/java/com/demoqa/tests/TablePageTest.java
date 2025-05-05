package com.demoqa.tests;

import static org.testng.Assert.*;

import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.TablePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("TablePageTest")
public class TablePageTest extends BaseTest {
  private TablePage tablePage;

  @BeforeMethod(description = "navigateToTablePage")
  public void testUserIsRedirectedToTablePage() {
    homePage.actions.navigateToUrl(homePage.url);
    assertTrue(homePage.verifyHomePage());
    tablePage = homePage.transferToSpecificPage("Elements", homePage.getSectionLocator("Web Tables"), TablePage.class);
    assertTrue(tablePage.assertions.verifyElementIsDisplayed(tablePage.title));
  }

  @Test(description = "testWebTableDelete")
  public void testWebTableDelete() {
    tablePage.actions.clickOnElement(tablePage.deleteIcon3);
    assertTrue(tablePage.assertions.verifyElementIsNotDisplayed(tablePage.deleteIcon3));
    tablePage.waiters.delay(2000);
  }

  @Test(description = "testWebTableEdit")
  public void testWebTableEdit() {
    var editModalWindow = tablePage.openEditModalWindow("cierra@example.com");
    assertTrue(editModalWindow.verifyEditModalWindow());
    editModalWindow.editRecord("Tommy", "Shelby", 27, 1500, "AQA");
    assertTrue(
        tablePage.assertions.verifyElementIsDisplayed(tablePage.getTableRowLocator("Tommy")));
    tablePage.waiters.delay(3000);
  }

  @Test(description = "testWebTablesAdd")
  public void testWebTablesAdd() {
    var addModalWindow = tablePage.openAddModalWindow();
    addModalWindow.verifyAddModalWindow();
    addModalWindow.fillAddRecordForm("Artur", "Shelby", "artur@gmail.com", 30, 2000, "Gangster");
    assertTrue(addModalWindow.assertions.verifyElementHasValue(addModalWindow.firstName, "Artur"));
    assertTrue(addModalWindow.assertions.verifyElementHasValue(addModalWindow.lastName, "Shelby"));
    assertTrue(
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.email, "artur@gmail.com"));
    assertTrue(
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.age, Integer.toString(30)));
    assertTrue(
        addModalWindow.assertions.verifyElementHasValue(
            addModalWindow.salary, Integer.toString(2000)));
    assertTrue(
        addModalWindow.assertions.verifyElementHasValue(addModalWindow.department, "Gangster"));

    addModalWindow.actions.scrollToElementAndClick(addModalWindow.submitBtn, ClickOptions.SELENIUM);
    assertTrue(
        tablePage.assertions.verifyElementIsDisplayed(
            tablePage.getTableRowLocator("artur@gmail.com")));
    tablePage.waiters.delay(3000);
  }
}
