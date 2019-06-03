package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotelSearchPage extends BasePage{

	public HotelSearchPage(WebDriver driver) {
		super(driver);		
	}
	
	public void VerificarMultiStepIndicator() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement step = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("multiStepIndicatorContainer")));	
		Assert.assertEquals(step.isDisplayed(), true);
		System.out.println("Indicador de Steps OK");
	}
	
	public void VerificarDiscountBanner10Off() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement step = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mer-signup-toggle-btn")));	
		Assert.assertEquals(step.isDisplayed(), true);
		System.out.println("Get an extra 10% banner OK");
	}	
	
	public void VerificarSponsoredFirst() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement step = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"525675_sponsored\"]/div[2]/div/div[1]/div[3]/div/div[1]/span/ul/li[6]")));	
		Assert.assertEquals(step.isDisplayed(), true);
		System.out.println("Sponsored First OK");
	}	
	
	public void VerificarGoogleMap() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement mapa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("googleMapContainer")));	
		Assert.assertEquals(mapa.isDisplayed(), true);
		System.out.println("Google Map OK");
	}
	
	public void VerificarTituloHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelResultTitle")));	
		Assert.assertEquals(titulo.isDisplayed(), true);
		System.out.println("Titulo de Hotel OK");
	}
	
	public void VerificarPropertySearch() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inpHotelNameMirror")));
		Assert.assertEquals(search.isDisplayed(), true);
		System.out.println("Search Field OK");
	}
	
	public void VerificarHotelButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelNameGoBtn")));
		Assert.assertEquals(boton.isDisplayed(), true);
		System.out.println("Boton Hotel OK");
	}
	
	public void OrderByPrice() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sortContainer\"]/div/div/div[2]/div/fieldset/ul/li[3]/button")));
		boton.click();
		System.out.println("Order By Price OK");
	}
	
	public void SeleccionarTresEstrellas() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("star3")));
		boton.click();
		System.out.println("3 Stars OK");
	}
	
	public void SeleccionarPrimeraOpcionTresEstrellas() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"33466320\"]/div[2]/div/a")));
		boton.click();
		System.out.println("Hotel Seleccionado OK");
	}
	
	
}


