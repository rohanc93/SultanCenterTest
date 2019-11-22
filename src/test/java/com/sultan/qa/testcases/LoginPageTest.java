package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.HomePage;
import com.sultan.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1 , enabled =false)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Customer Login");
	}

	@Test(priority = 2 , enabled =false)
	public void sultanLogoImageTest() {
		boolean flag = loginPage.validateSultanImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3 , enabled =false)
	public void loginTest() throws IOException, InterruptedException {
		// System.out.println("-----" +prop.getProperty("username") + "----");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 4 , enabled =false)
	public void SocialIconsCountTest() {
		boolean flag1 = loginPage.validateSocialIcons();
		Assert.assertTrue(flag1, "Count of social link icons are less/more....");
	}

	@Test(priority = 5 , enabled =false)
	public void footerLinksCountTest() {
		boolean flag2 = loginPage.validateFooterLinks();
		Assert.assertTrue(flag2, "Count of links in footer are less/more....");
	}
	
	@Test(priority = 6)
	public void fgtPwdLinkTest() throws InterruptedException {
		loginPage.fgtPasswdLink("yogita@techsevin.com");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
