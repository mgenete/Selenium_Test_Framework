package com.testing.base;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;



public class TestBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static TestEnvironment environment;
	public static String DRIVERS_PATH = "/drivers/";
	
	
	@BeforeClass
	public static void setupProxy() throws Exception {
		environment = TestEnvironmentLoader.INSTANCE.loadConfiguration("qa");
		if (environment.getProxyEnabled().equals("true")) {
			String loginString = environment.getTestUsername()+":"+environment.getTestPassword();
			System.out.println(loginString);
		
		}
	}
	
	@BeforeTest
	public void setUpEnvironment() throws Exception {
		setUpBrowser();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
		login();
		
	}
	
	public void login() {
		driver.get(environment.getServertUrl());
		driver.findElement(By.id("username")).sendKeys(environment.getTestUsername());
		driver.findElement(By.id("password")).sendKeys(environment.getTestPassword());
		driver.findElement(By.xpath("")).click();
	
	}
	
	
	public void setUpBrowser() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(environment.getProxyEnabled().equals("true")) {
			Proxy proxy = new Proxy();
			proxy.setHttpProxy(environment.getServertUrl());
			capabilities.setCapability(CapabilityType.PROXY, proxy);
		}
		
		
		String browser = environment.getBrowser();
		if (browser.equalsIgnoreCase("chrome")) {
			String fullPath = System.getProperty("user.dir");
			String driverPath = fullPath + DRIVERS_PATH;
			String os = System.getProperty("os.name"); 
			if (os.startsWith("Windows")) {
				driverPath = driverPath + "chromedriver.exe";
			} else if (os.startsWith("Mac")) {
				driverPath = driverPath + "chromedriver-mac";
			} else {
				driverPath = driverPath + "chromedriver-linux";
			}
			System.setProperty("webdriver.chrome.driver", driverPath);
			 ChromeOptions options = new ChromeOptions();
			  options.merge(capabilities);
			driver = new ChromeDriver(options);
		
		} else if (browser.equalsIgnoreCase("ie")) {
			String os = System.getProperty("os.name"); 
			Assert.assertFalse( os.startsWith("Windows"), "IE can only be tested on Windows");
			String fullPath = System.getProperty("user.dir");
			String driverPath = fullPath + DRIVERS_PATH;
			String arch = System.getProperty("os.arch");
			if (arch.equalsIgnoreCase("x86")) {
				driverPath = driverPath + "iedriver-x86.exe";
			} else {
				driverPath = driverPath + "iedriver.exe";
			}
			System.setProperty("webdriver.ie.driver", driverPath);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(capabilities);
			driver = new InternetExplorerDriver(options);
		
		} else if (browser.equalsIgnoreCase("http")) {
			driver = new HtmlUnitDriver(capabilities);
		} else {
			throw new Exception("Unsupported browser: "+browser+". Valid values are: firefox, chrome, ie, html");
		}
		
		
	}
	
	

}
