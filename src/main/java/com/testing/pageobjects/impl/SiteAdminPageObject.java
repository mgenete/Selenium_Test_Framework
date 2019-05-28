package com.testing.pageobjects.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testing.pageobjects.SiteAdminPage;

public class SiteAdminPageObject extends BasePage implements SiteAdminPage{
	
	
	@FindBy(className = "card-page")
	private List<WebElement> pages;
	@FindBy(className = "icon-edit")
	private WebElement editPage;
	@FindBy(className = "foundation-admin-properties-activator")
	private WebElement editProperties;
	@FindBy(className = "icon-copy")
	private WebElement copyPageButton;
	@FindBy(className = "icon-move")
	private WebElement movePageButton;
	@FindBy(className = "icon-globe")
	private WebElement publishPageButton;
	@FindBy(xpath = "//article[class='foundation-collection-item card-page']")
	private List<WebElement> pageCards;
	
	
	
	public SiteAdminPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	

	public List<WebElement> getPageCards() {
		return pageCards;
	}

//	public SiteAdminPage navigateToPage(String path) {
//		if(driver.getCurrentUrl().contains("siteadmin")) {
//			for(WebElement page : pages) {
//				String pageLink = page.getAttribute("data-path");
//				if(path.equals(pageLink)) {
//					boolean mouseOver = ACTIONS.mouseOver(driver, page);
//					if(mouseOver) {
//						editPage.click();
//					} else {
//						Assert.fail("Failed to mouseover page");
//					}
//				} else if (path.contains(pageLink)) {
//					page.click();
//				}
//			}
//			Assert.fail("page not found "+ path);
//		} else {
//			String[] parts = path.split("/");
//			for(String part : parts) {
//				if(part.equals("content")) {
//					continue;
//				}
//				driver.findElement(By.xpath("//div[text()[normalize-space() = '"+part+"']]")).click();
//			}
//		}
//		return new SiteAdminPageObject(driver, wait);
//	}

	public void validatePageTitle(String pageTitle) {
		Assert.assertNotNull(driver.getTitle(), "Page title " + pageTitle + " not found");
		
	}

	public void clickiteAdminbutton(String title) {
		try {
			driver.findElement(By.xpath("//button[@title='" + title + "']"))
					.click();
		} catch (Exception e) {
			driver.findElement(
					By.xpath("//button/span[text()='" + title + "']")).click();
		}
		
	}

	public void clickSiteAdminButton(String title, String fallback) {
		try {
			driver.findElement(By.xpath("//button[@title='" + title + "']"))
					.click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//button[@title='" + fallback + "']"))
					.click();
		}
		
	}

	public void clickSiteAdminLink(String title) {
		try {
			driver.findElement(By.xpath("//a[@title='" + title + "']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//button[@title='" + title + "']"))
					.click();
		}
		
	}

	public void selectDropdownItem(String text) {
		List<WebElement> elements = driver.findElements(By
				.xpath("//div[@class='endor-List']/a"));
		for (WebElement el : elements) {
			if (el.getText().equals(text)) {
				el.click();
				break;
			}
		}
		
	}

	public void clickButtonByText(String text) {
		try {
			driver.findElement(By.xpath("//button[text()='" + text + "']"))
					.click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//button/span[text()='" + text + "']"))
					.click();
		}
		
	}

	public void fillInDialogFieldByName(String name, String text) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
		driver.findElement(By.name(name)).sendKeys(text);
		
	}

	public void navigateToCurrentPage(String page) {
		driver.get(page);
		
	}

	public void validateUserSettings() {
		// TODO Auto-generated method stub
		
	}

	public void validateSidepanelLinks() {
		String[] sidepanelLinks = { "Projects", "Sites", "Apps",
				"Publications", "Forms", "Assets", "Communities", "Commerce",
				"Tools" };
		for (String s : sidepanelLinks) {
			WebElement el = null;
			el = driver.findElement(By.xpath("//nav/a[text()='" + s + "']"));
			Assert.assertNotNull(el, "Failed to find link " + s);
		}
		
	}
	
	public SiteAdminPageObject clickSiteAdminPage(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		return this;
	}

	public void search(String text) {
		clickSiteAdminPage("Search");
		WebElement searchBox = driver.findElement(By.name("fulltext"));
		searchBox.sendKeys(text);
		searchBox.sendKeys(Keys.RETURN);
		
	}

	public void validateNumberOfSearchResults(int number) {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='grid-3']/article"));
		Assert.assertTrue(elements.size() == number, 
				"Incorrect number of search results: " + elements.size() + " Expected: " + number);
		
	}

	public List<WebElement> getElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextFromElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickBy(By by) {
		// TODO Auto-generated method stub
		
	}

	public void checkWidthAndHeightOfComponent(String parsysName, String width, String height) {
		// TODO Auto-generated method stub
		
	}

	public void assertExists(By by) {
		// TODO Auto-generated method stub
		
	}

	public void assertText(By by, String text) {
		// TODO Auto-generated method stub
		
	}

	public void checkLinkByText(String s) {
		// TODO Auto-generated method stub
		
	}

	public void assertLinkText(String link) {
		// TODO Auto-generated method stub
		
	}

	public void openSitesPage() {
		// TODO Auto-generated method stub
		
	}


	public SiteAdminPage navigateToPage(String path) {
		// TODO Auto-generated method stub
		return null;
	}

}
