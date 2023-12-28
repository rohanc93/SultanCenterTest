package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.DeliveryPopUp;
import com.sultan.qa.pages.FooterPage;
import com.sultan.qa.pages.HomePage;

public class FooterPageTest extends TestBase
{
	FooterPage fp;
	DeliveryPopUp dp;
	
	public FooterPageTest() throws IOException {
		super();
		
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		fp = new FooterPage();
		dp = new DeliveryPopUp();
		}
	
	@Test
	public void checkFooterElements() throws InterruptedException
	{	dp.selectStdDeliveryArea("Abdally");
		fp.footerPresence();
		fp.footerLinks();
		fp.checkFooterLogo();
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}
