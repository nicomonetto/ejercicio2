package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.SelectPage;
import com.automation.training.pages.TripPage;
import com.automation.training.pages.WhoIsTravelingPage;

public class BaseTest {
	
	WebDriver myDriver;
	
	private Booking homepage;	
	
	String os = System.getProperty("os.name").toLowerCase();
	
	@BeforeTest
	public void beforeTest() { 
		
		System.setProperty("webdriver.chrome.driver", "/Users/nicomonetto/Documents/GitHub/ejercicio2/Drivers/chromedriver");
		myDriver = new ChromeDriver();		
		myDriver.manage().window().maximize();
		myDriver.get("https://www.travelocity.com/");
	}
		
	public Booking getBooking() {
		return homepage;
	}
	
	@Test
	public void ExerciseOne() {
		Booking home = new Booking(myDriver);
		home.PresionarFlightButton();	
		home.PresionarRoundTrip();
		home.IngresarOrigen("Las Vegas, NV (LAS-McCarran Intl.)");
		home.ingresarDestino("Los Angeles, CA (LAX-Los Angeles Intl.)");
		home.seleccionarFechaDeparture("07/20/2019");
		home.seleccionarFechaArrival("07/25/2019");
		home.presionarSearchButton();
	}
	
	@Test
	public void ExerciseTwoThreeFourFive() {
		SelectPage select = new SelectPage(myDriver);
		select.buscarDropDown();
		select.identificarSelectButton();
		select.ordenarPorDuration();
		select.SeleccionarVueloIda();
		select.SeleccionarVueloVuelta();
		select.confirmarVuelo();
		select.Modal();
	}
	
	@Test
	public void ExerciseSixSeven() {
		TripPage trip = new TripPage(myDriver);
		trip.VerificarTotal();
		trip.VerificarSalida();
		trip.VerificarVuelta();
		trip.VerificarPriceGuarantee();
	}
	
	@Test
	public void ExerciseEight() {
		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
		traveling.VerificarTitulo();
		traveling.VerificarPriceGuarantee();
		traveling.VerificarProtectYourFlight();
		traveling.VerificarTotal();
	}
	
}
