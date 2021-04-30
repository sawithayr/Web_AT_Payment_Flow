package steps;

import io.cucumber.java.en.Given;
import tests.TestBase;
import utilities.SeleniumHelpers;

public class CommonSteps extends TestBase {

    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user navigates to mamikos homepage {string}")
    public void userNavigatesToMamikosHomepage(String url) {
        selenium = new SeleniumHelpers(driver);
        selenium.navigateToPage(url);
    }
}
