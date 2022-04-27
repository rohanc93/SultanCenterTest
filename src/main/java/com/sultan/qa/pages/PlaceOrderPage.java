package com.sultan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sultan.qa.base.TestBase;

public class PlaceOrderPage extends TestBase {
	
	String successUrl = "https://m2staging.sultan-center.com/checkout/onepage/success/";
	
	@FindBy(xpath="//button[@class='action primary checkout']")
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//span[text()='At Store (Knet,Credit & Cash)']")
	WebElement codBtn;
	
	@FindBy(xpath="//p[contains(text(),'.')]//a")
	WebElement getOrderId;
	
	@FindBy(xpath="//span[contains(text(),'Select Mode of Payment')]")
	WebElement selectTab;

	public PlaceOrderPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectPayment() throws InterruptedException {
		Thread.sleep(5000);
		//selectTab.click();
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", codBtn);*/
		/*boolean b = codBtn.isDisplayed();
		if(b) {
			System.out.println("element present");
		}else {
			System.out.println("not present");
		}*/
		/*WebDriverWait wait= (new WebDriverWait(driver, 5));
		wait.until(ExpectedConditions. invisibilityOfElementLocated(By.xpath("//input[@id='cashondelivery' and @type='radio']")));*/
		codBtn.click();
		Thread.sleep(2000);
	
	}

	public void placeOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", placeOrderBtn);
		driver.findElements(By.xpath("//button[@class='action primary checkout']")).get(1).click();
		//placeOrderBtn.click();
		/*if(codBtn.isSelected()) {
		placeOrderBtn.click();
		}
		else {
			System.out.println("No Payment method");
		}*/
	}
	
	
	
	
	
	public void orderSuccess() {
		if(successUrl.equals("https://m2staging.sultan-center.com/checkout/onepage/success/")) {
			String orderId =getOrderId.getText();
			System.out.println("Your Order placed successfully with order Id :- " + orderId);
		}
		else {
			System.out.println("order Failure"); 
		}
	}
	
	/*public void getOrderId() {
	String orderId =getOrderId.getText();
		System.out.println("Your Order Id is :- " + orderId );
	}*/
}
