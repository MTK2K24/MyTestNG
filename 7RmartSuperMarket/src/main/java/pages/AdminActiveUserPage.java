package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminActiveUserPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;

	public AdminActiveUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageutility = new PageUtility();
		this.waitutility = new WaitUtility();
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchIcon;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement usernameToSearch;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//table//td[text()='jaya']")
	private WebElement searchedproductinlist;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-success btncss']")
	private WebElement greenlockicon;
	@FindBy(xpath = "//a[@class='btn btn-sm btn-danger btn-rounded']")
	private WebElement redlockicon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement sucessmessage;

	public AdminActiveUserPage clickSearchIcon() {
		searchIcon.click();
		return this;
	}

	public AdminActiveUserPage enteringTextToBeSearched(String text) {
		pageutility.sendKeysToElement(usernameToSearch, text);
		return this;
	}

	public AdminActiveUserPage clickingSearchButtonToExecuteSearch() {
		searchButton.click();
		return this;
	}

	public boolean isSearchResultDisplayed() {
		waitutility.waitUsingElementToBeVisible(driver, searchedproductinlist);
		return searchedproductinlist.isDisplayed();
	}

	public AdminActiveUserPage clickOnLockIcon() {
		if (greenlockicon.isDisplayed()) {
			greenlockicon.click();
		}
		return this;
	}

	public String showSuccessMessage() {
		return sucessmessage.getText();

	}
}
