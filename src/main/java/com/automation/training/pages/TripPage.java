package com.automation.training.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TripPage extends BasePage {
	
	public TripPage(WebDriver driver) {
		super(driver);		
	}
		
	public void VerificarTotal() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
		String windowHandle = driver.getWindowHandle();
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    System.out.println("Total Tabs: " + tabs.size());
	    
	    driver.switchTo().window(tabs.get(1).toString());
	    System.out.println(driver.getCurrentUrl().toString());
	    
		WebElement total = driver.findElement(By.className("packagePriceTotal"));
        Assert.assertEquals(total.isDisplayed(), true);
		System.out.println("Total Verificado: " + total.getText().toString());  			
	}	
	
	public void VerificarDepartureData() {
		WebElement departure = driver.findElement(By.cssSelector("section.flightSummaryContainer > div > div:nth-child(2)"));
		assertEquals(departure.isDisplayed(), true);
		System.out.println("Datos Departure OK");
	}
	
	public void VerificarReturnData() {
		WebElement llegada = driver.findElement(By.cssSelector("section.flightSummaryContainer > div > div:nth-child(3)"));
		assertEquals(llegada.isDisplayed(), true);
		System.out.println("Datos Return OK");
	}
	
	public void VerificarPriceGuarantee() {
		WebElement price = driver.findElement(By.className("priceGuarantee"));	
		Assert.assertEquals(price.isDisplayed(), true);
		System.out.println("Precio Garantizado OK");
	}
	
	public void SeleccionarContinuar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookButton")));	
		System.out.println("Boton Continuar");
		boton.click();
	}
}
