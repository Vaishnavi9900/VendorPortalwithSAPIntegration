package com.Basepack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader extends RegistrationCommonMethods{
	
	private static Properties properties;
	private final String propertyFilePath= "C:\\Users\\vaishnavi.t\\eclipse-workspace\\VendorRegistration\\Configurations\\vendor.properties";
	
	public ConfigurationReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	public static String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	public static long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getcountry() {
		String country = properties.getProperty("country");
		if(country!= null) return country;
		else throw new RuntimeException("country not specified in the Configuration.properties file.");
	}
	public String getmail() {
		String mail = properties.getProperty("mail");
		if(mail!= null) return mail;
		else throw new RuntimeException("mail not specified in the Configuration.properties file.");
	}
	public String getmobileno() {
		String mobileno = properties.getProperty("mobileno");
		if(mobileno!= null) return mobileno;
		else throw new RuntimeException("mobileno not specified in the Configuration.properties file.");
	}
	public String getmsofficeurl() {
		String msofficeurl = properties.getProperty("msofficeurl");
		if(msofficeurl!= null) return msofficeurl;
		else throw new RuntimeException("msofficeurl not specified in the Configuration.properties file.");
	}
	public String getoutlookurl() {
		String outlookurl = properties.getProperty("outlookurl");
		if(outlookurl!= null) return outlookurl;
		else throw new RuntimeException("outlookurl not specified in the Configuration.properties file.");
	}
	public String getoutlookpass() {
		String outlookpass = properties.getProperty("outlookpass");
		if(outlookpass!= null) return outlookpass;
		else throw new RuntimeException("outlookpass not specified in the Configuration.properties file.");
	}
	public String getnewpassword() {
		String newpassword = properties.getProperty("newpassword");
		if(newpassword!= null) return newpassword;
		else throw new RuntimeException("newpassword not specified in the Configuration.properties file.");
	}
	public String getconfirmpassword() {
		String confirmpassword = properties.getProperty("confirmpassword");
		if(confirmpassword!= null) return confirmpassword;
		else throw new RuntimeException("confirmpassword not specified in the Configuration.properties file.");
	}
	public static String getPurExe(){
		String PurchaseExecutive = properties.getProperty("PurchaseExecutive");
		if(PurchaseExecutive!= null) return PurchaseExecutive;
		else throw new RuntimeException("PurchaseExecutive not specified in the Configuration.properties file.");		
	}
	public static String getHOD(){
		String HOD = properties.getProperty("HOD");
		if(HOD!= null) return HOD;
		else throw new RuntimeException("HOD not specified in the Configuration.properties file.");		
	}
	public static String getFinance(){
		String Finance = properties.getProperty("Finance");
		if(Finance!= null) return Finance;
		else throw new RuntimeException("Finance not specified in the Configuration.properties file.");		
	}
	public static String getTax(){
		String Tax = properties.getProperty("Tax");
		if(Tax!= null) return Tax;
		else throw new RuntimeException("Tax not specified in the Configuration.properties file.");		
	}
	public static String getMDM(){
		String MDM = properties.getProperty("MDM");
		if(MDM!= null) return MDM;
		else throw new RuntimeException("MDM not specified in the Configuration.properties file.");		
	}
	public static String getPassword(){
		String Password = properties.getProperty("Password");
		if(Password!= null) return Password;
		else throw new RuntimeException("Password not specified in the Configuration.properties file.");		
	}
	public static String getCompanyname(){
		String Companyname = properties.getProperty("Companyname");
		if(Companyname!= null) return Companyname;
		else throw new RuntimeException("Companyname not specified in the Configuration.properties file.");		
	}
	public static String getaddress1(){
		String address1 = properties.getProperty("address1");
		if(address1!= null) return address1;
		else throw new RuntimeException("address1 not specified in the Configuration.properties file.");		
	}
	public static String getaddress2(){
		String address2 = properties.getProperty("address2");
		if(address2!= null) return address2;
		else throw new RuntimeException("address2 not specified in the Configuration.properties file.");		
	}
	public static String getcity(){
		String city = properties.getProperty("city");
		if(city!= null) return city;
		else throw new RuntimeException("Tax not specified in the Configuration.properties file.");		
	}
	public static String getpincode(){
		String pincode = properties.getProperty("pincode");
		if(pincode!= null) return pincode;
		else throw new RuntimeException("pincode not specified in the Configuration.properties file.");		
	}
	public static String getstate(){
		String state = properties.getProperty("state");
		if(state!= null) return state;
		else throw new RuntimeException("state not specified in the Configuration.properties file.");		
	}
	public static String getcontactname(){
		String contactname = properties.getProperty("contactname");
		if(contactname!= null) return contactname;
		else throw new RuntimeException("contactname not specified in the Configuration.properties file.");		
	}
	public static String getdepartment(){
		String department = properties.getProperty("department");
		if(department!= null) return department;
		else throw new RuntimeException("department not specified in the Configuration.properties file.");		
	}
	public static String getdesignation(){
		String designation = properties.getProperty("designation");
		if(designation!= null) return designation;
		else throw new RuntimeException("designation not specified in the Configuration.properties file.");		
	}
	public static String getgststatus(){
		String gststatus = properties.getProperty("gststatus");
		if(gststatus!= null) return gststatus;
		else throw new RuntimeException("gststatus not specified in the Configuration.properties file.");		
	}
	public static String getgstnumber(){
		String gstnumber = properties.getProperty("gstnumber");
		if(gstnumber!= null) return gstnumber;
		else throw new RuntimeException("gstnumber not specified in the Configuration.properties file.");		
	}
	public static String getpannumber(){
		String pannumber = properties.getProperty("pannumber");
		if(pannumber!= null) return pannumber;
		else throw new RuntimeException("pannumber not specified in the Configuration.properties file.");		
	}
	public static String getmsmenumber(){
		String msmenumber = properties.getProperty("msmenumber");
		if(msmenumber!= null) return msmenumber;
		else throw new RuntimeException("msmenumber not specified in the Configuration.properties file.");		
	}
	public static String getmatorser(){
		String matorser = properties.getProperty("matorser");
		if(matorser!= null) return matorser;
		else throw new RuntimeException("matorser not specified in the Configuration.properties file.");		
	}
	public static String gettypeofbusiness(){
		String typeofbusiness = properties.getProperty("typeofbusiness");
		if(typeofbusiness!= null) return typeofbusiness;
		else throw new RuntimeException("typeofbusiness not specified in the Configuration.properties file.");		
	}
	public static String getyearofestablish(){
		String yearofestablish = properties.getProperty("yearofestablish");
		if(yearofestablish!= null) return yearofestablish;
		else throw new RuntimeException("yearofestablish not specified in the Configuration.properties file.");		
	}
	public static String getmajorcleint(){
		String majorcleint = properties.getProperty("majorcleint");
		if(majorcleint!= null) return majorcleint;
		else throw new RuntimeException("majorcleint not specified in the Configuration.properties file.");		
	}
	public static String getbankname(){
		String bankname = properties.getProperty("bankname");
		if(bankname!= null) return bankname;
		else throw new RuntimeException("bankname not specified in the Configuration.properties file.");		
	}
	public static String getaccountno(){
		String accountno = properties.getProperty("accountno");
		if(accountno!= null) return accountno;
		else throw new RuntimeException("accountno not specified in the Configuration.properties file.");		
	}
	public static String getbenificiaryname(){
		String benificiaryname = properties.getProperty("benificiaryname");
		if(benificiaryname!= null) return benificiaryname;
		else throw new RuntimeException("benificiaryname not specified in the Configuration.properties file.");		
	}
	public static String getbrachname(){
		String brachname = properties.getProperty("brachname");
		if(brachname!= null) return brachname;
		else throw new RuntimeException("brachname not specified in the Configuration.properties file.");		
	}
	public static String getifsccode(){
		String ifsccode = properties.getProperty("ifsccode");
		if(ifsccode!= null) return ifsccode;
		else throw new RuntimeException("ifsccode not specified in the Configuration.properties file.");		
	}
	public static String getdocuments(){
		String documents = properties.getProperty("documents");
		if(documents!= null) return documents;
		else throw new RuntimeException("documents not specified in the Configuration.properties file.");		
	}
	public static String getjustcomments(){
		String justcomments = properties.getProperty("justcomments");
		if(justcomments!= null) return justcomments;
		else throw new RuntimeException("justcomments not specified in the Configuration.properties file.");		
	}
	public static String getvendorcomments(){
		String vendorcomments = properties.getProperty("vendorcomments");
		if(vendorcomments!= null) return vendorcomments;
		else throw new RuntimeException("vendorcomments not specified in the Configuration.properties file.");		
	}
	public static String getcompanycode(){
		String companycode = properties.getProperty("companycode");
		if(companycode!= null) return companycode;
		else throw new RuntimeException("companycode not specified in the Configuration.properties file.");		
	}
	public static String getpaymentterms(){
		String paymentterms = properties.getProperty("paymentterms");
		if(paymentterms!= null) return paymentterms;
		else throw new RuntimeException("paymentterms not specified in the Configuration.properties file.");		
	}
	public static String getpurpose(){
		String purpose = properties.getProperty("purpose");
		if(purpose!= null) return purpose;
		else throw new RuntimeException("purpose not specified in the Configuration.properties file.");		
	}
	public static String getfile(){
		String file = properties.getProperty("file");
		if(file!= null) return file;
		else throw new RuntimeException("file not specified in the Configuration.properties file.");		
	}
	public static String getcomments(){
		String comments = properties.getProperty("comments");
		if(comments!= null) return comments;
		else throw new RuntimeException("comments not specified in the Configuration.properties file.");		
	}
	public static String getrejcomments(){
		String rejcomments = properties.getProperty("rejcomments");
		if(rejcomments!= null) return rejcomments;
		else throw new RuntimeException("rejcomments not specified in the Configuration.properties file.");		
	}
	public static String getreturncomments(){
		String returncomments = properties.getProperty("returncomments");
		if(returncomments!= null) return returncomments;
		else throw new RuntimeException("returncomments not specified in the Configuration.properties file.");		
	}
	public static String gettype(){
		String type = properties.getProperty("type");
		if(type!= null) return type;
		else throw new RuntimeException("type not specified in the Configuration.properties file.");		
	}
	public static String getcode(){
		String code = properties.getProperty("code");
		if(code!= null) return code;
		else throw new RuntimeException("code not specified in the Configuration.properties file.");		
	}
}
