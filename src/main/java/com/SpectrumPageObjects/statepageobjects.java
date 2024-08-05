package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Basepack.PortalCommonMethods;


public class statepageobjects extends PortalCommonMethods{
	@FindBy(xpath = "//a[text()='Masters ']")
	WebElement masters;
	@FindBy(xpath = "//a[text()='State']")
	WebElement state;
	@FindBy(xpath = "//button[text()=' Create']")
	WebElement create;
	@FindBy(xpath = "(//button[text()=' Create'])[2]")
	WebElement createbutton;
	@FindBy(xpath = "//select[@formcontrolname='CountryId']")
	WebElement country;
	@FindBy(xpath = "//input[@formcontrolname='StateDescription']")
	WebElement statename;
	@FindBy(xpath = "//input[@formcontrolname='StateCode']")
	WebElement statecode;
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
    public statepageobjects(WebDriver d) {
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
    public void state(String countryy, String name, String code,String code1, String comm,String comm1, String comm2, String pass) throws InterruptedException {
    	clickElement(masters);
    	javawait();
    	javascript(state);
    	javawait();
    	javascript(create);
    	javawait();
    	clickElement(createbutton);
    	javawait();
    	textbox(country, countryy);
    	javawait();
    	textbox(statename, name);
    	javawait();
    	textbox(statecode, code);
    	javawait();
    	popup(pass);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(update);
    	javawait();
    	textboxc(statecode, code1);
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
    public void statecreation(String countryy,String name, String code) throws InterruptedException {
    	clickElement(masters);
    	javawait();
    	javascript(state);
    	javawait();
    	javascript(create);
    	javawait();
    	clickElement(createbutton);
    	javawait();
    	textbox(country, countryy);
    	javawait();
    	textbox(statename, name);
    	javawait();
    	textbox(statecode, code);
    }
    public void stateupdate(String code, String comm) throws InterruptedException {
    	clickElement(masters);
    	javawait();
    	javascript(state);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(update);
    	javawait();
    	textboxc(statecode, code);
    	javawait();
    	textbox(comments, comm);
    	javawait();
    	clickElement(update);
    }
    public void statedisable(String comm) throws InterruptedException {
    	clickElement(masters);
    	javawait();
    	javascript(state);
    	javawait();
    	clickElement(edit);
    	javawait();
    	clickElement(enablechbox);
    	javawait();
    	textbox(comments, comm);
    	javawait();
    	clickElement(update);
    }
    public void stateenable(String comm) throws InterruptedException {
    	clickElement(masters);
    	javawait();
    	javascript(state);
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
