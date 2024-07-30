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



public class ManageCategoryPage 
{
	WebDriver driver;
	WaitUtility waitutility;
	WebDriverWait wait;
	FileUploadUtility fileUploadUtility;
	
    public ManageCategoryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitutility = new WaitUtility();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fileUploadUtility = new FileUploadUtility();
    }
    @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton; 
    @FindBy(xpath="//input[@name='category']") WebElement categoryfield; 
    @FindBy(xpath = "//*[@id='134-selectable']") WebElement groupselectfield;
    @FindBy(xpath="//*[@id='main_img']") WebElement imageField; 
    @FindBy(xpath="//input[@name='top_menu' and @value='no']") WebElement topmenuradio;
    @FindBy(xpath="//input[@name='show_home' and @value='no']") WebElement leftmenuradio; 
    @FindBy(xpath="//button[@name='create']") WebElement savebutton;
    @FindBy(xpath="//*[@id='form']/div/div[5]/a") WebElement cancelbutton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
    
    public ManageCategoryPage clickingNewButtonToLoadAddCategoryPage()
    {
       newbutton.click();
       return this;
    }
    public ManageCategoryPage enteringTextInCategoryField(String newCategoryName)
    {
    	categoryfield.sendKeys(newCategoryName);
    	return this;
    }
    public ManageCategoryPage choosingDiscountGroup()
    {
    	waitutility.waitUsingElementToBeClickable(driver, groupselectfield);
    	groupselectfield.click();
    	return this;
    }
    public ManageCategoryPage choosingFiletoUpload(String filePath) throws AWTException
    {
    	 waitutility.waitUsingElementToBeClickable(driver, imageField);
         fileUploadUtility.sendKeysFileUpload(imageField, filePath);
         return this;
    }
    
    public ManageCategoryPage clickOnRadioButton()
    {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementToBeClickable(topmenuradio));
    	   wait.until(ExpectedConditions.elementToBeClickable(topmenuradio)).click();
    	//topmenuradio.click();
    	return this;
    }
    public ManageCategoryPage clickOnSecondRadioButton()
    {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementToBeClickable(leftmenuradio));
    	//leftmenuradio.click();
    	 wait.until(ExpectedConditions.elementToBeClickable(leftmenuradio)).click();
    	return this;
    }
    
    public ManageCategoryPage clickOnSaveButton()
    {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementToBeClickable(savebutton));
    	//savebutton.click();
    	 wait.until(ExpectedConditions.elementToBeClickable(savebutton)).click();
    	return this;
    
    }
    
    public String getSuccessMessage()
    {
        waitutility.waitUsingElementToBeVisible(driver, successMessage);
        return successMessage.getText();
    }
   

}
