package testcases;

import java.util.concurrent.*;
import java.net.*;
import java.net.MalformedURLException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.*;

public class HelloWorld{
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
	//driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("HelloAppium");
	driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("Mateusz");
	driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("mati8840@wp.pl");
	driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("Password");
	driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
	driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Mr. Matthew");
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[6]")).click();
	driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
	driver.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).click();
	
	Thread.sleep(3000);
	driver.quit();
	
	}
}
