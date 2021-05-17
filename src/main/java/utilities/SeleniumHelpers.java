package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions actions;

    String os = System.getProperty("os.name").toLowerCase();

    public SeleniumHelpers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.jse = (JavascriptExecutor)driver;
        this.select = select;
        this.actions = actions;
    }

    //----------- Navigation ------------

    /**
     * Navigate to url address
     *
     * @param url address destination
     */
    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    /**
     * Enter text to input field
     *
     * @param e     WebElement object
     * @param text  input text
     * @param clear set true if want to clear field else set false
     */
    public void enterText(WebElement e, String text, boolean clear) {
        e = waitTillElementIsClickable(e);
        if (clear) {
            e.clear();
        }
        e.sendKeys(text);
    }

    /**
     * Get Text from field
     *
     * @param e WebElement object
     * @return text from field
     */
    public String getText(WebElement e) {
        return waitTillElementIsVisible(e).getText().trim();
    }

    /**
     * Click on Element
     *
     * @param e WebElement object
     * @throws InterruptedException
     */
    public void clickOn(WebElement e) throws InterruptedException {
        waitTillElementIsClickable(e).click();
        waitForJavascriptToLoad();
    }

    /**
     * To determine whether WebElement has given Attribute or not
     *
     * @param e             WebElement object
     * @param attributeName attribute name e.g. style
     * @return boolean
     */
    public boolean isElementAtrributePresent(WebElement e, String attributeName) {
        return e.getAttribute(attributeName) != null;
    }

    /**
     * To get Element attribute value
     *
     * @param e             WebElement object
     * @param attributeName attribute name e.g. style
     * @return attribute value
     */
    public String getElementAttributeValue(WebElement e, String attributeName) {
        if (isElementAtrributePresent(e, attributeName)) {
            return e.getAttribute(attributeName);
        }
        return "Attribute" + attributeName + " not found";
    }

    /**
     * Verify element is displayed
     *
     * @param el WebElement object
     * @return boolean
     */
    public Boolean isElementDisplayed(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Waits

    /**
     * To wait until element is clickable
     *
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsClickable(WebElement e) {
        WebDriverWait wait = new  WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    /**
     * o wait until element is visible
     *
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    /**
     * o wait until element is visible
     *
     * @param e                     WebElement object
     * @param waitDurationInSeconds wait duration in seconds
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e, int waitDurationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, waitDurationInSeconds);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    /**
     * Waiting before performing next action
     *
     * @param seconds provide duration e.g. 1,2 etc
     * @throws InterruptedException
     */
    public void hardWait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    /**
     * This function will wait for page to load (waiting for java script to finish loading) before moving further
     *
     * @throws InterruptedException
     * @paramWaitTime Maximum time is the time out time. if the page loading completes before timeout, code will process
     */
    public void waitForJavascriptToLoad() throws InterruptedException {
        Thread.sleep(1000);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        try {
            wait.until(expectation);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    //iFrames

    public void switchToIframe(int iframeIndex) {
        driver.switchTo().frame(iframeIndex);
    }
}

