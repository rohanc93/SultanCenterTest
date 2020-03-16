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

public class MiniCartPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	MiniCartPage miniCartPage;

	public MiniCartPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		loginPage = new LoginPage();
		miniCartPage = new MiniCartPage();
	}
	
	@Test(priority=1 , enabled = false)
	public void incQtyMiniCart() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		miniCartPage.increaseQty();
	}
	
	@Test(priority=2 , enabled = false)
	public void decQtyMiniCart() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		miniCartPage.decreaseQty();
	}
	
	@Test(priority=3 , enabled = true)
	public void removeItemTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		miniCartPage.removeItem();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
