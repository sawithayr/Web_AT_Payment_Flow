package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.KostDetailsPO;
import pages.KostListingPO;
import tests.TestBase;
import utilities.SeleniumHelpers;

public class KostListingSteps extends TestBase {

    private KostListingPO kostListing = new KostListingPO(driver);
    private KostDetailsPO kostDetail = new KostDetailsPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user selects kost rule {string}")
    public void userSelectsKostRule(String kosRule) throws InterruptedException {
        kostListing.selectKosRule(kosRule);
    }

    @And("user selects instant filter {string}")
    public void userSelectsInstantFilter(String instantFilter) throws InterruptedException {
        kostListing.selectInstantFilter(instantFilter);
        kostListing.clickInstantBooking();
        kostListing.selectInstantFilter(instantFilter);
    }

    @Then("user selects for kost with name {string}")
    public void userSelectsForKostWithName(String kosName) throws InterruptedException {
        kostListing.clickSelectedKost(kosName);
        selenium.switchToWindow(2);
        kostDetail.dismissFTUEScreen2();
    }

}
