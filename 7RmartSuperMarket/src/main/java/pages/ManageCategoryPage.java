package pages;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WebDriver driver;
	WaitUtility waitutility;
	WebDriverWait wait;
	FileUploadUtility fileUploadUtility;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutility = new WaitUtility();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		fileUploadUtility = new FileUploadUtility();
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@name='category']")
	private WebElement categoryfield;
	@FindBy(xpath = "//*[@id='134-selectable']")
	private WebElement groupselectfield;
	@FindBy(xpath = "//*[@id='main_img']")
	private WebElement imageField;
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']")
	private WebElement topmenuradio;
	@FindBy(xpath = "//input[@name='show_home' and @value='no']")
	private WebElement leftmenuradio;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement savebutton;
	@FindBy(xpath = "//*[@id='form']/div/div[5]/a")
	private WebElement cancelbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[2]")
	private WebElement searchicon;
	@FindBy(xpath = "//*[@id=\"srdiv\"]/div/div/div/div[2]/form/div/div[1]/input")
	private WebElement texttosearch;
	@FindBy(xpath = "//*[@id=\"srdiv\"]/div/div/div/div[2]/form/div/div[2]/button")
	private WebElement searchbutton;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[1]/td[1]")
	private WebElement searchedtextintable;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editiconintable;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	private WebElement leftmenuradiobutton;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertUpdateMessage;

	public ManageCategoryPage clickingNewButtonToLoadAddCategoryPage() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage enteringTextInCategoryField(String newCategoryName) {
		categoryfield.sendKeys(newCategoryName);
		return this;
	}

	public ManageCategoryPage choosingDiscountGroup() {
		waitutility.waitUsingElementToBeClickable(driver, groupselectfield);
		groupselectfield.click();
		return this;
	}

	public ManageCategoryPage choosingFiletoUpload(String filePath) throws AWTException {
		waitutility.waitUsingElementToBeClickable(driver, imageField);
		fileUploadUtility.sendKeysFileUpload(imageField, filePath);
		return this;
	}

	public ManageCategoryPage clickOnRadioButton() {

		wait.until(ExpectedConditions.elementToBeClickable(topmenuradio)).click();
		return this;
	}

	public ManageCategoryPage clickOnSecondRadioButton() {
		wait.until(ExpectedConditions.elementToBeClickable(leftmenuradio)).click();
		return this;
	}

	public ManageCategoryPage clickOnSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(savebutton)).click();
		return this;

	}

	public String getSuccessMessage() {
		waitutility.waitUsingElementToBeVisible(driver, successMessage);
		return successMessage.getText();
	}

	public ManageCategoryPage clickOnSearchIcon() {
		searchicon.click();
		return this;
	}

	public ManageCategoryPage enterTextInSearchField() {
		texttosearch.sendKeys("Olives");
		return this;
	}

	public ManageCategoryPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public boolean findingEnteredTextInTable() {
		return searchedtextintable.isDisplayed();
	}

	public ManageCategoryPage clickingEditIcon() {
		waitutility.waitUsingElementToBeClickable(driver, editiconintable);
		editiconintable.click();
		return this;
	}

	public ManageCategoryPage clickOnYesRadioButton() {
		waitutility.waitUsingElementToBeClickable(driver, leftmenuradiobutton);
		leftmenuradiobutton.click();
		return this;
	}

	public ManageCategoryPage clickOnUpdateButton() {
		updatebutton.click();
		return this;
	}

	public String getUpdateMessage() {
		waitutility.waitUsingElementToBeVisible(driver, alertUpdateMessage);
		return alertUpdateMessage.getText();
	}

}
