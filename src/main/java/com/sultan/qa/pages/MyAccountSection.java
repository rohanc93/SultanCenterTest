package com.sultan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sultan.qa.base.TestBase;

public class MyAccountSection extends TestBase {

	@FindBy(xpath = "//span[@class='my_accont_click']")
	WebElement myAccBtn;

	@FindBy(xpath = "//ul[@class='MyAccountHoverDiv']//a[contains(text(),'Overview')]")
	WebElement overviewBtn;

	@FindBy(xpath = "//div[@class='box box-information']//span[contains(text(),'Edit')]")
	WebElement editLink;

	@FindBy(linkText = "Change Password")
	WebElement changePassLink;

	@FindBy(xpath = "//div[@class='box box-newsletter']//span[contains(text(),'Edit')]")
	WebElement newsEditLink;

	@FindBy(id = "change-email")
	WebElement emailCheckBox;

	@FindBy(id = "email")
	WebElement changeEmail;

	@FindBy(id = "current-password")
	WebElement changePass;

	@FindBy(xpath = "//button[@class='action save primary']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement msg;

	@FindBy(id = "change-password")
	WebElement changePassCheck;

	@FindBy(id = "password")
	WebElement newPass;

	@FindBy(id = "password-confirmation")
	WebElement cnfmNewPass;

	@FindBy(xpath = "//div[@class='column main']//li[1]//div[1]//div[1]//a[1]")
	WebElement editAddress;

	@FindBy(xpath = "//a[contains(text(),'Account Information')]")
	WebElement accInfo;

	@FindBy(linkText = "My Shopping Lists")
	WebElement shoppingList;

	@FindBy(id = "mwishlist-create")
	WebElement editShopping;

	@FindBy(xpath = "//button[@class='action primary']")
	WebElement createList;

	@FindBy(xpath = "//a[@id='edit_icon_rename_68448']")
	WebElement editList;

	@FindBy(id = "wishlist_tab_name_68448")
	WebElement renameList;

	public MyAccountSection() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	public void validateEditAccInfo(String email, String pwd) throws InterruptedException {
		Thread.sleep(5000);
		myAccBtn.click();
		Thread.sleep(5000);
		overviewBtn.click();
		Thread.sleep(5000);
		editLink.click();
		Thread.sleep(3000);
		emailCheckBox.click();
		Thread.sleep(3000);
		changeEmail.clear();
		changeEmail.sendKeys(email);
		Thread.sleep(2000);
		changePass.clear();
		changePass.sendKeys(pwd);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveBtn);
		saveBtn.click();
		String successMsg = msg.getText();
		// System.out.println(successMsg);
		if (successMsg.equalsIgnoreCase("You saved the account information.")) {
			System.out.println("Account info updation succes");
		} else {
			System.out.println("Account info updation failure");
		}
	}

	public void validateEditAccInfo(String currPwd, String newPwd, String cfmPwd) throws InterruptedException {
		Thread.sleep(5000);
		myAccBtn.click();
		Thread.sleep(5000);
		overviewBtn.click();
		Thread.sleep(5000);
		editLink.click();
		Thread.sleep(3000);
		changePassCheck.click();
		Thread.sleep(3000);
		changePass.sendKeys(currPwd);
		newPass.sendKeys(newPwd);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", cnfmNewPass);
		cnfmNewPass.sendKeys(cfmPwd);
		saveBtn.click();
		String successMsg = msg.getText();
		// System.out.println(successMsg);
		if (successMsg.equalsIgnoreCase("You saved the account information.")) {
			System.out.println("Account info updation succes");
		} else {
			System.out.println("Account info updation failure");
		}
	}

	public void myAddresses() throws InterruptedException {
		try {
			Thread.sleep(4000);
			myAccBtn.click();
			Thread.sleep(4000);
			overviewBtn.click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[contains(text(),'My Addresses')]")).click();
			Thread.sleep(3000);
			/*
			 * List<WebElement> add =
			 * driver.findElements(By.xpath("//li//div[1]//address[1]")); for(int i =0 ;
			 * i<add.size();i++) { System.out.println(add.get(i)); }
			 */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", editAddress);
			Thread.sleep(3000);
			// editAddress.click();
			if (editAddress.getAttribute("href")
					.matches("https://www.sultan-center.com/customer/address/edit/id/16072/")) {
				editAddress.click();
				Thread.sleep(3000);
			} else {
				System.out.println("address not found");
			}

			// System.out.println(add.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeInterest(Integer i) throws InterruptedException {
		Thread.sleep(5000);
		myAccBtn.click();
		Thread.sleep(3000);
		overviewBtn.click();
		Thread.sleep(3000);
		accInfo.click();
		Thread.sleep(3000);
		Select interest = new Select(driver.findElement(By.id("interestprofile")));
		interest.selectByIndex(i);
		Thread.sleep(3000);
		saveBtn.click();

	}

	public void createShoppingList(String shoppingListName) throws InterruptedException {
		Thread.sleep(5000);
		myAccBtn.click();
		Thread.sleep(3000);
		overviewBtn.click();
		Thread.sleep(5000);
		shoppingList.click();
		Thread.sleep(3000);
		editShopping.sendKeys(shoppingListName);
		Thread.sleep(3000);
		createList.click();
	}

	public void editShoppingList(String rename) throws InterruptedException {
		Thread.sleep(5000);
		myAccBtn.click();
		Thread.sleep(3000);
		overviewBtn.click();
		Thread.sleep(5000);
		shoppingList.click();
		Thread.sleep(3000);
		/*
		 * List<WebElement> noOfList =
		 * driver.findElements(By.xpath("//div[@id='mwishlist-tabs-outer']//div"));
		 * System.out.println(noOfList.size());
		 */
		if (editList.getAttribute("id").matches("edit_icon_rename_68448")) {
			Thread.sleep(3000);
			editList.click();
			Thread.sleep(3000);
			renameList.sendKeys(rename);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='column main']")).click();
			Thread.sleep(3000);
		}
	}

}
