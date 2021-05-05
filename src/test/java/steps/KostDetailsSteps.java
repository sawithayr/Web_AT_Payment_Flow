package steps;

import io.cucumber.java.en.When;
import pages.KostDetailsPO;
import tests.TestBase;
import utilities.SeleniumHelpers;

import java.text.ParseException;

public class KostDetailsSteps extends TestBase {

    private KostDetailsPO kostDetail = new KostDetailsPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user clicks on Booking button on Kost details page")
    public void userClicksOnBookingButtonOnKostDetailsPage() throws ParseException, InterruptedException {
        String tomorrow = selenium.updateTime("yyyy MMM dd", selenium.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        kostDetail.scrollToKostName();
        kostDetail.selectDateForStartBoarding(tomorrow);
        kostDetail.selectRentType("Per bulan");
        kostDetail.clickOnBookingButton();
    }
}
