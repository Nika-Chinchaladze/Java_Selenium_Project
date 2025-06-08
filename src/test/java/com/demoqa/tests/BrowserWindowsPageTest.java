package com.demoqa.tests;

import com.data.enums.ClickOptions;
import com.demoqa.pages.BrowserWindowsPage;
import com.demoqa.suites.BrowserWindowsBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BrowserWindowsPageTest extends BrowserWindowsBaseTest {
    protected BrowserWindowsPage browserWindowsPage;

    @BeforeMethod(description = "Navigates user to BrowserWindowsPage")
    public void testUserIsRedirectedToBrowserWindowsPage() {
        homePage.actions.navigateToUrl(homePage.url);
        browserWindowsPage = homePage.transferToSpecificPage("Alerts", homePage.getSectionLocator("Browser Windows"), BrowserWindowsPage.class);
        assertTrue(browserWindowsPage.verifyBrowserWindowsPage());
    }

    @Test(description = "Test new tab window")
    public void testNewTabWindow() {
        String originalWindow = browserWindowsPage.actions.storeOriginalWindow();
        browserWindowsPage.actions.scrollToElementAndClick(browserWindowsPage.newTabBtn, ClickOptions.SELENIUM);
        browserWindowsPage.waiters.waitForNewTab();
        browserWindowsPage.actions.switchToNewWindow(originalWindow);
        assertTrue(newTabWindow.assertions.verifyElementIsDisplayed(newTabWindow.title));
        assertTrue(newTabWindow.assertions.verifyElementHasText(newTabWindow.title, "This is a sample page"));
        browserWindowsPage.actions.switchBackToOriginalWindow(originalWindow);
    }
}
