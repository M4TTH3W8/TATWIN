package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tankpedia {
	WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]/span[4]")
	WebElement counter;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]")
	WebElement clear;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	WebElement germany;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	WebElement ussr;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	WebElement usa;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]")
	WebElement china;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]")
	WebElement france;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]")
	WebElement gb;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[1]")
	WebElement japan;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[2]")
	WebElement czech;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[3]")
	WebElement sweden;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[4]")
	WebElement poland;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[5]")
	WebElement italy;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]")
	WebElement light;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]")
	WebElement med;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]")
	WebElement heavy;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[4]")
	WebElement td;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[5]")
	WebElement spg;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]")
	WebElement t1;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]")
	WebElement t2;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[3]")
	WebElement t3;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[4]")
	WebElement t4;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[5]")
	WebElement t5;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[6]")
	WebElement t6;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[2]/li[1]")
	WebElement t7;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[2]/li[2]")
	WebElement t8;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[2]/li[3]")
	WebElement t9;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[2]/li[4]")
	WebElement t10;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]")
	WebElement premium;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[2]")
	WebElement collector;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[4]")
	WebElement sell;
	
	
	public Tankpedia(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	public void germany() {
		germany.click();
	}
	public void ussr() {
		ussr.click();
	}
	public void usa() {
		usa.click();
	}
	public void china() {
		china.click();
	}
	public void france() {
		france.click();
	}
	public void gb() {
		gb.click();
	}
	public void japan() {
		japan.click();
	}
	public void czech() {
		czech.click();
	}
	public void sweden() {
		sweden.click();
	}
	public void poland() {
		poland.click();
	}
	public void italy() {
		italy.click();
	}
	
	public void light() {
		light.click();
	}
	public void med() {
		med.click();
	}
	public void heavy() {
		heavy.click();
	}
	public void td() {
		td.click();
	}
	public void spg() {
		spg.click();
	}
	
	public void t1() {
		t1.click();
	}
	public void t2() {
		t2.click();
	}
	public void t3() {
		t3.click();
	}
	public void t4() {
		t4.click();
	}
	public void t5() {
		t5.click();
	}
	public void t6() {
		t6.click();
	}
	public void t7() {
		t7.click();
	}
	public void t8() {
		t8.click();
	}
	public void t9() {
		t9.click();
	}
	public void t10() {
		t10.click();
	}
	
	public void premium() {
		premium.click();
	}
	public void collector() {
		collector.click();
	}
	public void sell() {
		sell.click();
	}
	
	public void clear() {
		clear.click();
	}
	public String counter() {
		return counter.getText();
	}

}
