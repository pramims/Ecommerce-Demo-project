package com.InterviewDemoProject.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.InterviewDemoProject.utilities.Extentreport;
import com.InterviewDemoProject.utilities.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {
	ExtentReports extentsReport;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		extentsReport=Extentreport.generateExtentreport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		test=extentsReport.createTest(testName);
		test.log(Status.INFO, testName+ "test Start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String destinationFile=utilities.takeScreenshot(driver, testname);
		
		test.addScreenCaptureFromPath(destinationFile);
		test.log(Status.INFO,result.getThrowable());
		test.log(Status.FAIL, testname+ "got Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		test.log(Status.SKIP,result.getThrowable());
		test.log(Status.FAIL, testname+"got Failed");
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		File fil;
		extentsReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentreport.html";
		fil=new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(fil.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
