package com.nextera.testautomation;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance(String filePath) {
		ExtentReports extent;
		extent = new ExtentReports(filePath, false);
		extent
	     .addSystemInfo("Selenium Version", "2.XX")
	     .addSystemInfo("Platform", "Windows");

		return extent;
	}
}