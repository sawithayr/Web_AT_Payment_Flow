package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ProfilePagePO extends SeleniumHelpers {

    public ProfilePagePO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    @FindBy(xpath = "//label[@class='--waiting']")
    private WebElement statusWaiting;

    @FindBy(xpath = "//label[@class='--waiting']//parent::div/following-sibling::div[2]")
    private WebElement seeMoreButtonKostBooked;

    @FindBy(xpath = "//div[@class='detail-cancel']/button")
    private WebElement cancelBookingButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div[4]/div/div[3]/div/div/div[2]/div[2]/div/div[3]/div[2]/button[2]")
    private WebElement confirmCancelBookingButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[2]/div/div[3]/button")
    private WebElement clickOKCancelButton;

    @FindBy(css = ".message-set.user:last-child .message-item-desc .status")
    private WebElement lastChatStatus;

    @FindBy(css = ".btn.ic-close")
    private WebElement closeChatRoom;

    @FindBy(css = ".btn.ic-minimize")
    private WebElement closeChatMenu;

    @FindBy(css = ".booking-list-card:first-child #bookingListCard .booking-card .card-header .--failed")
    private WebElement statusBookingCanceled;

    //================================= ACTION METHOD ===================================

    /**
     * Check booked kost is present
     *
     * @return true / false
     */
    public boolean isBookedKostPresent() {
        pageScrollInView(statusWaiting);
        return waitInCaseElementVisible(statusWaiting, 3) != null;
    }

    /**
     * Click see more button booked kost
     *
     * @throws InterruptedException
     */
    public void clickSeeMoreButtonBookedKost() throws InterruptedException {
        pageScrollInView(seeMoreButtonKostBooked);
        clickOn(seeMoreButtonKostBooked);
        pageScrollInView(cancelBookingButton);
    }

    /**
     * Click cancel booking button
     *
     * @throws InterruptedException
     */
    public void clickCancelBookingButton() throws InterruptedException {
        waitInCaseElementVisible(cancelBookingButton, 3);
        javascriptClickOn(cancelBookingButton);
        hardWait(5);
        clickOn(confirmCancelBookingButton);
        hardWait(5);
        clickOn(clickOKCancelButton);
    }

    /**
     * Click close chat menu
     *
     * @throws InterruptedException
     */
    public void closeChatMenu() throws InterruptedException {
        waitInCaseElementVisible(closeChatRoom,2);
        clickOn(closeChatRoom);
        clickOn(closeChatMenu);
    }

    /**
     * Get Status chat
     *
     * @return string status
     */
    public String getStatusChat() {
        waitInCaseElementVisible(lastChatStatus, 7);
        String element = getElementAttributeValue(lastChatStatus, "alt");
        return element;
    }

    /**
     * Get status booking
     *
     * @return string status booking
     */
    public String getStatusBooking() {
        waitInCaseElementVisible(statusBookingCanceled, 5);
        return getText(statusBookingCanceled);
    }
}
