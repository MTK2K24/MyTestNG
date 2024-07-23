package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminPage 
{
	WebDriver driver;
	PageUtility pageutility;
    public AdminPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageutility=new PageUtility();
    }
    
    @FindBy(xpath="//a[@onclick=\"click_button(1)\"]") WebElement newbutton;
    @FindBy(xpath="//input[@id=\"username\"]") WebElement usernamefield; 
    @FindBy(xpath="//input[@id=\"password\"]") WebElement passwordfield;
    @FindBy(xpath="//select[@id=\"user_type\"]") WebElement usertypefield; 
    @FindBy(xpath="//button[@name=\"Create\"]") WebElement savebutton; 
    
    public AdminPage clickingNewButtonToLoadAdminUserInformationPage()
    {
       newbutton.click();
       return this;
    }
    public AdminPage enteringTextInUsernameField(String usernametext) 
    {
    	usernamefield.sendKeys(usernametext);
    return this;
    }
    public AdminPage enteringTextInPasswordField(String passwordtext) 
    {
    	passwordfield.sendKeys(passwordtext);
    return this;
    }
    public AdminPage choosingUserTypeFieldByVisibleTextMethod(String usertype) 
    {
    	pageutility.selectAValueUsingSelectByVisibleText(usertypefield, usertype);
       	return this;
    }
    public AdminPage clickingOnSaveButton()
    {
    	savebutton.click();
    	return this;
    }
    
    
    
    
    
    
    
}
