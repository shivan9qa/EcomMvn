package com.Ecom.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class UI_Common_Fns {
	WebDriver driver;
	public UI_Common_Fns(WebDriver driver) {
		this.driver = driver;
	}

	public boolean clickOnPageLink(WebDriver driver, String pageNumber) {
		try {
			driver.findElement(By.xpath("//a[@aria-label='Page "+pageNumber+"']")).click();
			return true;
		}catch(Exception e) {
			System.out.println("The 5th pagination link is not available");
		}
		return false;
		
	}

	public boolean clickLastNthLink(WebDriver driver, int noOfLinks, int linkFromTheLast) {
		try {
			driver.findElement(By.xpath("(//h3[@class = 'LC20lb DKV0Md'])["+(noOfLinks-linkFromTheLast)+ "]")).click();
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

	public void scollToBottomOfPage(WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
