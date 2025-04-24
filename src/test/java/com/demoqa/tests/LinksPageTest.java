package com.demoqa.tests;

import static org.testng.Assert.assertTrue;

import com.data.enums.ClickOptions;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.LinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksPageTest extends BaseTest {
  private LinksPage linksPage;

  @BeforeMethod(description = "navigateToLinksPage")
  public void navigateToLinksPage() {
    assertTrue(homePage.verifyHomePage());
    linksPage = homePage.transferToSpecificPage("Elements", homePage.links, LinksPage.class);
    assertTrue(linksPage.assertions.verifyElementIsDisplayed(linksPage.title));
    assertTrue(linksPage.assertions.verifyElementIsEnabled(linksPage.badRequest));
  }

  @Test(description = "Tests Bad Request scenario")
  public void testBadRequest() {
    linksPage.actions.scrollToElementAndClick(linksPage.badRequest, ClickOptions.JAVASCRIPT);
    linksPage.waiters.delay(1000);
    assertTrue(linksPage.assertions.verifyElementIsDisplayed(linksPage.linkResponse));
    assertTrue(
        linksPage.assertions.verifyElementHasText(
            linksPage.linkResponse, Integer.toString(linksPage.statusCode)));
    assertTrue(
        linksPage.assertions.verifyElementHasText(linksPage.linkResponse, linksPage.message));
    linksPage.waiters.delay(2000);
  }
}
