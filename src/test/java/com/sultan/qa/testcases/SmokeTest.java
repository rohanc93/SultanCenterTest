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
	LoginPage lp;
	HomePage hp;
	CartPage cp;
	SearchPage sp;
	MiniCartPage mp;
	TimeslotPage tp;
	PlaceOrderPage pp;
	DeliveryPopUp dp;
	
	public SmokeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod()
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin")); // for signinurl1 use O as value , signinurl use 1
		//System.out.println("isLogin : " + prop.getProperty("isLogin"));
		lp = new LoginPage();
		sp = new SearchPage();
		cp = new CartPage();
		hp = new HomePage();
		mp = new MiniCartPage();
		pp = new PlaceOrderPage();
		tp = new TimeslotPage();
		dp= new DeliveryPopUp();
	}

	@Test(priority = 1, enabled = true)
	public void loggedInUserCheckout() throws IOException, InterruptedException {
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		dp.selectCTCStore();
		Thread.sleep(3000);
		sp.search("milk");
		Thread.sleep(5000);
		sp.addToCart();
		Thread.sleep(3000);
		mp.usecartIcon();
		Thread.sleep(4000);
		cp.clickProceedToCheckout();
		Thread.sleep(5000);
		tp.selectSlot();
		pp.selectPayment();
		pp.placeOrder();
		pp.orderSuccess();

	}

	@Test(enabled = false)
	public void guestUserCheckout() throws InterruptedException, IOException {
		dp.selectDeliveryArea("salmiya");
		Thread.sleep(5000);
		sp.addToCart();
		Thread.sleep(3000);
		mp.usecartIcon();
		Thread.sleep(3000);
		cp.clickProceedToCheckout();
		lp.nonloggedInCheckout(prop.getProperty("username"), prop.getProperty("password"));
		cp.clickProceedToCheckout();
		Thread.sleep(20000);
		tp.selectSlot();
		pp.selectPayment();
		pp.placeOrder();
		pp.orderSuccess();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
