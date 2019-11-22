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

public class SearchPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	
	
	
	public SearchPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		searchPage = new SearchPage();
	}
	
	
	@Test
	public void searchTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage.search("fish");
		searchPage.addToCart();
		//Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
