package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pom1 {
	WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement loginwebsite;
	@FindBy(id = "id_login")
	WebElement username;
	@FindBy(id = "id_password")
	WebElement password;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/fieldset[2]/span[1]/button[1]/span[1]")
	WebElement loginbutton;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1432535]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/fieldset[2]/span[1]/button[1]/span[1123124324]")
	WebElement wrongbutton;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/form[1]/span[1]/div[1]/div[1]/p[1]")
	WebElement error;
	
	public pom1(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	public void login(){
		loginwebsite.click();
	}
	public void enterUsername(String username1){
		username.sendKeys(username1);
	}
	 
	public void enterPassword(String password1){
		password.sendKeys(password1);
	}
	public void button() {
		loginbutton.click();
	}
	public void buttons() {
		wrongbutton.click();
	}
	public String getResult(){
		return error.getText();
	}
	
}
