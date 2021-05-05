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

public class OwnerAddContractPO extends SeleniumHelpers {

    public OwnerAddContractPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    @FindBy(xpath = "//button[@class='bg-c-button contract-onboarding__button bg-c-button--primary bg-c-button--lg']")
    private WebElement FTUENextButton;

    @FindBy(xpath = "//button[contains(text(), 'Tambah Penyewa')]")
    private WebElement addTenantButton;

    @FindBy(css = ".add-contract__card-item:nth-child(2) .add-contract-box__card-title")
    private WebElement addContractByOwnerMenu;

    @FindBy(xpath = "//b[@class='add-tenant-kost-item__name'][1]")
    private WebElement kostFirstOption;

    @FindBy(xpath = "//input[@id='phoneNumberField']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@placeholder='Pilih nomor kamar kos']")
    private WebElement roomNumberDropdown;

    @FindBy(xpath = "//button[contains(text(),'Terapkan')]")
    private WebElement applyRoomButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitRoomButton;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement tenantNameForm;

    @FindBy(xpath = "//button[contains(text(),'Selanjutnya')]")
    private WebElement submitNameButton;

    @FindBy(css = ".add-tenant-select-options .mami-select-options .btn-group")
    private WebElement rentType;

    @FindBy(xpath = "//option[@value='monthly']")
    private WebElement rentTypeMonthly;

    @FindBy(xpath = "//span[contains(text(),'Pilih durasi sewa')]")
    private WebElement durationRent;

    @FindBy(xpath = "//option[@value='1']")
    private WebElement oneMonthDuration;

    private By dateTextBox = By.xpath("//input[@class='form-control add-tenant-due-date__input']");

    @FindBy(xpath = "//span[@class='cell day today']")
    private WebElement datePickToday;

    @FindBy(xpath = "(//span[@class='cell day today'])[2]")
    private WebElement datePickTomorrow;

    @FindBy(css = ".add-tenant-price-input .form-control")
    private WebElement lateCostForm;

    @FindBy(css = ".field-days .field-item:first-child .form-control")
    private WebElement dueDate;

    @FindBy(css = ".form-additional-cost .cost-title-container .form-control")
    private WebElement additionalItem;

    @FindBy(css = ".form-additional-cost:nth-child(3) .cost-title-container .form-control")
    private WebElement additionalItem2;

    @FindBy(css = ".form-additional-cost .cost-price-container .form-control")
    private WebElement additionalPrice;

    @FindBy(css = ".form-additional-cost:nth-child(3) .cost-price-container .form-control")
    private WebElement additionalPrice2;

    @FindBy(xpath = "//button[@class='form-additional-cost-btn text-primary']")
    private WebElement addAdditionalItemButton;

    @FindBy(xpath = "//button[contains(text(),'Selanjutnya')]")
    private WebElement nextButton;

    //-------------- Details Payment ---------------

    @FindBy(css = ".add-tenant-info-item:first-child .add-tenant-info-item__info")
    private WebElement tenantName;

    @FindBy(css = ".add-tenant-info-item:nth-child(2) .add-tenant-info-item__info")
    private WebElement tenantPhone;

    @FindBy(css = ".add-tenant-info-item:last-child .add-tenant-info-item__info")
    private WebElement tenantRoom;

    @FindBy(css = ".--main-price .add-tenant-price-wrapper b")
    private WebElement mainPrice;

    @FindBy(css = ".--other-price .price-list-item:first-child .add-tenant-price-wrapper b")
    private WebElement otherPrice1;

    @FindBy(css = ".--other-price .price-list-item:last-child .add-tenant-price-wrapper b")
    private WebElement otherPrice2;

    @FindBy(css = ".--price-total .add-tenant-price-wrapper b")
    private WebElement totalPrice;

    @FindBy(css = ".--other-price .price-list-item:nth-child(1) .price-list-label")
    private WebElement verifAdditionalItem;

    @FindBy(css = ".--other-price .price-list-item:nth-child(1) .add-tenant-price-wrapper b")
    private WebElement verifAdditionalPrice1;

    @FindBy(css = ".--other-price .price-list-item:nth-child(2) .price-list-label")
    private WebElement verifAdditionalItem2;

    @FindBy(css = ".--other-price .price-list-item:nth-child(2) .add-tenant-price-wrapper b")
    private WebElement verifAdditionalPrice2;

    @FindBy(xpath = "(//button[contains(text(),'Simpan')])[1]")
    private WebElement saveTenantContractButton;

    @FindBy(xpath = "(//button[contains(text(),'Simpan')])[2]")
    private WebElement saveTenantContractButton2;

    @FindBy(xpath = "//h2[contains(text(),'Berhasil Menyimpan Data!')]")
    private WebElement successPopUp;

    @FindBy(xpath = "//button[contains(text(),'Lihat Detail Penyewa')]")
    private WebElement seeContractTenantButton;

    @FindBy(className = "cost-add red")
    private WebElement totalPayment;

    @FindBy(xpath = "//span[contains(text(), 'Hentikan Kontrak Sewa')]")
    private WebElement terminateContractButton;

    @FindBy(xpath = "(//div[@role='radiobutton' and @type='success'])[1]")
    private WebElement finishContractRadioButton;

    @FindBy(xpath = "//input[@class='stop-rent-date__input']")
    private WebElement dateStopContract;

    @FindBy(xpath = "//button[contains(text(),'Pilih')]")
    private WebElement chooseDate;

    @FindBy(xpath = "//button[contains(text(),'Konfirmasi Pemberhentian Sewa')]")
    private WebElement confirmTerminateContractButton;

    @FindBy(xpath = "//p[@class='termination-card-info__description']")
    private WebElement stopContractDesc;


    //================================= ACTION METHOD ===================================

    /**
     * Click add contract by owner option
     *
     * @throws InterruptedException
     */
    public void clickAddContractByOwner() throws InterruptedException {
        hardWait(2);
        click(FTUENextButton);
        click(FTUENextButton);
        click(FTUENextButton);
        click(FTUENextButton);
        waitInCaseElementVisible(addContractByOwnerMenu, 3);
        clickOn(addContractByOwnerMenu);
    }

    /**
     * Check if first kos present
     */
    public boolean isSelectsPropertyPresent() {
        return waitInCaseElementVisible(kostFirstOption, 5) != null;
    }

    /**
     * Click the first kos on option
     *
     * @throws InterruptedException
     */
    public void selectFirstProperty() throws InterruptedException {
        clickOn(kostFirstOption);
        hardWait(3);
    }

    /**
     * Input tenant information phone number, and room number
     * @param number phone
     * @param room room
     * @throws InterruptedException
     */
    public void inputTenantInfo(String number, String room) throws InterruptedException {
        waitInCaseElementVisible(phoneNumberField, 5);
        enterText(phoneNumberField, number, false);
        clickOn(roomNumberDropdown);

        String roomNumber = "//span[text()='" + room + "']";
        waitInCaseElementVisible(By.xpath(roomNumber), 3);
        clickOn(By.xpath(roomNumber));
        clickOn(applyRoomButton);
        clickOn(submitRoomButton);
    }

    /**
     * Check form input tenant name is present
     */
    public boolean isFormInputTenantNamePresent() {
        return waitInCaseElementVisible(tenantNameForm, 10) != null;
    }

    /**
     * Input tenant name
     *
     * @param name name
     * @throws InterruptedException
     */
    public void inputTenantName(String name) throws InterruptedException {
        hardWait(2);
        enterText(tenantNameForm, name, true);
        clickOn(submitNameButton);
        hardWait(2);
    }

    /**
     * Select rent count kost
     *
     * @throws InterruptedException
     */
    public void selectRentCount() throws InterruptedException {
        clickOn(rentType);
        waitInCaseElementVisible(rentTypeMonthly, 2);
        clickOn(rentTypeMonthly);
        hardWait(2);
    }

    /**
     * Select duration rent
     *
     * @param month month
     * @throws InterruptedException
     */
    public void selectDurationrent(String month) throws InterruptedException {
        hardWait(2);
        clickOn(durationRent);
        WebElement element = driver.findElement(By.xpath("//option[@value='" + month + "']"));
        clickOn(element);
        hardWait(2);
    }

    /**
     * Select Starting Date of Boarding if exist
     *
     * @throws InterruptedException
     */
    public void selectDateForStartBoarding() throws InterruptedException {
        if (waitInCaseElementPresent(dateTextBox, 5) != null) {
            javascriptClickOn(dateTextBox);
            clickOn(datePickToday);
        }

        clickOn(nextButton);
    }

    /**
     * Input late cost and due date
     *
     * @param penalty charge cost
     * @param deadline due date
     * @throws InterruptedException
     */
    public void inputLateChargeCost(String penalty, String deadline) throws InterruptedException {
        hardWait(1);
        enterText(lateCostForm, penalty, false);
        hardWait(1);
        enterText(dueDate, deadline, true);
    }

    /**
     * Input Additional cost
     *
     * @param type1 name item1
     * @param amount1 cost1
     * @param type2 name item2
     * @param amount2 cost2
     * @throws InterruptedException
     */
    public void inputAdditionalCost(String type1, String amount1, String type2, String amount2) throws InterruptedException {
        hardWait(1);
        enterText(additionalItem, type1, false);
        hardWait(1);
        enterText(additionalPrice, amount1, false);
        hardWait(1);
        clickOn(addAdditionalItemButton);
        hardWait(1);
        enterText(additionalItem2, type2, false);
        hardWait(1);
        enterText(additionalPrice2, amount2, false);
        hardWait(1);
        clickOn(nextButton);
        hardWait(2);
    }

    /**
     * Get tenant name text
     *
     * @return string tenant name
     */
    public String getTenantName() {
        return getText(tenantName);
    }

    /**
     * Get tenant room text
     *
     * @return string tenant room
     */
    public String getTenantRoom() {
        return getText(tenantRoom);
    }

    /**
     * Get main price text, remove char [R, p, .]
     *
     * @return string price
     */
    public String getMainPrice() {
        String price = getText(mainPrice);
        price = price.replaceAll("[Rp.]", "");
        return price;
    }

    /**
     * Get tenant number phone
     *
     * @return string tenant number
     */
    public String getTenantNumber() {
        return getText(tenantPhone);
    }

    /**
     * Get additional item 1
     *
     * @return string additional item
     */
    public String getAdditionalItem1() {
        return getText(verifAdditionalItem);
    }

    /**
     * Get additional item 2
     *
     * @return string additional item
     */
    public String getAdditionalItem2() {
        return getText(verifAdditionalItem2);
    }

    /**
     * Get main price text, remove char [R, p, .]
     *
     * @return string price
     */
    public String getAdditionalPrice1() {
        String price = getText(verifAdditionalPrice1);
        price = price.replaceAll("[Rp.]", "");
        return price;
    }

    /**
     * Get main price text, remove char [R, p, .]
     *
     * @return string price
     */
    public String getAdditionalPrice2() {
        String price = getText(verifAdditionalPrice2);
        price = price.replaceAll("[Rp.]", "");
        return price;
    }

    /**
     * Click save tenant contract
     *
     * @throws InterruptedException
     */
    public void clickSaveTenantContract() throws InterruptedException {
        hardWait(3);
        clickOn(saveTenantContractButton);
        waitInCaseElementVisible(saveTenantContractButton2, 2);
        clickOn(saveTenantContractButton2);
    }

    /**
     * Check the success pop up present
     *
     * @return true/false
     */
    public boolean isSuccessPopUpPresent() {
        return waitInCaseElementVisible(successPopUp, 5) != null;
    }

    /**
     * Click see detail contract
     *
     * @throws InterruptedException
     */
    public void clickSeeDetailsContract() throws InterruptedException {
        clickOn(seeContractTenantButton);
    }

    /**
     * Check the total price present
     *
     * @return true/false
     */
    public boolean isTotalPricePresent() {
        return waitInCaseElementVisible(totalPayment, 5) != null;
    }

    /**
     * Click terminate contract button
     *
     * @throws InterruptedException
     */
    public void clickTerminateContractButton() throws InterruptedException {
        pageScrollInView(terminateContractButton);
        waitInCaseElementVisible(terminateContractButton, 2);
        clickOn(terminateContractButton);
    }

    /**
     * Click reason stop contract radio button
     * Select date stop contract
     * Click confirm button
     *
     * @throws InterruptedException
     */
    public void selectReasonTerminate() throws InterruptedException {
        clickOn(finishContractRadioButton);
        clickOn(dateStopContract);
        clickOn(datePickToday);
        clickOn(chooseDate);
        clickOn(confirmTerminateContractButton);
        hardWait(5);
    }

    /**
     * Get stop contract desc info
     *
     * @return string desc
     */
    public String getStopContractDesc() {
        waitInCaseElementVisible(stopContractDesc, 3);
        return getText(stopContractDesc);
    }
}
