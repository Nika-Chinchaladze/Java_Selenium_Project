package com.demoqa.base;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  protected HomePage homePage;
  protected WebDriver driver;

  @BeforeClass
  public void setUp() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless=new");
    chromeOptions.addArguments("window-size=1920,1080");
    chromeOptions.addArguments("--slowMo=100");
    driver = new ChromeDriver(chromeOptions);
    homePage = new HomePage(driver);
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
