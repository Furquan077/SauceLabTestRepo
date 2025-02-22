package com.TestCases.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.ProductPage;
import com.Pages.YourKartPage;
import com.TestBase.BasePage;

public class YourKartPageTest extends BasePage {
	LoginPage loginpage;
	ProductPage productpage;
	YourKartPage yourKartpage;

	public YourKartPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		productpage = new ProductPage();
		yourKartpage = new YourKartPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		productpage.Add_itemstokart();
	}

	@Test(priority = 1)
	public void verifyPageURLTest() {
		yourKartpage.verifyPageURL();
	}
	@Test(priority = 2)
	public void checkouttest() {
		yourKartpage.clickcheckout();
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
