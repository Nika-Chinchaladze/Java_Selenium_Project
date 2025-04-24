package com.demoqa.windows;

import com.demoqa.pages.TablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditModalWindow extends TablePage {
  // Locators
  public By window = By.cssSelector("div.modal-content");
  public By firstName = By.id("firstName");
  public By lastName = By.id("lastName");
  public By email = By.id("userEmail");
  public By age = By.id("age");
  public By salary = By.id("salary");
  public By department = By.id("department");
  public By submitBtn = By.id("submit");

  public EditModalWindow(WebDriver driver) {
    super(driver);
  }

  // Assertions
  public boolean verifyEditModalWindow() {
    By[] locators = {window, firstName, lastName, email, age, salary, department, submitBtn};
    return assertions.verifyMultipleElementsAreDisplayed(locators);
  }

  // Actions
  public void editRecord(
      String firstName, String lastName, Integer age, Integer salary, String department) {
    actions.setValueInField(this.firstName, firstName);
    actions.setValueInField(this.lastName, lastName);
    actions.setValueInField(this.age, Integer.toString(age));
    actions.setValueInField(this.salary, Integer.toString(salary));
    actions.setValueInField(this.department, department);
    actions.clickOnElement(submitBtn);
  }
}
