package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BasePage;

public class YourKartPage extends BasePage {

	
	
	public YourKartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="continue-shopping") WebElement continueShoppingbtn;
	@FindBy(id="remove-sauce-labs-onesie") WebElement Removebtn;
	@FindBy(id="checkout") WebElement checkoutbtn;
	
	
	
	public String verifyPageURL() {
	 return driver.getCurrentUrl();
	}
	
	public CheckOutPage clickcheckout() {
		checkoutbtn.click();
		return new CheckOutPage();
	}
	
}
