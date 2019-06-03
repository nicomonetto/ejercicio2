package com.automation.training.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RoomsPage extends BasePage {

	public RoomsPage(WebDriver driver) {
		super(driver);		
	}
	
	public void VerificarTituloHotel() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		
		String windowHandle = driver.getWindowHandle();
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    
	    ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    System.out.println("Total Tabs: " + tabs.size());
	    driver.switchTo().window(tabs.get(1).toString());
	    
		System.out.println(driver.getCurrentUrl().toString());
		WebElement hotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotel-name")));
        Assert.assertEquals(hotel.isDisplayed(), true);
		System.out.println("Hotel Verificado: " + hotel.getText().toString());  			
	}
	
	public void VerificarPriceGuarantee() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hpg-menu")));	
		Assert.assertEquals(price.isDisplayed(), true);
		System.out.println("Price Guarantee OK");
	}
	
	public void VerificarBotonRoom() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mock-book-button")));	
		Assert.assertEquals(boton.isDisplayed(), true);
		System.out.println("Boton Choose a Room OK");
	}
	
	public void SeleccionarPrimeraRoom() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rooms-and-rates\"]/article[2]/div/div/div[2]/div[2]/a")));	
		boton.click();
		System.out.println("Room Seleccionada OK");
	}
	
	
}
