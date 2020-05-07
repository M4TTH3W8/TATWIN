package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	//global variables for extent reports
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	  @BeforeTest
	  public void beforeTest() {
		  htmlReporter = new ExtentHtmlReporter("test-output//newtest.html");
	      htmlReporter.config().setDocumentTitle("Excercise 4");
	      htmlReporter.config().setReportName("Automatic reports generation");
	      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	      htmlReporter.config().setTheme(Theme.STANDARD);

	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	      extent.setSystemInfo("User Name", "Mateusz Glowacki");
	  }
	  //positive test
  @Test
  public void test1() {
	  logger = extent.createTest("First test csae");
	  Assert.assertTrue(true); 
  }
  //skip test
  @Test
  public void test2() {
	  logger = extent.createTest("Second test case");
	  throw new SkipException("skip");
  }
  //negative test
  @Test
  public void test3() {
	  logger = extent.createTest("Third test case");
	  Assert.assertTrue(false);
  }
  @AfterMethod
  public void getResult(ITestResult result) {
	  if (result.getStatus() == ITestResult.SUCCESS) {
		  logger.log(Status.PASS, "Succeed test case \""+ result.getName()+ "\"");
	  } else if (result.getStatus() == ITestResult.FAILURE) {
		  logger.log(Status.FAIL, "Failed test case \""+ result.getName()+ "\" Reason: " + result.getThrowable());
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
