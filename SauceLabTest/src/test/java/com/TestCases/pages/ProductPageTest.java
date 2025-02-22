package com.TestCases.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.ProductPage;
import com.TestBase.BasePage;

public class ProductPageTest extends BasePage{
      
	LoginPage loginpage;
	ProductPage productpage;
	WebElement backpack;
	
	public ProductPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		productpage = new ProductPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority = 1)
	public void verifytitleTest() {
		String title = productpage.verifyTitle();
		Assert.assertEquals(title, "Swag Labs");
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void verifyURlTest() {
		String url = productpage.verifyURL();
		Assert.assertEquals(url, prop.getProperty("productpageurl"));
		System.out.println(url);
	}
	
	@Test(priority = 3)
	public void Add_itemstokartTest() {
		productpage.Add_itemstokart();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
