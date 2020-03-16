package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;
import com.sultan.qa.pages.MyAccountSection;

public class MyAccountSectionTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	MyAccountSection accPage;

	public MyAccountSectionTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		loginPage = new LoginPage();
		homePage = new HomePage();
		accPage = new MyAccountSection();
	}

	@Test(priority = 1, enabled = false)
	public void editAccInfoTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accPage.validateEditAccInfo("rohan@techsevin.com", "123456");
	}

	@Test(priority = 2 , enabled = false)
	public void editAccInfoTest1() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accPage.validateEditAccInfo("123456", "1234567", "1234567");
	}

	@Test(priority = 3, enabled = false)
	public void myAddressTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accPage.myAddresses();
	}

	@Test(priority = 4, enabled = false)
	public void changeInterestTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accPage.changeInterest(4);

	}

	@Test(priority = 5, enabled = false)
	public void createShoppingListTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accPage.createShoppingList("Test1");
	}

	@Test(priority = 6, enabled = false)
	public void editShoppingListTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accPage.editShoppingList("3");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
