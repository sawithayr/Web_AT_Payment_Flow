package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BookingFormPO;
import tests.TestBase;

public class BookingFormSteps extends TestBase {

    private BookingFormPO booking = new BookingFormPO(driver);

    @And("user clicks Booking button on Booking form")
    public void userClicksBookingButtonOnBookingForm() throws InterruptedException {
        booking.clickAcceptTermAndCond();
    }

    @Then("user clicks chat owner kost after success booking kost")
    public void userClicksChatOwnerKostAfterSuccessBookingKost() throws InterruptedException {
        booking.clickChatOwnerButton();
    }
}
