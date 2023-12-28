package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.DeliveryPopUp;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;

public class DeliveryPopUpTest extends TestBase
{
	DeliveryPopUp dp;
	HomePage hp;

	public DeliveryPopUpTest() throws IOException {
		super();
	
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		dp = new DeliveryPopUp();	
		hp= new HomePage();
		}

	
	@Test(priority= 1 , enabled=true)
	public void selectStdArea() throws InterruptedException
	{	
		String stdArea = "Abdally";
		dp.selectStdDeliveryArea(stdArea);
		hp.userSelectedArea(stdArea);
	}
	
	@Test(priority= 1 , enabled=false)
	public void selectRushArea() throws InterruptedException
	{
		String rushArea = "Hawalli";
		dp.selectRushDeliveryArea(rushArea);
		hp.userSelectedArea(rushArea);	
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
