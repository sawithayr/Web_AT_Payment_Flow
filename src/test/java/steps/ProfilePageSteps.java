package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProfilePagePO;
import tests.TestBase;

public class ProfilePageSteps extends TestBase {

    private ProfilePagePO profile = new ProfilePagePO(driver);


    @When("user sees booked kost with status waiting in history booking")
    public void userSeesBookedKostWithStatusWaitingInHistoryBooking() throws InterruptedException {
        profile.closeChatMenu();
        Assert.assertTrue(profile.isBookedKostPresent(), "Booked kost not present!");
    }

    @And("user clicks see more button")
    public void userClicksSeeMoreButton() throws InterruptedException {
        profile.clickSeeMoreButtonBookedKost();
    }

    @And("user cancel the booking")
    public void userCancelTheBooking() throws InterruptedException {
        profile.clickCancelBookingButton();
    }

    @And("user sees the status chat is {string}")
    public void userSeesTheStatusChatIs(String status) {
        Assert.assertEquals(profile.getStatusChat(), status, "Status message is not delived!");
    }

    @Then("user sees the status turns to {string}")
    public void userSeesTheStatusTurnsTo(String status) {
        Assert.assertEquals(profile.getStatusBooking(), status, "Status booking still waiting for confirmations!");
    }
}
