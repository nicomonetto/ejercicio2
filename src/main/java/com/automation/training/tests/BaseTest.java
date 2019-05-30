package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.SelectPage;

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
		home.IngresarOrigen("LAS");
		home.ingresarDestino("LLAX");
		home.seleccionarFechaDeparture("06/10/2019");
		home.seleccionarFechaArrival("06/17/2019");
		home.presionarSearchButton();
	}
	
	@Test
	public void ExerciseTwoA() {
		SelectPage select = new SelectPage(myDriver);
		select.buscarDropDown();
		select.identificarSelectButton();
		select.ordenarPorDuration();
		select.SeleccionarVuelo();
		select.confirmarVuelo();
	}
}
