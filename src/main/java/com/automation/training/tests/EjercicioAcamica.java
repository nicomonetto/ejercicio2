package com.automation.training.tests;

import com.automation.training.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class EjercicioAcamica {
	
	WebDriver myDriver;

	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(@Optional("browser") String browser) {
		
		switch (browser){
		case "Chrome":
			try {

				WebDriverManager.chromedriver().setup();
				//System.getProperty("line.separator");
				myDriver = new ChromeDriver();
				myDriver.manage().window().maximize();
				myDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				myDriver.get("https://www.travelocity.com/");
				break;
			}
			catch(Exception e) {
				e.printStackTrace();
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
				e.printStackTrace();
			}
		}		
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
		select.verificarObjetos();
		select.seleccionarVueloDeparture();
		select.seleccionarVueloReturn();
		select.Modal();
				
		//Ejercicio 6 y 7
		TripPage trip = new TripPage(myDriver);
		trip.VerificarTotal();
		trip.VerificarDepartureData();
		trip.VerificarReturnData();
		trip.VerificarPriceGuarantee();
		trip.SeleccionarContinuar();
				
		//Ejercicio 8
		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
		traveling.VerificarTitulo();
		traveling.VerificarPriceGuarantee();
		traveling.VerificarProtectYourFlight();
		traveling.VerificarTotal();
		traveling.VerificarBotonContinuar();
	}	
	
	@Test(priority=1)
	public void EjercicioAcamicaDos() throws Exception{
		//Punto 1 y 2
		Booking home = new Booking(myDriver);
		home.PresionarPackageButton();
		home.PresionarFlightHotel();
		home.IngresarOrigenPackage("Las Vegas, NV (LAS-McCarran Intl.)");
		home.ingresarDestinoPackage("Los Angeles, CA (LAX-Los Angeles Intl.)");
		home.seleccionarFechaDeparturePackage();
		home.seleccionarFechaArrivalPackage();
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
		select.seleccionarVueloDeparture();
		select.seleccionarVueloReturn();
		select.PresionarFinalDetailsButton();
		
		//Punto 11, 12 y 13
		WhoIsTravelingPage traveling = new WhoIsTravelingPage(myDriver);
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
		home.seleccionarFechaCheckInHotel();
		home.seleccionarFechaCheckOutHotel();
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
		home.seleccionarFechaDeparturePackage();
		home.seleccionarFechaArrivalPackage();
		home.presionarCheckOnlyNeedHotelForPartOfMyStay();
		home.seleccionarFechaHotelIdaAfterCheckbox("07/10/2019");
		home.seleccionarFechaArrivalPackageAfterCheckbox("07/15/2019");
		home.presionarSearchButtonPackage();
		home.VerificarErrorMessage();
	}
	
	@Test(priority=4)
	public void EjercicioAcamicaCinco() {
		//Punto 1, 2, 3, 4 
		Booking home = new Booking(myDriver);
		home.PresionarCruiseTab();
		home.seleccionarGoingToDropdown();
		home.seleccionarFechaDepartsCruise();
		home.seleccionarFechaDepartsLateCruise();
		home.presionarSearchButtonCruise();

		//Punto 5
		CruiseSearchPage cruise = new CruiseSearchPage(myDriver);
		cruise.SeleccionarCruiseLength();
		cruise.OrdenarPorPrice();
		cruise.ValidarDescuentos();
		cruise.SeleccionarCrucero();
	}

//	@AfterTest
//	public void afterTest() {
//			myDriver.close();
//		}

}


