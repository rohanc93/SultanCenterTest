package com.sultan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.mustache.Model;

import com.sultan.qa.base.TestBase;

public class RegisterationPage extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="phone_number")
	WebElement phoneNo;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="password_confirmation")
	WebElement cnfPassword;
	
	@FindBy(id="no")
	WebElement noLoyaltyRadioBtn;
	
	@FindBy(id="yes")
	WebElement yesLoyaltyRadioBtn;
	
	@FindBy(id="next-btn11")
	WebElement nxtBtn;
	
	@FindBy(id="governorate")
	WebElement governorate;
	
	@FindBy(id="area")
	WebElement area;
	
	@FindBy(id="block_number")
	WebElement blockNo;
	
	@FindBy(id="street_avenue")
	WebElement streetName;
	
	@FindBy(id="building_number")
	WebElement bldgNo;
	
	@FindBy(id="floor_number")
	WebElement floorNo;
	
	@FindBy(id="apartment_number")
	WebElement aptNo;
	
	@FindBy(id="telephone")
	WebElement telephone;
	
	@FindBy(id="landmark")
	WebElement landmark;
	
	@FindBy(id="agree")
	WebElement consentTNC;
	
	@FindBy(id="is_subscribed")
	WebElement newsletterSub;
	
	@FindBy(xpath="//button[@id='register_me']//span[contains(text(),'Create an Account')]")
	WebElement createAccBtn;
	
	@FindBy(id="newsletter")
	WebElement newsletterBox;
	
	@FindBy(xpath="//div[@class='message-success success message']")
	WebElement successMsg;
	
	RegisterationModel model;
	

	public RegisterationPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		 model = new RegisterationModel();

	}
		
	
	public void registerUser(RegisterationModel resModel) throws InterruptedException 
	{
		firstName.sendKeys(resModel.getfName());
		lastName.sendKeys(resModel.getlName());
		email.sendKeys(resModel.getEmail());
		phoneNo.sendKeys(resModel.getPhnNo());
		password.sendKeys(resModel.getPwd());
		cnfPassword.sendKeys(resModel.getCnfPwd());
		newsletterBox.click();
		noLoyaltyRadioBtn.click();
		Thread.sleep(5000);
		nxtBtn.click();
		Thread.sleep(12000);
		Select govt = new Select(governorate);
		govt.selectByIndex(2);
		Thread.sleep(3000);
		Select ar = new Select(area);
		ar.selectByIndex(2);
		Thread.sleep(3000);
		Select blck = new Select(blockNo);
		blck.selectByIndex(1);
		streetName.sendKeys(resModel.getStreetName());
		bldgNo.sendKeys(resModel.getBldgNo());
		floorNo.sendKeys(resModel.getFloorNo());
		aptNo.sendKeys(resModel.getAptNo());
		consentTNC.click();
		String msg= successMsg.getText();
		System.out.println(msg);
		//createAccBtn.click();

	}
}
