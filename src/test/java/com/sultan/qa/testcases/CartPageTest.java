package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.CartPage;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;

public class CartPageTest extends TestBase {
	LoginPage loginPage;
	CartPage cartPage;
	HomePage homePage;
	
	public CartPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		loginPage = new LoginPage();
		cartPage = new CartPage();
	}
	
	@Test(priority=1 ,enabled=false , description ="increase qty in cart")
	public void incQtyCart() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
		cartPage.increaseQty();
	}
	
	@Test(priority=2 ,enabled =false , description ="decrease qty in cart")
	public void decQtyCart() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.decreaseQty();
	}
	
	@Test(priority=3 ,enabled =false , description ="add note in cart for a product")
	public void addNoteTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.addNote("testtttt");
	}
	
	@Test(priority=4 ,enabled =false, description ="remove item from cart")
	public void removeItemTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.removeItem();
	}
	
	@Test(priority=4 , enabled =false ,description ="empty cart")
	public void emptyCartTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.emptyCart();
		Thread.sleep(5000);
	}
	
	@Test(priority =5 , enabled = true)
	public void applyCouponTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.couponCode("test");
	}
	
	@Test(priority =6 , enabled = false)
	public void saveCartAsListTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.saveCartAsList("Rohan");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	
}
