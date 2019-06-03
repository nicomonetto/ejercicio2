package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.HotelSearchPage;

public class EjercicioTres {

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
	public void EjercicioAcamicaTres() {
		//Punto 1 y 2
		Booking home = new Booking(myDriver);
		home.PresionarHotelDesdeHeader();
		home.PresionarHotelOnlyTab();
		home.IngresarOrigenHotel("Montevideo, Uruguay");
		home.seleccionarFechaCheckInHotel("07/20/2019");
		home.seleccionarFechaCheckOutHotel("08/09/2019");
		home.presionarSearchButtonHotel();
		
		//Punto 3 a y b
		HotelSearchPage hotel = new HotelSearchPage(myDriver);
		hotel.VerificarSponsoredFirst();
		hotel.VerificarDiscountBanner10Off();
	}
	
	@AfterTest
	public void afterTest() { 
			myDriver.close();
		}
}
