package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Basepack.PortalCommonMethods;


public class UOM extends PortalCommonMethods {
	@FindBy(xpath = "//a[text()='Masters ']")
	WebElement masters;
	@FindBy(xpath = "//a[text()='Unit Of Measure']")
	WebElement uom;
	@FindBy(xpath = "//button[text()=' Create']")
	WebElement create;
	@FindBy(xpath = "//button[@id='iniBtn1']")
	WebElement createbutton;
	@FindBy(xpath = "//button[text()='×']")
	WebElement close;
	@FindBy(xpath = "//input[@formcontrolname='UnitOfMeasures']")
	WebElement uomname;
	@FindBy(xpath = "//input[@formcontrolname='UnitOfMeasureCode']")
	WebElement uomcode;
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
public UOM(WebDriver d) {
	driver=d;
	PageFactory.initElements(d, this);
}
public void uom(String name, String code, String code1,String comm,String comm1, String comm2, String pass) throws InterruptedException {
	clickElement(masters);
	javawait();
	javascript(uom);
	javawait();
	javascript(create);
	javawait();
	clickElement(createbutton);
	javawait();
	textbox(uomname, name);
	javawait();
	textbox(uomcode, code);
	javawait();
	popup(pass);
	javawait();
	clickElement(edit);
	javawait();
	clickElement(update);
	javawait();
	textboxc(uomcode, code1);
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
public void uomcreation(String name, String code) throws InterruptedException {
	clickElement(masters);
	javawait();
	javascript(uom);
	javawait();
	javascript(create);
	javawait();
	clickElement(createbutton);
	javawait();
	textbox(uomname, name);
	javawait();
	textbox(uomcode, code);
}
public void popup(String pass) throws InterruptedException {
	clickElement(yes);
	javawait();
	textbox(esignpass, pass);
	javawait();
	clickElement(ok);
}
public void updateuom(String code, String comm) throws InterruptedException {
	clickElement(masters);
	javawait();
	javascript(uom);
	javawait();
	clickElement(edit);
	javawait();
	clickElement(update);
	javawait();
	textboxc(uomcode, code);
	javawait();
	textbox(comments, comm);
	javawait();
	clickElement(update);
}
public void disableuom(String comm) throws InterruptedException {
	clickElement(masters);
	javawait();
	javascript(uom);
	javawait();
	clickElement(edit);
	javawait();
	clickElement(enablechbox);
	javawait();
	textbox(comments, comm);
	javawait();
	clickElement(update);
}
public void enableuom(String comm) throws InterruptedException {
	clickElement(masters);
	javawait();
	javascript(uom);
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
