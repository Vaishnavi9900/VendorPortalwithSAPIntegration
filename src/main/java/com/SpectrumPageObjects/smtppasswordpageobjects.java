package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Basepack.PortalCommonMethods;


public class smtppasswordpageobjects extends PortalCommonMethods {
	@FindBy(xpath = "//a[text()='Admin ']")
	WebElement admin;
	@FindBy(xpath = "//a[text()='SMTP And Password']")
	WebElement smtppassword;
	@FindBy(xpath = "//select[@formcontrolname='PlantId']")
	WebElement plant;
	@FindBy(xpath = "//option[text()=' Hetero Private Limited - Hetero - API - HETERO DRUGS LIMITED (UNIT-I) ']")
	WebElement plantsel;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;
	@FindBy(xpath = "//input[@formcontrolname='DefaultPassword']")
	WebElement password;
	@FindBy(xpath = "(//input[@formcontrolname='Random'])[2]")
	WebElement random;
	@FindBy(xpath = "(//input[@formcontrolname='Random'])[1]")
	WebElement defalt;
public smtppasswordpageobjects(WebDriver d) {
	driver=d;
	PageFactory.initElements(d, this);
}
public void random() throws InterruptedException {
	clickElement(admin);
	javawait();
	javascript(smtppassword);
	javawait();
	clickElement(plant);
	javawait();
	clickElement(plantsel);
	javawait();
	clickElement(random);
	javawait();
	clickElement(save);
}
public void defaltpass(String pass) throws InterruptedException {
	clickElement(plant);
	javawait();
	clickElement(plantsel);
	javawait();
	clickElement(defalt);
	javawait();
	clickElement(password);
	password.clear();
	password.sendKeys(pass);
	javawait();
	clickElement(save);
}
	
}
