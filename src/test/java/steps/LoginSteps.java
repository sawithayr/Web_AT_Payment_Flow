package steps;

import io.cucumber.java.en.And;
import pages.LoginPagePO;
import tests.TestBase;

public class LoginSteps extends TestBase {

    private LoginPagePO login = new LoginPagePO(driver);

    //Tenant Phone Number
    private String tenantPhoneNumber = "083843666866";
    private String tenantPhonePassword = "qamamikos";

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
}
