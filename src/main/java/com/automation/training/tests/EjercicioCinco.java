package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.CruiseSearchPage;

public class EjercicioCinco {
WebDriver myDriver;	
	
	private Booking homepage;

	@BeforeTest
	public void beforeTest() { 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nicolas.monetto\\nicoself\\Drivers\\chromedriver.exe");
		myDriver = new ChromeDriver();		
		myDriver.manage().window().maximize();
		myDriver.get("https://www.travelocity.com/");
	}
	
	public Booking getBooking() {
		return homepage;
	}
	
	@Test
	public void EjercicioAcamicaCinco() {
		//Punto 1, 2, 3, 4 
		Booking home = new Booking(myDriver);
		home.PresionarCruiseTab();
		home.seleccionarGoingToDropdown(); //Resta terminar
		home.seleccionarFechaDepartsCruise("07/20/2019");
		home.seleccionarFechaDepartsLateCruise("07/25/2019");
		home.presionarSearchButtonCruise();
		
		//Punto 5
		CruiseSearchPage cruise = new CruiseSearchPage(myDriver);
		cruise.SeleccionarCruiseLength();
	}
}
