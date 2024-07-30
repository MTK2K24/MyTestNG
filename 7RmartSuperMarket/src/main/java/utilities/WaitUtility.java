package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtility {
    public static final long EXPLICITWAIT = 30;
    public static final long IMPLICITWAIT = 10;
    public static final long FLUENTWAIT_TIMEOUT = 30;
    public static final long FLUENTWAIT_POLLING = 5;

    public void waitUsingElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUsingElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUsingElementToBePresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element.getAttribute("xpath"))));
    }

    public void waitUsingElementToContainText(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForFrameToBeAvailableAndSwitch(WebDriver driver, By frameLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void waitForAlertPresence(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForElementAttributeToBe(WebDriver driver, WebElement element, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public void waitForElementAttributeToContain(WebDriver driver, WebElement element, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public WebElement fluentWaitForElement(By locator, WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(FLUENTWAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(FLUENTWAIT_POLLING))
                .ignoring(Exception.class);

        return wait.until(driverInstance -> driverInstance.findElement(locator));
    }

    
        }
