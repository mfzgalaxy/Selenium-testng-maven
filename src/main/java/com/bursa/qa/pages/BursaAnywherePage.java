package com.bursa.qa.pages;

import com.bursa.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BursaAnywherePage extends TestBase{

	//Page Factory - OR:

	@FindBy(xpath="//div[contains(text(),'Register')]")
	WebElement registerMenu;

	@FindBy(xpath="//input[@id='newpopup-register-user']")
	WebElement userField;

	@FindBy(xpath="//input[@id='newpopup-register-email']")
	WebElement emailField;

	@FindBy(xpath="//input[@id='newpopup-register-pass']")
	WebElement passwordField;

	@FindBy(xpath="//input[@id='newpopup-register-marketing']")
	WebElement checkBox;

	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement captchaCheckBox;

	@FindBy(xpath="//button[@value='Sign Up']")
	WebElement registerButton;


	//Initializing the Page Objects:
	public BursaAnywherePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public void clickOnRegister() {
		registerMenu.click();
		if (userField.isDisplayed()){

		}
		else {
			registerMenu.click();
		}


	}
	public void registerNewUser (String DisplayName, String email, String Password){

		userField.sendKeys(DisplayName);
		emailField.sendKeys(email);
		passwordField.sendKeys(Password);
		checkBox.click();
		captchaCheckBox.click();
		registerButton.click();
	}

	
}
