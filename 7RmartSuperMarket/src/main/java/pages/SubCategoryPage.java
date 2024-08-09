package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutility = new WaitUtility();
		pageutility = new PageUtility();
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefilebutton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement sucessmessage;

	public SubCategoryPage navigatingToTheNewPage(String naviagteurl) {
		pageutility.navigateTo(driver, naviagteurl);
		return this;
	}

	public SubCategoryPage clickingNewButtonToLoadAddSubCategory() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage choosingCategoryByVisibleTextMethod(String category) {
		pageutility.selectAValueUsingSelectByVisibleText(categorydropdown, category);
		return this;
	}

	public SubCategoryPage enteringDataInSubCategory(String texttobeenteredinsubcategory) {
		subcategory.sendKeys(texttobeenteredinsubcategory);
		return this;
	}

	public SubCategoryPage choosingImageForCategory() throws AWTException {
		waitutility.waitUsingElementToBeClickable(driver, choosefilebutton);
		choosefilebutton.sendKeys("C:\\Users\\merin\\OneDrive\\Desktop\\lentils.jpeg");
		return this;
	}

	public SubCategoryPage clickingSaveButtonToAddASubCategory() {
		waitutility.waitUsingElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public String getSucessMessage() {
		waitutility.waitUsingElementToBeVisible(driver, sucessmessage);
		return sucessmessage.getText();
	}
}
