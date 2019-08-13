package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Booking extends BasePage {
	
	private String today;
	
	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightbutton;
	
	@FindBy(id="tab-package-tab-hp")
	private WebElement packagebutton;
	
	@FindBy(id="flight-type-roundtrip-label-hp-flight")
	private WebElement roundtrip;
	
	@FindBy(id="fh-fh-hp-package")
	private WebElement flighthotel;
	
	@FindBy(id="flight-departing-hp-flight")
	private WebElement flightdeparturedate;
	
	@FindBy(id="flight-returning-hp-flight")
	private WebElement flightarrivaldate;
	
	@FindBy(id="primary-header-hotel")
	private WebElement headerhotel;
	
	@FindBy(id="tab-hotel-tab-hlp")
	private WebElement hotelonlytab;
	
	@FindBy(id="hotel-destination-hlp")
	private WebElement hoteldestination;
	
	@FindBy(id="package-origin-hp-package")
	private WebElement packageorigin;
	
	@FindBy(id="package-destination-hp-package")
	private WebElement packagedestino;
	
	@FindBy(id="package-departing-hp-package")
	private WebElement packagedeparting;
	
	@FindBy(id="package-returning-hp-package")
	private WebElement packagereturning;
	
	@FindBy(id="tab-cruise-tab-hp")
	private WebElement cruisetab;
	
	@FindBy(id="hotel-checkin-hlp")
	private WebElement hotelcheckin;
	
	@FindBy(id="hotel-checkout-hlp")
	private WebElement hotelcheckout;
	
	@FindBy(id="search-button-hp-package")
	private WebElement searchbuttonpackage;
	
	@FindBy(id="package-checkin-hp-package")
	private WebElement packagecheckin;
	
	@FindBy(id="partialHotelBooking-hp-package")
	private WebElement partialhotel;
	
	@FindBy(id="package-checkout-hp-package")
	private WebElement packagecheckout;	
	
	@FindBy(id="cruise-start-date-hp-cruise")
	private WebElement cruisestartdate;	
	
	@FindBy(id="cruise-end-date-hp-cruise")
	private WebElement cruiseenddate;	
	
	@FindBy(xpath="//*[@id=\"flight-origin-hp-flight\"]")
	private WebElement flightorigen;
	
	@FindBy(xpath="//*[@id=\"flight-destination-hp-flight\"]")
	private WebElement flightdestino;
	
	@FindBy(xpath="//*[@id=\"gcw-hotel-form-hlp\"]/div[8]/label/button")
	private WebElement searchbuttonhotel;
	
	@FindBy(xpath="//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button")
	private WebElement searchbuttonflight;
	
	@FindBy(xpath="//*[@id=\"gcw-packages-form-hp-package\"]/div[2]/div/ul/li/a")
	private WebElement verificarerror;

	public Booking(WebDriver driver) {
		super(driver);		
	}
		
	public void PresionarFlightButton() {
		flightbutton.click();		
	}
	
	public void PresionarPackageButton() {
		packagebutton.click();
	}
	
	public void PresionarRoundTrip() {
		roundtrip.click();
	}
	
	public void PresionarFlightHotel() {
		Actions action = new Actions(driver);
		action.moveToElement(flighthotel).click().build().perform();		
	}
	
	public void PresionarCruiseTab() {
		Actions action = new Actions(driver);
		action.moveToElement(cruisetab).click().build().perform();		
	}
	
	public void PresionarHotelDesdeHeader() {
		Actions action = new Actions(driver);
		action.moveToElement(headerhotel).click().build().perform();		
	}
	
	public void PresionarHotelOnlyTab() {
		Actions action = new Actions(driver);
		action.moveToElement(hotelonlytab).click().build().perform();		
	}
	
	public void IngresarOrigenPackage(String origen) {		
		packageorigin.clear();
		packageorigin.sendKeys(origen);
	}
	
	public void IngresarOrigenHotel(String origen) {
		hoteldestination.clear();
		hoteldestination.sendKeys(origen);
	}
	
	public void IngresarOrigen(String origen){		
		flightorigen.clear();
		flightorigen.sendKeys(origen);
	}
	
	public void ingresarDestino(String destino){
		flightdestino.clear();
		flightdestino.sendKeys(destino);
	}	
	
	public void ingresarDestinoPackage(String destino){
		packagedestino.clear();
		packagedestino.sendKeys(destino);
	}	
	
	public void seleccionarFechaIdaDatePicker() {
		today = getDepartureDate();
		WebElement cal = flightdeparturedate;
		cal.sendKeys(today);
	}
	
	public void seleccionarFechaVueltaDatePicker() {
		today = getReturnDate();
		flightarrivaldate.click();
		flightarrivaldate.clear();
		for(int i=0; i<10; i++)
		{
			flightarrivaldate.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		WebElement cal = flightarrivaldate;
		cal.sendKeys(today);
	}
	
	public String getDepartureDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 60);
		String newDate = dateFormat.format(cal.getTime());
		return newDate;		
	}
	
	public String getReturnDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 67);
		String newDate = dateFormat.format(cal.getTime());
		return newDate;		
	}
	
	public void seleccionarFechaDeparturePackage() {
		today = getDepartureDate();
		WebElement cal = packagedeparting;
		cal.sendKeys(today);
	}
	
	public void seleccionarFechaCheckInHotel() {
		today = getDepartureDate();
		WebElement cal = hotelcheckin;
		cal.sendKeys(today);
	}
	
	public void seleccionarFechaCheckOutHotel() {
		today = getReturnDate();
		hotelcheckout.click();
		hotelcheckout.clear();
		for(int i=0; i<10; i++)
		{
			hotelcheckout.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		WebElement cal = hotelcheckout;
		cal.sendKeys(today);
	}
	
	public void presionarSearchButtonHotel() {
		searchbuttonhotel.click();		
	}
	
	public void seleccionarFechaArrivalPackage() {
		today = getReturnDate();
		packagereturning.click();
		packagereturning.clear();
		for(int i=0; i<10; i++)
		{
			packagereturning.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		WebElement cal = packagereturning;
		cal.sendKeys(today);
	}	
	
	public void presionarSearchButton() {
		searchbuttonflight.click();
		System.out.println("Flight Search realizado");
	}
	
	public void presionarSearchButtonPackage() {
		searchbuttonpackage.click();
	}
	
	public void presionarCheckOnlyNeedHotelForPartOfMyStay() {
		partialhotel.click();	
	}
	
	public void seleccionarFechaHotelIdaAfterCheckbox(String checkindate) {
		packagecheckin.clear();
		packagecheckin.sendKeys(checkindate);		
	}
	
	public void seleccionarFechaArrivalPackageAfterCheckbox(String arrivaldate) {
		packagecheckout.click();
		packagecheckout.clear();
		for(int i=0; i<10; i++)
		{
			packagecheckout.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		packagecheckout.sendKeys(arrivaldate);
	}
	
	public void VerificarErrorMessage() {
		Assert.assertEquals(verificarerror.getText().toString(), "Dates must be between 7/16/2019 and 6/9/2020.");
	}	
	
	public void seleccionarGoingToDropdown() {

		WebElement dropdown = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#cruise-destination-hp-cruise>optgroup:nth-child(2)>option:nth-child(5)")));
		dropdown.click();
	}
	
	public void seleccionarFechaDepartsCruise() {
		today = getDepartureDate();
		WebElement cal = cruisestartdate;
		cal.sendKeys(today);
	}
	
	public void seleccionarFechaDepartsLateCruise() {
		today = getReturnDate();
		cruiseenddate.click();
		cruiseenddate.clear();
		for(int i=0; i<10; i++)
		{
			cruiseenddate.sendKeys(Keys.BACK_SPACE);
			i=i++;
		}
		WebElement cal = cruiseenddate;
		cal.sendKeys(today);
	}
	
	public void presionarSearchButtonCruise() {
		WebElement search = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcw-cruises-form-hp-cruise\"]/button")));
		search.click();
	}
	
}
