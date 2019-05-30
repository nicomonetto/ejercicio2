package com.automation.training.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Booking extends BasePage {

	private String today;
	
	public Booking(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightbutton;
		
	public void PresionarFlightButton() {
		flightbutton.click();		
	}
	
	public void PresionarRoundTrip() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement roundtrip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-type-roundtrip-label-hp-flight")));	
		roundtrip.click();
	}
	
	public void IngresarOrigen(String origen){
		
	WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement txtOutbound = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-origin-hp-flight\"]")));	
		txtOutbound.clear();
		txtOutbound.sendKeys(origen);
	}
	
	public void ingresarDestino(String destino){
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement txtInbound = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-destination-hp-flight\"]")));	
		txtInbound.clear();
		txtInbound.sendKeys(destino);
	}	
	
	public void seleccionarDeparture() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		today = getCurrentDay();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-departing-hp-flight")));
		departing.click();
		
		WebElement tablefrom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[3]")));
		
		List<WebElement> columns = tablefrom.findElements(By.tagName("td"));
		
		for(WebElement cell: columns) {
			if(cell.getText().equals(today+60)) {
				cell.click();
				break;
			}
		}
	}
	
	
	//Get The Current Day
    private String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
    }
	
	public void seleccionarFechaDeparture(String fechaPartida) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-departing-hp-flight")));
		departing.clear();
		departing.sendKeys(fechaPartida);
	}
		
	public void seleccionarFechaArrival(String fechaArribo) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-returning-hp-flight")));
		arrival.click();
		arrival.clear();
		for(int i=0; i<10; i++)
		{
			arrival.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		arrival.sendKeys(fechaArribo);
	}	
	
	public void presionarSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button")));
		searchButton.click();
		
	}
}
