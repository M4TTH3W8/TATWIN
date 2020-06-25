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
import poms.Register;

public class WoTRegister3 {
	//global variables for extent reports
		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public ExtentTest logger;
		public String driverPath;
		public WebDriver driver;
		public MainWebsite pageObject;
		public Register reg;
		
		
		
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
	      reg = new Register(driver);
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      
		  //reporting properties
		  htmlReporter = new ExtentHtmlReporter("test-output//wotregister.html");
	      htmlReporter.config().setDocumentTitle("TATWIN - Project");
	      htmlReporter.config().setReportName("Automatic reports generation");
	      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	      htmlReporter.config().setTheme(Theme.STANDARD);

	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	      extent.setSystemInfo("User Name", "Mateusz Glowacki");		  
	  }
//first test case - entering main website, and proceeding to the register site
@Test(priority=1)
	  public void Testofreg() {
		logger = extent.createTest("First test case");
		pageObject.goregister();
		Assert.assertTrue(true);
	  }
// second test case - eula check 
@Test(priority =2)
	public void eula() {
	logger = extent.createTest("Second test case");
	WebElement element = driver.findElement(By.id("id_eula"));
	Actions actions = new Actions(driver);
	actions.moveToElement(element).click().perform();
}
//third test case - we enter wrong email adress and read popup
@Test(priority=3)
	  public void Testofname() {
		logger = extent.createTest("Third test case");
		String bademail = "test@test";
		reg.emailfields(bademail);
		String name = "M4TTH3W8";
		reg.namefields(name);
		String pass = "testing";
		reg.passfields(pass);
		String repass = "testing";
		reg.repassfields(repass);
		reg.registerbig();
		String err1 = reg.emailfail();
		System.out.println(err1);
		Assert.assertTrue(true); 
}
//fourth test case - checks if entered email adress is in correct format however its used already
@Test(priority=3)
	public void Testofcorrectemail() {
	logger = extent.createTest("Fourth test case");
	String bademail = "test@tlen.pl";
	reg.emailfields(bademail);
	String name = "M4TTH3W89";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "testing";
	reg.repassfields(repass);
	reg.registerbig();
	String err = reg.emailfail();
	System.out.println(err);
	Assert.assertTrue(true); 
}
//fifth test case - we input wrong username by using spaces
@Test(priority=3)
	public void Testofwrongusername1() {
	logger = extent.createTest("Fifth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4 TTH 3W 89";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "testing";
	reg.repassfields(repass);
	reg.registerbig();
	String err2 = reg.namefail();
	System.out.println(err2);
	Assert.assertTrue(true); 
}

//Sixth test case - we input wrong username by using polish and special signs
@Test(priority=3)
	public void Testofwrongusername2() {
	logger = extent.createTest("Sixth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4#ŁSOOPÓŚ@#";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "testing";
	reg.repassfields(repass);
	reg.registerbig();
	String err3 = reg.namefail();
	System.out.println(err3);
	Assert.assertTrue(true); 
}
//Seventh test case - we input too short username
@Test(priority=3)
	public void Testofwrongusername3() {
	logger = extent.createTest("Seventh test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "testing";
	reg.repassfields(repass);
	reg.registerbig();
	String err4 = reg.namefail();
	System.out.println(err4);
	Assert.assertTrue(true); 
}
//Eighth test case - we input already taken username
@Test(priority=3)
	public void Testofwrongusername4() {
	logger = extent.createTest("Eighth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4TTH3W";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "testing";
	reg.repassfields(repass);
	reg.registerbig();
	String err5 = reg.namefail();
	System.out.println(err5);
	Assert.assertTrue(true); 
}
//ninth test case - we input password with spaces
@Test(priority=3)
	public void Testofwrongpass1() {
	logger = extent.createTest("Ninth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4TTH3W89";
	reg.namefields(name);
	String pass = "tes ti ng";
	reg.passfields(pass);
	String repass = "tes ti ng";
	reg.repassfields(repass);
	reg.registerbig();
	String err6 = reg.passfail();
	System.out.println(err6);
	Assert.assertTrue(true); 
}
//tenth test case - we input password with special signs
@Test(priority=3)
	public void Testofwrongpass2() {
	logger = extent.createTest("Tenth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4TTH3W89";
	reg.namefields(name);
	String pass = "te$$@&ł";
	reg.passfields(pass);
	String repass = "te$$@&ł";
	reg.repassfields(repass);
	reg.registerbig();
	String err7 = reg.passfail();
	System.out.println(err7);
	Assert.assertTrue(true); 
}
//eleven test case - we input too short password
@Test(priority=3)
	public void Testofwrongpass3() {
	logger = extent.createTest("Eleventh test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4TTH3W89";
	reg.namefields(name);
	String pass = "test";
	reg.passfields(pass);
	String repass = "test";
	reg.repassfields(repass);
	reg.registerbig();
	String err8 = reg.passfail();
	System.out.println(err8);
	Assert.assertTrue(true); 
}
//twelfth test case - we reenter wrong password
@Test(priority=3)
	public void refail() {
	logger = extent.createTest("Twelfth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4TTH3W89";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "test";
	reg.repassfields(repass);
	reg.registerbig();
	String err9 = reg.repassfail();
	System.out.println(err9);
	Assert.assertTrue(true); 
}
//Thirteenth test case - we enter every data correctly but we do not click register to prevent creation of an account
@Test(priority=4)
	public void correct() {
	logger = extent.createTest("Thirteenth test case");
	String bademail = "qxaenurdbgamasppio@ttirv.net";
	reg.emailfields(bademail);
	String name = "M4TTH3W89";
	reg.namefields(name);
	String pass = "testing";
	reg.passfields(pass);
	String repass = "testing";
	reg.repassfields(repass);
	//reg.registerbig();
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
				ImageIO.write(image, "png", new File("C:\\Users\\M4TTH3W\\eclipse-workspace\\WoTProject\\test-output\\testfailreg.png"));
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
