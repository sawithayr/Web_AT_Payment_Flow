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

public class HomePagePO extends SeleniumHelpers {

	public HomePagePO(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

    //============================== ELEMENTS DECLARATION ===============================

    //---------- Midtrans Homepage ---------
    @FindBy(xpath = "//a[@class='btn buy']")
    private WebElement BuyNowButton;

    //----------- Shopping Cart -----------
    @FindBy(xpath = "//div[@class='cart-content buying']")
    private WebElement shoppingCart;

    @FindBy(css = ".cart-section:last-child .table-content:nth-child(1) input")
    private WebElement custNameText;

    @FindBy(css = ".cart-section:last-child .table-content:nth-child(2) input")
    private WebElement custEmailText;

    @FindBy(css = ".cart-section:last-child .table-content:nth-child(3) input")
    private WebElement custPhoneText;

    @FindBy(css = ".cart-section:last-child .table-content:nth-child(4) input")
    private WebElement custCityText;

    @FindBy(css = ".cart-section:last-child .table-content textarea")
    private WebElement custAddressText;

    @FindBy(css = ".cart-section:last-child .table-content:nth-child(6) input")
    private WebElement custPostalCodeText;

    @FindBy(css = ".cart-section:nth-child(2) .table-content td:nth-child(2)")
    private WebElement qtyText;

    @FindBy(css = ".cart-section:nth-child(2) .table-content td:last-child input")
    private WebElement amountText;

    @FindBy(css = ".total .amount")
    private WebElement totalPrice;

    @FindBy(className = "cart-checkout")
    private WebElement checkOutButton;

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    private WebElement amountOrderSummaryText;

    @FindBy(xpath = "//a[@class = 'text-actionable']/span[text()='shipping details']")
    private WebElement shippingDetailsButton;

    @FindBy(xpath = "//a[@class='button-main-content']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@class='list with-promo']")
    private WebElement debitCreditCardOption;

    @FindBy(xpath = "//p[.='Credit/Debit Card']")
    private WebElement creditDebitPageTitle;

    @FindBy(xpath = "//input[@name='cardnumber']")
    private WebElement cardNumberForm;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    private WebElement cardExpiryDateForm;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    private WebElement cardCVVNumberForm;

    @FindBy(xpath = "//label[text()='Potongan 10 Rupiah']/input")
    private WebElement promo10RupiahText;

    @FindBy(xpath = "//label[text()='Potongan 10% - Demo Promo Engine']/input")
    private WebElement promo10PersenText;

    @FindBy(xpath = "//label[text()='Promo Demo MasterCard']/input")
    private WebElement promoMasterCard;

    @FindBy(xpath = "//label[text()='Potongan 10 Rupiah']/span")
    private WebElement promo10Rupiah;

    @FindBy(xpath = "//label[text()='Potongan 10% - Demo Promo Engine']/span")
    private WebElement promoDiscount10Persen;

    @FindBy(xpath = "//label[text()='Promo Demo MasterCard']/span")
    private WebElement promoDiscountMasterCard;

    @FindBy(className = "text-amount-amount")
    private WebElement totalAmountPrice;

    @FindBy(xpath = "//div/input[@type='email']")
    private WebElement confirmEmailText;

    @FindBy(xpath = "(//div/input[@type='tel'])[4]")
    private WebElement confirmPhoneText;

    @FindBy(xpath = "//p[@class='form-control-static' and @id='txn_amount']")
    private WebElement totalAmountFinal;

    @FindBy(xpath = "//input[@id='PaRes']")
    private WebElement passwordForm;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;


    //================================= ACTION METHOD ===================================

    /**
     * Click on BUY NOW button
     * @throws InterruptedException
     */
    public void clickBUYNOWButton() throws InterruptedException {
        clickOn(BuyNowButton);
    }

    /**
     * Check the shopping cart present
     * @return shopping cart status true/false
     */
    public boolean isShoppingCartPresent() {
        return waitTillElementIsVisible(shoppingCart, 2) != null;
    }

    /**
     * Get Customer Name Text
     * @return string customer name
     */
    public String getCustomerNameText() {
        return getElementAttributeValue(custNameText, "value");
    }

    /**
     * Get Customer Email Text
     * @return string customer email
     */
    public String getCustomerEmailText() {
        return getElementAttributeValue(custEmailText, "value");
    }

    /**
     * Get Customer Phone Text
     * @return string customer phone
     */
    public String getCustomerPhoneText() {
        return getElementAttributeValue(custPhoneText, "value");
    }

    /**
     * Get Customer City Text
     * @return string customer city
     */
    public String getCustomerCityText() {
        return getElementAttributeValue(custCityText, "value");
    }

    /**
     * Get Customer Address Text
     * @return string customer address
     */
    public String getCustomerAddressText() {
        return getText(custAddressText);
    }

    /**
     * Get Customer Postal Code Text
     * @return string customer postal code
     */
    public String getCustomerPostalCodeText() {
        return getElementAttributeValue(custPostalCodeText, "value");
    }

    /**
     * Get Qty of Item
     * @return int Qty
     */
    public int getQty() {
        String qty = getText(qtyText);
        qty = qty.replaceAll("[× ]", "");
        return Integer.parseInt(qty);
    }

    /**
     * Get amount price for 1 item
     * @return int amount price
     */
    public int getAmount() {
        String amount = getElementAttributeValue(amountText, "value");
        return Integer.parseInt(amount);
    }

    /**
     * Calculate amount price fold with qty item
     * @return int amount price total
     */
    public String calculatePrice(){
        int result = getQty() * getAmount();
        return Integer.toString(result);
    }

    /**
     * Get Total price text, remove (,) symbol
     * @return string price text
     */
    public String getTotalPrice() {
        String price = getText(totalPrice);
        price = price.replaceAll(",", "");
        return price;
    }

    /**
     * Click checkout button
     * hardwait 3 seconds
     * @throws InterruptedException
     */
    public void clickCheckoutButton() throws InterruptedException {
        clickOn(checkOutButton);
        hardWait(3);
    }

    /**
     * Get amount order summary, remove (,) symbol
     * @return string price text
     */
    public String getAmountOrderSummary() {
        String price = getText(amountOrderSummaryText);
        price = price.replaceAll(",", "");
        return price;
    }

    /**
     * Click shipping details button
     * @throws InterruptedException
     */
    public void clickShippingDetailsButton() throws InterruptedException {
        clickOn(shippingDetailsButton);
    }

    /**
     * Check element is present
     * @return status element present/not
     */
    public boolean isValueElementTrue(String value) {
        WebElement element = driver.findElement(By.xpath("//div[@class = 'text-body' and text()='"+ value +"']"));
        return isElementDisplayed(element);
    }

    /**
     * Click continue button
     * @throws InterruptedException
     */
    public void clickContinueButton() throws InterruptedException {
        clickOn(continueButton);
        hardWait(20);
    }

    /**
     * Check payment option is present
     * @return status debit card present/not
     */
    public boolean isPaymentOptionPresent() {
        return waitTillElementIsVisible(debitCreditCardOption, 3) != null;
    }

    /**
     * Click credit debit card option
     * hardwait 2 seconds
     * @throws InterruptedException
     */
    public void clickCreditDebitCardOption() throws InterruptedException {
        clickOn(debitCreditCardOption);
        hardWait(2);
    }

    /**
     * Check credit/debit card page is present
     * @return status credit/debit card page present/not
     */
    public boolean isCreditDebitCardPagePresent() {
        return waitTillElementIsVisible(creditDebitPageTitle, 2) != null;
    }

    /**
     * Enter text card number
     */
    public void enterCardNumber(String card) {
        enterText(cardNumberForm, card, true);
    }

    /**
     * Enter text card expiry date form
     */
    public void enterExpiryDate(String expiry) {
        enterText(cardExpiryDateForm, expiry, true);
    }

    /**
     * Enter text cvv number form
     */
    public void enterCVVNumber(String cvv) {
        enterText(cardCVVNumberForm, cvv, true);
    }

    /**
     * Click promo 10 rupiah option
     * @throws InterruptedException
     */
    public void clickPromo10Rupiah() throws InterruptedException {
        clickOn(promo10RupiahText);
    }

    /**
     * Total nominal - discount nominal
     * Remove symbol (-Rp )
     * @return string price result
     */
    public String promo10Rupiah(int nominal) {
        String price = getText(promo10Rupiah);
        price = price.replaceAll("[- Rp]", "");
        int prc = Integer.parseInt(price);
        int promo = nominal - prc;
        return Integer.toString(promo);
    }

    /**
     * Click promo discount 10 persen option
     * @throws InterruptedException
     */
    public void clickDiscount10Persen() throws InterruptedException {
        clickOn(promo10PersenText);
    }

    /**
     * Total nominal - discount nominal
     * Remove symbol (-Rp )
     * @return string price result
     */
    public String promoDiscount10Persen(int nominal) {
        String price = getText(promoDiscount10Persen);
        price = price.replaceAll("[- Rp,]", "");
        int prc = Integer.parseInt(price);
        int promo = nominal - prc;
        return Integer.toString(promo);
    }

    /**
     * Click promo discount master card option
     * @throws InterruptedException
     */
    public void clickDiscountMasterCard() throws InterruptedException {
        clickOn(promoMasterCard);
    }

    /**
     * Total nominal - discount nominal
     * Remove symbol (-Rp )
     * @return string price result
     */
    public String promoDiscountMasterCard(int nominal) {
        String price = getText(promoDiscountMasterCard);
        price = price.replaceAll("[- Rp,]", "");
        int prc = Integer.parseInt(price);
        int promo = nominal - prc;
        return Integer.toString(promo);
    }

    /**
     * Get email text with attribute value
     * @return string email text
     */
    public String getEmailText() {
       return getElementAttributeValue(confirmEmailText, "placeholder");
    }

    /**
     * Get phone text with attribute value
     * @return string phone text
     */
    public String getPhoneText() {
        return getElementAttributeValue(confirmPhoneText, "placeholder");
    }

    /**
     * Get total amount final text
     * remove 3 char (.00)
     * @return string price
     */
    public String getTotalAmountFinal() {
        String price = getText(totalAmountFinal);
        String prc = price.substring(0, price.length() - 3);
        return prc;
    }

    /**
     * Input password OTP
     * hardwait 2 seconds
     * @throws InterruptedException
     */
    public void inputPassword(String password) throws InterruptedException {
        enterText(passwordForm, password, true);
        hardWait(2);
    }

    /**
     * Click submit button
     * hardwait 2 seconds
     * @throws InterruptedException
     */
    public void clickSubmitButton() throws InterruptedException {
        clickOn(submitButton);
        hardWait(2);
    }

    /**
     * Get status transaction text
     * @return status text successful / failed
     */
    public boolean getStatusTransaction(String status) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+ status +"')]"));
        return isElementDisplayed(element);
    }
}
