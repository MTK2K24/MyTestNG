package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {

    WebDriver driver;
    public ManageProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@onclick=\"click_button(2)\"]") WebElement searchIcon;

    @FindBy(xpath = "//input[@name=\"un\"]") WebElement textToSearch;

    @FindBy(xpath = "//button[@value=\"sr\"]") WebElement searchButton;

   

     public ManageProductPage clickingSearchIconToLoadSearchPage()
     {
        searchIcon.click();
        return this;
     }
     
     public ManageProductPage enteringTextToBeSearched(String text) 
     {
        textToSearch.sendKeys(text);
     return this;
     }
     
     public ManageProductPage clickingSearchButtonToExecuteSearch() 
     {
        searchButton.click();
        return this;
    }
     
}
