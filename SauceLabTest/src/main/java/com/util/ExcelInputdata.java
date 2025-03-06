package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelInputdata {

	@Test(dataProvider = "testdata")
	public void datatest1(String username , String password) throws IOException {
		System.out.println(username+ "......."+password);
	}
	
	@DataProvider(name = "testdata")
	public Object[][]  demo() throws IOException {
		File file = new File("C:\\Users\\ADMIN\\git\\SauceLabPOMTest\\SauceLabTest\\src\\main\\java\\com\\TestData\\inputdata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("logindata");
		 
		 int rowcount = sheet.getLastRowNum();
		 int colcount = sheet.getRow(0).getLastCellNum();
		 
		 Object[][] data = new Object[rowcount][colcount];
		 
		 for(int r=0;r<rowcount;r++) {
			XSSFRow row = sheet.getRow(r+1);
			for(int c=0;c<colcount;c++) {
				XSSFCell cell = row.getCell(c);
				
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				case STRING: 
					data[r][c] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[r][c]	=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[r][c]=cell.getBooleanCellValue();
				}
			}
			
		 }
		return data;
		
		 
		
		 
	}
}
