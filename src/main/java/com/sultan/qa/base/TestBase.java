package com.sultan.qa.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.sultan.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				//"C:\\sultancenter_staging\\src\\main\\java\\com\\sultan\\qa\\config\\config.properties"
				"R:\\Sultan\\SultanCenterTest\\src\\main\\java\\com\\sultan\\qa\\config\\config.properties");
		prop.load(ip);
	}

	public static void initialization(String isLogin) {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					//"C:\\sultancenter_staging\\src\\main\\resources\\Browsers\\chromedriver.exe"
					"R:\\Sultan\\SultanCenterTest\\src\\main\\resources\\Browsers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					//"C:\\sultancenter_staging\\src\\main\\resources\\Browsers\\geckodriver.exe"
					"R:\\Sultan\\SultanCenterTest\\src\\main\\resources\\Browsers\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					//"C:\\sultancenter_staging\\target\\logs.txt"
					"R:\\Sultan\\SultanCenterTest\\target\\logs.txt");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		try {
			if(isLogin.equals("1"))
			{
				driver.get(prop.getProperty("signinurl"));
				//System.out.println("isLogin : "+ prop.getProperty("signinurl") );
			}else if(isLogin.equals("0")) {
				driver.get(prop.getProperty("signinurl1"));
				//System.out.println("isLogin : "+ prop.getProperty("signinurl1"));
			}else {
				driver.get(prop.getProperty("regurl"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("exception ="+e.getMessage());
		}
		
	}
}
