package com.testing.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//methods to perform actions on the site admin page

public interface SiteAdminPage {
	
	
	public List<WebElement> getPageCards();
	
	/**
	 * @param path  Path to navigate to
	 * @return New instance of the SiteAdminPage
	 */
	public SiteAdminPage navigateToPage(String path);
	
	/**
	 * @param pageTitle  The expected page title
	 */
	public void validatePageTitle(String pageTitle);

	/**
	 * @param title Title attribute of the button
	 */
	public void clickiteAdminbutton(String title);
	
	/**
	 * @param title      Title attribute of the button
	 * @param fallback   Fallback attribute to use when element doesn't exist
	 */
	public void clickSiteAdminButton(String title, String fallback);
	
	/**
	 * @param title Title attribute of the button
	 */
	public void clickSiteAdminLink(String title);
	
	/**
	 * @param text Text value of the option to select
	 */
	public void selectDropdownItem(String text);
	
	/**
	 * @param text Text of the button
	 */
	public void clickButtonByText(String text);
	
	/**
	 * Fills in dialog field by its html name
	 * @param name  The html name of the element
	 * @param text  Text to input
	 */
	public void fillInDialogFieldByName(String name, String text);
	
	/**
	 * @param page Absolute url of the page to go to
	 */
	public void navigateToCurrentPage(String page);
	
	/**
	 * Test the default user settings options
	 */
	public void validateUserSettings();
	
	/**
	 * Validates the default side panel links
	 */
	public void validateSidepanelLinks();
	
	/**
	 * Performs a search in the site admin
	 * @param text Text to search for
	 */
	public void search(String text);
	
	/** 
	 * Validates the number of search results returned
	 * @param number The expected amount of results
	 */
	public void validateNumberOfSearchResults(int number);
	
	/**
	 * Waits for and finds a list of elements by their selenium selector
	 * @param by Selenium selector of the elements
	 * @return List of all the found elements
	 */
	public List<WebElement> getElements(By by);
	
	/**
	 * Extracts text from an element
	 * @param by The selenium selector of the element to extract text from
	 * @return String value of the elements text
	 */
	public String getTextFromElement(By by);
	
	/**
	 * Waits for an element and clicks it.&nbsp;Found by a selenium selector
	 * @param by The selenium selector of the element
	 */
	public void clickBy(By by);
	
	/**
	 * Tests the width and height of a component
	 * 
	 * @param parsysName Parent parsys of the element
	 * @param width      The expected width
	 * @param height     The expected height
	 */
	public void checkWidthAndHeightOfComponent(String parsysName, String width, String height);
	
	/**
	 * Validate an element exists by a selenium selector
	 * @param by selenium selector of the target element
	 */
	public void assertExists(By by);
	
	/**
	 * Validate an element has the specified text by a selenium selector
	 * @param by selenium selector of the target element
	 * @param text the expected text value
	 */
	public void assertText(By by, String text);
	
	/**
	 * Validate a link created using the List component
	 * @param s The link text to search for
	 */
	public void checkLinkByText(String s);
	
	/**
	 * Validate a link has the specified text by a selenium selector
	 * @param link The link text to search for
	 */
	public void assertLinkText(String link);
	
	/**
	 * Opens the sites page
	 */
	public void openSitesPage();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
