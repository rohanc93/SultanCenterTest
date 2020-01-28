package com.sultan.qa.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//tr[@class='row same-day-slot']//td[2]")
	WebElement tsBtn;
	
	@FindBy(xpath="//button[@class='action primary checkout']")
	WebElement checkoutBtn;
	

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
	
	public void selectTimeslot() {
		/*List<WebElement> timeslots = driver.findElements(By.xpath("//div[@id='checkout-step-shipping_method']"));
		System.out.println(timeslots.size());*/
		tsBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='row same-day-slot']//td[2]")));
		tsBtn.click();
		nxtBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button action continue primary']")));
		nxtBtn.click();
		checkoutBtn.click();
		
	}

}
