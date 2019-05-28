package com.testing.pageobjects.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.pageobjects.SiteAdminPage;
import com.testing.pageobjects.WelcomePage;

public class WelcomePageObject extends BasePage implements WelcomePage{
	
	protected final WebDriver driver;
	
	@FindBy(linkText = "Projects")
	private WebElement projectsLink;
	
	@FindBy(linkText = "Sites")
	private WebElement sitesLink;
	
	@FindBy(linkText = "Publications")
	private WebElement publicationsLink;
	
	@FindBy(linkText = "Communities")
	private WebElement communitiesLink;
	
	@FindBy(linkText = "Feed")
	private WebElement feedLink;
	
	@FindBy(linkText = "Tools")
	private WebElement toolsLink;
	
	@FindBy(id = "create-pulldown")
	private WebElement createButton;
	
	@FindBy(className = "help")
	private WebElement helpButton;
	
	@FindBy(className = "notifications")
	private WebElement notifications;
	
	@FindBy(className = "user icon-user")
	private WebElement userInfo;
	
	@FindBy(xpath = "//div[@class='dropdown-container']/input")
	private WebElement impersonateField;
	
	@FindBy(className = "submit-impersonate")
	private WebElement impersonateSubmit;
	
	@FindBy(css = "a[href*='#user_preferences']")
	private WebElement userPreferences;
	
	@FindBy(css = "a[href*='/system/sling/logout.html']")
	private WebElement signOut;
	
	@FindBy(className = "icon-viewcard")
	private WebElement viewCard;
	
	@FindBy(className = "icon-viewlist")
	private WebElement viewList;
	
	
	public WelcomePageObject(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	

	public SiteAdminPage openSiteAdmin() {
		sitesLink.click();
		SiteAdminPageObject siteAdminPage = PageFactory.initElements(driver, SiteAdminPageObject.class);
		return siteAdminPage;
	}

}
