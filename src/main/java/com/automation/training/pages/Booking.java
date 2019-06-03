package com.automation.training.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Booking extends BasePage {

	public Booking(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightbutton;
	
	@FindBy(id="tab-package-tab-hp")
	private WebElement packagebutton;
		
	public void PresionarFlightButton() {
		flightbutton.click();		
	}
	
	public void PresionarPackageButton() {
		packagebutton.click();
	}
	
	public void PresionarRoundTrip() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement roundtrip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-type-roundtrip-label-hp-flight")));	
		roundtrip.click();
	}
	
	public void PresionarFlightHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement flighthotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fh-fh-hp-package")));	
		Actions action = new Actions(driver);
		action.moveToElement(flighthotel).click().build().perform();		
	}
	
	public void PresionarCruiseTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement flighthotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-cruise-tab-hp")));	
		Actions action = new Actions(driver);
		action.moveToElement(flighthotel).click().build().perform();		
	}
	
	public void PresionarHotelDesdeHeader() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement hotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primary-header-hotel")));	
		Actions action = new Actions(driver);
		action.moveToElement(hotel).click().build().perform();		
	}
	
	public void PresionarHotelOnlyTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement hotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-hotel-tab-hlp")));	
		Actions action = new Actions(driver);
		action.moveToElement(hotel).click().build().perform();		
	}
	
	public void IngresarOrigenPackage(String origen) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement txtSalida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-origin-hp-package")));	
		txtSalida.clear();
		txtSalida.sendKeys(origen);
	}
	
	public void IngresarOrigenHotel(String origen) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement txtSalida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotel-destination-hlp")));	
		txtSalida.clear();
		txtSalida.sendKeys(origen);
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
	
	public void ingresarDestinoPackage(String destino){
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement txtRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-destination-hp-package")));	
		txtRetorno.clear();
		txtRetorno.sendKeys(destino);
	}	
		
	public void seleccionarFechaDeparture(String departuredate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-departing-hp-flight")));
		departing.clear();
		departing.sendKeys(departuredate);
	}
	
	public void seleccionarFechaDeparturePackage(String departuredate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-departing-hp-package")));
		departing.clear();
		departing.sendKeys(departuredate);
	}
	
	public void seleccionarFechaCheckInHotel(String checkindate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotel-checkin-hlp")));
		departing.clear();
		departing.sendKeys(checkindate);
	}
	
	public void seleccionarFechaCheckOutHotel(String checkoutdate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotel-checkout-hlp")));
		arrival.click();
		arrival.clear();
		for(int i=0; i<10; i++)
		{
			arrival.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		arrival.sendKeys(checkoutdate);
	}
	
	public void presionarSearchButtonHotel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcw-hotel-form-hlp\"]/div[8]/label/button")));
		searchButton.click();		
	}
		
	public void seleccionarFechaArrival(String arrivaldate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-returning-hp-flight")));
		arrival.click();
		arrival.clear();
		for(int i=0; i<10; i++)
		{
			arrival.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		arrival.sendKeys(arrivaldate);
	}	
	
	public void seleccionarFechaArrivalPackage(String arrivaldate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-returning-hp-package")));
		arrival.click();
		arrival.clear();
		for(int i=0; i<10; i++)
		{
			arrival.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		arrival.sendKeys(arrivaldate);
	}	
	
	public void presionarSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button")));
		searchButton.click();		
	}
	
	public void presionarSearchButtonPackage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button-hp-package")));
		searchButton.click();
		System.out.println("Search completa");
	}
	
	public void presionarCheckOnlyNeedHotelForPartOfMyStay() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("partialHotelBooking-hp-package")));
		checkbox.click();	
	}
	
	public void seleccionarFechaHotelIdaAfterCheckbox(String checkindate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-checkin-hp-package")));
		departing.clear();
		departing.sendKeys(checkindate);		
	}
	
	public void seleccionarFechaArrivalPackageAfterCheckbox(String arrivaldate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-checkout-hp-package")));
		arrival.click();
		arrival.clear();
		for(int i=0; i<10; i++)
		{
			arrival.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		arrival.sendKeys(arrivaldate);
	}
	
	public void VerificarErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcw-packages-form-hp-package\"]/div[2]/div/ul/li/a")));	
		Assert.assertEquals(error.isDisplayed(), true);
		System.out.println("Error Message: " + error.getText().toString());
	}	
	
	public void seleccionarGoingToDropdown() {
		Select selectItem = new Select(driver.findElement(By.id("cruise-destination-hp-cruise")));
		System.out.println(selectItem.getOptions().toString());		
	}
	
	public void seleccionarFechaDepartsCruise(String checkindate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement departing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cruise-start-date-hp-cruise")));
		departing.clear();
		departing.sendKeys(checkindate);
	}
	
	public void seleccionarFechaDepartsLateCruise(String arrivaldate) {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cruise-end-date-hp-cruise")));
		arrival.click();
		arrival.clear();
		for(int i=0; i<10; i++)
		{
			arrival.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		arrival.sendKeys(arrivaldate);
	}
	
	public void presionarSearchButtonCruise() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcw-cruises-form-hp-cruise\"]/button")));
		checkbox.click();	
	}
	
}
