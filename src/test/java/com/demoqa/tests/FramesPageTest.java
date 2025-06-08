package com.demoqa.tests;

import com.demoqa.pages.FramesPage;
import com.demoqa.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FramesPageTest extends BaseTest {
    protected FramesPage framesPage;

    @BeforeMethod(description = "Navigate user to FramesPage")
    public void userIsRedirectedToFramesPage() {
        homePage.actions.navigateToUrl(homePage.url);
        framesPage = homePage.transferToSpecificPage("Alerts", homePage.getSectionLocator("Frames"), FramesPage.class);
    }

    @Test(description = "Test FramesPage is displayed")
    public void testFramesPage() {
        assertTrue(framesPage.verifyFramesPage());
    }

    @Test(description = "Test Frame by string & id")
    public void testSwitchFrameByStringId() {
        assertTrue(framesPage.verifyFramesPage());
        framesPage.actions.switchToFrameByStringId("frame1");
        assertTrue(framesPage.assertions.verifyElementHasText(framesPage.frameTitle, "This is a sample page"));
        framesPage.actions.switchFromFrameToDocument();
    }

    @Test(description = "Test Frame by index")
    public void testSwitchFrameByIndex() {
        assertTrue(framesPage.verifyFramesPage());
        framesPage.actions.switchToFrameByIndex(2);
        assertTrue(framesPage.assertions.verifyElementHasText(framesPage.frameTitle, "This is a sample page"));
        framesPage.actions.switchFromFrameToDocument();
    }

    @Test(description = "Test Frame by WebElement")
    public void testSwitchFrameByWebElement() {
        assertTrue(framesPage.verifyFramesPage());
        framesPage.actions.switchToFrameByWebElement(framesPage.frame1);
        assertTrue(framesPage.assertions.verifyElementHasText(framesPage.frameTitle, "This is a sample page"));
        framesPage.actions.switchFromFrameToDocument();
    }

    @Test(description = "Test Switch & Back scenarios")
    public void testSwitchBackMultiple() {
        assertTrue(framesPage.verifyFramesPage());
        // Second Stage
        framesPage.actions.switchToFrameByIndex(3);
        assertTrue(framesPage.assertions.verifyElementHasText(framesPage.frameTitle, "This is a sample page"));
        framesPage.actions.switchFromFrameToDocument();
        // First Stage
        framesPage.actions.switchToFrameByStringId("frame2");
        assertTrue(framesPage.assertions.verifyElementHasText(framesPage.frameTitle, "This is a sample page"));
        framesPage.actions.switchFromFrameToDocument();
        // Third Stage
        framesPage.actions.switchToFrameByWebElement(framesPage.frame2);
        assertTrue(framesPage.assertions.verifyElementHasText(framesPage.frameTitle, "This is a sample page"));
        framesPage.actions.switchFromFrameToDocument();
    }
}
