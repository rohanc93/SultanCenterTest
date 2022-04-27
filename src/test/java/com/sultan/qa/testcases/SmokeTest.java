package com.sultan.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.CartPage;
import com.sultan.qa.pages.DeliveryPopUp;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;
import com.sultan.qa.pages.MiniCartPage;
import com.sultan.qa.pages.PlaceOrderPage;
import com.sultan.qa.pages.SearchPage;
import com.sultan.qa.pages.TimeslotPage;

public class SmokeTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	SearchPage searchPage;
	MiniCartPage miniCartPage;
	TimeslotPage tsp;
	PlaceOrderPage po;
	DeliveryPopUp dp;
	
	public SmokeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod()
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin")); // for signinurl1 use O as value , signinurl use 1
		//System.out.println("isLogin : " + prop.getProperty("isLogin"));
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		cartPage = new CartPage();
		homePage = new HomePage();
		miniCartPage = new MiniCartPage();
		po = new PlaceOrderPage();
		tsp = new TimeslotPage();
		dp= new DeliveryPopUp();
	}

	@Test(priority = 1, enabled = true)
	public void loggedInUserCheckout() throws IOException, InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dp.selectCTCStore();
		Thread.sleep(3000);
		//searchPage.navigateUrl();
		searchPage.search("milk");
		Thread.sleep(5000);
		//cartPage.incQtyList();
		searchPage.addToCart();
		Thread.sleep(3000);
		miniCartPage.usecartIcon();
		//cartPage.grandTotal();
		Thread.sleep(4000);
		// cartPage.incQty();
		// Thread.sleep(3000);
		// cartPage.grandTotal1();
		cartPage.clickProceedToCheckout();
		Thread.sleep(10000);
		tsp.selectSlot();
		po.selectPayment();
		po.placeOrder();
		po.orderSuccess();
		//po.getOrderId();
	}

	@Test(enabled = false)
	public void guestUserCheckout() throws InterruptedException, IOException {
		dp.selectDeliveryArea("salmiya");
		searchPage.navigateUrl();
		Thread.sleep(5000);
		cartPage.incQtyList();
		searchPage.addToCart();
		Thread.sleep(3000);
		miniCartPage.usecartIcon();
		cartPage.grandTotal();
		Thread.sleep(3000);
		cartPage.clickProceedToCheckout();
		loginPage.nonloggedInCheckout(prop.getProperty("username"), prop.getProperty("password"));
		cartPage.clickProceedToCheckout();
		Thread.sleep(20000);
		tsp.selectSlot();
		po.placeOrder();
		po.orderSuccess();
		//po.getOrderId();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
