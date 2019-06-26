package com.automation.training.tests;

import java.util.concurrent.TimeUnit;
import java.net.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.CruiseSearchPage;
import com.automation.training.pages.HotelSearchPage;
import com.automation.training.pages.RoomsPage;
import com.automation.training.pages.SelectPage;
import com.automation.training.pages.TripPage;
import com.automation.training.pages.WhoIsTravelingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EjercicioAcamica {
	
	WebDriver myDriver;	
	
	private Booking homepage;
		
	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(@Optional("browser") String browser) { 
		
		switch (browser){
		case "Chrome":
			try {
				WebDriverManager.chromedriver().setup();				
				myDriver = new ChromeDriver();		
				myDriver.manage().window().maximize();		
				myDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				myDriver.get("https://www.travelocity.com/");
				break;
			}
			catch(Exception e) {
				e.printStackTrace();;
			}
			
		case "Firefox":
			try {
				WebDriverManager.firefoxdriver().setup();
				myDriver = new FirefoxDriver();		
				myDriver.manage().window().maximize();		
				myDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				myDriver.get("https://www.travelocity.com/");
				break;
			}
			catch(Exception e) {
				e.printStackTrace();;
			}
		}		
	}
		
	public Booking getBooking() {
		return homepage;
	}
	
	@Test(priority=0)
	public void EjercicioAcamicaUno() {
		Booking home = new Booking(myDriver);
		home.PresionarFlightButton();	
		home.PresionarRoundTrip();
		home.IngresarOrigen("Las Vegas, NV (LAS-McCarran Intl.)");
		home.ingresarDestino("Los Angeles, CA (LAX-Los Angeles Intl.)");
		home.seleccionarFechaIdaDatePicker();
		home.seleccionarFechaVueltaDatePicker();
		home.presionarSearchButton();
		
		//Ejercicio 2, 3, 4 y 5
		SelectPage select = new SelectPage(myDriver);
		select.buscarDropDown();
		select.ordenarPorDuration();
		select.SeleccionarVueloIda();
		select.SeleccionarVueloVuelta();
		select.Modal();
				
		//Ejercicio 6 y 7 
//		TripPage trip = new TripPage(myDriver);		
//		trip.VerificarTotal();
//		trip.VerificarDepartureData();
//		trip.VerificarReturnData();
//		trip.VerificarPriceGuarantee();
//		trip.SeleccionarContinuar();
				
		//Ejercicio 8
//		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
//		traveling.VerificarTitulo();
//		traveling.VerificarPriceGuarantee();
//		traveling.VerificarProtectYourFlight();
//		traveling.VerificarTotal();
//		traveling.VerificarBotonContinuar();
	}	
	
	@Test(priority=1)
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
		select.SeleccionarVueloIda();
		select.SeleccionarVueloVuelta();
//		select.AgregarAuto();
		select.PresionarFinalDetailsButton();
		
		//Punto 11, 12 y 13
		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
		traveling.VerificarAuto();
		traveling.VerificarFlight();
		traveling.VerificarHotel();
		traveling.VerificarTotalVueloHotelAuto();
	}	
	
	@Test(priority=2)
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
	
	@Test(priority=3)
	public void EjercicioAcamicaCuatro() {
		//Punto 1, 2, 3, 4 y 5
		Booking home = new Booking(myDriver);
		home.PresionarPackageButton();
		home.PresionarFlightHotel();
		home.IngresarOrigenPackage("Las Vegas, NV (LAS-McCarran Intl.)");
		home.ingresarDestinoPackage("Los Angeles, CA (LAX-Los Angeles Intl.)");
		home.seleccionarFechaDeparturePackage("07/20/2019");
		home.seleccionarFechaArrivalPackage("07/25/2019");
		home.presionarCheckOnlyNeedHotelForPartOfMyStay();
		home.seleccionarFechaHotelIdaAfterCheckbox("07/10/2019");
		home.seleccionarFechaArrivalPackageAfterCheckbox("07/15/2019");
		home.presionarSearchButtonPackage();
		home.VerificarErrorMessage();
	}
	
	@Test(priority=4)
	public void EjercicioAcamicaCinco() throws Exception {
		//Punto 1, 2, 3, 4 
		Booking home = new Booking(myDriver);
		home.PresionarCruiseTab();
		home.seleccionarGoingToDropdown();
		home.seleccionarFechaDepartsCruise("07/20/2019");
		home.seleccionarFechaDepartsLateCruise("07/25/2019");
		home.presionarSearchButtonCruise();
		
		//Punto 5
		CruiseSearchPage cruise = new CruiseSearchPage(myDriver);
		cruise.SeleccionarCruiseLength();
		Thread.sleep(5000);
		cruise.OrdenarPorPrice();
		Thread.sleep(10000);
		cruise.ValidarDescuentos();
		cruise.SeleccionarCrucero();
	}

//	@AfterTest
//	public void afterTest() { 
//			myDriver.close();
//		}		
}


