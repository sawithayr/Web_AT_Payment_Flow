package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePagePO;
import pages.LoginPagePO;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.userRegistrationPage;

public class AddProductReviewTest extends TestBase {

	/*
	 * 1- User registration 2- Search for product 3- Add reivew 4- Logout
	 */

	HomePagePO homeObject;
	userRegistrationPage registerObject;
	LoginPagePO loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	// 1- User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		homeObject = new HomePagePO(driver);
		homeObject.OpenRegistrationPage();
		registerObject = new userRegistrationPage(driver);
		registerObject.userRegistration("Moataz", "Nabil", "test0987@gmail.com", "12345678");
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

	// 3- Add review
	@Test(priority = 3)
	public void RegisteredUserCanReviewProduct() {
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("new reivew", "the product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added."));
	}

	// 4- User Logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.userLogOut();
	}

}
