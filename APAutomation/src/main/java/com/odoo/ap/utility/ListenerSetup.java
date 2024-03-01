package com.odoo.ap.utility;

import java.time.LocalDateTime;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.odoo.ap.testbase.TestBase;

public class ListenerSetup extends TestBase implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Execution Started :- " +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Execution Finished Successfully :- " +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		CommonMethods.captureScreenshot(result.getName() + "-" + System.currentTimeMillis());
		
		logger.info("Execution Failed and captured Screenshot:- " +result.getName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Execution Skipped :- " +result.getName());
	}	
	
}
