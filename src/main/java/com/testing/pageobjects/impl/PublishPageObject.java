package com.testing.pageobjects.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.testing.pageobjects.PublishPage;

public class PublishPageObject extends BasePage implements PublishPage{

	public void validateContentByTag(By by, String text) {
		List<WebElement> elements = driver.findElements(by);
		WebElement targetElement = null;
		for (WebElement el : elements) {
			if (el.getText().equals(text)) {
				targetElement = el;
				break;
			}
		}
		Assert.assertNotNull(targetElement, text+" not found.");
		
	}

	public void validateImageAttribute(String attribute, String text) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
			List<WebElement> elements = driver.findElements(By.tagName("img"));
			WebElement targetElement = null;
			for (WebElement el : elements) {
				if (el.getAttribute(attribute).equals(text)) {
					targetElement = el;
					break;
				}
			}
			Assert.assertNotNull(targetElement, text+" "+attribute+" not found.");
		} catch (Exception e) {
			Assert.fail("Failed to find image attribute "+attribute+": "+e);
		}

		
	}

	public void closeDriver() {
		driver.close();
		
	}

	public void isNot404(String newTitle) {
		String pageTitleXpath = "//div[@class='title']/h1";
		WebElement element = null;
		String titleText = "";
		try {
			element = driver.findElement(By.xpath(pageTitleXpath));
			titleText = element.getText();
		} catch (Exception e) {

		}
		Assert.assertTrue(titleText.toLowerCase().equals(newTitle.toLowerCase()), "Page returned 404 "+newTitle);
		
	}

	public void is404(String newTitle) {
		String pageTitleXpath = "//div[@class='title']/h1";
		String titleText = "";
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(pageTitleXpath));
			titleText = element.getText();
		} catch (Exception e) {
			
		}
		Assert.assertFalse(titleText.toLowerCase().equals(newTitle.toLowerCase()), "Page exists "+newTitle);
		
	}

	public boolean is404() {
		try {
		      HttpURLConnection.setFollowRedirects(false);
		      HttpURLConnection con =
		         (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
		      con.setRequestMethod("HEAD");
		      return (con.getResponseCode() != HttpURLConnection.HTTP_OK);
		    }
		    catch (Exception e) {
		       return true;
		    }
	}

	public void refresh() {
		driver.navigate().refresh();
		
	}

	public String getTextFromInput(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextFromInput(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
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

	public void assertNotExists(By by) {
		// TODO Auto-generated method stub
		
	}

	public void assertText(By by, String text) {
		// TODO Auto-generated method stub
		
	}

	public void assertVisibility(By by, boolean visible) {
		// TODO Auto-generated method stub
		
	}

	public void checkLinkByText(String s) {
		// TODO Auto-generated method stub
		
	}

	public void assertLinkText(String link) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(By by) {
		// TODO Auto-generated method stub
		
	}

}
