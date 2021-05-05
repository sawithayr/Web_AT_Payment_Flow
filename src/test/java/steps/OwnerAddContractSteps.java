package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.OwnerAddContractPO;
import tests.TestBase;

import java.text.ParseException;

public class OwnerAddContractSteps extends TestBase {

    private OwnerAddContractPO addContract = new OwnerAddContractPO(driver);

    @And("user selects option Add Tenant Contract by owner")
    public void userSelectsOptionAddTenantContractByOwner() throws InterruptedException {
        addContract.clickAddContractByOwner();
        Assert.assertTrue(addContract.isSelectsPropertyPresent(), "Kost option is not present! Make sure you are in kost option page!");
    }

    @And("user selects kost and inputs the tenant info with phone number {string}, room number {string} and name {string}")
    public void userSelectsKostAndInputsTheTenantInfoWithPhoneNumberRoomNumberAndName(String number, String room, String name) throws InterruptedException {
        addContract.selectFirstProperty();
        addContract.inputTenantInfo(number, room);
        Assert.assertTrue(addContract.isFormInputTenantNamePresent(), "Form input tenant name is not present! Make sure you are in Input Tenant Info page!");
        addContract.inputTenantName(name);
    }

    @And("user inputs the payment info with price and {string} month")
    public void userInputsThePaymentInfoWithPriceAndMonth(String month) throws InterruptedException, ParseException {
        addContract.selectRentCount();
        addContract.selectDurationrent(month);
        addContract.selectDateForStartBoarding();
    }

    @And("user inputs the late charge {string} {string}, and additonal charge {string} {string} and {string} {string}")
    public void userInputsTheLateChargeAndAdditonalChargeAnd(String penalty, String deadline, String type1, String amount1, String type2, String amount2) throws InterruptedException {
        addContract.inputLateChargeCost(penalty, deadline);
        addContract.inputAdditionalCost(type1, amount1, type2, amount2);
    }

    @Then("verify all data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void verifyAllData(String phone, String room, String name, String price, String type, String amount, String type2, String amount2) {
        Assert.assertEquals(addContract.getTenantName(), name, "Tenant Name is NOT equals!");
        Assert.assertEquals(addContract.getTenantRoom(), room, "Tenant Room is NOT equals!");
        Assert.assertEquals(addContract.getTenantNumber(), phone, "Tenant Phone Number is NOT equals!");
        Assert.assertEquals(addContract.getMainPrice(), price, "Main Price is NOT equals!");
        Assert.assertEquals(addContract.getAdditionalItem1(), type, "Additional Type1 is NOT equals!");
        Assert.assertEquals(addContract.getAdditionalItem2(), type2, "Additional Type2 is NOT equals!");
        Assert.assertEquals(addContract.getAdditionalPrice1(), amount, "Additional price1  is NOT equals!");
        Assert.assertEquals(addContract.getAdditionalPrice2(), amount2, "Additional price2  is NOT equals!");
    }

    @When("user sees success save data")
    public void userSeesSuccessSaveData() throws InterruptedException {
        addContract.clickSaveTenantContract();
        Assert.assertTrue(addContract.isSuccessPopUpPresent(), "Success Pop Up Not Appears!");
    }

    @And("user clicks link to navigate to Detail Tenant page")
    public void userClicksLinkToNavigateToDetailTenantPage() throws InterruptedException {
        addContract.clickSeeDetailsContract();
    }

    @And("user sees the total amount payment")
    public void userSeesTheTotalAmountPayment() {
        Assert.assertTrue(addContract.isTotalPricePresent(), "Total Price is not appears!");
    }

    @And("user terminates the tenant contract")
    public void userTerminatesTheTenantContract() throws InterruptedException {
        addContract.clickTerminateContractButton();
        addContract.selectReasonTerminate();
    }

    @Then("user sees description of stop tenant contract {string}")
    public void userSeesDescriptionOfStopTenantContract(String desc) {
        Assert.assertEquals(addContract.getStopContractDesc(), desc, "Description not equals!!");
    }
}