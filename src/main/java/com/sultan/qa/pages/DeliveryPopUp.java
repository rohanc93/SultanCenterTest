package com.sultan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sultan.qa.base.TestBase;

public class DeliveryPopUp  extends TestBase{
	
	@FindBy(xpath="//input[@id='select_home_delivery']")
	WebElement chooseArea;
	
	@FindBy(xpath="//button[@id='submit_process']")
	WebElement continueShopBtn;
	
	@FindBy(xpath="//aside[contains(@class,'_show')]")
	WebElement outClick;

	public DeliveryPopUp() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectDeliveryArea(String area) throws InterruptedException {
		chooseArea.click();
		chooseArea.sendKeys(area);
		Thread.sleep(5000);
		chooseArea.sendKeys(Keys.DOWN , Keys.ENTER);
		Thread.sleep(5000);
		//continueShopBtn.click();
	}

}
