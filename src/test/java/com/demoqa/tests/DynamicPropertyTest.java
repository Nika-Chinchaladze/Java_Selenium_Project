package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.pages.DynamicPropertyPage;
import static org.testng.Assert.*;

public class DynamicPropertyTest extends BaseTest {
    private DynamicPropertyPage dynamicPropertyPage;

    @BeforeMethod(description = "Navigate user to Dynamic Properties Page")
    public void transferUserToDynamicPropertiesPage() {
        homePage.actions.navigateToUrl(homePage.url);
        assertTrue(homePage.verifyHomePage());
        dynamicPropertyPage = homePage.transferToSpecificPage("Elements", homePage.getSectionLocator("Dynamic Properties"), DynamicPropertyPage.class);
    }

    @Test(description = "Verify Dynamic Properties Page - Explicit Waiter")
    public void testDynamicPropertyPageExplicitWait() {
        dynamicPropertyPage.waiters.explicitWaitUntilVisible(dynamicPropertyPage.visibleBtn);
        assertTrue(dynamicPropertyPage.verifyDynamicPropertyPage());
    }

    @Test(description = "Verify Dynamic Properties Page - Fluent Waiter")
    public void testDynamicPropertyPageFluentWait() {
        dynamicPropertyPage.waiters.fluentWaitUntilVisible(dynamicPropertyPage.visibleBtn);
        assertTrue(dynamicPropertyPage.verifyDynamicPropertyPage());
    }
}
