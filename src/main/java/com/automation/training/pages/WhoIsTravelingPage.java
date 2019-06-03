package com.automation.training.pages;

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
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"preferences\"]/form/fieldset/h2")));	
		Assert.assertEquals(titulo.isDisplayed(), true);
		System.out.println("Who is Traveling Titulo OK");
	}
	
	public void VerificarProtectYourFlight() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement flight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"insurance\"]/section/header/h2")));	
		Assert.assertEquals(flight.isDisplayed(), true);
		System.out.println("Protect your flight OK");
	}
	
	public void VerificarTotal() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalPriceForTrip")));	
		Assert.assertEquals(total.isDisplayed(), true);
		System.out.println("Total Flight OK");
	}
	
	public void VerificarPriceGuarantee() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best-price-guarantee\"]/div/h3")));	
		Assert.assertEquals(price.isDisplayed(), true);
		System.out.println("Precio Garantizado OK");
	}
	
	public void SeleccionarContinuar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complete-booking")));	
		Assert.assertEquals(boton.isDisplayed(), true);
		System.out.println("Boton Continuar Booking OK");
	}
	
	public void VerificarFlight() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement flight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"trip-summary\"]/div[1]/div/a")));	
		Assert.assertEquals(flight.isDisplayed(), true);
		System.out.println("Vuelo Confirmado en Summary OK");
	}
	
	public void VerificarHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement hotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"trip-summary\"]/div[2]/div/a")));	
		Assert.assertEquals(hotel.isDisplayed(), true);
		System.out.println("Hotel Confirmado en Summary OK");
	}
	
	public void VerificarAuto() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement auto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"trip-summary\"]/div[3]/div/a")));	
		Assert.assertEquals(auto.isDisplayed(), true);
		System.out.println("Auto Confirmado en Summary OK");
	}
	
	public void VerificarTotalVueloHotelAuto() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"trip-summary\"]/div[4]/div/div[3]/div[1]/div[1]/div/span")));	
		Assert.assertEquals(total.isDisplayed(), true);
		System.out.println("Total: " + total.getText().toString());
	}

	
}
