package com.bursa.qa.testcases;

import com.bursa.qa.base.TestBase;
import com.bursa.qa.pages.BursaAnywherePage;
import com.bursa.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BursaRegisterTest extends TestBase {

	BursaAnywherePage bursaAnywherePage;
	String sheetName = "newUser";

	public BursaRegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization("https://www.bursamarketplace.com/");
		bursaAnywherePage = new BursaAnywherePage();
	}

	@DataProvider
	public Object[][] getBursaTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getBursaTestData")
	public void registerNewUser(String DisplayName, String email, String Password){
		bursaAnywherePage.clickOnRegister();
		bursaAnywherePage.registerNewUser(DisplayName, email, Password);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
