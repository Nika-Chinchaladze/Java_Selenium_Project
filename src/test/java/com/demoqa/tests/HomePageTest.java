package com.demoqa.tests;

import static org.testng.Assert.*;

import com.demoqa.base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("HomePageTest")
public class HomePageTest extends BaseTest {
  @Test(description = "testHomePage")
  public void testHomePage() {
    homePage.waiters.delay(2000);
    assertTrue(homePage.verifyHomePage());
  }
}
