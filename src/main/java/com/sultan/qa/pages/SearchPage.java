package com.sultan.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sultan.qa.base.TestBase;

public class SearchPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	@FindBy(id="search")
	WebElement inputSearch;
	
	@FindBy(xpath="//div[@class='products wrapper grid products-grid']//li")
	List<WebElement> products;
	
	@FindBy(id="amasty-shopby-product-list")
	List<WebElement> products1;
	
	@FindBy(xpath="//button[contains(@id,'addtocart')]")
	WebElement addToCartBtn;
	
	@FindBy(className="control")
	WebElement inputSearch1;
	
	@FindBy(xpath="/html/body/div[4]/div[5]/ul/li[2]/strong")
	WebElement searchResultText;
	
	@FindBy(className="action tocart primary")
	WebElement addToCartBtn1;
	
	@FindBy(xpath="//*[@role='alert']")
	WebElement successMsg;
	
	
	
	public SearchPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void search(String s) throws InterruptedException {
		inputSearch.click();
		inputSearch.sendKeys(s);
		inputSearch.click();
		Thread.sleep(3000);
		inputSearch.sendKeys(Keys.ENTER);
		//String url = driver.getCurrentUrl();
		/*String url = searchResult.getText();
		System.out.println(url);*/
		Thread.sleep(3000);
		/*if(url.contains("https://m2staging.sultan-center.com/catalogsearch/result/")) {
			return true;
		}else
			return false;*/
		if(searchResultText.isDisplayed()) {
			System.out.println("Items searched successfully");
		}else {
			System.out.println("search failed");
		}
		
		
	}
	
	public void addToCart() throws InterruptedException {
		// to print list page items 
		/*for(WebElement items:products1) {
			String item =items.getText();
			System.out.println(item);
			
		}*/
		//WebElement scroll = driver.findElement(By.xpath("//button[contains(@id,'addtocart')]"));
		/*WebElement scroll = driver.findElement(By.className("action tocart primary"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(3000);*/
		addToCartBtn.click();
		Thread.sleep(3000);
		String success = successMsg.getText();
		if(success.contains("You added ")) {
			System.out.println("Item successfully added to the cart");
		}
		else {
			System.out.println("Item not added");
		}
		/*for(int i= 0; i<=products1.size(); i++) {
			//System.out.println(products1.size());
			if(i==0) {
				addToCartBtn.click();
				System.out.println("product added to cart");
			}
			else {
				System.out.println("product not added");
			}
		Thread.sleep(4000);
	}*/
}
	public void navigateUrl() {
		driver.navigate().to("https://m2staging.sultan-center.com/catalogsearch/result/?q=FISH");
	}

}
