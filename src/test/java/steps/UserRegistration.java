package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import pages.HomePagePO;
import pages.userRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

	HomePagePO homeObject;
	userRegistrationPage registerObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePagePO(driver);
		homeObject.OpenRegistrationPage();

	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("I entered the user data")
	public void i_entered_the_user_data() {
		registerObject = new userRegistrationPage(driver);
		registerObject.userRegistration("lilo", "filo", "ase@gaa.ae", "1234567");
	}

	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registerObject.userLogOut();
	}

}
