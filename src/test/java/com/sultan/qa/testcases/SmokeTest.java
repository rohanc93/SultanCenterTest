package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.CartPage;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;
import com.sultan.qa.pages.MiniCartPage;
import com.sultan.qa.pages.SearchPage;
import com.sultan.qa.pages.TimeslotPage;

public class SmokeTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	SearchPage searchPage;
	MiniCartPage miniCartPage;
	TimeslotPage tsp;
	

	public SmokeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		cartPage = new CartPage();
		homePage = new HomePage();
		miniCartPage = new MiniCartPage();
	}
	
	@Test(priority =1)
	public void loggedInUserCheckout () throws IOException, InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage.search("FISH");
		Thread.sleep(5000);
		searchPage.addToCart();
		Thread.sleep(3000);
		miniCartPage.usecartIcon();
		cartPage.grandTotal();
		cartPage.incQty();
		Thread.sleep(3000);
		cartPage.grandTotal1();
		//cartPage.clickProceedToCheckout();
		Thread.sleep(5000);
		tsp.selectTimeslot();
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/
	

}
