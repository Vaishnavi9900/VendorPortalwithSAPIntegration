package com.SpectrumTestRunner;

import java.io.IOException;

import org.testng.annotations.Test;
import com.Basepack.PortalCommonMethods;
import com.SpectrumPageObjects.usercontrolpageobjects;
import com.SpectrumPageObjects.usercreationpageobjects;
import com.aventstack.extentreports.Status;


@Test
public class UserControl extends PortalCommonMethods {
	public usercontrolpageobjects ucc;
	public usercreationpageobjects uc;
	public void usercontrolactivity() throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); 
		uc = new usercreationpageobjects(driver);
		ucc = new usercontrolpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extenttest.info("Login was successful");
		ucc.usercontrols("998800");
		implicitwait();
		ucc.popup(cell2val);
		implicitwait();
		uc.logout();
		extenttest.log(Status.PASS, "This usercreate test is passed");
	}

}
