package project;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import poms.MainWebsite;
import poms.Login;

public class WotLogin {
	//global variables for extent reports
		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public ExtentTest logger;
		public String driverPath;
		public WebDriver driver;
		public MainWebsite pageObject;
		public Login log;
		
		
		
@BeforeTest
	  public void beforeTest() {
		  //setting up the webdriver
		  //needs your own path to driver
		  driverPath = "C:\\Webdriver\\chromedriver-v83\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver", driverPath);
		  driver = new ChromeDriver();
		  //driver.manage().window().setSize(new Dimension(1280,1024));
		  driver.manage().window().maximize();
	      driver.get("https://worldoftanks.eu/pl/");
	      pageObject = new MainWebsite(driver);
	      log = new Login(driver);
	      
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      
		  //reporting properties
		  htmlReporter = new ExtentHtmlReporter("test-output//wotlogin.html");
	      htmlReporter.config().setDocumentTitle("TATWIN - Project");
	      htmlReporter.config().setReportName("Automatic reports generation");
	      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	      htmlReporter.config().setTheme(Theme.STANDARD);

	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	      extent.setSystemInfo("User Name", "Mateusz Glowacki");		  
	  }
//first test case - entering main website, and proceeding to the login site
@Test(priority=1)
	  public void Testoflog() {
		logger = extent.createTest("First test case");
		pageObject.gologin();
		Assert.assertTrue(true);
	  }
//Second test case - We try to login without password data
@Test(priority=2)
	public void loginfail() {
	logger = extent.createTest("Second test case");
	String loginff = "mati8840@wp.pl";
	log.loginf(loginff);
	String passff = "";
	log.passf(passff);
	log.logbutton();
	String err = log.loginfail();
	System.out.println(err);
	Assert.assertTrue(true);
}
//Third test case - We try to login without login data
@Test(priority=2)
	public void loginfail2() {
	logger = extent.createTest("Third test case");
	String loginff = "";
	log.loginf(loginff);
	String passff = "test";
	log.passf(passff);
	log.logbutton();
	String err1 = log.loginfail();
	System.out.println(err1);
	Assert.assertTrue(true);
}
//Fourth test case - We try to login using wrong data
@Test(priority=2)
	public void loginfail3() {
	logger = extent.createTest("Fourth test case");
	String loginff = "mati8840@wp.pl";
	log.loginf(loginff);
	String passff = "test";
	log.passf(passff);
	log.logbutton();
	String err1 = log.loginfail();
	System.out.println(err1);
	Assert.assertTrue(true);
}
//Fifth test case - We login correctly - Uses prio3 as its necessary for further part of the testing
@Test(priority=3)
	public void logincorrect() throws InterruptedException {
	logger = extent.createTest("Fifth test case");
//it was needed as selenium tries to paste login too fast resulting in errors
	Thread.sleep(1000);
	String loginff = "nmngzjuifraodwmgpo@awdrt.com";
	log.loginf(loginff);
	String passff = "wottatwin123";
	log.passf(passff);
	log.logbutton();
	Assert.assertTrue(true);
}
//Sixth test case - we enter manage account site - prio4
@Test(priority=4)
public void manage() {
	logger = extent.createTest("Sixth test case");
	log.userna();
	log.manage();
	Assert.assertTrue(true);
}
//Seventh test case - we print data on management site
@Test(priority=5)
public void data() {
	logger = extent.createTest("Seventh test case");
	String account = log.accname();
	String miejsc = log.miejsce();
	String ctr = log.country();
	String mail = log.email();
	String pw = log.haslo();
	String tel = log.telefon();
	System.out.println("Twoje dane to: " + "Nazwa konta: " + account + ", " + miejsc + ctr + ", adres email: " + mail + ", " + pw + ", Nr telefonu: " + tel );
	Assert.assertTrue(true);
}

@AfterMethod
	  public void getResult(ITestResult result) {
		  if (result.getStatus() == ITestResult.SUCCESS) {
			  logger.log(Status.PASS, "Succeed test case \""+ result.getName()+ "\"");
		  } else if (result.getStatus() == ITestResult.FAILURE) {
			  logger.log(Status.FAIL, "Failed test case \""+ result.getName()+ "\" Reason: " + result.getThrowable());
			  //trying to do a failed case screenshot using robot library
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
				ImageIO.write(image, "png", new File("C:\\Users\\M4TTH3W\\eclipse-workspace\\WoTProject\\test-output\\testfaillog.png"));
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
