package com.demoqa.windows;

import com.demoqa.pages.TablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddModalWindow extends TablePage {
  // Locators
  public By title = By.id("registration-form-modal");
  public By window = By.className("modal-content");
  public By firstName = By.id("firstName");
  public By lastName = By.id("lastName");
  public By email = By.id("userEmail");
  public By age = By.id("age");
  public By salary = By.id("salary");
  public By department = By.id("department");
  public By submitBtn = By.id("submit");

  public AddModalWindow(WebDriver driver) {
    super(driver);
  }

  // Methods
  public boolean verifyAddModalWindow() {
    By[] locators = {window, title, firstName, lastName, email, age, salary, department, submitBtn};
    return assertions.verifyMultipleElementsAreDisplayed(locators);
  }

  public void fillAddRecordForm(
      String firstName,
      String lastName,
      String email,
      Integer age,
      Integer salary,
      String department) {
    actions.setValueInField(this.firstName, firstName);
    actions.setValueInField(this.lastName, lastName);
    actions.setValueInField(this.email, email);
    actions.setValueInField(this.age, Integer.toString(age));
    actions.setValueInField(this.salary, Integer.toString(salary));
    actions.setValueInField(this.department, department);
  }
}
