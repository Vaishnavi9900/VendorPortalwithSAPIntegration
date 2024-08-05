package com.SpectrumTestRunner;

import java.io.IOException;
import org.testng.annotations.Test;

import com.Basepack.PortalCommonMethods;
import com.Basepack.SpectrumDataProvider;
import com.SpectrumPageObjects.usercreationpageobjects;
import com.aventstack.extentreports.Status;


public class UserCreation extends PortalCommonMethods{
	public usercreationpageobjects uc;
	
	
	@Test(dataProvider = "spectrumusercreation", dataProviderClass = SpectrumDataProvider.class)
	public void usercreate(String empid, String salutation, String firstname, String lastname, String department, String application) throws InterruptedException, IOException {
		getcell0value("logins"); getcell2value("logins"); 
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extenttest.info("Login was successful");
		uc.usercreation(empid,salutation,firstname,lastname,department,application);
		implicitwait();
		uc.createpopup(cell2val);
		implicitwait();
		uc.alreadyexist(empid);
		uc.logout();
		extenttest.log(Status.PASS, "This usercreate test is passed");
	}
	@Test
	public void userupdate() throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); getcell7value("logins");
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extenttest.info("Login was successful");
		uc.updateuser("sravani.kandi@audreeinfotech.com", cell7val);
		implicitwait();
		uc.updatepopup(cell2val);
		extenttest.log(Status.PASS, "This usercreate test is passed");
		implicitwait();
		uc.logout();
	}
	@Test
	public void userdisable() throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); getcell8value("logins");
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extenttest.info("Login was successful");
		uc.disableuser(cell8val);
		implicitwait();
		uc.updatepopup(cell2val);
		extenttest.log(Status.PASS, "This usercreate test is passed");
		implicitwait();
		uc.logout();
	}
	@Test
	public void userenable() throws IOException, InterruptedException {
		getcell0value("logins"); getcell2value("logins"); getcell9value("logins");
		uc = new usercreationpageobjects(driver);
		uc.userlogin(cell0val, cell2val);
		implicitwait();
		uc.dashboard();
		javawait();
		extenttest.info("Login was successful");
		uc.enableuser(cell9val);
		implicitwait();
		uc.updatepopup(cell2val);
		implicitwait();
		uc.logout();
		extenttest.log(Status.PASS, "This usercreate test is passed");
	}

}
