package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BasePage;

public class ProductPage extends BasePage{
	
	public   ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack") WebElement backpack;
	@FindBy(id="add-to-cart-sauce-labs-bike-light") WebElement BikeLights;
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt") WebElement BoltTshirt;
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket") WebElement Fleecejacket;
	@FindBy(id="add-to-cart-sauce-labs-onesie") WebElement Onesie;
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)") WebElement RedTshirt;
	@FindBy(className ="shopping_cart_link") WebElement AddtoKartbutton;
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String verifyURL() {
	return driver.getCurrentUrl();
	}
	
	public YourKartPage Add_itemstokart() {
		
		
		backpack.click();
		Fleecejacket.click();
		RedTshirt.click();
		AddtoKartbutton.click();
		
		return new YourKartPage();
	}
	
	
	
	
	
	
}
