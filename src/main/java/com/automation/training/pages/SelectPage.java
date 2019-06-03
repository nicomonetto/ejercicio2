package com.automation.training.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.*;

public class SelectPage extends BasePage {
	
	public SelectPage(WebDriver driver) {
		super(driver);
	}
		
	public void buscarDropDown(){
			
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
		System.out.println("Ordenamiento por Duracion OK");
	}
	
	public void SeleccionarVueloIda() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-module-2019-07-20t06:15:00-07:00-coach-las-lax-dl-2920_2019-07-25t19:47:00-07:00-coach-lax-las-ua-2048_\"]/div[1]/div[1]/div[2]/div/div[2]/button")));	
		boton.click();
		System.out.println("Vuelo ida seleccionado OK");
	} 
	
	public void SeleccionarVueloVuelta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-module-2019-07-20t06:15:00-07:00-coach-las-lax-dl-2920_2019-07-25t21:00:00-07:00-coach-lax-las-ua-325_\"]/div[1]/div[1]/div[2]/div/div[2]/button")));		
		boton.click();
		System.out.println("Vuelo vuelta seleccionado OK");		
	}
	
	public void confirmarVuelo() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement seleccionar;
		WebElement modal;
		Actions action = new Actions(driver);
					
		if(driver.findElements(By.xpath("//*[@id=\"xSellHotelForcedChoice\"]/div")).size() !=0) {
			modal = driver.findElement(By.id("forcedChoiceNoThanks"));
			action.moveToElement(modal).click().build().perform();
			System.out.println("No Thanks Modal apretado OK");			
		}else {
		
		if(driver.findElements(By.xpath("//*[@id=\"basic-economy-tray-content-3\"]/div/div/div[1]/button")).size() !=0){
			 seleccionar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic-economy-tray-content-3\"]/div/div/div[1]/button")));	
			 seleccionar.click();
			 System.out.println("Vuelo vuelta confirmado OK");	
		}else 
			{
				if(driver.findElements(By.xpath("//*[@id=\\\"basic-economy-tray-content-3\\\"]/div/article/div[1]/button")).size() !=0){ 		
				seleccionar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic-economy-tray-content-3\"]/div/article/div[1]/button")));
				seleccionar.click();
				System.out.println("Vuelo vuelta confirmado OK");
			}	
			}
		}
	}	

	public void Modal() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement nothanks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forcedChoiceNoThanks")));
		nothanks.click();
		System.out.println("No Thanks apretado");
	}
	
	public void SeleccionVueloIdaAfterHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-module-2019-07-20t13:30:00-07:00-coach-las-lax-nk-561_2019-08-09t15:45:00-07:00-coach-lax-sfo-ua-460-coach-sfo-las-ua-728_\"]/div[1]/div[1]/div[2]/div/div[2]/button")));	
		boton.click();
		System.out.println("Vuelo ida seleccionado OK");
	}
	
	public void ConfirmarVueloIdaAfterHotel() {
		WebElement boton;
		if(driver.findElements(By.xpath("//*[@id=\"basic-economy-tray-content-1\"]/div/div/div[1]/button")).size() != 0) {
			boton = driver.findElement(By.xpath("//*[@id=\"basic-economy-tray-content-1\"]/div/div/div[1]/button"));
			boton.click();
			System.out.println("Vuelo ida confirmado OK");
		}else {System.out.println("Confirmacion Vuelo Ida no necesaria");}
	}
	
	
	public void SeleccionVueloVueltaAfterHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-module-2019-07-20t13:30:00-07:00-coach-las-lax-nk-561_2019-08-09t08:35:00-07:00-coach-lax-las-ua-1260_\"]/div[1]/div[1]/div[2]/div/div[2]/button")));	
		boton.click();
		System.out.println("Vuelo Vuelta seleccionado OK");
	}
	
	public void ConfirmarVueloVueltaAfterHotel() {		
		WebElement boton;
		if(driver.findElements(By.xpath("//*[@id=\"basic-economy-tray-content-3\"]/div/div/div[1]/button")).size() != 0) {
			boton = driver.findElement(By.xpath("//*[@id=\"basic-economy-tray-content-3\"]/div/div/div[1]/button"));
			boton.click();
			System.out.println("Vuelo vuelta confirmado OK");
		}else {System.out.println("Confirmacion Vuelo vuelta no necesaria");}		
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
	
}	

