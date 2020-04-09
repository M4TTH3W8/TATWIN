package testcases;

import java.util.concurrent.*;
import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.*;

public class TouchActions {
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
		driver.findElement(By.id("io.selendroid.testapp:id/touchTest")).click();
		TouchAction action =new TouchAction(driver);
		MultiTouchAction multiAction = new MultiTouchAction(driver);
		
		action.tap(PointOption.point(299,437)).perform();
		action.longPress(PointOption.point(100,200)).perform();
		//przechodzimy do canvas
		driver.findElement(By.id("io.selendroid.testapp:id/canvas_button")).click();
		TouchAction action1 = new TouchAction(driver);
		TouchAction action2 = new TouchAction(driver);
		action1.press(PointOption.point(100,200)).moveTo(PointOption.point(600,500));
		action2.press(PointOption.point(100,400)).moveTo(PointOption.point(600,700));
		multiAction.add(action1).add(action2).perform();
		
		//action.press(PointOption.point(100,200)).moveTo(PointOption.point(300,500)).moveTo(PointOption.point(100,))
		Thread.sleep(3000);
		driver.quit();
		
		}
	
}
