package com.demoqa.tests;

import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.ProgressBarPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProgressBarTest extends BaseTest {
    ProgressBarPage progressBarPage;

    @BeforeMethod(description = "Navigate user to Progress Bar Page")
    public void transferUserToProgressBarPage() {
        homePage.actions.navigateToUrl(homePage.url);
        assertTrue(homePage.verifyHomePage());
        progressBarPage = homePage.transferToSpecificPage("Widgets", homePage.getSectionLocator("Progress Bar"), ProgressBarPage.class);
    }

    @Test(description = "Test progress Bar - Explicit waiter")
    public void testProgressBarExplicitWait() {
        assertTrue(progressBarPage.verifyProgressBarPage());
        progressBarPage.actions.scrollToElementAndClick(progressBarPage.startBtn, ClickOptions.SELENIUM);
        progressBarPage.waiters.explicitWaitUntilAttributeValue(
                progressBarPage.progressBar,
                progressBarPage.attributeName,
                progressBarPage.attributeValue,
                30
        );
        assertTrue(progressBarPage.assertions.verifyAttributeValue(
                progressBarPage.progressBar,
                progressBarPage.attributeName,
                progressBarPage.attributeValue
        ));
    }

    @Test(description = "Test progress Bar - Fluent waiter")
    public void testProgressBarFluentWait() {
        assertTrue(progressBarPage.verifyProgressBarPage());
        progressBarPage.actions.scrollToElementAndClick(progressBarPage.startBtn, ClickOptions.SELENIUM);
        progressBarPage.waiters.fluentWaitUntilAttributeValue(
                progressBarPage.progressBar,
                progressBarPage.attributeName,
                progressBarPage.attributeValue,
                30
        );
        assertTrue(progressBarPage.assertions.verifyAttributeValue(
                progressBarPage.progressBar,
                progressBarPage.attributeName,
                progressBarPage.attributeValue
        ));
    }
}
