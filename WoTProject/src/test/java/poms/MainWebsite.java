package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWebsite {
	WebDriver driver;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[2]")
	WebElement registerlink;
	@FindBy(linkText = "Zaloguj")
	WebElement loginlink;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement tankmenu;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[4]/a[1]")
	WebElement tankopedia;
	
	public MainWebsite(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	public void goregister() {
		registerlink.click();
	}
	public void gologin() {
		loginlink.click();
	}
	public void gotank() {
		tankmenu.click();
		tankopedia.click();
	}
	
	
}
