package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailToFriendPage;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.userRegistrationPage;

public class EmailFriendTest extends TestBase {
	HomePagePO homeObject;
	userRegistrationPage registerObject;
	LoginPagePO loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailToFriendPage emailObject;

	// 1- User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		homeObject = new HomePagePO(driver);
		homeObject.OpenRegistrationPage();
		registerObject = new userRegistrationPage(driver);
		registerObject.userRegistration("Moataz", "Nabil", "testnn6@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	// 2- Search For Product
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNameDetails.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

	// 3- Email to Friend
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() {
		detailsObject.openSendEmail();
		emailObject = new EmailToFriendPage(driver);
		emailObject.SendEmailToFriend("aaa@tte.com", "Hello my friend , check this product");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}

	// 4- User Logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.userLogOut();
	}

}
