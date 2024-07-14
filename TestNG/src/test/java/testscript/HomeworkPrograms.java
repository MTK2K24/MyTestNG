package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomeworkPrograms extends Base{
	
	@Test
	
	public void verifyShowButton()
	{
	driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
	WebElement showmessage= driver.findElement(By.xpath("//button[@id=\"button-one\"]"));
	
	if(!showmessage.isDisplayed())
	{
		System.out.println("Show button test failed");
	}
	else
	{
		System.out.println("Show button test passed");
	}
	
	}
	@Test
	
	public void verifySingleInputField()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement entermessage=driver.findElement(By.xpath("//input[@id=\"single-input-field\"]"));
		String entermessagedata= "Test Data";
		entermessage.sendKeys(entermessagedata);
		WebElement showmessage=driver.findElement(By.xpath("//button[@id=\"button-one\"]"));
		showmessage.click();
		WebElement yourmessage=driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
		String displayedMessage = yourmessage.getText();
		System.out.println(displayedMessage);
		if(yourmessage.isDisplayed() && displayedMessage.contains(entermessagedata))
		{
			System.out.println("Single input field test passed");
		}
		else
		{
			System.out.println("Single input field test failed");
		}
		
		}
	
	@Test
	
	public void verifyShowMessageBackgroundColour()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement showmessage=driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
		String expectedcolor= "rgba(0, 123, 255, 1)";
		String actualcolor=showmessage.getCssValue("background-color");
		System.out.println(actualcolor);
		if(expectedcolor.equals(actualcolor))
		{ 
			System.out.println("Show message background colour test pass");
		}
		else
		{
			System.out.println("Show message background colour test fail");
		}
	}
	
	}
	

