package com.testing.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public enum BaseActions {

	ACTIONS;
	
	private BaseActions() {
		
	}
	
	
	public boolean mouseOver(WebDriver driver, WebElement element) {
		try {
			Actions builder = new Actions(driver);
			Actions hoverOverElement = builder.moveToElement(element);
			hoverOverElement.build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean contextClick(WebDriver driver, WebElement element) {
		try {
			Actions builder = new Actions(driver);
			builder.contextClick(element).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean doubleClick(WebDriver driver, WebElement element) {
		try {
			Actions builder = new Actions(driver);
			builder.doubleClick(element).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void dragDrop(WebDriver driver, WebDriverWait wait, WebElement source, WebElement target) {
		Actions builder = new Actions(driver);
		builder.clickAndHold(source).moveToElement(target).release().build().perform();
	}
	
	
	public void hitEscape() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			Assert.fail("Failed to push Escapae");
		}
	}
	
	
	public void hitEnter() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			Assert.fail("Faild to push enter");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
