package com.TestCases.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.TestBase.BasePage;

public class LoginPagetest extends BasePage{

	LoginPage loginpage;
	public LoginPagetest() {
		super();
	}
	
	
	@BeforeMethod
	public void openbrowser() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void PagetitleTest() {
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, prop.getProperty("title"));
		System.out.println(title);
	}
	@Test(priority = 2)
	public void PageUrlTest() {
		String URL=loginpage.VerifyURL();
		Assert.assertEquals(URL, prop.get("url"));
		System.out.println(URL);
	}
	
	
	@Test(priority = 3)
	public void LoginTest() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
