package com.sultan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sultan.qa.base.TestBase;
import com.sultan.qa.pages.RegisterationModel;
import com.sultan.qa.pages.RegisterationPage;

public class RegisterationTest extends TestBase{

	RegisterationPage rg;
	
	
	public RegisterationTest() throws IOException {
		super();  
		}
	
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization(prop.getProperty("isLogin"));
		rg = new RegisterationPage();
	}	
	
	@Test
	public void registerTest() throws InterruptedException {
		RegisterationModel resModel = new RegisterationModel();
		resModel.setfName("Rohan");
		resModel.setlName("Chavan");
		resModel.setEmail("rrc8@gmail.com");
		resModel.setPhnNo("45632178");
		resModel.setPwd("123456");
		resModel.setCnfPwd("123456");
		resModel.setStreetName("street");
		resModel.setBldgNo("1B");
		resModel.setFloorNo("1");
		resModel.setAptNo("1A");
		rg.registerUser(resModel);		
	}
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */

}
