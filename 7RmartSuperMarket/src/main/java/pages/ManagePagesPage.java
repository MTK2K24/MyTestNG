package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManagePagesPage {
	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;
	FileUploadUtility fileuploadutility;
	
	 public ManagePagesPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        waitutility = new WaitUtility();
	        pageutility=new PageUtility();
	        
	     }
	 @FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement searchicon;
	 @FindBy(xpath="//input[@name='un']") private WebElement texttosearch;
	 @FindBy(xpath="//button[@name='Search']") private WebElement searchbutton;
	 @FindBy(xpath="/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr/td[1]") private WebElement searchedtextintable;
	 @FindBy(xpath="//i[@class='fas fa-trash-alt']") private WebElement deleteiconintable;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertDeleteMessage;
	 
	 public ManagePagesPage navigatingToTheListPage(String naviagteurl) 
	    {
	    	pageutility.navigateTo(driver, naviagteurl);
	       	return this;
	    }
	   public ManagePagesPage clickOnSearchIcon()
	    {
	    	searchicon.click();
	    	return this;
	    }
	    public ManagePagesPage enterTextInSearchField()
	    {
	    	texttosearch.sendKeys("Page testing");
	    	return this;
	    }
	    public ManagePagesPage clickOnSearchButton()
	    {
	    	searchbutton.click();
	    	return this;
	    }
	    public boolean findingEnteredTextInTable() 
	    {
	        if (searchedtextintable.isDisplayed()) 
	        {
	            deleteiconintable.click();
	            return true;
	        } else {
	            return false;
	        }
	    }   
	    public ManagePagesPage clickingDeleteIcon()
	    {
	    	pageutility.acceptAlert(driver);
	    	return this;
	    }
	    public String getDeleteMessage()
	    {
	        waitutility.waitUsingElementToBeVisible(driver, alertDeleteMessage);
	        return alertDeleteMessage.getText();
	    }
}
