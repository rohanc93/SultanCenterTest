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
	
	@FindBy(xpath="//select[@id='select_click_to_collect']")
	WebElement chooseStore;
	
	@FindBy(xpath="//a[@id='click_to_collect_settings' and @href='#']")
	WebElement deliveryHeader;
	
	@FindBy(xpath="//div[@class='panel header']")
	WebElement click;

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
	
	public void selectCTCStore () throws InterruptedException {
		Thread.sleep(2000);
		
		//click.click();
		/*boolean d = deliveryHeader.isDisplayed();
		if(d) {
			System.out.println("element present");
		}else
		{
			System.out.println("not present");
		}*/
		deliveryHeader.click();
		Select store = new Select(driver.findElement(By.id("select_click_to_collect")));
		store.selectByValue("45");
		continueShopBtn.click();
		Thread.sleep(2000);
	
	}

}
