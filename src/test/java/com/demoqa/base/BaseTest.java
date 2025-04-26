package com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.utils.ErrorHandler;
import java.io.File;
import java.time.LocalDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

  @AfterMethod
  public void takeFailedResultScreenshot(ITestResult testResult) {
    if (ITestResult.FAILURE == testResult.getStatus()) {
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      File source = screenshot.getScreenshotAs(OutputType.FILE);
      File destination =
          new File(
              System.getProperty("user.dir")
                  + "/resources/screenshots/("
                  + LocalDate.now()
                  + ")-"
                  + testResult.getName()
                  + ".png");
      ErrorHandler.ExecuteLogic(() -> FileHandler.copy(source, destination));
      System.out.println("Screenshot Located At " + destination);
    }
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
