package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	WebDriver driver;

	@FindBy(id = "id_login")
	WebElement emailfield;
	@FindBy(id = "id_name")
	WebElement namefield;
	@FindBy(id = "id_password")
	WebElement passfield;
	@FindBy(id = "id_re_password")
	WebElement repassfield;
	@FindBy(xpath = "//p[@class='field-hint-game_error']")
	WebElement emailerr;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[2]/span[1]/div[1]/div[1]/div[1]/p[1]")
	WebElement nameerr;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[3]/span[1]/div[1]/div[1]/div[1]/p[1]")
	WebElement passerr;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[4]/span[1]/div[1]/div[1]/div[1]/p[1]")
	WebElement repasserr;
	@FindBy(xpath = "//span[@class='b-big-button_inner b-big-button_inner__arrow']")
	WebElement registerbb;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[1]/div[1]/span[1]")
	WebElement emailcheck;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[2]/div[1]/span[1]")
	WebElement namecheck;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[3]/div[1]/span[1]")
	WebElement passcheck;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[4]/div[1]/span[1")
	WebElement repasscheck;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/form[1]/fieldset[1]/span[1]/div[1]/div[1]/div[1]/p[1]")
	WebElement regi;
	
	public Register(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

		public void emailfields(String bademail) {
		emailfield.clear();
		emailfield.sendKeys(bademail);
	}
	public String emailfail(){
		return emailerr.getText();
	}
	public void registerbig() {
		registerbb.click();
	}
	public void emailok() {
		emailcheck.getText();
	}
	public void nameok() {
		namecheck.getText();
	}
	public void namefields(String name) {
		namefield.clear();
		namefield.sendKeys(name);
	}
	public String namefail() {
		return nameerr.getText();
	}
	public void passfields(String pass) {
		passfield.clear();
		passfield.sendKeys(pass);
	}
	public String passfail() {
		return passerr.getText();
	}
	public void passok() {
		passcheck.getText();
	}
	public void repassok() {
		repasscheck.getText();
	}
	public void repassfields(String repass) {
		repassfield.clear();
		repassfield.sendKeys(repass);
	}
	public String repassfail() {
		return repasserr.getText();
	}
	public String regii() {
		return regi.getText();
	}
}
