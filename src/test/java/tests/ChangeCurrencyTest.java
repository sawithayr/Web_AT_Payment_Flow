package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePagePO;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePagePO homeObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;

	@Test(priority = 1)
	public void UserCanChangeCurrency() {
		homeObject = new HomePagePO(driver);
		homeObject.ChangeCurrency();	}

	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNameDetails.getText(), productName);
			//Assert.assertTrue(detailsObject.productPricelbl.getText().contains("€"));
			System.out.println(detailsObject.productPricelbl.getText());
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

}
