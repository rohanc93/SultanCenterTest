package com.sultan.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sultan.qa.base.TestBase;

public class CartPage extends TestBase {
	static String total , total1;
	static float i,i1;
	WebDriverWait wait = new WebDriverWait(driver, 60);

	@FindBy(xpath = "//div[@class='floatingCartTitle showcart']")
	WebElement cartIcon;

	@FindBy(xpath = "//a[@class='action viewcart']")
	WebElement viewCart;

	@FindBy(xpath = "//body[@class='checkout-cart-index page-layout-1column default']/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='cart-container']/form[@id='form-validate']/div[@class='cart table-wrapper']/table[@id='shopping-cart-table']/tbody[1]/tr[1]/td[2]/div[1]/div[2]/div[1]")
	WebElement addNote;

	@FindBy(name = "addNoteVal")
	WebElement editNoteBox;

	@FindBy(name = "savenotebtn")
	WebElement saveNoteBtn;

	@FindBy(xpath = "//tbody[1]//tr[1]//td[7]//div[1]//a[1]")
	WebElement removeItem;

	@FindBy(xpath = "//button[@id='empty_cart_button']")
	WebElement emptyCartBtn;

	@FindBy(xpath = "//button[@id='empty_cart_button']")
	WebElement scroll;

	@FindBy(xpath = "//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]")
	WebElement text;

	@FindBy(id = "coupon_code")
	WebElement enterCouponCode;

	@FindBy(xpath = "//button[@class='action apply primary']")
	WebElement applyCouponBtn;

	@FindBy(xpath = "//div[@class='fieldset coupon']//div[@class='primary']")
	WebElement removeCouponBtn;
	
	@FindBy(xpath="//li[@class='item']//button[@class='action primary checkout']")
	WebElement checkoutBtn;
	
	@FindBy(xpath="//span[@class='total_value']")
	WebElement grandTotal;

	public CartPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public void increaseQty() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatingCartTitle showcart']")));
		cartIcon.click();
		viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCart.click();
		Thread.sleep(3000);
		List<WebElement> prodCount = driver.findElements(By.xpath("//form[@id='form-validate']//tbody//tr[1]//td[1]"));
		System.out.println(prodCount.size());
		WebElement qtyCount = driver.findElement(By.xpath("//input[@id='cart-1835878-qty']"));
		String count = qtyCount.getAttribute("value");
		// System.out.println(count);
		driver.findElement(By.xpath("//tbody[1]//tr[1]//td[4]//div[1]//div[1]//input[2]")).click();
		String count1 = qtyCount.getAttribute("value");
		if (count != count1) {
			System.out.println("Qty increased");
		} else {
			System.out.println("Qty not increased");
		}
	}

	public void decreaseQty() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatingCartTitle showcart']")));
		cartIcon.click();
		viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCart.click();
		WebElement qtyCount = driver.findElement(By.xpath("//input[@id='cart-1835878-qty']"));
		String count = qtyCount.getAttribute("value");
		driver.findElement(By.xpath("//tbody[1]//tr[1]//td[4]//div[1]//div[1]//input[1]")).click();
		String count1 = qtyCount.getAttribute("value");
		if (count != count1) {
			System.out.println("Qty Decreased");
		} else {
			System.out.println("Qty not decreased");
		}
	}

	public void addNote(String note) throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatingCartTitle showcart']")));
		cartIcon.click();
		viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCart.click();
		addNote.click();
		editNoteBox.clear();
		editNoteBox.sendKeys(note);
		saveNoteBtn.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(3000);

	}

	public void removeItem() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatingCartTitle showcart']")));
		cartIcon.click();
		viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCart.click();
		// removeItem.click();
		List<WebElement> prodCount = driver.findElements(By.xpath("//form[@id='form-validate']//tbody//tr[1]//td[1]"));
		int count = prodCount.size();
		// System.out.println(count);
		removeItem.click();
		int count1 = prodCount.size();
		// System.out.println(count1);
		if (count != count1) {
			System.out.println("product removal success");
		} else {
			System.out.println("product not removed");
		}
	}

	public void emptyCart() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatingCartTitle showcart']")));
		cartIcon.click();
		viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCart.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		// Thread.sleep(3000);
		emptyCartBtn.click();
		String s = text.getText();
		// System.out.println(s);
		if (s.contains("You have no items in your shopping cart.")) {
			System.out.println("Cart empty success");
		} else {
			System.out.println("cart empty failure");
		}

	}

	public void couponCode(String coupon) throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatingCartTitle showcart']")));
		cartIcon.click();
		viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCart.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		if (removeCouponBtn.isDisplayed() && removeCouponBtn != null) {
			Thread.sleep(3000);
			removeCouponBtn.click();
			Thread.sleep(8000);
			WebElement data1 = driver.findElement(By.xpath("//span[@class='total_value']"));
			String checkTotal1 = data1.getText();
			// enterCouponCode.clear();
			enterCouponCode.sendKeys(coupon);
			Thread.sleep(3000);
			applyCouponBtn.click();
			// Thread.sleep(8000);
			WebElement waitDiscount = driver.findElement(By.xpath("//span[@class='title']"));
			waitDiscount = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']")));
			String checkTotalAfterCodeApllied = data1.getText();
			// System.out.println(checkTotalAfterCodeApllied);
			if (!checkTotalAfterCodeApllied.matches(checkTotal1)) {
				System.out.println("Coupon Apllied successfully");
			} else {
				System.out.println("coupon not applied");
			}
		} else {
			// enterCouponCode.clear();
			WebElement data1 = driver.findElement(By.xpath("//span[@class='total_value']"));
			String checkTotal1 = data1.getText();
			enterCouponCode.sendKeys(coupon);
			Thread.sleep(3000);
			applyCouponBtn.click();
			Thread.sleep(8000);
			WebElement waitDiscount = driver.findElement(By.xpath("//span[@class='title']"));
			waitDiscount = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']")));
			String checkTotalAfterCodeApllied = data1.getText();
			// System.out.println(checkTotalAfterCodeApllied);
			if (!checkTotalAfterCodeApllied.matches(checkTotal1)) {
				System.out.println("Coupon Apllied successfully");
			} else {
				System.out.println("coupon not applied");
			}
		}
	}
	
	public void clickProceedToCheckout() {
		checkoutBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item']//button[@class='action primary checkout']")));
		checkoutBtn.click();
	}
	
	public void incQty() {
		for (int i=0 ; i<3 ;i++ ) {
			driver.findElement(By.xpath("//tbody[1]//tr[1]//td[4]//div[1]//div[1]//input[2]")).click();
		}
	}
	
	public void grandTotal() {
		total = grandTotal.getText();
		String[] s = total.split("\\s+");
		i=Float.parseFloat(s[1]);
	}
	
	
	public void grandTotal1() {
		total1 = grandTotal.getText();
		String[] s = total1.split("\\s+");
		 i1=Float.parseFloat(s[1]);  
		if(i1>6) {
			clickProceedToCheckout();
		}
		else {
			System.out.println("Cart total is less");
		}
		
	}
	
	
}
