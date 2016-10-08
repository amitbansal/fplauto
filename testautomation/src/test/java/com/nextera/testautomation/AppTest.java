package com.nextera.testautomation;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AppTest {
	public WebDriver driver;
	private String baseUrl;
	String testName;
	String fileName;
	ExtentReports report;
	ExtentTest test;	
	SearchResultPage searchpage;
	HomePage homePage;
	AutomationConstants SuiteConstants = new AutomationConstants();
	String reportPath=SuiteConstants.Reportfile_Path;
	String suiteName;
	
	@BeforeTest
	public void beforeTest(ITestContext ctx) {
		testName = ctx.getCurrentXmlTest().getName();
		suiteName=ctx.getSuite().getName();
	}
	
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		
		report = ExtentFactory.getInstance(reportPath+suiteName+".html");
		
	}
	
	@Parameters({"browserType"})
	@BeforeMethod
	public void beforeMethod(String browserType) throws MalformedURLException {
		driver = Utilities.getDriver(browserType, SuiteConstants.Hub_URL);
		searchpage= new SearchResultPage(driver);
		homePage= new HomePage(driver);
		baseUrl=SuiteConstants.Base_URL;
		test=report.startTest(testName);
		test.log(LogStatus.INFO, "Entered in Before  method");
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Opened the base URL");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Window maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testMethod1() {
		test.log(LogStatus.INFO, "Entered in test method 1");		
		homePage.performSearch("education");
		WebElement searchResult= searchpage.getFirstResult();
		Assert.assertTrue(searchResult.isDisplayed());
		test.log(LogStatus.PASS, "Verified test method1");
	}

	@Test
	public void testMethod2() {
		test.log(LogStatus.INFO, "Entered in test method 2");
		HomePage page= new HomePage(driver);
		page.performSearch("amit bansal");		
		WebElement searchResult= searchpage.getFirstResult();
		Assert.assertFalse(searchResult.isDisplayed());
		test.log(LogStatus.PASS, "Verified test method2");
	}

	@Test
	public void testMethod3() {
		test.log(LogStatus.INFO, "Entered in test method");
		HomePage page= new HomePage(driver);
		page.performSearch("Energy");
		WebElement searchResult= searchpage.getFirstResult();
		Assert.assertTrue(searchResult.isDisplayed());
		test.log(LogStatus.PASS, "Verified test method3");
	}
	@AfterMethod
	public void tearDown(ITestResult testResult) {
		fileName = SuiteConstants.Screenshot_Path + testName + ".png";
		if(testResult.getStatus()==ITestResult.FAILURE){
			Utilities.takeScreenshot(driver, fileName);
			test.log(LogStatus.WARNING, "Below is the screenshot when the failure happened");
			test.log(LogStatus.FAIL, "test method"+testName+" FAILED",test.addScreenCapture(fileName));
		}
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
