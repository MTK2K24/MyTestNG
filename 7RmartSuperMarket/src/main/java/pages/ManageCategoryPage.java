package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;



public class ManageCategoryPage 
{
	WebDriver driver;
	WaitUtility waitutility;
	
    public ManageCategoryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitutility = new WaitUtility();
       
    }
    @FindBy(xpath="//a[@onclick=\"click_button(1)\"]") WebElement newbutton; 
    @FindBy(xpath="//input[@name=\"category\"]") WebElement categoryfield; 
    @FindBy(xpath = "//*[@id=\"134-selectable\"]") WebElement groupselectfield;
    @FindBy(xpath="//*[@id=\"main_img\"]") WebElement imagefield; 
    @FindBy(xpath="//input[@name='top_menu' and @value='yes']") WebElement topmenuradio;
    @FindBy(xpath="//input[@name=\"show_home\" and @value='yes']") WebElement leftmenuradio; 
    @FindBy(xpath="//button[@name=\"create\"]") WebElement savebutton;
    @FindBy(xpath="//*[@id=\"form\"]/div/div[5]/a") WebElement cancelbutton;
    
    public ManageCategoryPage clickingNewButtonToLoadAddCategoryPage()
    {
       newbutton.click();
       return this;
    }
    public ManageCategoryPage enteringTextInCategoryField(String newcategoryname)
    {
    	categoryfield.sendKeys(newcategoryname);
    	return this;
    }
    public ManageCategoryPage choosingDiscountGroup()
    {
    	waitutility.waitUsingElementToBeClickable(driver, groupselectfield);
    	groupselectfield.click();
    	return this;
    }
    public ManageCategoryPage choosingFiletoUpload() throws AWTException
    {
    	waitutility.waitUsingElementToBeClickable(driver, imagefield);
    /*	imagefield.click();
    	StringSelection ss = new StringSelection("C:\\Users\\merin\\OneDrive\\Desktop\\lentils.jpeg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(90);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
    	imagefield.sendKeys("C:\\Users\\merin\\OneDrive\\Desktop\\lentils.jpeg");
    	
        return this;
    }
    
    /*public ManageCategoryPage clickOnRadioButton()
    {
    	topmenuradio.click();
    	return this;
    }
    public ManageCategoryPage clickOnSecondRadioButton()
    {
    	leftmenuradio.click();
    	return this;
    }*/
    public ManageCategoryPage clickOnSaveButton()
    {
    	savebutton.click();
    	return this;
    
    }
   


}
