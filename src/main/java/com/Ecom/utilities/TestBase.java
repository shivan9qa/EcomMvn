package com.Ecom.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Ecom.UI.Pages.EcomPages;
import com.Ecom.UI.Pages.GooglePage;

public class TestBase {
	protected WebDriver driver;
	protected UI_Common_Fns uiFns;
	protected GooglePage gp;
	protected EcomPages ecom;
	
	@BeforeSuite
	public void openBrowser() {
				
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		uiFns = new UI_Common_Fns(driver);
		gp = new GooglePage(driver);
		ecom = new EcomPages(driver);
	}
	
	@AfterSuite
	public void tearDown() {
		try {
			driver.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
