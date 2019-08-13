package com.automation.training.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WhoIsTravelingPage extends BasePage {

	public WhoIsTravelingPage(WebDriver driver) {
		super(driver);		
	}
	
	public void VerificarTitulo() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					
		WebElement titulo = driver.findElement(By.className("faceoff-module-title"));	
		Assert.assertEquals(titulo.getText().toString(), "Who's traveling?");
		System.out.println("Who is Traveling Titulo OK");
	}
	
	public void VerificarProtectYourFlight() {
		WebElement flight = driver.findElement(By.cssSelector("article#insurance"));
		Assert.assertEquals(flight.isDisplayed(), true);
		System.out.println("Protect your flight OK");
	}
	
	public void VerificarTotal() {
		WebElement total = driver.findElement(By.id("totalPriceForTrip"));	
		Assert.assertEquals(total.isDisplayed(), true);
		System.out.println("Total Flight OK");
	}
	
	public void VerificarPriceGuarantee() {
		
		WebElement price = driver.findElement(By.cssSelector("article#best-price-guarantee"));
		Assert.assertEquals(price.isDisplayed(), true);
		System.out.println("Precio Garantizado OK");
	}
	
	public void VerificarBotonContinuar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complete-booking")));	
		Assert.assertEquals(boton.isDisplayed(), true);
		System.out.println("Boton Continuar Booking OK");
	}
	
	public void VerificarFlight() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement flight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.trip-summary>div:nth-child(2)>div>div")));
		Assert.assertEquals(flight.isDisplayed(), true);
		System.out.println("Vuelo Confirmado en Summary OK");
	}
	
	public void VerificarHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement hotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.trip-summary>div:nth-child(3)>div>div")));
		Assert.assertEquals(hotel.isDisplayed(), true);
		System.out.println("Hotel Confirmado en Summary OK");
	}
	
	public void VerificarTotalVueloHotelAuto() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.multi-item-price-breakdown-summary>div>div:nth-child(3)>div:nth-child(3)>span:nth-child(2)")));
		Assert.assertEquals(total.isDisplayed(), true);
		System.out.println("Total: " + total.getText().toString());
	}
}
