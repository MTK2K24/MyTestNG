package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageNewsPage {
	WebDriver driver;
	PageUtility pageutility;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageutility = new PageUtility();
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enternewsfield;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;

	public ManageNewsPage navigateToManageNewsPage(String url) {
		pageutility.navigateTo(driver, url);
		return this;
	}

	public ManageNewsPage clickingNewButtonInManageNewsPage() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage enteringTextInNewsField(String text) {
		pageutility.sendKeysToElement(enternewsfield, text);
		return this;
	}

	public ManageNewsPage clickingSaveButton() {
		savebutton.click();
		return this;
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
