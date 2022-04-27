package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.CartPage;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;
import com.sultan.qa.pages.SearchPage;

public class AddToCart extends TestBase {
	LoginPage lp;
	SearchPage sp;
	HomePage hp;

	public AddToCart() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		lp = new LoginPage();
		sp = new SearchPage();
		hp = new HomePage();
		
	}
	
	@Test(priority=1 ,enabled=true , description ="add to cart")
	public void addToCart() throws IOException, InterruptedException {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password")); 
		sp.navigateUrl();
		sp.addToCart();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
}

