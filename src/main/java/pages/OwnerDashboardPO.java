package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class OwnerDashboardPO extends SeleniumHelpers {

    public OwnerDashboardPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    //------------------ Pop Up -----------------
    @FindBy(xpath = "//*[@class='update-price__action-button']//*[contains(text(), 'Saya Mengerti')]")
    private WebElement iUnderstandButtonAdditionalPrice;

    @FindBy(css = ".all-properties")
    private WebElement updateAllKos;

    @FindBy(xpath = "//span[@class='greeting-section__name']")
    private WebElement greetingText;

    @FindBy(xpath = "//a[@class='bg-c-link mk-action-card bg-c-link--high mk-action-card--light'][4]/div[@class='bg-c-card bg-c-card--lined bg-c-card--sm bg-c-card--light']")
    private WebElement addTenantMenu;


    //================================= ACTION METHOD ===================================

    /**
     * Click 'Saya Mengerti' to close set additional costs pop up
     * @throws InterruptedException
     */
    public void clickOnIUnderstandOnSetAdditionalCostsPopUp() throws InterruptedException {
        hardWait(5);
        if (waitInCaseElementVisible(iUnderstandButtonAdditionalPrice, 5) != null) {
            clickOn(iUnderstandButtonAdditionalPrice);
        }
    }

    /**
     * Click on Update All Kos from update Popup
     *
     * @throws InterruptedException
     */
    public void clickOnUpdateAllKosButton() throws InterruptedException {
        if (waitInCaseElementVisible(updateAllKos, 3) != null) {
            clickOn(updateAllKos);
            waitTillElementIsNotVisible(updateAllKos);
        }
    }

    /**
     * Check the greetings text present
     *
     * @return true/false
     */
    public boolean isGreetingSectionNamePresent() {
        return waitInCaseElementVisible(greetingText, 10) != null;
    }

    /**
     * Click add tenant menu
     *
     * @throws InterruptedException
     */
    public void clickAddTenantMenu() throws InterruptedException {
        hardWait(5);
        pageScrollInView(addTenantMenu);
        if(waitInCaseElementVisible(addTenantMenu,3) != null){
            hardWait(2);
            clickOn(addTenantMenu);
        }
    }
}
