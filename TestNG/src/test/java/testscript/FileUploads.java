package testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUploads extends Base
{
	@Test
	public void fileUpload()
	{
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement choosefile= driver.findElement(By.xpath("//input[@id=\"uploadfile_0\"]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //explicitwait example
		wait.until(ExpectedConditions.elementToBeClickable(choosefile));
		choosefile.sendKeys("C:\\Users\\merin\\OneDrive\\Desktop\\TK\\2024\\June\\26062024.pdf");
		
	}
	@Test
	public void fileUploadUsingRoboClass() throws AWTException
	{
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		
		WebElement selectPdfFileButton = driver.findElement(By.xpath("//div[@id='uploader']//a[@class='uploader__btn tooltip--left active']")); 
 		selectPdfFileButton.click(); 
 		StringSelection ss = new StringSelection("C:\\Users\\merin\\OneDrive\\Desktop\\TK\\2024\\June\\26062024.pdf"); 
 		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //copies to clipboard
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
 		robot.keyRelease(KeyEvent.VK_ENTER);
	
	
	}
	

}
