package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.*;

import java.util.List;

import static java.lang.Thread.*;

public class SelectPage extends BasePage {
	
	private Select dropdown;	
			
	public void buscarDropDown(){

		dropdown = new Select(getDriver().findElement(By.id("sortDropdown")));
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
		dropdown = new Select(getWait().until(ExpectedConditions.elementToBeClickable(By.id("sortDropdown"))));
		if(dropdown.getOptions() != null){
			dropdown.getOptions().get(2).click();
			System.out.println("Ordenamiento por "+dropdown.getOptions().get(2).getText().toString()+" OK");
		}
	}

	public void verificarObjetos() {
		WebElement lista = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#flightModuleList")));
		List<WebElement> listado = lista.findElements(By.className("grid-container"));
		System.out.println(listado.size());
		WebElement temp =null;

		for (int i=1; i<listado.size(); i++){

			temp=listado.get(i);

			Assert.assertTrue(temp.findElement(By.cssSelector("button.btn-secondary.btn-action.t-select-btn")).isDisplayed());
			Assert.assertTrue(temp.findElement(By.cssSelector("span.duration-emphasis")).isDisplayed());
			Assert.assertTrue(temp.findElement(By.cssSelector("span.show-flight-details")).isDisplayed());

			System.out.println(i);
		}
	}

	public void seleccionarVueloDeparture() {
		WebElement boton1 = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul#flightModuleList>li:nth-child(1) button")));
		boton1.click();
		System.out.println("Vuelo Ida Seleccionado");
		if (getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul#flightModuleList>li:nth-child(1)>div:nth-child(3)>div button"))).isDisplayed()) {
			WebElement boton2 = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul#flightModuleList>li:nth-child(1)>div:nth-child(3)>div button")));
			boton2.click();
			System.out.println("Vuelo Ida Confirmado");
		}
	}

	public void seleccionarVueloReturn() {
		WebElement boton3 = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul#flightModuleList>li:nth-child(3) button")));
		boton3.click();
		System.out.println("Vuelo Vuelta Seleccionado");
		if(getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul#flightModuleList>li:nth-child(3)>div:nth-child(3)>div button"))).isDisplayed()){
			WebElement boton4 = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul#flightModuleList>li:nth-child(3)>div:nth-child(3)>div button")));
			boton4.click();
			System.out.println("Vuelo Vuelta Confirmado");
		}
	}

	public void Modal() {
		WebElement link = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("forcedChoiceNoThanks")));
		Actions act = new Actions(getDriver());
		act.moveToElement(link).click().build().perform();
		System.out.println("Modal No Thanks apretado");
	}
	
	public void PresionarFinalDetailsButton() {
		WebElement boton = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlightUDPBookNowButton1\"]/button")));
		boton.click();
		System.out.println("Final Details button presionado");
	}
	
	public SelectPage(WebDriver driver) {
		super(driver);
	}
}	

