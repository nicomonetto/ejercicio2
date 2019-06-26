package com.automation.training.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.*;

public class SelectPage extends BasePage {
	
	private Select dropdown;	
			
	public void buscarDropDown(){
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
		dropdown = new Select(driver.findElement(By.id("sortDropdown")));
		Assert.assertEquals(dropdown.getOptions().get(0).getText(), "Price (Lowest)");
		Assert.assertEquals(dropdown.getOptions().get(1).getText(), "Price (Highest)");
		Assert.assertEquals(dropdown.getOptions().get(2).getText(), "Duration (Shortest)");
		Assert.assertEquals(dropdown.getOptions().get(3).getText(), "Duration (Longest)");
		Assert.assertEquals(dropdown.getOptions().get(4).getText(), "Departure (Earliest)");
		Assert.assertEquals(dropdown.getOptions().get(5).getText(), "Departure (Latest)");
		Assert.assertEquals(dropdown.getOptions().get(6).getText(), "Arrival (Earliest)");
		Assert.assertEquals(dropdown.getOptions().get(7).getText(), "Arrival (Latest)");
		System.out.println("Dropdown Completo");		
	}
	
	public void ordenarPorDuration() {					
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		dropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("sortDropdown"))));
		dropdown.getOptions().get(2).click();	
		System.out.println("Ordenamiento por Duracion OK");			
	}
		
//	public void identificarSelectButton() {
//		
//	WebDriverWait wait = new WebDriverWait(driver, 10);	
//	WebElement lista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flightModuleList")));
//	List<WebElement> listado = lista.findElements(By.tagName("li"));
//			
//		for (int i=0; i<listado.size(); i++) {
//			if(listado.get(i).findElement(By.tagName("button")) != null){
//				Assert.assertEquals((listado.get(i).findElement(By.tagName("button"))).isDisplayed(), true);
//				System.out.println("El boton Select esta presente en la oferta: ");
//			}
//		}
//	}		
	
	public void SeleccionarVueloIda() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement lista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flightModuleList")));
		List<WebElement> listado = lista.findElements(By.tagName("li"));
		List<WebElement> divs = listado.get(0).findElements(By.tagName("div"));
		WebElement boton = divs.get(1).findElement(By.tagName("button"));
		
		if(boton.isEnabled()) {
			boton.click();
			System.out.println("Vuelo Ida Seleccionado");
		}
		
		WebElement boton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic-economy-tray-content-1\"]/div/article/div[1]/button")));
		
		if(boton2.isEnabled()) {
			boton2.click();
			System.out.println("Vuelo Ida Confirmado");
		}						
	}	
	
	public void SeleccionarVueloVuelta() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		WebElement lista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flightModuleList")));
		List<WebElement> listado = lista.findElements(By.tagName("li"));
		List<WebElement> divs = listado.get(2).findElements(By.tagName("div"));
		WebElement boton = divs.get(1).findElement(By.tagName("button"));
		
		if(boton.isDisplayed()) {
			boton.click();
			System.out.println("Vuelo Vuelta Seleccionado");
		}
				
		WebElement boton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic-economy-tray-content-3\"]/div/article/div[1]/button")));
		
		if(boton2.isDisplayed()) {
			boton2.click();
			System.out.println("Vuelo Vuelta Confirmado");
		}				
	}

	public void Modal() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement nothanks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forcedChoiceNoThanks")));
		if(nothanks.isDisplayed()) {
			Actions act = new Actions(driver);
			act.moveToElement(nothanks).click().build().perform();
			System.out.println("No Thanks Modal apretado");
		}		
	}	

	public void AgregarAuto() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement auto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gt320100\"]/div/div[2]/div[2]/div/button")));	
		auto.click();
		System.out.println("Auto Agregado OK");
	}
	
	public void PresionarFinalDetailsButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlightUDPBookNowButton1\"]/button")));	
		boton.click();
		System.out.println("Final Details button presionado");
	}
	
	public SelectPage(WebDriver driver) {
		super(driver);
	}	
	
}	

