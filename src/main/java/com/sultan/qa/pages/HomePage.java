package com.sultan.qa.pages;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sultan.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='action advanced search_title_head']")
	WebElement multisearchIcon;

	@FindBy(xpath = "//div[@class='message-success success message']") 
	WebElement msg;

	@FindBy(xpath = "//button[contains(@id,'addtocart')]")
	WebElement addToCart;

	@FindBy(xpath = "//div[@id='new-in-store']/div[@class='owl-wrapper-outer']/div[@class='owl-wrapper']/div/div")
	List<WebElement> inStore;

	@FindBy(xpath = "//div[@class='aw-rbslider-container__item slick-slide']/a/img")
	List<WebElement> banner;
	
	@FindBy(xpath="//div[@class='message-error error message']")
	WebElement errorMsgOOS;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean countBanner() {
		// List<WebElement> banner =
		// driver.findElements(By.xpath("//div[@class='aw-rbslider-container__item
		// slick-slide']/a/img"));
		System.out.println(banner.size());
		if (banner.size() == 4) {
			return true;
		}
		return false;
	}

	/*
	 * public void bannerRedirection() throws InterruptedException {
	 * List<WebElement> banner = driver.findElements(By.
	 * xpath("//div[@class='aw-rbslider-container__item slick-slide']/a")); for(int
	 * i =0 ; i<banner.size();i++) { Thread.sleep(6000);
	 * if(banner.get(i).getAttribute("href")==
	 * "https://www.sultan-center.com/food/snack-beverage/protein-suppliments.html/grenade.html")
	 * {
	 * 
	 * 
	 * Thread.sleep(2000); } System.out.println(banner.get(i).getAttribute("href"));
	 * 
	 * }
	 * 
	 * }
	 */
	/*
	 * public void clickLinkByHref(String href) throws InterruptedException {
	 * List<WebElement> anchors = driver.findElements(By.
	 * xpath("//div[@class='aw-rbslider-container__item slick-slide']/a"));
	 * //List<WebElement> anchors = driver.findElements(By.tagName("a"));
	 * Iterator<WebElement> i = anchors.iterator();
	 * 
	 * while(i.hasNext()) { //Thread.sleep(3000); WebElement anchor = i.next();
	 * if(anchor.getAttribute("href").contains(href)) {
	 * driver.findElement(By.xpath("//button[contains(text(),'2')]")).click();
	 * Thread.sleep(5000); driver.findElement(By.xpath(
	 * "//div[@class='slider-outer-contner']//div[3]//a[1]//img[1]")).click();
	 * //anchor.click(); Thread.sleep(5000); //break; } String url =
	 * driver.getCurrentUrl();
	 * if(url.equals("String url = driver.getCurrentUrl();")) {
	 * System.out.println("Redirection sucess"); }else { System.out.println("fail");
	 * } } }
	 */
	public void bannerRedirect() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'2')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slider-outer-contner']//div[3]//a[1]//img[1]")).click();
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		if (url.equals("https://www.sultan-center.com/food/snack-beverage/chips-snacks-nuts.html?brand_01=SIMPLY+7")) {
			System.out.println("Redirection sucess");
		} else {
			System.out.println("fail");
		}

	}

	public boolean multiSearch() {
		return multisearchIcon.isEnabled();

	}

	public void addToCartHomePage() throws InterruptedException {
		WebElement scroll = driver.findElement(By.xpath("//div[@id='new-in-store']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(3000);
		for (int i = 0; i < inStore.size(); i++) {
			//System.out.println(inStore.size());
			//addToCart.get(1).click();
		if(i==1) {
			addToCart.click();
			//String successMsg = msg.getText();
			String errorMsg = errorMsgOOS.getText();
			System.out.println(errorMsg);
			/*if (!successMsg.isEmpty()){
				System.out.println("product added successfully");
			}*/
			Thread.sleep(3000);
			if(!errorMsg.isEmpty()){
				System.out.println("Product OOS");
			}
			/*else if(!successMsg.isEmpty()) {
				System.out.println("product added succesfully");
			}*/
			else {
				System.out.println("Product not found");
			}
				
		}
			
		}		
		
	}
			//System.out.println(s);
		
		
			/*if(inStore.get(2).isDisplayed()) {
				if (addToCart.getAttribute("title").matches("Add to Cart")) {
					Thread.sleep(3000);
					addToCart.click();

					Thread.sleep(5000);
				} else {
					System.out.println("item not found");
				}
			}*/
		
		// WebElement add =
		// driver.findElement(By.xpath("//button[@id='addtocart_51344']"));
		// System.out.println(add.getAttribute("title"));
		/*if (addToCart.getAttribute("title").matches("Add to Cart")) {
			Thread.sleep(3000);
			addToCart.click();

			Thread.sleep(5000);
		} else {
			System.out.println("item not found");
		}
		WebElement msg = driver.findElement(By.xpath("//div[@class='message-success success message']"));
		String successMsg = msg.getText();
		// System.out.println(successMsg);
		if (successMsg.equalsIgnoreCase("You added Hellmann's Chili Mayonnaise to your shopping cart.")) {
			System.out.println("Product added successfully");
		} else {
			System.out.println("wrong product added");
		}*/

	}


