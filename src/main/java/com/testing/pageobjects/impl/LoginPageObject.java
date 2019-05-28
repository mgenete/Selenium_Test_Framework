package com.testing.pageobjects.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.pageobjects.LoginPage;
import com.testing.pageobjects.WelcomePage;

public class LoginPageObject implements LoginPage{
	
	private final WebDriver driver;
	private WebDriverWait wait;

	private WebElement username;
	private WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signIn;
	
	public LoginPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}

	public WelcomePage loginAs(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		signIn.click();
		WelcomePageObject welcomePage = new WelcomePageObject(driver, wait);
		return welcomePage;
	}

}
