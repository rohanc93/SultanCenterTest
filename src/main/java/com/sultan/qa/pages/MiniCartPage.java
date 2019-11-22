package com.sultan.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sultan.qa.base.TestBase;

public class MiniCartPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='floatingCartTitle showcart']")
	WebElement cartIcon;
	
	@FindBy(xpath="//li[1]//div[1]//div[1]//div[1]//div[2]//input[3]")
	WebElement incQty;
	
	@FindBy(xpath="//li[1]//div[1]//div[1]//div[1]//div[2]//input[1]")
	WebElement decQty;
	
	@FindBy(xpath="//button[@class='update-cart-item']")
	WebElement updateCartBtn;
	
	@FindBy(xpath="//li[1]//div[1]//div[1]//strong[1]//div[1]//a[1]")
	WebElement removeBtn;
	
	@FindBy(xpath="//div[@class='header content']//li")
	List <WebElement> miniProds;
	
	@FindBy(xpath="//input[@class='item-qty cart-item-qty']")
	WebElement qtyCount;
	
	public MiniCartPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void increaseQty() throws InterruptedException {
		Thread.sleep(3000);
		cartIcon.click();
		String count1 = qtyCount.getAttribute("data-item-qty");
		Thread.sleep(3000);
		incQty.click();
		Thread.sleep(3000);
		updateCartBtn.click();
		Thread.sleep(3000);
		String count2 = qtyCount.getAttribute("data-item-qty");
		if(count1!=count2) {
			System.out.println("Quantity increased");
		}else {
			System.out.println("Quantity not increased");
		}		
	}
	
	public void decreaseQty() throws InterruptedException {
		Thread.sleep(3000);
		cartIcon.click();
		String count1 = qtyCount.getAttribute("data-item-qty");
		Thread.sleep(3000);
		decQty.click();
		Thread.sleep(3000);
		updateCartBtn.click();
		Thread.sleep(3000);
		String count2 = qtyCount.getAttribute("data-item-qty");
		if(count1!=count2) {
			System.out.println("Quantity decreased");
		}else {
			System.out.println("Quantity not decreased");
		}
	}
	
	public void removeItem() throws InterruptedException {
		Thread.sleep(3000);
		cartIcon.click();
		int count1 = miniProds.size();
		Thread.sleep(3000);
		removeBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'action-primary action-accept')]")).click();
		Thread.sleep(3000);
		int count2 = miniProds.size();
		if(count1 !=count2) {
			System.out.println("item removal success");
		}else {
			System.out.println("item not removed");
		}
	}
	
	
}

