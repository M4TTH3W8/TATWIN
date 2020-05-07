package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.WebDriver;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pom.pom1;

public class PreviousTestCheck {
	//global variables for extent reports
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public String driverPath;
	public WebDriver driver;
	public pom1 pageObject;
	  @BeforeTest
	  public void beforeTest() {
		  //setting up the webdriver
		  //needs your own path to driver
		  driverPath = "C:\\Webdriver\\chromedriver-v81\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver", driverPath);
		  driver = new ChromeDriver();
		  driver.manage().window().setSize(new Dimension(1280,1024));
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      driver.get("https://worldoftanks.eu/pl/");
	      pageObject = new pom1(driver);
		  
		  //reporting properties
		  htmlReporter = new ExtentHtmlReporter("test-output//previoustests.html");
	      htmlReporter.config().setDocumentTitle("Excercise 4");
	      htmlReporter.config().setReportName("Automatic reports generation");
	      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	      htmlReporter.config().setTheme(Theme.STANDARD);

	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	      extent.setSystemInfo("User Name", "Mateusz Glowacki");
	  }
	  //positive test - based on pom shows error box when trying to login
  @Test
  public void test1() {
	  logger = extent.createTest("First test case");
	  String username1 = "test@test.com";
	  String password1 = "test";
	  pageObject.login();
	  pageObject.enterUsername(username1);
	  pageObject.enterPassword(password1);
	  pageObject.button();
	  pageObject.getResult();
	  Assert.assertTrue(true); 
  }
  //skip test - goes to google and searches webdriver
  @Test
  public void test2() {
	  logger = extent.createTest("Second test case");
		driver.get("https://google.pl/");
		driver.findElement(By.name("q")).sendKeys("Hello webdriver |!|");
		driver.findElement(By.id("gsr")).click();
		
	  throw new SkipException("skip");
  }
  //negative test - same test from test1 but one of the pom's has wrong xpath
  @Test
  public void test3() {
	  logger = extent.createTest("Third test case");
	  String username1 = "test@test.com";
	  String password1 = "test";
	  pageObject.login();
	  pageObject.enterUsername(username1);
	  pageObject.enterPassword(password1);
	  pageObject.buttons();
	  pageObject.getResult();
	  driver.close();
	  Assert.assertTrue(true); 
  }
  @AfterMethod
  public void getResult(ITestResult result) {
	  if (result.getStatus() == ITestResult.SUCCESS) {
		  logger.log(Status.PASS, "Succeed test case \""+ result.getName()+ "\"");
	  } else if (result.getStatus() == ITestResult.FAILURE) {
		  logger.log(Status.FAIL, "Failed test case \""+ result.getName()+ "\" Reason: " + result.getThrowable());
		  BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//need to put your own path
		  try {
			ImageIO.write(image, "png", new File("C:\\Users\\M4TTH3W\\eclipse-workspace\\TATWINCW4\\test-output\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  else if (result.getStatus() == ITestResult.SKIP) {
		  logger.log(Status.SKIP,  "Skipped test case \""+ result.getName());
	  }
  }
  @AfterTest
  public void afterTest() {	
		extent.flush();
  }

}
