package com.InterviewDemoProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {
	public static String timeStamp() {
		Date date=new Date();
		String dateString= date.toString().replace(" ", "").replace(":", "");
		return "redingtest01"+dateString+"@mailinator.com";
		
	}
	
	public static Object[][] getdataFromExcel(String sheetName) {
		
		XSSFWorkbook workbook=null;
		File excelfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\InterviewDemoProject\\testdata\\TestData.xlsx");
		try {
		FileInputStream fis=new FileInputStream(excelfile);
		 workbook=new XSSFWorkbook(fis);
		
		}catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		int column=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[row][column];
		for(int i=0;i<row;i++) {
			XSSFRow rowVal=sheet.getRow(i+1);
			for(int j=0;j<column;j++) {
				XSSFCell cell=rowVal.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
				default:
					break;			
			}
		}	
	}
return data;	
}
	
	public static String takeScreenshot(WebDriver driver, String name) {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile=(System.getProperty("user.dir")+"\\Screenshots\\"+ name +".png");
		try {
			FileHandler.copy(srcFile, new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationFile;
	}
	
	
}