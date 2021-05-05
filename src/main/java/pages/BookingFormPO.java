package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;
import utilities.SeleniumHelpers;

public class BookingFormPO extends SeleniumHelpers {

    public BookingFormPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    @FindBy(id = "mamiCheckboxCommon")
    private WebElement bookingTermCondCheckBox;

    @FindBy(xpath = "//button[@class='btn btn-primary track_success_booking booking-action--btn']")
    private WebElement bookingButton;

    @FindBy(css = "#bookingContainer .booking-success button")
    private WebElement chatOwnerButton;


    //================================= ACTION METHOD ===================================

    /**
     * Click check button Term and Conditions
     *
     * @throws InterruptedException
     */
    public void clickAcceptTermAndCond() throws InterruptedException {
        pageScrollInView(bookingTermCondCheckBox);
        javascriptClickOn(bookingTermCondCheckBox);
        javascriptClickOn(bookingButton);
        hardWait(3);
    }

    /**
     * Click chat owner button
     *
     * @throws InterruptedException
     */
    public void clickChatOwnerButton() throws InterruptedException {
        clickOn(chatOwnerButton);
    }

}
