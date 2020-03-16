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
	static String total, total1;
	static float i, i1;
	WebDriverWait wait = new WebDriverWait(driver, 60);

	@FindBy(xpath = "//div[@class='minicart-wrapper cart_outer']")
	WebElement cartIcon;

	@FindBy(xpath="//a[@class='action viewcart']")
	WebElement viewCartBtn;

	@FindBy(xpath = "//div[@class='cart_add_note']//span[@class='tooltip addNoteCartPage']")
	WebElement addNote;

	@FindBy(name = "addNoteVal")
	WebElement editNoteBox;

	@FindBy(name = "savenotebtn")
	WebElement saveNoteBtn;

	@FindBy(xpath = "//div[@class='actions-toolbar']//a[@class='action action-delete']")
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

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement removeCouponBtn;

	@FindBy(xpath = "//li[@class='item']//button[@class='action primary checkout']")
	WebElement checkoutBtn;

	@FindBy(xpath = "//span[@class='total_value']")
	WebElement grandTotal;
	
	@FindBy(xpath="//div[@class='control qty']//input[@title='Qty']")
	WebElement qtyCount;
	
	@FindBy(xpath="//div//input[@class='qty_btn_inc']")
	WebElement qtyInc;
	
	@FindBy(xpath="//div//input[@class='qty_btn_dec']")
	WebElement qtyDec;
	
	 @FindBy(xpath="//form[@id='form-validate']//tbody//tr[1]//td[1]")
	 List<WebElement> prodCount;
	 
	 @FindBy(xpath="//span[contains(text(),'Save Cart As List')]")
	 WebElement saveCartListBtn;
	 
	 @FindBy(xpath="//label[contains(text(),'OR create a new List')]")
	 WebElement createNewList;
	 
	 @FindBy(xpath="//input[@id='mwishlist_new']")
	 WebElement newListName;
	 
	 @FindBy(xpath="//button[@id='mwishlist_popup_add']")
	 WebElement addListBtn;
	 
	 @FindBy(xpath="//div[contains(text(),'All Items has been Added to your Shopping List.')]")
	 WebElement addListSuccessMsg;
	 
	 @FindBy(xpath="//div[@class='cart_note_title']")
	 WebElement scrollForCoupon;
	 
	 
	public CartPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public void increaseQty() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		Thread.sleep(3000);
		//List<WebElement> prodCount = driver.findElements(By.xpath("//form[@id='form-validate']//tbody//tr[1]//td[1]"));
		//System.out.println(prodCount.size());
		String count = qtyCount.getAttribute("value");
		//System.out.println(count);
		qtyInc.click();
		String count1 = qtyCount.getAttribute("value");
		//System.out.println(count1);
		 if (count != count1)
		 { 
			 System.out.println("Qty increased"); 
			 }
		 else {
		 System.out.println("Qty not increased");
		 }	 
	}

	public void decreaseQty() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		Thread.sleep(3000);
		String count = qtyCount.getAttribute("value");
		qtyDec.click();
		String count1 = qtyCount.getAttribute("value");
		if (count != count1) {
			System.out.println("Qty Decreased");
		} else {
			System.out.println("Qty not decreased");
		}
	}

	
	public void addNote(String note) throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		Thread.sleep(3000);
		addNote.click();
		editNoteBox.clear();
		editNoteBox.sendKeys(note);
		saveNoteBtn.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(3000);

	}

	public void removeItem() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		Thread.sleep(3000);
		int count = prodCount.size();
		//System.out.println(count);
		 Thread.sleep(3000);
		 removeItem.click(); 
		 Thread.sleep(6000);
		 int count1 = prodCount.size(); 
		 //System.out.println(count1); 
		 if (count != count1) {
			 System.out.println("product removal success"); 
		 	} 
		 else 
		 {
			 System.out.println("product not removed");
		 }
		 
	}

	public void emptyCart() throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		Thread.sleep(3000);
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

	public void saveCartAsList(String wishlistName) throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		Thread.sleep(3000);
		saveCartListBtn.click();
		Thread.sleep(2000);
		createNewList.click();
		Thread.sleep(2000);
		newListName.sendKeys(wishlistName);
		addListBtn.click();
		String msg = addListSuccessMsg.getText();
		//System.out.println(msg);
		if(msg.equals("All Items has been Added to your Shopping List.")) {
			System.out.println("Save cart as List success");
		}
		else {
			System.out.println("Save cart as List Failure");
		}
	}
	
	
	public void couponCode(String coupon) throws InterruptedException {
		cartIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='minicart-wrapper cart_outer']")));
		cartIcon.click();
		Thread.sleep(2000);
		viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action viewcart']")));
		viewCartBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollForCoupon);
		//removeCouponBtn = wait.until(
				//ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='action apply primary']")));
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
		checkoutBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@class='item']//button[@class='action primary checkout']")));
		checkoutBtn.click();
	}

	public void incQty() {
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//input[@class='qty_btn_inc']")).click();
		}
	}

	public void incQtyList() {
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//button[@class='incr_qty'][contains(text(),'+')]")).click();
		}
	}

	public void grandTotal() {
		total = grandTotal.getText();
		String[] s = total.split("\\s+");
		i = Float.parseFloat(s[1]);
	}

	public void grandTotal1() {
		total1 = grandTotal.getText();
		String[] s = total1.split("\\s+");
		i1 = Float.parseFloat(s[1]);
		if (i1 > 6) {
			clickProceedToCheckout();
		} else {
			System.out.println("Cart total is less");
		}

	}

	public void nonLoggedInCheckout() {

	}

}
