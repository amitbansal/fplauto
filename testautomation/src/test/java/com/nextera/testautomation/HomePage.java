package com.nextera.testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class HomePage {
	
	
	public HomePage(WebDriver driver){
		
         //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

	
	static Logger log = Logger.getLogger(HomePage.class);
	
	@FindBy(name="q")
	private WebElement SearchBox;	
	
	@FindBy(name="btnG")
	private WebElement SmallGreenSearchButton;
	
	public void verifyWeather() {
		// TODO Auto-generated method stub
		System.out.println("from verify weather of down level page helper");
		
	}

	
	public void performSearch(String str) {
		SearchBox.click();
		log.info("clicked in the search field");
		SearchBox.sendKeys(str);
		log.info("Entered the text");
		SmallGreenSearchButton.click();
		log.info("Clicked the search button");
		
	}

	public void verifySettings() {
		// TODO Auto-generated method stub

	}

	public void verifyLogo() {
		// TODO Auto-generated method stub
	

	}

}
