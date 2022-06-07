package com.bursa.qa.testcases;

import com.bursa.qa.base.TestBase;
import com.bursa.qa.pages.BursaHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BursaTop10Test extends TestBase {

	BursaHomePage bursaHomePage;

	public BursaTop10Test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization("https://www.bursamalaysia.com");
		bursaHomePage = new BursaHomePage();
	}
	
	
	@Test
	public void exportTop10Counter(){
		String title = bursaHomePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Home");
		bursaHomePage.exportTop10Stock();
	}


	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
