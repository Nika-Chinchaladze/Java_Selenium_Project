package com.demoqa.base;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected HomePage homePage;
  protected String url = "https://demoqa.com/";
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @BeforeMethod
  public void loadApplication() {
    driver.get(url);
    homePage = new HomePage(driver);
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
