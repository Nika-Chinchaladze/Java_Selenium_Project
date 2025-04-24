package com.demoqa.pages;

import com.base.page.BasePage;
import com.data.enums.ClickOptions;
import com.demoqa.windows.AddModalWindow;
import com.demoqa.windows.EditModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage extends BasePage {
  // Locators
  public By title = By.cssSelector("h1.text-center");
  public By deleteIcon3 = By.id("delete-record-3");
  public By addBtn = By.id("addNewRecordButton");
  // Data
  protected String address = "//div[@class='rt-td' and normalize-space(text())='";

  public TablePage(WebDriver driver) {
    super(driver);
  }

  // Method
  public By getEditIconLocator(String email) {
    return By.xpath(address + email + "']/..//span[@title=\"Edit\"]");
  }

  public By getTableRowLocator(String value) {
    return By.xpath(address + value + "']/..");
  }

  public EditModalWindow openEditModalWindow(String email) {
    actions.scrollToElementAndClick(getEditIconLocator(email), ClickOptions.SELENIUM);
    return new EditModalWindow(driver);
  }

  public AddModalWindow openAddModalWindow() {
    actions.scrollToElementAndClick(addBtn, ClickOptions.SELENIUM);
    return new AddModalWindow(driver);
  }
}
