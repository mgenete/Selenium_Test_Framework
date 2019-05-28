package com.testing.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;

public interface AuthorPage {

	
	/**
	 * Determines if the author page editor is in classic mode
	 * @return Returns boolean value if editor is in classic mode
	 */
	public boolean isClassic();
	
	/** 
	 * Toggles the side panel in the new author interface
	 */
	public void toggleSidePanel();
	
	/**
	 * Select the specified side panel tab by the tab title
	 * @param tabName   The text title of the tab to switch to
	 * @return   Returns a new instance of the AuthorPage with reloaded elements initialized
	 */
	public AuthorPage selectSidePanelTab(String tabName);
	
	/**
	 * Select the specified tab by text inside of new component dialogs
	 * The dialogs use the coral-panel
	 * @param tabName   The text title of the dialog tab to switch to
	 */
	public void selectDialogTab(String tabName);
	
	/**
	 * Helper method to fill in dialog fields by the html name
	 * @param name The html name of the component
	 * @param text The text to input into the field
	 */
	public void fillInDialogFieldByName(String name, String text);
	
	/**
	 * Switches to the iframe that classic UI dialogs are contained within
	 */
	public void switchToOldDialogIframe();
	
	/**
	 * Helper method to locate an element by its html name
	 * @param name The html name of the element
	 * @return The WebElement found
	 */
	public WebElement findElementByName(String name);
	
	/**
	 * Helper method to locate an element by a selenium selector
	 * @param by The selenium selector to use to find the element
	 * @return The WebElement found
	 */
	public WebElement findElementBy(By by);
	
	/**
	 * Helper method to locate an element's parent by a selenium selector
	 * @param by The selenium selector to use to find the element
	 * @return The WebElement found
	 */
	public WebElement getParentOfElement(By by);
	
	/**
	 * Helper method to open the inline text editor for components
	 * @param componentName The name of the component to open the text editor for
	 */
	public void editText(String componentName);
	
	/**
	 * Types text into the current location of the active cursor
	 * @param text The text to input
	 */
	public void type(String text);
	
	/**
	 * Selects the specified option from the dropdown menu located in the 
	 * side panel
	 * @param option The text value of the option to select
	 */
	public void selectAssetFinderDropdown(String option);
	
	/**
	 * Validates the label value for the specified form field
	 * @param elementName The component crx name for the form component
	 * @param label The expected text value of the label
	 */
	public void checkFormLabel(String elementName, String label);
	
	/**
	 * Validates the label value for the specified component
	 * @param elementName The component crx name for the component
	 * @param label The expected text value of the label
	 */
	public void checkLabel(String elementName, String label);
	
	/**
	 * Helper method to validate the value of multiple form fields
	 * @param fields A map of the form fields to check
	 */
	public void validateFields(Map<String, String> fields);
	
	/**
	 * Opens the edit dialog for the specified component
	 * @param componentName The crx name of the component to edit
	 */
	public void editComponent(String componentName);
	
	/**
	 * Opens the edit dialog for the specified component
	 * @param componentName The crx name of the component to edit
	 * @param location The numerical value of which component to select
	 * 					when multiple of the same component exist
	 */
	public void editComponent(String componentName, int location);
	
	/**
	 * Opens the edit dialog using the specified mouse action
	 * @param componentName The crx name of the component to edit
	 * @param mouseAction MouseAction enum value for the type of mouse click to perform
	 */
	public void editComponent(String componentName, MouseAction mouseAction);
	
	/**
	 * Helper method for AEM 6.1 text component
	 * @param type The text to type
	 */
	public void selectInlineEditor(String type);
	
	/**
	 * Deletes the specified component
	 * @param componentName The crx name of the component to edit
	 */
	public void deleteComponent(String componentName);
	
	/**
	 * Validate the specified class name exists inside of the content frame
	 * @param className The class to search for
	 */
	public void checkContentByClass(String className);

	/**
	 * Validates the specified element exists inside of the content frame
	 * by its xpath
	 * @param xpath The xpath of the element to search for
	 */
	public void checkContentByXPath(String xpath);
	
	/**
	 * Tests the values of drop down menus
	 * @param options Array of the expected values
	 */
	public void validateDropdownValues(String[] options);
	
	/**
	 * Helper method to switch to the content iframe
	 */
	public void switchToContent();
	
	/**
	 * Switches the driver back to the entire window frame
	 */
	public void switchToDefaultContent();
	
	/**
	 * Switches to an iframe based on a selenium selector
	 * @param by The selector to use to locate the iframe
	 */
	public void switchToFrame(By by);
	
	/**
	 * Opens a new window that navigates to the specified
	 * page in the publish environment
	 * 
	 * @param publishUrl The absolute url of the publish page
	 */
	public void navigateToPublish(String publishUrl);
	
	/**
	 * Helper method to click an element by its xpath
	 * 
	 * @param xpath The xpath of the element to click
	 */
	public void clickByXpath(String xpath);
	
	/**
	 * Selects dropdown value based on the adjacent label
	 * @param label The label of the dropdown field
	 * @param option The option to select
	 */
	public void selectDropDown(String label, String option);
	
	
	/**
	 * Moves the mouse to the specified position
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void moveMouse(int x, int y);
	
	/**
	 * Closes the auto suggest popup that appears when typing 
	 * into fields
	 */
	public void closeSuggestions();
	
	/**
	 * Helper method which inputs text into the element that directly
	 * follows the specified element
	 * @param label The label of the element adjacent to the desired element
	 * @param text The text to input
	 */
	public void followingSiblingInput(String label, String text);
	
	
	/**
	 * Helper method which inputs text into the element that directly
	 * follows the specified element. Falls back to a default value if 
	 * the label element is not found
	 * 
	 * @param label The label of the element adjacent to the desired element
	 * @param text The text to input
	 * @param fallback The fallback selector to use if label is not found
	 */
	public void followingSiblingInput(String label, String text, String fallback);
	
	/**
	 * Tests the page title of the acitve page
	 * @param newTitle The expected page title
	 */
	public void validatePageTitle(String newTitle);
	
	
	/** 
	 * Closes the inline text editor
	 */
	public void closeInlineEditor();
	
	/**
	 * Adds fields in multiselect fields
	 * 
	 * @param numberOfTabs The number of fields to add
	 * @return The active AuthorPage object
	 */
	public AuthorPage addTabs(int numberOfTabs);
	
	/**
	 * Inputs text into multiple fields in CQ multiset fields 
	 * 
	 * @param fieldName The name of each individual field
	 * @param prefix    The prefix to use for input text, incremented int is added to prefix per field
	 * @return The active AuthorPage object
	 */
	public AuthorPage fillInMultipleFields(String fieldName, String prefix);
	
	/**
	 * Inputs text into multiple fields in CQ multiset fields 
	 * 
	 * @param fieldName The name of each individual field
	 * @param values    An array of values to use for dialog input
	 * @return The active AuthorPage object
	 */
	public AuthorPage fillInMultipleFields(String fieldName, String[] values);
	
	
	/**
	 * Selects dropdown value in x-tab panels
	 * @param option The text of the option to select
	 */
	public void selectDropDownValue(String option);
	
	/**
	 * Extracts text from an html input field
	 * @param by The selenium selector of the element to extract text from
	 * @return String value of the input fields text
	 */
	public String getTextFromInput(By by);
	
	/**
	 * Extracts text from an html input field
	 * @param ele The element to extract text from
	 * @return String value of the input fields text
	 */
	public String getTextFromInput(WebElement ele);
	
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
	 * 
	 * @param by The selenium selector of the element
	 */
	public void clickBy(By by);
	
	/**
	 * Validate an element exists by a selenium selector
	 * 
	 * @param by selenium selector of the target element
	 */
	public void assertExists(By by);

	/**
	 * Validate an element does not exist by a selenium selector
	 *
	 * @param by selenium selector of the target element
	 */
	public void assertNotExists(By by);
	
	/**
	 * Validate an element has the specified text by a selenium selector
	 * 
	 * @param by selenium selector of the target element
	 * @param text the expected text value
	 */
	public void assertText(By by, String text);

	/**
	 * Assert that an element is visible by a selenium selector
	 *
	 * @param by selenium selector of the target element
	 * @param visible  true if element should be visible, false if hidden
	 */
	public void assertVisibility(By by, boolean visible);
	/**
	 * Validate a link created using the List component
	 * 
	 * @param s The link text to search for
	 */
	public void checkLinkByText(String s);
	
	/**
	 * Validate a link has the specified text by a selenium selector
	 * 
	 * @param link The link text to search for
	 */
	public void assertLinkText(String link);
	
	/**
	 * Refreshes the current page
	 */
	public void refresh();
	
	/**
	 * Waits for a page to finish reloading
	 */
	public void waitForRefresh();

	/**
	 * Finds the field in the dialog by DOM index and increments by the specified amount
	 * 
	 * @param numberOfTimes           The number of times to increment field
	 * @param indexOfIncrementField   The index of the element in the dom 
	 */
	public void increment(int numberOfTimes, int indexOfIncrementField); 
	
	/**
	 * Finds the field in the dialog by DOM index and decrements by the specified amount
	 * 
	 * @param numberOfTimes           The number of times to decrement field
	 * @param indexOfIncrementField   The index of the element in the dom 
	 */
	public void decrement(int numberOfTimes, int indexOfIncrementField); 
	
	
	
	
	
	
	
	
	
	
}
