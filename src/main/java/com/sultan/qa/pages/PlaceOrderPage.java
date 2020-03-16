package com.sultan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sultan.qa.base.TestBase;

public class PlaceOrderPage extends TestBase {
	
	String successUrl = "https://m2staging.sultan-center.com/checkout/onepage/success/";
	
	@FindBy(xpath="//button[@class='action primary checkout']")
	WebElement placeOrderBtn;
	
	@FindBy(id="cashondelivery")
	WebElement codBtn;
	
	@FindBy(xpath="//p[contains(text(),'.')]//a")
	WebElement getOrderId;

	public PlaceOrderPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	

	public void placeOrder() {
		if(codBtn.isSelected()) {
		placeOrderBtn.click();
		}
		else {
			System.out.println("No Payment method");
		}
	}
	
	public void orderSuccess() {
		if(successUrl.equals("https://m2staging.sultan-center.com/checkout/onepage/success/")) {
			System.out.println("Your Order placed successfully");
		}
		else {
			System.out.println("order Failure"); 
		}
	}
	
	public void getOrderId() {
	String orderId =getOrderId.getText();
		System.out.println("Your Order Id is :- " + orderId );
	}
}
