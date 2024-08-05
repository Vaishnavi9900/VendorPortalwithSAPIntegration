package com.SpectrumTestRunner;

import java.io.IOException;
import org.testng.annotations.Test;
import com.Basepack.PortalCommonMethods;
import com.SpectrumPageObjects.menubasedrolepageobjects;
import com.SpectrumPageObjects.usercontrolpageobjects;
import com.SpectrumPageObjects.usercreationpageobjects;
import com.aventstack.extentreports.Status;

public class MenuBasedRole extends PortalCommonMethods {
	public usercontrolpageobjects ucc;
	public menubasedrolepageobjects mb;
	public usercreationpageobjects uc;
	@Test
	public void menubased() throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); 
		mb = new menubasedrolepageobjects(driver);
		ucc = new usercontrolpageobjects(driver);
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extenttest.info("Login was successful");
		mb.menubasedrole("vendorportal","tax");
		implicitwait();
		ucc.popup(cell2val);
		implicitwait();
		uc.logout();
		extenttest.log(Status.PASS, "This usercreate test is passed");
	}
}
