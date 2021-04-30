package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePagePO;

public class ProductHoverMenuTest extends TestBase
{
	HomePagePO homeObject ;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() 
	{
		homeObject = new HomePagePO(driver);
		homeObject.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
