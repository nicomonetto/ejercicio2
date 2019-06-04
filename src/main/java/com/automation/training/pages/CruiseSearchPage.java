package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CruiseSearchPage extends BasePage{

	public CruiseSearchPage(WebDriver driver) {
		super(driver);		
	}
	
	public void SeleccionarCruiseLength() {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement radiobutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ember1327\"]/div/label")));	
		Actions action = new Actions(driver);
		action.moveToElement(radiobutton).click().build().perform();
		System.out.println("Length 10-14 Nights OK");
	}
	
	public void OrdenarPorPrice() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ordenamiento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container-bar\"]/div/div[2]/div/fieldset/ul/li[3]/button")));
		Actions action = new Actions(driver);
		action.moveToElement(ordenamiento).click().build().perform();
		System.out.println("Ordenamiento por price OK");
	}
	
	public void ValidarDescuentos() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement discount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message-flag flex-flag']")));		
		Assert.assertEquals(discount.isDisplayed(), true);
		System.out.println(discount.getText());		
	}
	
	public void SeleccionarCrucero() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectSailingButton-AQoCbmMSAjIxGIDwz47BLSAMKgNzdGgyAmdiOgNzdGhCAmdi-21")));		
		boton.click();
		
		System.out.println("Crucero con mayor descuento Elegido");
		
		//To extract a number from a string
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement discount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message-flag flex-flag']")));		
//		int a = Integer.parseInt(discount.getText().replaceAll("[^0-9.]", ""));
//		System.out.println(a);		
	}
}
