package com.Basepack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SpectrumDataProvider {
	String filepath = "C:\\Users\\vaishnavi.t\\eclipse-workspace\\VendorPortalwithSAPIntegration\\Resources\\PortalSpectrumDetails.xlsx";
	@DataProvider(name="spectrumusercreation")
	public String[][] usercreate() throws IOException {
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("usercreation");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols =sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows-1][cols];
		for (int i = 0; i <rows-1; i++) {
			for (int j = 0; j <cols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		workbook.close();
		fis.close();
		return data;
	}
	@DataProvider(name="passwordpolicy")
	public String[][] passwordpolicy() throws IOException{
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("passwordpolicy");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols =sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows-1][cols];
		for (int i = 0; i <rows-1; i++) {
			for (int j = 0; j <cols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		workbook.close();
		fis.close();
		return data;
	}
	@DataProvider(name="UOM")
	public String[][] UOM() throws IOException{
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("UOM");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols =sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows-1][cols];
		for (int i = 0; i <rows-1; i++) {
			for (int j = 0; j <cols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		workbook.close();
		fis.close();
		return data;
	}
	@DataProvider(name="state")
	public String[][] State() throws IOException{
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("state");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols =sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows-1][cols];
		for (int i = 0; i <rows-1; i++) {
			for (int j = 0; j <cols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		workbook.close();
		fis.close();
		return data;
	}
	@DataProvider(name="salutation")
	public String[][] Salutation() throws IOException{
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("salutation");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols =sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows-1][cols];
		for (int i = 0; i <rows-1; i++) {
			for (int j = 0; j <cols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		workbook.close();
		fis.close();
		return data;
	}
	@DataProvider(name="designation")
	public String[][] Designation() throws IOException{
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("designation");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols =sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows-1][cols];
		for (int i = 0; i <rows-1; i++) {
			for (int j = 0; j <cols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		workbook.close();
		fis.close();
		return data;
	}
	

}
