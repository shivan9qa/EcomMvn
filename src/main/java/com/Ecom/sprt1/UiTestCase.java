package com.Ecom.sprt1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecom.utilities.TestBase;

public class UiTestCase extends TestBase{

	@Test(priority = 1, description = "Click last 6 link of 5th page of search")
	public void click6thlinkofPage5() throws Exception {
		
		driver.get("https://www.google.co.in");
		gp.searchText(driver, "testing");
				
		uiFns.scollToBottomOfPage(driver);
				
		System.out.println("Clicking on page 5");
		if(!uiFns.clickOnPageLink(driver, "5")) {
			System.out.println("The 5th pagination link is not available");
			Assert.assertTrue(false);
		}
		
		
		int noOfLinks = gp.getNoOfLinks(driver);
		//int noOfLinks = driver.findElements(By.xpath("//h3[@class = 'LC20lb DKV0Md']")).size();
		
		//click on the last 6th link
		if(noOfLinks<6) {
			System.out.println("There is less than 6 links available");
			Assert.assertTrue(false);
		}
		int lastNthLink = 6;
		if(uiFns.clickLastNthLink(driver,noOfLinks, lastNthLink)) {
			System.out.println("Clicked on the last 6th link successfully");
		}else {
			System.out.println("Failed to click last 6th link successfully");
			Assert.assertTrue(false);
		}
		
		
		
	}
	
	@Test(priority = 2, description = "Click last 6 link of 5th page of search negative scenario")
	public void click6thlinkofPage5NegScenario() throws Exception {
		
		driver.get("https://www.google.co.in");
		gp.searchText(driver, "testingInvalidScenarios13456677");
				
		uiFns.scollToBottomOfPage(driver);
				
		System.out.println("Clicking on page 5");
		if(uiFns.clickOnPageLink(driver, "5")) {
			System.out.println("The 5th pagination link is available");
			Assert.assertTrue(false);
		}else {
			System.out.println("The 5th pagination link avialable for a invalid text");
			
		}
	}
	
	@Test(priority = 3, description = "Add to card and remove once")
	public void addToCard() throws Exception {
		
		driver.get("https://www.totalleecase.com/");
		try {
			ecom.setProfile(driver, "shivan9.qa@gmail.com");
		}catch(Exception e) {
			System.out.println("Profile is already set");
		}
		
		ecom.shopNow();
		
		int numOFTimesToRemove = 1;
		if(!ecom.selectProductAndAddToCartAndRemove(driver, "12 PRO MAX", numOFTimesToRemove)) {
			System.out.println("Failed to add the product");
			Assert.assertTrue(false);
		}else {
			System.out.println("Product added and removed from the card successfully");
		}
	}
	
	@Test(priority = 4, description = "Add to card and remove twice")
	public void addToCardAndRemove2wice() throws Exception {
		
		driver.get("https://www.totalleecase.com/");
		try {
			ecom.setProfile(driver, "Shivan9.qa@gmail.com");
		}catch(Exception e) {
			System.out.println("Profile is already set");
		}
		
		ecom.shopNow();
		
		int numOFTimesToRemove = 2;
		if(!ecom.selectProductAndAddToCartAndRemove(driver, "12 PRO MAX", numOFTimesToRemove)) {
			System.out.println("Remove mutiple times worked as expected");
		}else {
			System.out.println("Remove mutiple times failed");
			Assert.assertTrue(false);
		}
	}


	
}
