package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LoginPagePO;
import pages.OwnerDashboardPO;
import tests.TestBase;

public class LoginSteps extends TestBase {

    private LoginPagePO login = new LoginPagePO(driver);
    private OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(driver);

    //Tenant Phone Number
    private String tenantPhoneNumber = "0898765432111";
    private String tenantPhonePassword = "hahaha123";

    //Owner Phone Number
    private String ownerPhoneNumberStaging = "087133998156";
    private String ownerPhonePasswordStaging = "fathul123";

    private String ownerPhoneNumber1 = "089673406382";
    private String ownerPhonePassword1 = "qwerty123";

    private String ownerPhoneNumber = "083843666891";
    private String ownerPhonePassword = "qamamikos";

    @And("user logs in as Tenant via phone number as {string}")
    public void userLogsInAsTenantViaPhoneNumberAs(String type) throws InterruptedException {
        String number = "";
        String password = "";

        if (type.equalsIgnoreCase("DC Automation")) {
            number = tenantPhoneNumber;
            password = tenantPhonePassword;
        }
        login.loginAsTenantToApplication(number, password);
    }

    @When("user logs in as Owner via phone number as {string}")
    public void userLogsInAsOwnerViaPhoneNumberAs(String type) throws InterruptedException {
        String number = "";
        String password = "";

        if (type.equalsIgnoreCase("Owner Automation")) {
            number = ownerPhoneNumber;
            password = ownerPhonePassword;
        }
        login.loginAsOwnerToApplication(number, password);
        ownerDashboard.clickOnIUnderstandOnSetAdditionalCostsPopUp();
//        ownerDashboard.clickOnUpdateAllKosButton();
    }
}
