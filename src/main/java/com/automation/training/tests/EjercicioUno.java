package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.SelectPage;
import com.automation.training.pages.TripPage;
import com.automation.training.pages.WhoIsTravelingPage;

public class EjercicioUno {
	
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
	public void EjercicioAcamicaUno() throws Exception {
		Booking home = new Booking(myDriver);
		home.PresionarFlightButton();	
		home.PresionarRoundTrip();
		home.IngresarOrigen("Las Vegas, NV (LAS-McCarran Intl.)");
		home.ingresarDestino("Los Angeles, CA (LAX-Los Angeles Intl.)");
		home.seleccionarFechaDeparture("07/20/2019");
		home.seleccionarFechaArrival("07/25/2019");
		home.presionarSearchButton();
		
		//Ejercicio 2, 3, 4 y 5
		SelectPage select = new SelectPage(myDriver);
		select.buscarDropDown();
		select.identificarSelectButton();
		select.ordenarPorDuration();
		select.SeleccionarVueloIda();
		select.SeleccionarVueloVuelta();
		select.confirmarVuelo();
		select.Modal();
				
		//Ejercicio 6 y 7 
		TripPage trip = new TripPage(myDriver);
		Thread.sleep(15000);
		trip.VerificarTotal();
		trip.VerificarSalida();
		trip.VerificarVuelta();
		trip.VerificarPriceGuarantee();
		trip.SeleccionarContinuar();
				
		//Ejercicio 8
		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
		traveling.VerificarTitulo();
		traveling.VerificarPriceGuarantee();
		traveling.VerificarProtectYourFlight();
		traveling.VerificarTotal();
		traveling.SeleccionarContinuar();
	}	

	@AfterTest
	public void afterTest() { 
			myDriver.close();
		}		
}


