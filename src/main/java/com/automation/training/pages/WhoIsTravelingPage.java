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
		Assert.assertEquals(titulo, true);
		System.out.println("Who is Traveling Titulo OK");
	}
	
	public void VerificarProtectYourFlight() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement flight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"insurance\"]/section/header/h2/text()")));	
		Assert.assertEquals(flight, true);
		System.out.println("Protect your flight OK");
	}
	
	public void VerificarTotal() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalPriceForTrip")));	
		Assert.assertEquals(total, true);
		System.out.println("Total Flight OK");
	}
	
	public void VerificarPriceGuarantee() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best-price-guarantee\"]/div/h3")));	
		Assert.assertEquals(price, true);
		System.out.println("Precio Garantizado OK");
	}
	
	public void SeleccionarContinuar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complete-booking")));	
		Assert.assertEquals(boton, true);
		System.out.println("Boton Continuar Booking OK");
	}
}
