package com.Reportsgenrated;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestBase.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class EXtentRGenrator extends BasePage implements ITestListener{
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	
	@Override
	public void onStart(ITestContext context) {
		spark= new ExtentSparkReporter(System.getProperty("user-dir")+"/extentreport.html");
		spark.config().setReportName("SauceLab-Automation-Report");
		spark.config().setDocumentTitle("SauceLab-Automation");
		spark.config().setTheme(Theme.DARK);
		
		 extent = new ExtentReports();
		 extent.attachReporter(spark);
		 extent.setSystemInfo("Environment", "QA-Automaion");
		 extent.setSystemInfo("OS", "Windows 10");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignAuthor("QA one ");
		
		 }
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, result.getName()+"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, result.getName()+"Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName()+"Test Skipped");
	}



	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
