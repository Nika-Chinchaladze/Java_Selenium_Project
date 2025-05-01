package com.demoqa.tests;

import com.data.enums.ClickOptions;
import com.demoqa.suites.ModalPageBaseTest;
import com.demoqa.pages.ModalDialogPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ModalPageTest extends ModalPageBaseTest {
    private ModalDialogPage modalDialogPage;

    @BeforeMethod(description = "Navigate user to ModalPage")
    public void navigateToModalPage() {
        modalDialogPage = homePage.transferToSpecificPage("Alerts", homePage.modalDialogs, ModalDialogPage.class);
    }

    @Test(description = "Test ModalPage is opened and elements are displayed")
    public void testModalPage() {
        assertTrue(modalDialogPage.verifyModalDialogPage());
    }

    @Test(description = "Test Small Modal window")
    public void testSmallModalWindow() {
        modalDialogPage.actions.scrollToElementAndClick(modalDialogPage.smallModalBtn, ClickOptions.SELENIUM);
        assertTrue(smallDialogModalWindow.verifySmallDialogModalWindow());
    }

    @Test(description = "Test Large Modal window")
    public void testLargeModalWindow() {
        modalDialogPage.actions.scrollToElementAndClick(modalDialogPage.largeModalBtn, ClickOptions.SELENIUM);
        assertTrue(largeDialogModalWindow.verifyLargeDialogModalWindow());
    }
}
