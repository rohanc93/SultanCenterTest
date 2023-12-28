package com.sultan.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sultan.qa.base.TestBase;

public class DeliveryPopUp  extends TestBase{
	
	
	@FindBy(xpath="//div[2]//button[@class='grocery grocery-btn']")
	WebElement std;
	
	@FindBy(xpath="//div[2]//button[@class='rush rush-btn']")
	WebElement rush;
	
	@FindBy(xpath="//input[@class='did-floating-input']")
	WebElement deliveringTo;
	
	@FindBy(xpath="//div//ul[@class='autocomplete-results']")
	WebElement areaDropDwn;
	
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
	
	
	public void selectStdDeliveryArea(String stdArea) throws InterruptedException {
		Thread.sleep(2000);
		deliveringTo.click();
		//deliveringTo.sendKeys(area);
		Thread.sleep(2000);
		List<WebElement> options = areaDropDwn.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals(stdArea))
		    {
		        option.click();
		        break;
		    }
		}
		Thread.sleep(5000);
		continueShopBtn.click();
	}
	
	public void selectRushDeliveryArea(String rushArea) throws InterruptedException {
		rush.click();
		Thread.sleep(3000);
		deliveringTo.click();
		//deliveringTo.sendKeys(area);
		Thread.sleep(5000);
		List<WebElement> options = areaDropDwn.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals(rushArea))
		    {
		        option.click();
		        break;
		    }
		}
		Thread.sleep(5000);
		continueShopBtn.click();
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
