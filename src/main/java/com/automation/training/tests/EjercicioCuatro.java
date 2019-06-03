package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.Booking;
import com.automation.training.pages.HotelSearchPage;

public class EjercicioCuatro {
	
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
	
	@AfterTest
	public void afterTest() { 
			myDriver.close();
		}
}
