package com.SpectrumTestRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Basepack.RegistrationCommonMethods;
import com.aventstack.extentreports.Status;
import com.spectrumadminPageObjects.smtppasswordpageobjects;
import com.spectrumadminPageObjects.usercontrolpageobjects;
import com.spectrumadminPageObjects.usercreationpageobjects;

public class SMTPPassword extends RegistrationCommonMethods {
	public usercontrolpageobjects ucc;
	public smtppasswordpageobjects smtp;
	public usercreationpageobjects uc;
	@Test
	public void randompass() throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); 
		smtp = new smtppasswordpageobjects(driver);
		ucc = new usercontrolpageobjects(driver);
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extentTest.info("Login was successful");
		smtp.random();
		implicitwait();
		ucc.popup(cell2val);
		implicitwait();
		smtp.defaltpass("123");
		implicitwait();
		ucc.popup(cell2val);
		implicitwait();
		uc.logout();
		extentTest.log(Status.PASS, "This usercreate test is passed");
	}

}
