package com.InterviewDemoProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {
	public static ExtentReports generateExtentreport() {
		ExtentReports report =new ExtentReports();
		File extentfile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentreport.html");
		ExtentSparkReporter sparker= new ExtentSparkReporter(extentfile);
		
		sparker.config().setTheme(Theme.DARK);
		sparker.config().setDocumentTitle("ExtentReport");
		sparker.config().setReportName("DemoExecution");
		sparker.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		report.attachReporter(sparker);
		Properties prop=new Properties();
		File file1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\InterViewDemoProject\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(file1);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
				report.setSystemInfo("Application Url:", prop.getProperty("url"));
				report.setSystemInfo("Browser", prop.getProperty("browser"));
				report.setSystemInfo("Email:", prop.getProperty("validUserName"));
				report.setSystemInfo("Password", prop.getProperty("ValidPassword"));
				report.setSystemInfo("Operating System", System.getProperty("os.name"));
				report.setSystemInfo("UserName", System.getProperty("user.name"));
				report.setSystemInfo("Java version", System.getProperty("java.version"));
				
				return report;
		
		
	}
	

}
