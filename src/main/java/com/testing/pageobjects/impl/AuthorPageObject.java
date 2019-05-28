package com.testing.pageobjects.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testing.pageobjects.AuthorPage;

public class AuthorPageObject extends BasePage implements AuthorPage{
	
	
	@FindBy(className = "x-form-arrow-trigger")
	protected WebElement sidekickWorkflowDropdown;
	@FindBy(className = "cq-sidekick-tab-icon-workflow")
	protected WebElement sidekickWorkflowTab;
	@FindBy(className = "cq-sidekick-tab-icon-components")
	protected WebElement sidekickComponentsTab;
	@FindBy(xpath = "//div[@class='x-combo-list-inner']/div[@class='x-combo-list-item']")
	protected List<WebElement> sidekickAvailableWorkflows;
	@FindBy(xpath = "//button[text()='Start Workflow']")
	protected WebElement sidekickStartWorkflow;
	@FindBy(xpath = "//button[text()='Complete']")
	protected WebElement sidekickCompleteWorkflow;
	@FindBy(xpath = "//span[text()='Complete Work Item']")
	protected WebElement workflowCompleteDialog;
	@FindBy(name = "comment")
	protected WebElement workflowDialogComment;
	@FindBy(xpath = "//button[text()='OK']")
	protected WebElement workflowDialogOkButton;
	@FindBy(xpath = "//div[@class='x-combo-list-item']")
	protected WebElement sidekickWorkflowLabel;

	// New UI
	@FindBy(xpath = "//button[@title='Toggle Side Panel']")
	protected WebElement sidePanelToggle;
	@FindBy(className = "search")
	protected WebElement filterSearch;
	@FindBy(className = "componentfilter")
	protected WebElement componentFilter;
	@FindBy(className = "coral-TabPanel-tab")
	protected List<WebElement> sidePanelTabs;
	@FindBy(className = "card-component")
	protected List<WebElement> componentCards;
	@FindBy(className = "cq-droptarget")
	protected List<WebElement> dropTargets;
	@FindBy(xpath = "//i[contains(@class,'coral-Icon--addCircle')]")
	protected WebElement addItemButton;
	
	
	public AuthorPageObject(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	public boolean isClassic() {
		return !driver.getCurrentUrl().contains("/editor.html");
	}

	public void toggleSidePanel() {
		wait.until(ExpectedConditions.visibilityOf(sidePanelToggle));
		sidePanelToggle.click();
		
	}

	public AuthorPage selectSidePanelTab(String tabName) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='coral-TabPanel-tab' and text()='" + tabName + "']")));
		} catch (Exception e) {
			toggleSidePanel();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='coral-TabPanel-tab' and text()='" + tabName + "']")));
		}
		
		for (WebElement el : sidePanelTabs) {
			if (el.getText().equals(tabName)) {
				el.click();
				return new AuthorPageObject(driver, wait);
			}
		}
		return this;
	}

	public void selectDialogTab(String tabName) {
		driver.switchTo().activeElement();
		By tabBy = By.xpath("//nav[@class='coral-TabPanel-navigation']/a[text()='" + tabName + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(tabBy));
		driver.findElement(tabBy).click();
	}

	public void fillInDialogFieldByName(String name, String text) {
		By fieldBy = By.name(name);
		wait.until(ExpectedConditions.presenceOfElementLocated(fieldBy));
		List<WebElement> fields = driver.findElements(fieldBy);
		WebElement field = null;
		for (WebElement f : fields) {
			if (f.getAttribute("type") == null || !f.getAttribute("type").equals("hidden")) {
				field = f;
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOf(field));
		field.clear();
		field.sendKeys(text);
		field.sendKeys(Keys.BACK_SPACE);
		
	}

	public void switchToOldDialogIframe() {
		try {
			driver.switchTo().frame(
					driver.findElement(By.xpath("//div[@class='coral-Modal-body']/iframe")));
		} catch (Exception e) {
		}
		
	}

	public WebElement findElementByName(String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
		return driver.findElement(By.name(name));
	}

	public WebElement findElementBy(By by) {
		try {
			driver.switchTo().activeElement();
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return driver.findElement(by);
		} catch (Exception e) {
			return null;
		}
	}

	public WebElement getParentOfElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public void editText(String componentName) {
		driver.switchTo().activeElement();
		List<WebElement> componentTargets = driver.findElements(By.xpath("//*[@id='OverlayWrapper']/div/div"));
		for (WebElement el : componentTargets) {
			if (el.getAttribute("data-path") != null) {
				if (el.getAttribute("data-path").endsWith("/" + componentName.toLowerCase().replace(" ", ""))) {
					el.click();
					el.click();
				}
			}
		}
		
	}

	public void type(String text) {
		driver.switchTo().activeElement().sendKeys(text);
		
	}

	public void selectAssetFinderDropdown(String option) {
		driver.findElement(By.xpath("//div[@id='assetfinder-filter']/div/span/button/span")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//select[@name='assetfilter_type_selector']/following-sibling::ul/li"));
		for (WebElement el : elements) {
			if (el.getText().equals(option)) {
				el.click();
				break;
			}
		}
		
	}

	public void checkFormLabel(String elementName, String label) {
		Assert.assertTrue(driver.findElement(By.xpath("//label[@for='new_form_" + elementName + "']"))
						.getText().equals(label), "Default Account Name label incorrect");
		
	}

	public void checkLabel(String elementName, String label) {
		Assert.assertTrue( driver.findElement(By.xpath("//label[@for='" + elementName + "']"))
				.getText().equals(label), "Default Account Name label incorrect");
		
	}

	public void validateFields(Map<String, String> fields) {
		Iterator<Entry<String, String>> it = fields.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> pairs = it.next();
			checkFormLabel(pairs.getValue(), pairs.getKey());
			it.remove(); // avoids a ConcurrentModificationException
		}
		
	}

	public void editComponent(String componentName) {
		// TODO Auto-generated method stub
		
	}

	public void editComponent(String componentName, int location) {
		// TODO Auto-generated method stub
		
	}

	public void editComponent(String componentName, MouseAction mouseAction) {
		// TODO Auto-generated method stub
		
	}

	public void selectInlineEditor(String type) {
		// TODO Auto-generated method stub
		
	}

	public void deleteComponent(String componentName) {
		// TODO Auto-generated method stub
		
	}

	public void checkContentByClass(String className) {
		switchToContent();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.className(className)));
		driver.switchTo().frame(driver.findElement(By.id("ContentFrame")));
		Assert.assertNotNull(driver.findElement(By.className(className)), "Address component not found");
		driver.switchTo().defaultContent();
		
	}

	public void checkContentByXPath(String xpath) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		driver.switchTo().frame(driver.findElement(By.id("ContentFrame")));
		Assert.assertNotNull( driver.findElement(By.className(xpath)), "Address component not found");
		driver.switchTo().defaultContent();
		
	}

	public void validateDropdownValues(String[] options) {
		Select select = new Select(driver.findElement(By.name("dropdown")));
		List<WebElement> elements = select.getOptions();
		for (WebElement el : elements) {
			boolean hasOption = false;
			String optionText = el.getText();
			for (String s : options) {
				if (s.equals(optionText)) {
					hasOption = true;
				}
			}
			Assert.assertTrue(hasOption, optionText + " is not a valid option");
		}
		
	}

	public void switchToContent() {
		// TODO Auto-generated method stub
		
	}

	public void switchToDefaultContent() {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(By by) {
		// TODO Auto-generated method stub
		
	}

	public void navigateToPublish(String publishUrl) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpath(String xpath) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDown(String label, String option) {
		// TODO Auto-generated method stub
		
	}

	public void moveMouse(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void closeSuggestions() {
		// TODO Auto-generated method stub
		
	}

	public void followingSiblingInput(String label, String text) {
		// TODO Auto-generated method stub
		
	}

	public void followingSiblingInput(String label, String text, String fallback) {
		// TODO Auto-generated method stub
		
	}

	public void validatePageTitle(String newTitle) {
		// TODO Auto-generated method stub
		
	}

	public void closeInlineEditor() {
		// TODO Auto-generated method stub
		
	}

	public AuthorPage addTabs(int numberOfTabs) {
		// TODO Auto-generated method stub
		return null;
	}

	public AuthorPage fillInMultipleFields(String fieldName, String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	public AuthorPage fillInMultipleFields(String fieldName, String[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownValue(String option) {
		// TODO Auto-generated method stub
		
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

	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	public void waitForRefresh() {
		// TODO Auto-generated method stub
		
	}

	public void increment(int numberOfTimes, int indexOfIncrementField) {
		// TODO Auto-generated method stub
		
	}

	public void decrement(int numberOfTimes, int indexOfIncrementField) {
		// TODO Auto-generated method stub
		
	}

}
