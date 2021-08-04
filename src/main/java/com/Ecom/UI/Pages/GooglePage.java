package com.Ecom.UI.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	WebDriver driver;
	@FindBy(xpath = "//input[@class = 'gLFyf gsfi']")
	WebElement searchInput;
	
	@FindBys({@FindBy(xpath = "//h3[@class = 'LC20lb DKV0Md']")})
	List<WebElement> linksList;
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchText(WebDriver driver, String text) {
		searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
		
	}
	public int getNoOfLinks(WebDriver driver) {
		try {
			int noOfLinks = linksList.size();
			return noOfLinks;
		}catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
}
