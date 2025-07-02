package com.demoqa.tests;

import com.demoqa.pages.AlertPage;
// import com.pojo.alert.AlertWrapper;
// import com.utils.JsonHandler;
import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
// import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AlertPageTest extends BaseTest {
    protected AlertPage alertPage;
    // protected AlertWrapper alertData;

    // @BeforeClass(description = "loads alert data")
    // public void loadAlertData() {
    //   alertData = JsonHandler.readJsonFile("src/test/java/com/demoqa/resources/alerts_test_data.json", AlertWrapper.class);
    // }

    @BeforeMethod(description = "Navigate user to alerts page")
    public void testUserIsRedirectedToAlertPage() {
        homePage.actions.navigateToUrl(homePage.url);
        assertTrue(homePage.verifyHomePage());
        alertPage = homePage.transferToSpecificPage("Alerts", homePage.getSectionLocator("Alerts"), AlertPage.class);
    }

    @Test
    public void verifyExecution() {
        System.out.println(">>>> TEST EXECUTED <<<<");
    }

    @Test(description = "Verify AlertPage is opened")
    public void testAlertPage() {
        assertTrue(alertPage.verifyAlertPage());
    }

    @Test(description = "Verify simple alert by text content")
    public void testSimpleAlert() {
        alertPage.actions.scrollToElementAndClick(alertPage.simpleAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                "You clicked a button"
        ));
        alertPage.actions.acceptAlert();
    }

    @Test(description = "Verify confirmation alert - Ok scenario")
    public void testConfirmationAlertPositive() {
        alertPage.actions.scrollToElementAndClick(alertPage.confirmAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                "Do you confirm action?"
        ));
        alertPage.actions.acceptAlert();
        assertTrue(alertPage.assertions.verifyElementHasText(
          alertPage.confirmationResult,
                "You selected Ok"
        ));
    }

    @Test(description = "Verify confirmation alert - Cancel scenario")
    public void testConfirmationAlertNegative() {
        alertPage.actions.scrollToElementAndClick(alertPage.confirmAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                "Do you confirm action?"
        ));
        alertPage.actions.dismissAlert();
        assertTrue(alertPage.assertions.verifyElementHasText(
          alertPage.confirmationResult,
                "You selected Cancel"
        ));
    }

    @Test(description = "Verify prompt alert - Ok scenario")
    public void testPromptAlertPositive() {
        alertPage.actions.scrollToElementAndClick(alertPage.promptAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
                "Please enter your name"
        ));
        alertPage.actions.sendKeysToAlert("By order of the peacky blinders");
        alertPage.actions.acceptAlert();
        assertTrue(alertPage.assertions.verifyElementHasText(
          alertPage.promptResult,
                "By order of the peacky blinders"
        ));
    }

    @Test(description = "Verify prompt alert - Cancel scenario")
    public void testPromptAlertNegative() {
        alertPage.actions.scrollToElementAndClick(alertPage.promptAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent("Please enter your name"));
        alertPage.actions.dismissAlert();
        assertTrue(alertPage.assertions.verifyElementIsNotDisplayed(alertPage.promptResult));
    }
}
