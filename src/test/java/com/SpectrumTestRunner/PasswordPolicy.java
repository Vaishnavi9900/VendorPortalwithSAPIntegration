package com.SpectrumTestRunner;

import org.testng.annotations.Test;

import com.Basepack.PortalCommonMethods;
import com.SpectrumPageObjects.passwordpolicypageobjects;
import com.SpectrumPageObjects.usercontrolpageobjects;
import com.SpectrumPageObjects.usercreationpageobjects;
import com.aventstack.extentreports.Status;
import java.io.IOException;



public class PasswordPolicy extends PortalCommonMethods {
	public com.SpectrumPageObjects.usercontrolpageobjects ucc;
	public passwordpolicypageobjects pp;
	public usercreationpageobjects uc;
	@Test
	public void passwordpolicyy(String exp, String invalidattempts, String expalertbefore, String enforcepass, String minupcase, String minlowcase, String mindigits, String minspecial , String mincharacters) throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); 
		pp = new passwordpolicypageobjects(driver);
		ucc = new usercontrolpageobjects(driver);
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		extenttest.info("Login was successful");
		pp.passwordpolicy(exp,invalidattempts,expalertbefore,enforcepass,minupcase,minlowcase,mindigits,minspecial ,mincharacters);
		implicitwait();
		ucc.popup(cell2val);
		implicitwait();
		uc.logout();
		extenttest.log(Status.PASS, "This usercreate test is passed");
	}

}
