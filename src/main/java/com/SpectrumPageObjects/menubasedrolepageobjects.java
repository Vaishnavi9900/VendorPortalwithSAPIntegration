package com.SpectrumPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Basepack.PortalCommonMethods;


public class menubasedrolepageobjects extends PortalCommonMethods {
	@FindBy(xpath = "//a[text()='Admin ']")
	WebElement admin;
	@FindBy(xpath = "//a[text()='Menu Based Role']")
	WebElement menubasedrole;
	@FindBy(xpath = "//button[text()='Show Menus']")
	WebElement showmenus;
	@FindBy(xpath = "//select[@formcontrolname='PlantId']")
	WebElement plant;
	@FindBy(xpath = "//option[text()=' HETERO DRUGS LIMITED (UNIT-I) ']")
	WebElement plantsel;
	@FindBy(xpath = "//select[@formcontrolname='ApplicationId']")
	WebElement appid;
	@FindBy(xpath = "//select[@formcontrolname='RoleId']")
	WebElement role;
	@FindBy(xpath = "//input[@value='Save']")
	WebElement save;
	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	WebElement checkbox;
	@FindBy(xpath = "(//input[@type='checkbox'])[12]")
	WebElement chbox;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement ok;
	public menubasedrolepageobjects(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	public void menubasedrole(String application, String roleid) throws InterruptedException {
		clickElement(admin);
		javawait();
		javascript(menubasedrole);
		javawait();
		clickElement(showmenus);
		javawait();
		clickElement(plant);
		javawait();
		clickElement(plantsel);
		javawait();
		textbox(appid, application);
		javawait();
		textbox(role, roleid);
		javawait();
		clickElement(showmenus);
		javawait();
		clickElement(save);
		clickElement(ok);
		javawait();
		scrollup(checkbox);
		javascript(checkbox);
		javawait();
		clickElement(save);
	}

}
