package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePagePO;

public class ContactUsTest extends TestBase {
	HomePagePO home;
	ContactUsPage contactPage;

	String email = "test@test.com";
	String fullName = "Test User";
	String enquiry = "Hello Admin , this is for test";

	@Test
	public void UserCanUseContactUs() {
		home = new HomePagePO(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.UserContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}

}
