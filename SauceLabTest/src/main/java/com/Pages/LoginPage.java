package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BasePage;

public class LoginPage extends BasePage {
	//constructor
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//locator
	@FindBy(id="user-name") 
	WebElement un;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(id ="login-button")
	WebElement loginbutton;
	
	
	//actions
	
	public String VerifyTitle() {
		 String title = driver.getTitle();
		 return title;
	}
	
	public String VerifyURL() {
		String currenturl =driver.getCurrentUrl();
		return currenturl;
	}
	
	public ProductPage login(String uname,String pswd) {
		un.sendKeys(uname);
		pass.sendKeys(pswd);
		loginbutton.click();
		
		return new  ProductPage() ;
	}
	
	
	
	
	
}
