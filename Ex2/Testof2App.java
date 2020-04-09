package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

//Using TestNG v6.14.3 - done without assertions!
public class Testof2App {
	//Test searches Politechnika Koszalińska, finds and copies its adress and then displays it in output
  @Test
  public void TestGMap() throws MalformedURLException, InterruptedException{
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.apps.maps");
	  cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.google.android.maps.MapsActivity");
	  
	  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")).click();
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText/android.widget.TextView")).click();
	  driver.findElement(By.id("com.google.android.apps.maps:id/search_omnibox_edit_text")).sendKeys("Politechnika Koszalińska");
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]")).click();
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ViewSwitcher/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).click();
	  driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Address: Politechnika Koszalińska, Śniadeckich 2, 75-453 Koszalin, Poland\"]/android.widget.TextView")).click();
	  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]")).click();
	  Thread.sleep(2000);
	  String address = driver.getClipboardText();
	  System.out.println(address);
	 
	  Thread.sleep(8000);
	  driver.quit();
	  
	  }
  //Test searches for youtube channel of Politechnika Koszalinska and prints about page
  @Test
  public void GMail() throws MalformedURLException, InterruptedException{
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.youtube");
	  cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.google.android.apps.youtube.app.WatchWhileActivity");
	  
	  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
	  driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("Politechnika Koszalińska");
	  driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	  driver.findElement(By.id("com.google.android.youtube:id/channel_name")).click();
	  driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"About\"]")).click();
	  String opis = driver.findElement(By.id("com.google.android.youtube:id/description")).getText();
	  System.out.println(opis);
	  
	  Thread.sleep(8000);
	  driver.quit();
}
}
