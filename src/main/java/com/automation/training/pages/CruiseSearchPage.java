package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CruiseSearchPage extends BasePage{

	public CruiseSearchPage(WebDriver driver) {
		super(driver);		
	}
	
	public void SeleccionarCruiseLength() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement radiobutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("length-10-14-ember1330")));	
		Actions action = new Actions(driver);
		action.moveToElement(radiobutton).click().build().perform();
		System.out.println("Length 10-14 Nights OK");
	}
}
