package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.Basepack.PortalCommonMethods;


public class usercreationpageobjects extends PortalCommonMethods {
	@FindBy(xpath = "//a[text()='Admin ']")
	WebElement admin;
	@FindBy(xpath = "//input[@placeholder='User ID']")
	WebElement userid;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;
	@FindBy(xpath = "//p[text()='Termination']")
	WebElement term;
	@FindBy(xpath = "//button[text()='Terminate Other Login']")
	WebElement termother;
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/a")
	WebElement home;
	@FindBy(xpath = "//a[text()='User Creation']")
	WebElement usercreation;
	@FindBy(xpath = "//button[text()=' Create']")
	WebElement createbutton;
	@FindBy(xpath = "(//input[@formcontrolname='EmployeeId'])[1]")
	WebElement empid;
	@FindBy(xpath = "//button[text()='Go']")
	WebElement gobutton;
	@FindBy(xpath = "//button[text()='×']")
	WebElement closebutton;
	@FindBy(xpath = "//select[@formcontrolname='SalutationId']")
	WebElement salutation;
	@FindBy(xpath = "//input[@formcontrolname='FirstName']")
	WebElement firstname;
	@FindBy(xpath = "//input[@formcontrolname='LastName']")
	WebElement lastname;
	@FindBy(xpath = "//select[@formcontrolname='DepartmentId']")
	WebElement department;
	@FindBy(xpath = "//select[@formcontrolname='DesignationId']")
	WebElement designation;
	@FindBy(xpath = "//select[@formcontrolname='SelectedPlantIds']")
	WebElement plant;
	@FindBy(xpath = "//option[text()=' HETERO LABS LTD [UNIT-V (B)] ']")
	WebElement plantselection;
	@FindBy(xpath = "//select[@formcontrolname='SelectedApplicationIds']")
	WebElement application;
	@FindBy(xpath = "(//span[@class='dropdown-btn'])[4]")
	WebElement role;
	@FindBy(xpath = "//div[text()='Purchase Department Executive']")
	WebElement roleselection;
	@FindBy(xpath = "//button[text()=' Add']")
	WebElement useraddbutton;
	@FindBy(xpath = "(//button[text()=' Create'])[2]")
	WebElement usercreate;
	@FindBy(xpath = "(//input[@name='i.baseplant'])[1]")
	WebElement baseplant;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yes;
	@FindBy(xpath = "(//button[text()='No'])[2]")
	WebElement no;
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement esignpass;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement ok;
	@FindBy(xpath = "(//span[@class='fa fa-eye'])[1]")
	WebElement view;
	@FindBy(xpath = "(//button[@class='editBtn'])[1]")
	WebElement edit;
	@FindBy(xpath = "//input[@formcontrolname='EmailId']")
	WebElement mail;
	@FindBy(xpath = "//input[@formcontrolname='comments']")
	WebElement comments;
	@FindBy(xpath = "(//input[@type='checkbox'])[8]")
	WebElement isactive;
	@FindBy(xpath = "(//button[text()='Update'])[2]")
	WebElement update;
	@FindBy(xpath = "//span[@class='avatarIcon']")
	WebElement profile;
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement logout;
	@FindBy(xpath = "//a[text()='Yes']")
	WebElement logoutyes;
	@FindBy(xpath = "//button[text()='No']")
	WebElement logoutno;

	public usercreationpageobjects(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}
	public void userlogin(String id, String pass) {
		textbox(userid, id);
		implicitwait();
		textbox(password, pass);
		clickElement(login);
	}
	public void dashboard() {
		implicitwait();
		if(term.isDisplayed()) {
			clickElement(termother);
		}else {
			clickElement(home);
		}
	}
	public void usercreation(String id, String sal, String firstnamee, String lastnamee, String dept, String app) throws InterruptedException {
		clickElement(admin);
		javawait();
		javascript(usercreation);
		javawait();
		clickElement(createbutton);
		javawait();
		empid.sendKeys(id);
		Thread.sleep(8000);
		clickElement(gobutton);
		Thread.sleep(8000);
		textbox(salutation, sal);
		implicitwait();
		textbox(firstname, firstnamee);
		javawait();
		textbox(lastname, lastnamee);
		javawait();
		textbox(department, dept);
		javawait();
		clickElement(plant);
		clickElement(plantselection);
		javawait();
		textbox(application, app);
		clickElement(role);
		javawait();
		clickElement(roleselection);
		javawait();
		clickElement(role);
		javawait();
		doubleclick(useraddbutton);
		clickElement(baseplant);
		implicitwait();
		clickElement(usercreate);
	}
	public void alreadyexist(String id) throws InterruptedException {
		clickElement(createbutton);
		javawait();
		empid.sendKeys(id);
		Thread.sleep(8000);
		clickElement(gobutton);
		Thread.sleep(8000);
		clickElement(ok);
		javawait();
		clickElement(closebutton);
	}
	public void createpopup(String pass) throws InterruptedException {
		clickElement(no);
		javawait();
		clickElement(usercreate);
		javawait();
		clickElement(yes);
		javawait();
		textbox(esignpass, pass);
		javawait();
		clickElement(ok);
	}
	public void viewuser() {
	   clickElement(view);
	   implicitwait();
	   clickElement(closebutton);
	}
	public void updateuser(String email, String comm) throws InterruptedException {
		javascript(usercreation);
		javawait();
		clickElement(edit);
		javawait();
		textbox(mail, email);
		javawait();
		textbox(comments, comm);
		clickElement(update);
	}
	public void updatepopup(String pass) throws InterruptedException {
		clickElement(no);
		javawait();
		clickElement(update);
		javawait();
		clickElement(yes);
		javawait();
		textbox(esignpass, pass);
		javawait();
		clickElement(ok);
	}
	public void disableuser(String comm) throws InterruptedException {
		javascript(usercreation);
		javawait();
		clickElement(edit);
		implicitwait();
		textbox(comments, comm);
		implicitwait();
		clickElement(isactive);
		implicitwait();
		clickElement(update);
	}
	public void enableuser(String comm) throws InterruptedException {
		javascript(usercreation);
		javawait();
		clickElement(edit);
		implicitwait();
		textbox(comments, comm);
		implicitwait();
		clickElement(isactive);
		implicitwait();
		clickElement(update);
	}
	public void logout() throws InterruptedException {
		javascript(profile);
		implicitwait();
		clickElement(logout);
		implicitwait();
		clickElement(logoutyes);
	}
}
