package com.sultan.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sultan.qa.base.TestBase;

public class FooterPage extends TestBase
{
	@FindBy(xpath="//div[@class='footer_section']")
	WebElement footer;
	
	@FindBy(xpath="//footer//img[@class='logo']")
	WebElement footerSultanLogo;
	
	
	public FooterPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		
	}
	
	public void footerPresence() 
	{
		boolean b =footer.isDisplayed();
		if(b) {
			System.out.println("Footer Displayed");
		}else {
			System.out.println("Footer not displayed");
		}
	}
	
	public void footerLinks() {
		boolean b = false;
		List<WebElement> links = footer.findElements(By.tagName("li"));
		
		/*for (int i=0 ; i< links.size() ; i++ )
		{
			System.out.println(links.get(i).getText());
		}*/	
		for (int i=0 ; i< links.size() ; i++ )
		{
		 b=	links.get(i).isEnabled();
		}
		if(b) {
			System.out.println("Footer Links present ");
		}
		else {
			System.out.println("Footer Links missing");
			}
		System.out.println("Total no of links present in footer are : " + links.size());
	}
	
	public void checkFooterLogo()
	{
	boolean b=	footerSultanLogo.isDisplayed();
	if(b) {
		System.out.println("sultan logo present in footer");
	}else {
		System.out.println("Sultan logo missing");
	}
		
	}
}
