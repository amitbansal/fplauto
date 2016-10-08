package com.nextera.testautomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class SearchResultPage {

	
	public SearchResultPage(WebDriver driver){
		
         //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

	
	static Logger log = Logger.getLogger(HomePage.class);
	
	@FindBy(xpath="//*[@id='title_1']/span")
	private WebElement FirstResult;

	public WebElement getFirstResult() {
		return FirstResult;
	}

	public void setFirstResult(WebElement firstResult) {
		FirstResult = firstResult;
	}	
	
	
}
