package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.HotelSearchPage;
import com.automation.training.pages.RoomsPage;
import com.automation.training.pages.SelectPage;
import com.automation.training.pages.WhoIsTravelingPage;

public class EjercicioDos {

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
	public void EjercicioAcamicaDos() throws Exception {
		//Punto 1 y 2
		Booking home = new Booking(myDriver);
		home.PresionarPackageButton();
		home.PresionarFlightHotel();
		home.IngresarOrigenPackage("Las Vegas, NV (LAS-McCarran Intl.)");
		home.ingresarDestinoPackage("Los Angeles, CA (LAX-Los Angeles Intl.)");
		home.seleccionarFechaDeparturePackage("07/20/2019");
		home.seleccionarFechaArrivalPackage("08/09/2019");
		home.presionarSearchButtonPackage();
		
		//Punto 3, 4 y 5
		Thread.sleep(20000);
		HotelSearchPage hotel = new HotelSearchPage(myDriver);
		hotel.VerificarMultiStepIndicator();
		hotel.VerificarGoogleMap();
		hotel.VerificarHotelButton();
		hotel.VerificarTituloHotel();
		hotel.VerificarPropertySearch();
		hotel.OrderByPrice();
		hotel.SeleccionarTresEstrellas();
		hotel.SeleccionarPrimeraOpcionTresEstrellas();
		
		//Punto 6 y 7
		RoomsPage rooms = new RoomsPage(myDriver);
		rooms.VerificarTituloHotel();
		rooms.VerificarBotonRoom();
		rooms.VerificarPriceGuarantee();
		rooms.SeleccionarPrimeraRoom();
		
		//Punto 8, 9 y 10
		SelectPage select = new SelectPage(myDriver);
		select.SeleccionVueloIdaAfterHotel();
		select.ConfirmarVueloIdaAfterHotel();
		select.SeleccionVueloVueltaAfterHotel();
		select.ConfirmarVueloVueltaAfterHotel();
//		select.AgregarAuto();
		select.PresionarFinalDetailsButton();
		
		//Punto 11, 12 y 13
		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
		traveling.VerificarAuto();
		traveling.VerificarFlight();
		traveling.VerificarHotel();
		traveling.VerificarTotalVueloHotelAuto();
	}	
	
	@AfterTest
	public void afterTest() { 
			myDriver.close();
		}
}
