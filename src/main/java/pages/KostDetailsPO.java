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

public class KostDetailsPO extends SeleniumHelpers {

    public KostDetailsPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    @FindBy(css = ".name .--kost-title")
    private WebElement kostName;

    //-------------- FTUE Booking Benefit -------------
    private By ftueScreenPopUpBody = By.cssSelector(".onboarding-ftue.highlighted");

    private By iUnderstandButtonBy = By.xpath("//*[not(@class='modal-gender-button')]/child::*[contains(text(), 'Saya Mengerti')]");

    @FindBy(css = ".onboarding-ftue-content button.btn-next")
    private WebElement continueBtn;

    //-------------- Booking Section ------------
    @FindBy(css = "//input[@class='booking-input-checkin__input']")
    private WebElement bookingDate;

    private By dateTextBox = By.xpath("//input[@class='booking-input-checkin__input']");

    @FindBy(xpath = "(//span[@class='cell day today'])[2]")
    private WebElement datePickToday;

    @FindBy(xpath = "(//span[@class='cell day'])[1]")
    private WebElement datePickTomorrow;

    @FindBy(css = ".booking-card__booking-action")
    private WebElement bookingButton;


    //================================= ACTION METHOD ===================================

    /**
     * @return true if TFUE present, otherwise false.
     * @return true / false
     * @throws InterruptedException
     */
    public Boolean isFTUE_screenPresent() {
        return waitInCaseElementPresent(ftueScreenPopUpBody, 5) != null
                || waitInCaseElementPresent(iUnderstandButtonBy, 5) != null;
    }

    /**
     * Will check First Time User Experience screen first. And then will click on continue button or I understand button on FTUE if present in the screen.
     * Dismiss FTUE firt time user experience by click on next button if present.
     *
     * @throws InterruptedException
     */
    public void dismissFTUEScreen() throws InterruptedException {
        waitInCaseElementVisible(ftueScreenPopUpBody, 5);
        int lol = 1;
        while (isFTUE_screenPresent()) {
            if (waitInCaseElementVisible(continueBtn, 3) != null) {
                clickOn(continueBtn);
            } else if (isElementPresent(iUnderstandButtonBy)) {
                clickOn(iUnderstandButtonBy);
            } else if (!isFTUE_screenPresent()) {
                break;
            }
            lol++;
        }
    }

    /**
     * Dismiss FTUE screen by clicks on next 5 times
     *
     * @throws InterruptedException
     */
    public void dismissFTUEScreen2() throws InterruptedException {
        waitInCaseElementVisible(continueBtn, 5);
        clickOn(continueBtn);
        clickOn(continueBtn);
        clickOn(continueBtn);
        clickOn(continueBtn);
        clickOn(continueBtn);
        clickOn(iUnderstandButtonBy);
    }

    /**
     * Scroll to kost name element
     */
    public void scrollToKostName() {
        pageScrollInView(kostName);
    }

    /**
     * Select Starting Date of Boarding if exist
     *
     * @param date date e.g. 15,20 etc
     */
    public void selectDateForStartBoarding(String date) throws InterruptedException {
        if (waitInCaseElementPresent(dateTextBox, 5) != null) {
            if (date.equalsIgnoreCase("today")) {
                javascriptClickOn(dateTextBox);
                clickOn(datePickToday);
            } else {
                javascriptClickOn(dateTextBox);
                javascriptClickOn(datePickTomorrow);
            }
        }
    }

    /**
     * Select Rent Type of Booking
     *
     * @param type type of rent
     */
    public void selectRentType(String type) {
        javascriptClickOn(By.xpath("//div[@class='booking-rent-type__options']/div[@class='booking-rent-type__options-item']/div[contains(.,'" + type + "')]"));
    }

    /**
     * Click on Booking Button
     */
    public void clickOnBookingButton() {
        pageScrollInView(bookingButton);
        waitTillElementIsClickable(bookingButton);
        javascriptClickOn(bookingButton);
    }
}