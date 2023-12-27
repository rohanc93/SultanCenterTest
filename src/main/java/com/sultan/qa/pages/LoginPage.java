package com.sultan.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sultan.qa.pages.HomePage;
import com.sultan.qa.base.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 20);

	// PageFactory (webelements)
	@FindBy(linkText = "Login")
	WebElement signInBtn;

	@FindBy(xpath = "//div[@class='inputs did-floating-label-content']")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "send2")
	WebElement signInBtn2;

	@FindBy(xpath = "//a[@class='logo']//img")
	WebElement sultanLogo;

	@FindBy(linkText = "Forgot Your Password?")
	WebElement fgtPassLink;

	@FindBy(id = "email_address")
	WebElement resetPass;

	@FindBy(xpath = "//button[@class='action submit primary']")
	WebElement resetBtn;

	@FindBy(xpath = "//div[@class='page messages']")
	static WebElement resetCnfmtn;

	@FindBy(xpath = "//span[contains(text(),'Welcome, Rohan!')]")
	WebElement welcomeText;

	// Initializing PageFactory elements
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	// Actions (functions)
	public String validateLoginPageTitle() {
	return driver.getTitle();	
	
	}

	public boolean validateSultanImage() {
		return sultanLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws IOException, InterruptedException {
		// signInBtn.click();
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		signInBtn2.click();
		Thread.sleep(5000);
		//String title = driver.getTitle();
	
		System.out.println(welcomeText);
		if (welcomeText.isDisplayed()) {
			System.out.println("Login Successfull");
		} else {
			System.out.println("Login Failed");
		}
		return new HomePage();
	}

	public boolean validateSocialIcons() {
		List<WebElement> icons = driver.findElements(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li/a"));
		/*
		 * for(int i= 0 ; i<icons.size();i++) {
		 * System.out.println(icons.get(i).getAttribute("title")); }
		 */
		// System.out.println(icons.size());
		if (icons.size() == 5) {
			return true;
		}
		return false;
	}

	public boolean validateFooterLinks() {
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='foot_col']/ul/li/a"));
		/*
		 * for (int i = 0; i < links.size(); i++) {
		 * System.out.println(links.get(i).isDisplayed());
		 * 
		 * }
		 */if (links.size() == 14) {
			return true;
		}
		return false;

	}

	public void fgtPasswdLink(String email) throws InterruptedException {
		fgtPassLink.click();
		resetPass.clear();
		resetPass.sendKeys(email);
		resetBtn.click();
		Thread.sleep(5000);
		if (resetCnfmtn.getText().contains(email)) {
			System.out.println("Password reset link sent successfully");
		} else {
			System.out.println("Password reset link not sent successfully");
		}

	}

	public void nonloggedInCheckout(String un, String pwd) throws IOException, InterruptedException {
		// signInBtn.click();
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		signInBtn2.click();
		Thread.sleep(5000);
		if (welcomeText.getText().contains("Welcome, Rohan!")) {
			System.out.println("Login Success");
		} else {
			System.out.println("login Fail");
		}

	}
	
	
}
