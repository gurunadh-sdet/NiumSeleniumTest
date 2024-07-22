package com.ebay.search.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static String USER_DIR = "user.dir";
	public static String PROPERTIES_FILE = "/resources/app_deatils.properties";
	
//	@BeforeTest
//	public void invoke_browser() throws IOException {
//		Properties prop = new Properties();
//		String path = System.getProperty(USER_DIR)+PROPERTIES_FILE;
//		FileInputStream fis = new FileInputStream(path);
//		prop.load(fis);
//		String browser = prop.getProperty("browser");
//		String chrome_driver_path = prop.getProperty("chrome_driver_path");
//		long timeout = Long.parseLong(prop.getProperty("timeout"));
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver" ,chrome_driver_path);		
//			driver =new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
//		}
//		
//	}
	
	@BeforeTest
	public void invoke_browser() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	
	@Parameters({"url"})
	@BeforeMethod
	public void open_Website(String url) {
		driver.get(url);		
	}
	
	@AfterTest
	public void close_browser() {
		driver.quit();// closing the browser after the test
	}

}
