package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Basepack.PortalCommonMethods;


public class salutationpageobjects extends PortalCommonMethods {
	@FindBy(xpath = "//a[text()='Masters ']")
	WebElement masters;
	@FindBy(xpath = "//a[text()='Salutation']")
	WebElement salutation;
	@FindBy(xpath = "//button[text()=' Create']")
	WebElement create;
	@FindBy(xpath = "(//button[text()=' Create'])[2]")
	WebElement createbutton;
	@FindBy(xpath = "//input[@formcontrolname='SalutationDescription']")
	WebElement saldesc;
	@FindBy(xpath = "//input[@formcontrolname='SalutationCode']")
	WebElement salcode;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yes;
	@FindBy(xpath = "(//button[text()='No'])[2]")
	WebElement no;
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement esignpass;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement ok;
	@FindBy(xpath = "(//span[@class='fa fa-pencil'])[1]")
	WebElement edit;
	@FindBy(xpath = "//textarea[@formcontrolname='Comments']")
	WebElement comments;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement update;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement enablechbox;
	public salutationpageobjects(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	public void popup(String pass) throws InterruptedException {
		clickElement(yes);
    	javawait();
    	textbox(esignpass, pass);
    	javawait();
    	clickElement(ok);
	}
	public void salutation(String desc, String code,String code1, String comm,String comm1, String comm2, String pass) throws InterruptedException {
		clickElement(masters);
    	javawait();
    	javascript(salutation);
    	javawait();
    	javascript(create);
    	javawait();
    	clickElement(createbutton);
    	javawait();
    	textbox(saldesc, desc);
    	javawait();
    	textbox(salcode, code);
    	javawait();
    	popup(pass);
    	javawait();
    	javascript(edit);
    	javawait();
    	clickElement(update);
    	javawait();
    	textboxc(salcode, code1);
    	javawait();
    	textbox(comments, comm);
    	javawait();
    	clickElement(update);
    	javawait();
    	popup(pass);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(enablechbox);
    	javawait();
    	textbox(comments, comm1);
    	javawait();
    	clickElement(update);
    	javawait();
    	popup(pass);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(enablechbox);
    	javawait();
    	textbox(comments, comm2);
    	javawait();
    	clickElement(update);
    	javawait();
    	popup(pass);	
	}
	public void salutationcreation(String desc, String code) throws InterruptedException {
		clickElement(masters);
    	javawait();
    	javascript(salutation);
    	javawait();
    	javascript(create);
    	javawait();
    	clickElement(createbutton);
    	javawait();
    	textbox(saldesc, desc);
    	javawait();
    	textbox(salcode, code);
	}
	public void salutationupdate(String code, String comm) throws InterruptedException {
		clickElement(masters);
    	javawait();
    	javascript(salutation);
    	javawait();
    	javascript(edit);
    	javawait();
    	clickElement(update);
    	javawait();
    	textboxc(salcode, code);
    	javawait();
    	textbox(comments, comm);
    	javawait();
    	clickElement(update);
	}
	public void salutationdisable(String comm) throws InterruptedException {
		clickElement(masters);
    	javawait();
    	javascript(salutation);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(enablechbox);
    	javawait();
    	textbox(comments, comm);
    	javawait();
    	clickElement(update);
	}
	public void salutationenable(String comm) throws InterruptedException {
		clickElement(masters);
    	javawait();
    	javascript(salutation);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(enablechbox);
    	javawait();
    	textbox(comments, comm);
    	javawait();
    	clickElement(update);
	}
}
