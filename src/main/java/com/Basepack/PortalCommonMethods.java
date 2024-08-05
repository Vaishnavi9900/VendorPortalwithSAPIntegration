package com.Basepack;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PortalCommonMethods {
	public static WebDriver driver;
	public String screenshotsubfoldername;
	public static ExtentReports extentreports;
	public static ExtentTest extenttest;
	public String file="C:\\Users\\vaishnavi.t\\eclipse-workspace\\VendorPortalwithSAPIntegration\\Resources\\PortalSpectrumDetails.xlsx";
	protected String cell0val,cell1val,cell2val,cell3val,cell4val,cell5val,cell6val,cell7val,cell8val,cell9val;


	@Parameters("browser")
	@BeforeTest
	public void browserlogin(ITestContext context, @Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://172.16.5.90:8085/Home/");
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName();
		String author = context.getCurrentXmlTest().getParameter("author");
		extenttest = extentreports.createTest(context.getName());
		extenttest.assignAuthor(author);
		extenttest.assignDevice(device);
	}

	@BeforeSuite
	public void initializeExtentReports() {
		ExtentSparkReporter sparkreporter_all = new ExtentSparkReporter("alltests.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter_all);
		extentreports.setSystemInfo("OS", System.getProperty("OS.name"));
		extentreports.setSystemInfo("Java version", System.getProperty("java.version"));
	}

	@AfterSuite
	public void generateExtentReports() throws IOException {
		extentreports.flush();
		Desktop.getDesktop().browse(new File("alltests.html").toURI());
	}

	@AfterTest
	public void checkstatus(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotpath = null;
			screenshotpath = CaptureScreenshot(
					result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + " .jpg");
			extenttest.addScreenCaptureFromPath(screenshotpath);
			extenttest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extenttest.pass(m.getName() + " is passed");
		}
	}

	public String CaptureScreenshot(String filename) {
		if (screenshotsubfoldername == null) {
			LocalDateTime mylocdate = LocalDateTime.now();
			DateTimeFormatter dateform = DateTimeFormatter.ofPattern("ddMMYYYYHHmmss");
			screenshotsubfoldername = mylocdate.format(dateform);
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File(",/Screenshots/" + screenshotsubfoldername + " " + filename);
		try {
			FileUtils.copyFile(sourcefile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	public void clickElement(WebElement element) {
		element.click();
	}
	public void CheckBox(WebElement checkbox) {
		if (!checkbox.isSelected())
			checkbox.click();
	}
	public void takescreenshot() {
		TakesScreenshot tcsc = (TakesScreenshot) driver;
		File srcfile = tcsc.getScreenshotAs(OutputType.FILE);
		if (screenshotsubfoldername == null) {
			LocalDateTime mydateobj = LocalDateTime.now();
			DateTimeFormatter myformobj = DateTimeFormatter.ofPattern("ddMMYYYYHHmmss");
			screenshotsubfoldername = mydateobj.format(myformobj);
			try {
				FileUtils.copyFile(srcfile, new File("./RegistrationFailureScreenshots/screenshots.jpg" + screenshotsubfoldername));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void getimageprint(String webelementname) {
		WebElement img = driver.findElement(By.xpath(""));
		System.out.println("target img " + img.getAttribute("src"));
	}
	public void javascript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void scrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", element);
	}
	public void scrollup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,0)", element);
	}
	public void javascript() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", "");
	}
	public void textbox(WebElement element, String text) {
		element.click();
		//element.clear();
		element.sendKeys(text, Keys.ENTER);
	}
	public void textboxc(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	public void dropdown(WebElement dropdownElement) {
		Select s = new Select(dropdownElement);
		s.isMultiple();
		s.selectByIndex(0);
		// s.selectByValue("audi");
		// s.selectByVisibleText("Audi");
	}
	public void multiseldropdown(WebElement multiSelectDropdownElement) {
		Select s = new Select(multiSelectDropdownElement);
		if (s.isMultiple()) {
			s.selectByIndex(0);
			// s.selectByValue("opel");
			// s.selectByVisibleText("Audi");
			s.deselectByIndex(0);
			s.deselectByValue("opel");
			s.deselectByVisibleText("Audi");
		} else {
			s.selectByVisibleText("Audi");
		}
	}
	public void buttonlabel(WebElement buttonElement) {
		buttonElement.getAttribute("value");
		if (buttonElement.getAttribute("value").equals("ExpectedLabel")) {
			System.out.println("Label is matching");
		} else {
			System.out.println("Label is not matching");
		}
	}
	public void titlematch() {
		driver.getTitle();
		if (driver.getTitle().equals("ExpectedTitle")) {
			System.out.println("Title is as Expected");
		} else {
			System.out.println("Title is not matching");
		}
	}
	public void enterkey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	public void pageup() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).perform();
	}
	public void presssinglekey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
	}
	public void pressmultiplekeys() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.CONTROL.SHIFT.DELETE).perform();
	}
	public void rightclick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	public void doubleclick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void mouseover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void radiobutton(WebElement radiobutton) {
		radiobutton.click();
	}
	public void image(WebElement imageElement) {
		imageElement.isDisplayed();
	}
	public void navigate(String url) {
		driver.navigate().to("url");
	}
	public void backtoprevious() {
		driver.navigate().back();
	}
	public void moveforwardtonext() {
		driver.navigate().forward();
	}
	public void refresh() {
		driver.navigate().refresh();
	}
	public void nexttab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	public void nextwindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	public void windowsize() {
		Dimension size = driver.manage().window().getSize();
		System.out.println("Height is : " + size.getHeight());
		System.out.println("Width is : " + size.getWidth());
	}
	public void javawait() throws InterruptedException {
		Thread.sleep(5000);
	}
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	public void explicitwait(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("xpath"), 0));
	}
	public void fluentwait() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[@id='windowButton']"), 0));
	}
	public void frames() {
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame4");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
	}
	public void alertaccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void alertgettext() {
		Alert alert = driver.switchTo().alert();
		alert.getText();
	}
	public void alertsend() {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("value");
	}
	public void switchtomultiplewindows() {
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.switchTo().window(windows.get(0)); // Switch to Main window"
	}
	public String getcell0value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(0);
		System.out.println(cols);
		cell0val = cols.getStringCellValue();
		return cell0val;
	}
	public String getcell1value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(1);
		cell1val = cols.getStringCellValue();
		return cell1val;
	}
	public String getcell2value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(2);
		cell2val = cols.getStringCellValue();
		return cell2val;
	}
	public String getcell3value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(3);
		cell3val = cols.getStringCellValue();
		return cell3val;
	}
	public String getcell4value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(4);
		cell4val = cols.getStringCellValue();
		return cell4val;
	}
	public String getcell5value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(5);
		cell5val = cols.getStringCellValue();
		return cell5val;
	}
	public String getcell6value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(6);
		cell6val = cols.getStringCellValue();
		return cell6val;
	}
	public String getcell7value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(7);
		cell7val = cols.getStringCellValue();
		return cell7val;
	}
	public String getcell8value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(8);
		cell8val = cols.getStringCellValue();
		return cell8val;
	}
	public String getcell9value(String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		XSSFCell cols = sheet.getRow(1).getCell(9);
		cell9val = cols.getStringCellValue();
		return cell9val;
		
	}
}