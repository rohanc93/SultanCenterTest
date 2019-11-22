package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test(priority = 1, enabled = false, description = "gives count of banner on Home page")
	public void countBannerTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag = homePage.countBanner();
		Assert.assertTrue(flag, "No of banners are less/more...");
	}

	@Test(priority = 4, enabled = false)
	public void bannerRedirectionTest() throws InterruptedException, IOException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// homePage.bannerRedirection();
		homePage.bannerRedirect();
	}

	@Test(priority = 2, enabled = false)
	public void multisearchIconEnabled() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag1 = homePage.multiSearch();
		Assert.assertTrue(flag1, "Multisearch Icon is not enabled");
	}

	@Test(priority = 3, enabled = true)
	public void addToCartTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.addToCartHomePage();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
