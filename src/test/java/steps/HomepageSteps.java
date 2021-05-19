package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePagePO;
import utilities.JavaHelpers;
import tests.TestBase;

public class HomepageSteps extends TestBase {

    private HomePagePO homepage = new HomePagePO(driver);

    private String customerDetails = "src/test/resources/testdata/customerDetails.properties";
    private String name = JavaHelpers.getPropertyValue(customerDetails, "name");
    private String email = JavaHelpers.getPropertyValue(customerDetails, "email");
    private String phone = JavaHelpers.getPropertyValue(customerDetails, "phone");
    private String phoneIndo = JavaHelpers.getPropertyValue(customerDetails, "phoneIndo");
    private String phone2 = JavaHelpers.getPropertyValue(customerDetails, "phone2");
    private String city = JavaHelpers.getPropertyValue(customerDetails, "city");
    private String address = JavaHelpers.getPropertyValue(customerDetails, "address");
    private String addressFull = JavaHelpers.getPropertyValue(customerDetails, "addressFull");
    private String postal_code = JavaHelpers.getPropertyValue(customerDetails, "postal_code");

    @When("user clicks BUY NOW button")
    public void userClicksBUYNOWButton() throws InterruptedException {
        homepage.clickBUYNOWButton();
        Assert.assertTrue(homepage.isShoppingCartPresent(), "Shopping cart is not present!");
    }

    @And("user validates total price similar on order summary")
    public void userValidatesTotalPriceSimilarOnOrderSummary() throws InterruptedException {
        Assert.assertEquals(homepage.getTotalPrice(), homepage.calculatePrice(), "Total Price not equals!");
        String priceCalculated = homepage.calculatePrice();
        homepage.clickCheckoutButton();
        homepage.switchToIframe(0);
        Assert.assertEquals(homepage.getAmountOrderSummary(), priceCalculated, "Total price in order summary not equals!");
    }

    @And("user validates shipping details on order summary")
    public void userValidatesShippingDetailsOnOrderSummary() throws InterruptedException {
        homepage.clickShippingDetailsButton();
//        homepage.clickShippingDetailsButton();
        Assert.assertTrue(homepage.isValueElementTrue(name), "Element name is not equals with " + name + "!");
        Assert.assertTrue(homepage.isValueElementTrue(email), "Element email is not equals with " + email + "!");
        Assert.assertTrue(homepage.isValueElementTrue(phoneIndo), "Element email is not equals with " + email + "!");
        Assert.assertTrue(homepage.isValueElementTrue(addressFull), "Element address is not equals with " + addressFull + "!");
    }

    @Then("user validates Customer Details")
    public void userValidatesCustomerDetails() {
        Assert.assertEquals(name, homepage.getCustomerNameText(), "Customer name is not equals!");
        Assert.assertEquals(email, homepage.getCustomerEmailText(), "Customer email is not equals!");
        Assert.assertEquals(phone, homepage.getCustomerPhoneText(), "Customer phone is not equals!");
        Assert.assertEquals(city, homepage.getCustomerCityText(), "Customer city is not equals!");
        Assert.assertEquals(address, homepage.getCustomerAddressText(), "Customer address is not equals!");
        Assert.assertEquals(postal_code, homepage.getCustomerPostalCodeText(), "Customer postal codex is not equals!");
    }


    @When("user clicks CONTINUE button")
    public void userClicksCONTINUEButton() throws InterruptedException {
        homepage.clickContinueButton();
        Assert.assertTrue(homepage.isPaymentOptionPresent(), "Payment option is not present!");
    }

    @And("user selects Credits or Debit Card payment method")
    public void userSelectsCreditsDebitCardPaymentMethod() throws InterruptedException {
        homepage.clickCreditDebitCardOption();
        Assert.assertTrue(homepage.isCreditDebitCardPagePresent(), "Credit/Debit page is not present!");
    }

    @And("user inputs card number {string}, {string}, and {string}")
    public void userInputsCardNumberAnd(String card, String expiry, String cvv) {
        homepage.enterCardNumber(card);
        homepage.enterExpiryDate(expiry);
        homepage.enterCVVNumber(cvv);
    }

    @Then("user validates total amount and {string} selected is matching")
    public void userValidatesTotalAmountAndSelectedIsMatching(String promo) throws InterruptedException {
        homepage.clickDiscount10Persen();
        int price = Integer.parseInt(homepage.getAmountOrderSummary());
        if (promo.equalsIgnoreCase("Promo 10 Rupiah")) {
            homepage.clickPromo10Rupiah();
            Assert.assertEquals(homepage.promo10Rupiah(price), homepage.getAmountOrderSummary(), "Total amount is not equals!");
        } else if (promo.equalsIgnoreCase("Potongan 10% - Demo Promo Engine")) {
            homepage.clickDiscount10Persen();
            Assert.assertEquals(homepage.promoDiscount10Persen(price), homepage.getAmountOrderSummary(), "Total amount is not equals!");
        } else {
            homepage.clickDiscountMasterCard();
            Assert.assertEquals(homepage.promoDiscountMasterCard(price), homepage.getAmountOrderSummary(), "Total amount is not equals!");
        }

        Assert.assertEquals(homepage.getEmailText(), email, "Confirmation email user is not equals!");
        Assert.assertEquals(homepage.getPhoneText(), phone2, "Confirmation phone user is not equals!");

        String totalPrice = homepage.getAmountOrderSummary();

        homepage.clickContinueButton();
        homepage.switchToIframe(0);
        Assert.assertEquals(homepage.getTotalAmountFinal(), totalPrice, "Total amount is not equals!");
    }

    @And("user validates amount and inputs {string}")
    public void userValidatesAmountAndInputs(String password) throws InterruptedException {
        homepage.inputPassword(password);
    }

    @When("user clicks OK button")
    public void userClicksOKButton() throws InterruptedException {
        homepage.clickSubmitButton();
    }

    @Then("user sees total amount with {string} message")
    public void userSeesTotalAmountWithStatusMessage(String status) {
        homepage.switchToIframe(0);
        Assert.assertTrue(homepage.getStatusTransaction(status), "Something was wrong with the transaction!");
    }
}
