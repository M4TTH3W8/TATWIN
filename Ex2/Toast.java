package testcases;

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

public class Toast {
	public static void main(String[] args) throws MalformedURLException,  InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
		//driver.getScreenshotAs(OutputType.FILE);
		driver.findElement(By.id("io.selendroid.testapp:id/showToastButton")).click();
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
