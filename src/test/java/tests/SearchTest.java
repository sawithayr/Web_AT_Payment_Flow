package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchTest extends TestBase {

	SearchPage SearchObject;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test
	public void UserCanSearchProduct() {
		SearchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		SearchObject.UserSearchProduct(productName);
		SearchObject.ProductDetailsPage();
		Assert.assertTrue(productDetailsObject.productNameDetails.getText().equalsIgnoreCase(productName));
	//	Assert.assertEquals(productDetailsObject.productNameDetails.getText(), productName);
		

	}

}
