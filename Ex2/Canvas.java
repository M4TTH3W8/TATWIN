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

public class Canvas {
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
		//przechodzimy do canvas
		driver.findElement(By.id("io.selendroid.testapp:id/canvas_button")).click();
		Thread.sleep(1000);
		TouchAction action1 = new TouchAction(driver);
//kwadrat
		action1.longPress(PointOption.point(100,500));
		action1.moveTo(PointOption.point(400,500));
		action1.moveTo(PointOption.point(400,800));
		action1.moveTo(PointOption.point(100,800));
		action1.moveTo(PointOption.point(100,500));
//pionowe linie
		action1.moveTo(PointOption.point(200,500));
		action1.moveTo(PointOption.point(200,800));
		action1.moveTo(PointOption.point(300,800));
		action1.moveTo(PointOption.point(300,500));
//poziome linie
		action1.moveTo(PointOption.point(400,500));
		action1.moveTo(PointOption.point(400,600));
		action1.moveTo(PointOption.point(100,600));
		action1.moveTo(PointOption.point(100,700));
		action1.moveTo(PointOption.point(400,700));
		action1.perform();
		
		Thread.sleep(5000);
		driver.quit();
		
		}
	
}
