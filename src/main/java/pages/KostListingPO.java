package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class KostListingPO extends SeleniumHelpers {

    public KostListingPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    //-------------- FTUE Booking Benefit -------------
    @FindBy(xpath = "//h2[@data-path='lbl_popperTitle']")
    private WebElement FTUETitleText;

    @FindBy(css = "button[data-path='btn_popperAction']")
    private WebElement popUpConfirmationbutton;

    //-------------- Instant Filter -------------
    @FindBy(xpath = "//div[@id='baseMainFilter'][3]//button[@class='base-filter-button']")
    private WebElement kosRuleFilter;

    @FindBy(xpath = "//div[@class='open btn-group']//span[.='Akses 24 Jam']")
    private WebElement filter24Jam;

    @FindBy(xpath = "//span[@data-path='lbl_booking']/following-sibling::div//span")
    private WebElement instantBookingTogle;

    @FindBy(xpath = "//*[@id='baseMainFilter'][3]//button[@class='base-save']")
    private WebElement saveKosRuleFilter;


    //================================= ACTION METHOD ===================================

    /**
     * Will check First Time User Experience screen first. And then will click on close button on FTUE if present in the screen.
     * Dismiss FTUE first time user experience by click on close button if present.
     *
     * @throws InterruptedException
     */
    public void closeFTUEKosListingPopUp() throws InterruptedException {
        if (waitInCaseElementVisible(popUpConfirmationbutton, 3) != null) {
            clickOn(popUpConfirmationbutton);
            clickOn(popUpConfirmationbutton);
        }
    }

    /**
     * Select Kos Rule filter
     *
     * @param kosRule
     * @throws InterruptedException
     */
    public void selectKosRule(String kosRule) throws InterruptedException {
        clickOn(kosRuleFilter);
        hardWait(2);
        String xpathLocator = "//div[@class='open btn-group']//span[.='"+ kosRule +"']";
        javascriptClickOn(By.xpath(xpathLocator));
        clickOn(saveKosRuleFilter);
    }

    /**
     * Click Instant Filter on Kos Listing
     *
     * @param instantFilter
     * @throws InterruptedException
     */
    public void selectInstantFilter(String instantFilter) throws InterruptedException {
        String xpathLocator = "//span[text()='" + instantFilter + "']";
        clickOn(By.xpath(xpathLocator));
    }

    /**
     * Click Instant Booking filter
     *
     * @throws InterruptedException
     */
    public void clickInstantBooking() throws InterruptedException {
        clickOn(instantBookingTogle);
    }

    /**
     * Click selected kos
     *
     * @param kosName
     * @throws InterruptedException
     */
    public void clickSelectedKost(String kosName) throws InterruptedException {
        String xpathLocator = "//h3[@title='" + kosName + "']";
        clickOn(By.xpath(xpathLocator));
    }
}