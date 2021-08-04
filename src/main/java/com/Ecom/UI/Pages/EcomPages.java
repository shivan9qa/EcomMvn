package com.Ecom.UI.Pages;

import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EcomPages {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='santaana-field-email']")
	WebElement emailTxtBox;
	
	@FindBy(xpath = "//button[@name = 'santaana-submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//button[@value= 'KEEP SHOPPING']")
	WebElement keepShopingBtn;
	
	@FindBy(xpath = "(//*[@class = 'btn hero__btn'])[1]")
	WebElement shopNowBtn;
	
	@FindBy(xpath = "//section[1]/div[2]/div[2]/button")
	WebElement ProMax12Btn;
	
	@FindBy(xpath = "//section[1]/div[2]/div[2]/button")
	WebElement firstFlavorBtn;
	
	@FindBy(xpath = "//div/section[2]/div/div[1]/div/div[1]/a")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id='CartContainer']/form/div[1]/div/div/div/div/div/div[3]/div/button")
	WebElement removeFromCartBtn;
	
	
	public EcomPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setProfile(WebDriver driver, String text) {
		emailTxtBox.sendKeys(text);
		submitBtn.click();
		keepShopingBtn.click();
	}
	
	public void shopNow() {
		shopNowBtn.click();
	}
	
	public boolean selectProductAndAddToCart(WebDriver driver, String productName) {
		String itemName = "";
		productName = productName.toUpperCase();
		switch(productName) {
		case "12 PRO MAX":
			itemName = ProMax12Btn.getText();
			ProMax12Btn.click();
			break;			
		}
		firstFlavorBtn.click();
		addToCartBtn.click();
		
		itemName = itemName.trim();
		itemName = WordUtils.capitalizeFully(itemName);
				
		System.out.println("//a[contains(text(),'"+itemName+" Case')]");
		
		if(driver.findElements(By.xpath("//a[contains(text(),'"+itemName+" Case')]")).size()==1){
			return true;
		}else {
			System.out.println("Item is not present in card");
		}
		return false;
	}
	
	public boolean selectProductAndAddToCartAndRemove(WebDriver driver, String productName, int noOfTimesToRemove) throws Exception {
		String itemName = "";
		productName = productName.toUpperCase();
		switch(productName) {
		case "12 PRO MAX":
			itemName = ProMax12Btn.getText();
			Thread.sleep(5000);
			ProMax12Btn.click();
			break;		
		default:
			throw new Exception("No Such Selection present");
		}
		Thread.sleep(5000);
		firstFlavorBtn.click();
		Thread.sleep(5000);
		addToCartBtn.click();
		Thread.sleep(5000);
		
		itemName = itemName.trim();
		itemName = WordUtils.capitalizeFully(itemName);
				
		System.out.println("//a[contains(text(),'"+itemName+" Case')]");
		
		if(driver.findElements(By.xpath("//a[contains(text(),'"+itemName+" Case')]")).size()==1){
			System.out.println("Item added successfully to the cart");
		}else {
			System.out.println("Item is not present in cart");
			return false;
		}
		try {
			Thread.sleep(5000);
			for(int noOfIters = 1; noOfIters <= noOfTimesToRemove; noOfIters++) {
				removeFromCartBtn.click();
				Thread.sleep(5000);
				if(driver.findElements(By.xpath("//a[contains(text(),'"+itemName+" Case')]")).size()==0){
					System.out.println("Item removed from cart sucessfully");
				}else {
					System.out.println("Item is not removed from cart");
					return false;
				}
			}
		}catch(Exception e) {
			return false;
		}
		return true;	
	}
	
	
	
	public void shopProduct(WebDriver driver, String text) {
		emailTxtBox.sendKeys(text);
		submitBtn.click();
		keepShopingBtn.click();
	}	
}

