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

public class WebApp {
	public static void main(String[] args) throws MalformedURLException,  InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		//
		
		//W tym folderze musialem zmeinic wersje chromedrivera na starsza aby nie wywalalo bledu: C:\Users\M4TTH3W\AppData\Local\Programs\Appium\resources\app\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win
		
		//
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
		driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("com.android.chrome:id/search_box_text")).click();
		driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("https://modxvm.com");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_chrome
		}
		
		driver.context("WEBVIEW_chrome");	
		String test1 = driver.findElement(By.className("entry-title")).getText();
		System.out.println(test1);
		
		
//		driver.getContext();
//		driver.context("NATIVE_APP");
		Thread.sleep(5000);
		driver.quit();
		
		}
}
