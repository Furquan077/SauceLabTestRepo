package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelInputdata {
	
	String InputDataSheetpath = "C:\\Users\\ADMIN\\eclipse-workspace\\SauceLabTest\\src\\main\\java\\com\\TestData\\inputdata.xlsx";

	public void getsheetname() {
try {
		File file = new File(InputDataSheetpath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		
		workbook.getSheet("logindata");
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



		
	}
	}
	
