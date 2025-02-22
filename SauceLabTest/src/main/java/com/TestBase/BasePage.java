package com.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.util.PageTimeOuts;
import com.util.WebEventListener;

//constructor - properties
//driver/Browser
public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringDecorator<WebDriver> decorator;
	public static WebEventListener listener;

	public BasePage() {

		prop = new Properties();
		File file = new File(
				"C:\\Users\\ADMIN\\eclipse-workspace\\SauceLabTest\\src\\main\\java\\com\\config\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver",
					"F:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromediver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("WebDriver.gecko.driver", "F:\\Driver\\geckodriver-v0.33.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "F:\\Driver\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		listener = new WebEventListener();
		decorator =new  EventFiringDecorator<WebDriver>(listener);
		
		WebDriver edriver = decorator.decorate(driver);
		driver=edriver;
	
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PageTimeOuts.PageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PageTimeOuts.implicitwaitTime));
		driver.manage().deleteAllCookies();

	}

}
