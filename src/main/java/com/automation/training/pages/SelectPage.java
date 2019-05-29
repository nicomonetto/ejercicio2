package com.automation.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.*;

public class SelectPage extends BasePage {

	public SelectPage(WebDriver driver) {
		super(driver);
	}
		
	public void buscarDropDown() {
		Select selectItem = new Select(driver.findElement(By.id("sortDropdown")));
		Assert.assertEquals(selectItem.getOptions().get(0).getText(), "Price (Lowest)");
		Assert.assertEquals(selectItem.getOptions().get(1).getText(), "Price (Highest)");
		Assert.assertEquals(selectItem.getOptions().get(2).getText(), "Duration (Shortest)");
		Assert.assertEquals(selectItem.getOptions().get(3).getText(), "Duration (Longest)");
		Assert.assertEquals(selectItem.getOptions().get(4).getText(), "Departure (Earliest)");
		Assert.assertEquals(selectItem.getOptions().get(5).getText(), "Departure (Latest)");
		Assert.assertEquals(selectItem.getOptions().get(6).getText(), "Arrival (Earliest)");
		Assert.assertEquals(selectItem.getOptions().get(7).getText(), "Arrival (Latest)");
	}
		
	public void identificarSelectButton() {
		
		List<WebElement> links = driver.findElements(By.id("flightModuleList"));
				
		for (WebElement link : links) { 
			System.out.println(link.getText().trim());
			//Faltan puntos 2.b, 2.c, 2.d
		}
	}	
	
	public void ordenarPorDuration() {
		Select selectItem = new Select(driver.findElement(By.id("sortDropdown")));
		selectItem.getOptions().get(2).click();		
	}
	
	public void SeleccionarVuelo() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-module-2019-06-10t06:15:00-07:00-coach-las-lax-dl-2920_2019-06-17t20:25:00-07:00-coach-lax-las-as-560_\"]/div[1]/div[1]/div[2]/div/div[2]/button")));	
		boton.click();
	}
	
	public void confirmarVuelo() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement seleccionar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic-economy-tray-content-1\"]/div/article/div[1]/button")));	
		seleccionar.click();
	}
	
}
