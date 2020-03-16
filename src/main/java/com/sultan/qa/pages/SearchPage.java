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
	
	@FindBy(xpath="//button[contains(@id,'addtocart')]")
	WebElement addToCartBtn;
	
	public SearchPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean search(String s) throws InterruptedException {
		inputSearch.click();
		inputSearch.sendKeys(s);
		inputSearch.sendKeys(Keys.ENTER);
		String url = driver.getCurrentUrl();
		Thread.sleep(3000);
		if(url.contains("https://m2staging.sultan-center.com/catalogsearch/result/")) {
			return true;
		}else
			return false;
		
	}
	
	public void addToCart() throws InterruptedException {
		WebElement scroll = driver.findElement(By.xpath("//button[contains(@id,'addtocart')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(3000);
		for(int i= 0; i<products.size(); i++) {
			if(i==1) {
				addToCartBtn.click();
			}
			Thread.sleep(4000);
	}
}
	public void navigateUrl() {
		driver.navigate().to("https://m2staging.sultan-center.com/catalogsearch/result/?q=FISH");
	}

}
