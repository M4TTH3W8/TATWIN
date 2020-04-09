package testcases;

import java.util.Set;
import java.util.concurrent.*;
import java.io.File;
import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.*;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.Keys.*;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

//Using TestNG v6.14.3 - done without assertions!
public class HybridApp {
	//cw5
	  @Test 
	  public void main() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.selendroid.testapp");
	  cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.selendroid.testapp.HomeScreenActivity");
	  
	  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
	  driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
	  Thread.sleep(2000);
	  Set<String> contextNames =driver.getContextHandles();
	  for (String contextName : contextNames) {
		  System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_chrome 
	  } 
	  driver.context("WEBVIEW_io.selendroid.testapp");
	  driver.findElementById("name_input").clear();
	  driver.findElementById("name_input").sendKeys("Mateusz");
	  driver.findElementByName("car").click();
	  driver.findElementByXPath("html/body/form/div/p/select/option[2]").click();
	  //String s1 = driver.getPageSource(); //System.out.println(s1);
	  driver.findElementByXPath("/html/body/form/div/input[2]").click();
	  
	  Thread.sleep(8000); driver.quit();
	  
	  }
	@Test
	//cw6.1
	//test otwiera podstrone xhtml i wypisuje tekst na dole strony
	public void main1() throws MalformedURLException,  InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("io.selendroid.testapp:id/spinner_webdriver_test_data")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[2]")).click();
		
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_chrome
		}
		driver.context("WEBVIEW_io.selendroid.testapp");
		MultiTouchAction multiAction = new MultiTouchAction(driver);
		TouchAction action1 = new TouchAction(driver);
		TouchAction action2 = new TouchAction(driver);
		action1.press(PointOption.point(500,1600)).moveTo(PointOption.point(500,200));
		action2.press(PointOption.point(600,1600)).moveTo(PointOption.point(600,200));
		multiAction.add(action1).add(action2).perform();
		
		String l1 = driver.findElement(By.xpath("//*[@id=\"my_span\"]/div[1]")).getText();
		String l2 = driver.findElement(By.xpath("//*[@id=\"my_span\"]/div[2]")).getText();
		String l3 = driver.findElement(By.xpath("//*[@id=\"my_span\"]/span[1]")).getText();
		String l4 = driver.findElement(By.xpath("//*[@id=\"my_span\"]/span[2]")).getText();
		String l5 = driver.findElement(By.xpath("//*[@id=\"parent\"]")).getText();
		String l6 = driver.findElement(By.xpath("//*[@id=\"child\"]")).getText();
		String l7 = driver.findElement(By.xpath("//*[@id=\"only-exists-on-xhtmltest\"]")).getText();
		System.out.println(l1 + "\n" + l2 + "\n" + l3 + "\n" + l4 + "\n" + l5 + "\n" + l6 + "\n" + l7);
		Thread.sleep(8000);
		driver.quit();
		
		}

	//otwiera strone clicks klika na przycisk "click me" i wysietla tekst
	  @Test 
	  public void main2() throws MalformedURLException, InterruptedException{ 
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.selendroid.testapp");
	  cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.selendroid.testapp.HomeScreenActivity");
	  
	  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
	  driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click(); Thread.sleep(2000);
	  driver.findElement(By.id("io.selendroid.testapp:id/spinner_webdriver_test_data")).click();
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[10]")).click();
	  
	  Set<String> contextNames = driver.getContextHandles();
	  for (String contextName : contextNames) { 
		  System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_chrome 
	  }
	  driver.context("WEBVIEW_io.selendroid.testapp");
	  driver.findElement(By.id("twoClientRects")).click();
	//*[@id="twoClientRects"]/span[2]
	  String s1 = driver.findElement(By.xpath("/html/body/div[2]/h1")).getText();
	  System.out.println(s1);
	  
	  Thread.sleep(8000); driver.quit();
	  
	  }
	  //Aplikacja wyswietli toast nono i odczytamy jego wartosc
	  @Test
	  public void test3() throws MalformedURLException, InterruptedException{
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
      cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.selendroid.testapp");
	  cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.selendroid.testapp.HomeScreenActivity");
		  
	  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
	  driver.findElement(By.id("io.selendroid.testapp:id/buttonTest")).click();
	  driver.findElement(By.id("android:id/button2")).click();
	  Thread.sleep(600);
	  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  ITesseract instance = new Tesseract();
		try {
			String result = instance.doOCR(srcFile);
			System.out.println(result);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	  Thread.sleep(3000);
	  driver.quit();
		
	  }
}
