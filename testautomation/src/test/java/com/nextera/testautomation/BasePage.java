package com.nextera.testautomation;

import java.util.List;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
	private String pageName;
	private List<WebElement> listOfWebElements;

	public String getName() {
		return pageName;
	}

	public void setName(String name) {
		pageName = name;
	}

	/**
	 * @return the listOfWebElements
	 */
	public List<WebElement> getListOfWebElements() {
		return listOfWebElements;
	}

	/**
	 * @param listOfWebElements
	 *            the listOfWebElements to set
	 */
	public void setListOfWebElements(List<WebElement> listOfWebElements) {
		this.listOfWebElements = listOfWebElements;
	}

}
