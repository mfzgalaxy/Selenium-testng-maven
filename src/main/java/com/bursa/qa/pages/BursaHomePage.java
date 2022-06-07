package com.bursa.qa.pages;

import com.bursa.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BursaHomePage extends TestBase{

	//Page Factory - OR:

	@FindBy(xpath="//div[normalize-space()='Trade']")
	WebElement tradeMenu;

	@FindBy(xpath="//a[normalize-space()='Market']")
	WebElement marketMenu;

	@FindBy(xpath="//h2[@class='h5 bold']")
	WebElement todayUpdateText;

	@FindBy(linkText="Read More")
	WebElement readMoreLink;

	@FindBy(xpath="//th[@aria-label='CHG: activate to sort column ascending']")
	WebElement chgSort;

	@FindBy(xpath="//div[@id=\"pills-active\"]//tbody/tr/td[1]")
	List<WebElement> codeElements;

	@FindBy(xpath="/div[@id=\"pills-active\"]//tbody/tr/th//a")
	List<WebElement> nameElements;

	@FindBy(xpath="//div[@id=\"pills-active\"]//tbody/tr/td[3]")
	List<WebElement> changeElements;

	@FindBy(xpath="//div[@id=\"pills-active\"]//tbody/tr/td[4]")
	List<WebElement> volumeElements;

	//Initializing the Page Objects:
	public BursaHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public void exportTop10Stock() {

		tradeMenu.click();
		marketMenu.click();
		readMoreLink.click();
		chgSort.click();
		chgSort.click();

		List<WebElement> code_elements = codeElements;
		List<WebElement> name_elements = nameElements;
		List<WebElement> change_elements = changeElements;
		List<WebElement> volume_elements = volumeElements;
		List<String> codes = new ArrayList<>();
		List<String> names = new ArrayList<>();
		List<String> changes = new ArrayList<>();
		List<String> volumes = new ArrayList<>();
		for(WebElement ele1:code_elements)
			codes.add(ele1.getText());
		for(WebElement ele2:name_elements)
			names.add(ele2.getText());
		for(WebElement ele3:change_elements)
			changes.add(ele3.getText());
		for(WebElement ele4:volume_elements)
			volumes.add(ele4.getText());
		for(int i=0; i<10; i++)
			System.out.println("Code:" + codes.get(i) +" "+ "Name:" + names.get(i)+" "+"Change:"+ changes.get(i)+" "+"Volume:" + volumes.get(i));
		Collections.sort(changes);
		System.out.println("Change:" + changes);
	}

	
}
