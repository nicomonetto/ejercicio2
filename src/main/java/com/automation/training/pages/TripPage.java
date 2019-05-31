package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TripPage extends BasePage {
	
	public TripPage(WebDriver driver) {
		super(driver);		
	}
	
	public void VerificarTotal() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section[2]/div/div[2]/div/div[1]/span[2]")));	
		Assert.assertEquals(total, true);
		System.out.println(total.getText());
	}
	
	public void VerificarSalida() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement salida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section[1]/div[2]/div[1]/div/div/div[1]/div[1]")));	
		Assert.assertEquals(salida, true);
		System.out.println("Datos de salida OK");
	}
	
	public void VerificarVuelta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement vuelta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section[1]/div[2]/div[2]/div/div/div[1]")));	
		Assert.assertEquals(vuelta, true);
		System.out.println("Datos de retorno OK");
	}
	
	public void VerificarPriceGuarantee() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section[2]/div/div[2]/div/div[2]")));	
		Assert.assertEquals(price, true);
		System.out.println("Precio Garantizado OK");
	}
	
	public void SeleccionarContinuar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookButton")));	
		System.out.println("Boton Continuar");
		boton.click();
	}
}
