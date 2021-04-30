package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class PageBase{
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public PageBase() {
        WebDriver m = new FirefoxDriver();
        PageFactory.initElements(m, this);
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setText(WebElement e, String value, boolean clear) {
        if (clear) {
            e.clear();
        }
        e.sendKeys(value);
    }

    public void scrollToBottom() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0,2500)");
    }

    public WebElement pageScrollInView(WebElement e) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", e);
        return e;
    }

    public void clearText(WebElement element) {
        element.clear();
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

}
