package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signinField;
	@FindBy(xpath="//aside[@class='main-sidebar elevation-4 sidebar-light-dark']") WebElement dispalyDashboardElement;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertbox;
	
	
		public LoginPage enterUserNameOnUserNameField(String username)
	{
		usernameField.sendKeys(username);
		return this;
		
	}
		public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
		public LoginPage clickOnSignIn()
	{
		signinField.click();
		return this;
	}
		public boolean isDashboardDisplayed() 
	{
        boolean dashboardelement=dispalyDashboardElement.isDisplayed();
        return dashboardelement;
    }
	    public boolean isAlertBoxDisplayed() 
    {
    	boolean alertstatus=alertbox.isDisplayed();
        return alertstatus;
    }
        public void naviagteToAPage(String url) 
    {
    	driver.navigate().to(url);

    }
       public void navigateToAdminPage(String adminurl)
    {
    	driver.navigate().to(adminurl);
    }
       public void navigateToManageCatrgoryPage(String managecategoryurl)
    {
    	driver.navigate().to(managecategoryurl);
    }
    
    
}
