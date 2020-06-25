package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	@FindBy(id = "id_login")
	WebElement loginfield;
	@FindBy(id = "id_password")
	WebElement passfield;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/fieldset[2]/span[1]/button[1]")
	WebElement loginbutton;
	@FindBy(xpath = "//p[contains(@class,'js-form-errors-content')]")
	WebElement loginerr;
	@FindBy(xpath = "//span[@class='cm-user-menu-link_cutted-text']")
	WebElement usern;
	@FindBy(xpath = "//span[contains(text(),'dzanie kontem')]")
	WebElement management;
	@FindBy(xpath = "//h2[@class='b-heading2 b-heading2__noindent']")
	WebElement accnam;
	@FindBy(xpath = "//span[contains(text(),'Miejsce zamieszkania:')]")
	WebElement pob;
	@FindBy(xpath = "//span[@class='country-name']")
	WebElement ctr;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[1]")
	WebElement mail;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/p[1]")
	WebElement hasllo;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/p[1]")
	WebElement tel;
	
	public Login(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	public void loginf(String loginff) {
	loginfield.clear();
	loginfield.sendKeys(loginff);
}
	public void passf(String passff) {
		passfield.clear();
		passfield.sendKeys(passff);
	}
	public void logbutton() {
		loginbutton.click();
	}
	public String loginfail() {
		return loginerr.getText();
	}
	public void userna() {
		usern.click();
	}
	public void manage() {
		management.click();
	}
	public String accname() {
		return accnam.getText();
	}
	public String miejsce() {
		return pob.getText();
	}
	public String country() {
		return ctr.getText();
	}
	public String email() {
		return mail.getText();
	}
	public String haslo() {
		return hasllo.getText();
	}
	public String telefon() {
		return tel.getText();
	}
}
