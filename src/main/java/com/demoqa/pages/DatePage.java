package com.demoqa.pages;

import com.base.page.BasePage;
import com.data.enums.ClickOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class DatePage extends BasePage {
    // Constructor
    public DatePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By title = By.cssSelector("h1.text-center");
    public By date = By.id("datePickerMonthYearInput");
    public By time = By.id("dateAndTimePickerInput");
    public By calendar = By.cssSelector("div.react-datepicker__month-container");
    public By monthDropDown = By.cssSelector("select.react-datepicker__month-select");
    public By yearDropDown = By.cssSelector("select.react-datepicker__year-select");

    // Assertions
    public boolean verifyDatePage() {
        By[] locators = {title, date, time};
        return assertions.verifyMultipleElementsAreDisplayed(locators);
    }

    // Actions
    public void chooseDayFromCalendar(Integer day) {
        // We need logic for repeated day number, when it resolves 2 values
        By dayLocator = By.xpath(
"//div[@class='react-datepicker__month']//div[@class='react-datepicker__week']//div[text()='" + Integer.toString(day) + "']"
        );
        actions.scrollToElementAndClick(dayLocator, ClickOptions.SELENIUM);
    }
}
