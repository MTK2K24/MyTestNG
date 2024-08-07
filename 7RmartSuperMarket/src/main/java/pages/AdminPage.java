package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage 
{
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
    public AdminPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageutility=new PageUtility();
        this.waitutility=new WaitUtility();
    }
    
    @FindBy(xpath="//a[@onclick='click_button(1)']") private  WebElement newbutton;
    @FindBy(xpath="//input[@id='username']") private  WebElement usernamefield; 
    @FindBy(xpath="//input[@id='password']") private  WebElement passwordfield;
    @FindBy(xpath="//select[@id='user_type']") private  WebElement usertypefield; 
    @FindBy(xpath="//button[@name='Create']") private  WebElement savebutton; 
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private  WebElement successMessage;
    @FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement searchIcon;
    @FindBy(xpath = "//input[@name='un']") private WebElement usernameToSearch;
    @FindBy(xpath = "//button[@name='Search']") private  WebElement searchButton;
    @FindBy(xpath = "//table//td[text()='jaya']") private WebElement searchedproductinlist;
    
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
    public String getSuccessMessage() {
        return successMessage.getText();
    }
  
    public AdminPage clickSearchIcon() {
       searchIcon.click();
        return this;
    }
     
     public AdminPage enteringTextToBeSearched(String text) 
     {
    	  pageutility.sendKeysToElement(usernameToSearch, text);
     return this;
     }
     
     public AdminPage clickingSearchButtonToExecuteSearch() 
     {
    	 searchButton.click();
        return this;
    }
     public String getSearchSuccessMessage()
     {
         waitutility.waitUsingElementToBeVisible(driver, searchedproductinlist);
         return searchedproductinlist.getText();
     }
     
     public boolean isSearchResultDisplayed() 
     {
         waitutility.waitUsingElementToBeVisible(driver, searchedproductinlist);
         return searchedproductinlist.isDisplayed();
     }
    
  }
