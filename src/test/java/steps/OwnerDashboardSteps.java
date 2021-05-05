package steps;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.OwnerAddContractPO;
import pages.OwnerDashboardPO;
import tests.TestBase;

public class OwnerDashboardSteps extends TestBase {

    private OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(driver);
    private OwnerAddContractPO addContract = new OwnerAddContractPO(driver);

    @And("user sees owner dashboard page")
    public void userSeesOwnerDashboardPage() {
        Assert.assertTrue(ownerDashboard.isGreetingSectionNamePresent(), "Owner Greetings is not appears! Make sure your are in Owner Dashboard!");
    }

    @And("user sees and clicks Add Tenant Menu")
    public void userSeesAndClicksAddTenantMenu() throws InterruptedException {
        ownerDashboard.clickAddTenantMenu();
    }

}
