package com.nextera.testautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.FileUtils;

public class Utilities {

	public static String getsubWindowHandler(WebDriver driver) {
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window
															// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}

		return subWindowHandler;

	}

	public static WebDriver getDriver(String browserName, String nodeURL) {

		DesiredCapabilities cap = new DesiredCapabilities();
		WebDriver driver;
		if (browserName == "mobile") {
			// cap.setPlatform(Platform.ANDROID);
			cap.setCapability("deviceName", "LG521e1e85d29");
			cap.setCapability("platformName", "Android");
			cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		} else {
			cap.setCapability(CapabilityType.BROWSER_NAME, browserName);
			cap.setPlatform(Platform.WINDOWS);
			cap.setCapability(FirefoxDriver.PROFILE, "test");

		}

		try {
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
			return driver;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static WebDriver getDriver(String browserName, String nodeURL, String profileName) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		WebDriver driver;
		if (browserName == "androidmobile") {
			// cap.setPlatform(Platform.ANDROID);
			cap.setCapability("deviceName", "LG521e1e85d29");
			cap.setCapability("platformName", "Android");
			cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		} else {
			cap.setBrowserName(browserName);
			cap.setPlatform(Platform.WINDOWS);
			cap.setCapability(FirefoxDriver.PROFILE, profileName);

		}

		driver = new RemoteWebDriver(new URL(nodeURL), cap);
		return driver;

	}

	public static Object JSonToJava(Person p, String JSON_FILE_PATH){
		FileInputStream fis = null;
	   // InputStreamReader isr =null; 
		try{
			  // new input stream reader is created 
	         fis = new FileInputStream(JSON_FILE_PATH);
	       	    Reader reader = new InputStreamReader(fis);
	            Gson gson = new GsonBuilder().create();
	            p = gson.fromJson(reader, Person.class);
	            System.out.println(p);
	            return p;
		}catch(Exception e){
			}
	 return null;
		}
		 
	
	public static String executeJS(WebDriver driver, String script) {
		if (driver instanceof JavascriptExecutor) {
			return (String) ((JavascriptExecutor) driver).executeScript(script);
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}

	}

	public static void takeScreenshot(WebDriver driver, String filename) {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String linkStatus(URL url) {
		String responseMessage = "";
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();

			responseMessage = http.getResponseMessage();
			http.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseMessage;

	}

	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		for (WebElement e : elements) {
			if (e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;

	}

}
