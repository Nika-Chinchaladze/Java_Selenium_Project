package com.demoqa.tests;

import com.demoqa.pages.AlertPage;
import com.pojo.alert.AlertWrapper;
import com.utils.JsonHandler;
import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AlertPageTest extends BaseTest {
    protected AlertPage alertPage;
    protected AlertWrapper alertData;

    @BeforeClass(description = "loads alert data")
    public void loadAlertData() {
        alertData = JsonHandler.readJsonFile("src/test/java/com/demoqa/resources/alerts_test_data.json", AlertWrapper.class);
    }

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
          alertData.getAlerts().getSimpleAlert().getQuestion()
        ));
        alertPage.actions.acceptAlert();
    }

    @Test(description = "Verify confirmation alert - Ok scenario")
    public void testConfirmationAlertPositive() {
        alertPage.actions.scrollToElementAndClick(alertPage.confirmAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
          alertData.getAlerts().getConfirmationAlert().getQuestion()
        ));
        alertPage.actions.acceptAlert();
        assertTrue(alertPage.assertions.verifyElementHasText(
          alertPage.confirmationResult,
          alertData.getAlerts().getConfirmationAlert().getTextOk()
        ));
    }

    @Test(description = "Verify confirmation alert - Cancel scenario")
    public void testConfirmationAlertNegative() {
        alertPage.actions.scrollToElementAndClick(alertPage.confirmAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
          alertData.getAlerts().getConfirmationAlert().getQuestion()
        ));
        alertPage.actions.dismissAlert();
        assertTrue(alertPage.assertions.verifyElementHasText(
          alertPage.confirmationResult,
          alertData.getAlerts().getConfirmationAlert().getTextCancel()
        ));
    }

    @Test(description = "Verify prompt alert - Ok scenario")
    public void testPromptAlertPositive() {
        alertPage.actions.scrollToElementAndClick(alertPage.promptAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(
          alertData.getAlerts().getPromptAlert().getQuestion()
        ));
        alertPage.actions.sendKeysToAlert(alertData.getAlerts().getPromptAlert().getValue());
        alertPage.actions.acceptAlert();
        assertTrue(alertPage.assertions.verifyElementHasText(
          alertPage.promptResult,
          alertData.getAlerts().getPromptAlert().getValue()
        ));
    }

    @Test(description = "Verify prompt alert - Cancel scenario")
    public void testPromptAlertNegative() {
        alertPage.actions.scrollToElementAndClick(alertPage.promptAlertBtn, ClickOptions.SELENIUM);
        assertTrue(alertPage.assertions.verifyAlertByTextContent(alertData.getAlerts().getPromptAlert().getQuestion()));
        alertPage.actions.dismissAlert();
        assertTrue(alertPage.assertions.verifyElementIsNotDisplayed(alertPage.promptResult));
    }
}
