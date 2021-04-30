package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePagePO;
import pages.LoginPagePO;
import pages.userRegistrationPage;

public class UserRegistrationTest extends TestBase {

	HomePagePO homeObject;
	userRegistrationPage userRegisterObject;
	LoginPagePO loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void userRegisterSuccessfully() {
		homeObject = new HomePagePO(driver);
		homeObject.OpenRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration("Mohamed", "Khalil", "am5347@gmail.com", "12345678");
		
		Assert.assertTrue(userRegisterObject.successMessage.getText().contains("Your registration completed"));

	}

	@Test(dependsOnMethods = { "RegisteredUserCanLogOut" })
	public void RegisteredUserCanLogin() {

		homeObject.OpenLoginPage();
		loginObject = new LoginPagePO(driver);
		loginObject.UserLogin("am5347@gmail.com", "12345678");
		Assert.assertTrue(userRegisterObject.LogoutLink.getText().contains("Log out"));
	}

	@Test(dependsOnMethods = { "userRegisterSuccessfully" })
	public void RegisteredUserCanLogOut() {
		userRegisterObject.userLogOut();

	}

}
