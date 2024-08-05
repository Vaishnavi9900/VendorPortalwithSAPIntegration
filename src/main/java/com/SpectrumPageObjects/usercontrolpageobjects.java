package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Basepack.PortalCommonMethods;


public class usercontrolpageobjects extends PortalCommonMethods {
	@FindBy(xpath = "//a[text()='Admin ']")
	WebElement admin;
	@FindBy(xpath = "//a[text()='User Control']")
	WebElement usercontrol;
	@FindBy(xpath = "//button[text()='Get Status']")
	WebElement getstatus;
	@FindBy(xpath = "//input[@name='LoginId']")
	WebElement userid;
	@FindBy(xpath = "//div[text()=' User is in Reset state ']")
	WebElement resetalert;
	@FindBy(xpath = "//button[@id='lockbtn']")
	WebElement lockuser;
	@FindBy(xpath = "//button[@id='resetbtn']")
	WebElement resetuser;
	@FindBy(xpath = "//button[@id='UnlockBtn']")
	WebElement unlockuser;
	@FindBy(xpath = "//div[text()=' User is in Lock state ']")
	WebElement lockalert;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yes;
	@FindBy(xpath = "(//button[text()='No'])[2]")
	WebElement no;
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement esignpass;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement ok;

	public usercontrolpageobjects(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	public void usercontrols(String id) throws InterruptedException {
		clickElement(admin);
		javawait();
		javascript(usercontrol);
		javawait();
		textbox(userid, id);
		implicitwait();
		clickElement(getstatus);
		if(lockalert.isDisplayed()) {
			clickElement(unlockuser);
			System.out.println("lock alert is there");
		}	
		else if(resetalert.isDisplayed()) {
			clickElement(lockuser);
			System.out.println("reset alert is there");	
		}
	     {
			System.out.println("no alert is there");
		}
	}
	public void popup(String pass) {
		clickElement(yes);
		implicitwait();
		textbox(esignpass, pass);
		implicitwait();
		clickElement(ok);
	}
}
