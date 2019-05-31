package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	public WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver pDriver) {
		wait = new WebDriverWait(pDriver, 10);
		driver = pDriver;
		PageFactory.initElements(pDriver, this);
	}
	
	public WebDriverWait getWait() {
		return wait;
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	public void dispose() {
		if (driver != null){
			driver.quit();
		}
	}	
}
