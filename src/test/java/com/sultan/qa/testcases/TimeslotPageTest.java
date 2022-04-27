package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.LoginPage;
import com.sultan.qa.pages.SearchPage;
import com.sultan.qa.pages.TimeslotPage;

public class TimeslotPageTest extends TestBase {

	TimeslotPage tsp;
	LoginPage loginPage;
	
	public TimeslotPageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		loginPage = new LoginPage();
		tsp = new TimeslotPage();
	}
	
	@Test(enabled =false)
	public void changeAddRedirection() throws IOException, InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.navigate().to("https://m2staging.sultan-center.com/checkout/");
		tsp.chngAddRedirection();
		
	}
	@Test(enabled=true)
	public void selectTimeslotTest() throws IOException, InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.navigate().to("https://m2staging.sultan-center.com/checkout/");
		tsp.selectSlot();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
