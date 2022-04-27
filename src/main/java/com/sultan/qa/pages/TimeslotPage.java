package com.sultan.qa.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sultan.qa.base.TestBase;

public class TimeslotPage extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	@FindBy(xpath="//span[contains(text(),'Change Address')]")
	WebElement chngAddBtn;
	
	@FindBy(xpath="//span[contains(text(),'Ship Here')]")
	WebElement shipHereBTn;
	
	@FindBy(xpath="//button[@class='button action continue primary']")
	WebElement nxtBtn;
	
	@FindBy(xpath="//tr[16]//td[4]")
	WebElement tsBtn;
	
	@FindBy(xpath="//button[@class='button action continue primary']")
	WebElement checkoutBtn;
	
	@FindBy(xpath="//input[@name='radio']")
	WebElement tsBtn1;
	

	public TimeslotPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean chngAddRedirection() {
		chngAddBtn.click();	
		String url = driver.getCurrentUrl();
		if(url.equals("https://m2staging.sultan-center.com/customer/address/")) {
			return true;
		}
		return false;
	}
	
/*	public void selectTimeslot() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[@class='control']//textarea"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		 tsBtn = wait.until( ExpectedConditions.visibilityOfElementLocated(By.
		 xpath("//tr[16]//td[4]")));
		 tsBtn.click();
		 
		  nxtBtn = wait.until( ExpectedConditions.visibilityOfElementLocated(By.
		 xpath("//button[@class='button action continue primary']"))); nxtBtn.click();
		 
		 		//checkoutBtn.click();	
	}*/
	
	public void selectSlot() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", tsBtn1);
		driver.findElements(By.xpath("//input[@name='radio']")).get(0).click();
		Thread.sleep(3000);
		if(tsBtn1.isSelected()) {
			System.out.println("Timeslot selected");
		}
		else {
			System.out.println("Timeslot selection failed");
		}
		checkoutBtn.click();
		
	}

}
