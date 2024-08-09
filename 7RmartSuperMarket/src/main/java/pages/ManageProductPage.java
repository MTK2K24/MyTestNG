package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class ManageProductPage {
	WebDriver driver;
	WaitUtility waitutility;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutility = new WaitUtility();
	}

	@FindBy(xpath = "//a[@onclick=\"click_button(2)\"]")
	private WebElement searchIcon;

	@FindBy(xpath = "//input[@name=\"un\"]")
	private WebElement textToSearch;

	@FindBy(xpath = "//button[@value=\"sr\"]")
	private WebElement searchButton;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-success']")
	private WebElement searchedproductinlist;

	public ManageProductPage clickingSearchIconToLoadSearchPage() {
		searchIcon.click();
		return this;
	}

	public ManageProductPage enteringTextToBeSearched(String text) {
		textToSearch.sendKeys(text);
		return this;
	}

	public ManageProductPage clickingSearchButtonToExecuteSearch() {
		searchButton.click();
		return this;
	}

	public String getSuccessMessage() {
		waitutility.waitUsingElementToBeVisible(driver, searchedproductinlist);
		return searchedproductinlist.getText();
	}

	public boolean isSearchResultDisplayed() {
		waitutility.waitUsingElementToBeVisible(driver, searchedproductinlist);
		return searchedproductinlist.isDisplayed();
	}
}
