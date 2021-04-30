package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePagePO;
import pages.LoginPagePO;
import pages.MyAccountPage;
import pages.userRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePagePO homeObject;
	userRegistrationPage userRegisterObject;
	MyAccountPage MyAccountObject;
	LoginPagePO loginObject;
	String OldPassword = "123456789";
	String NewPassword = "1357911";
	String fName = "Mohamed";
	String lName = "Khalil";
	String email = "at4@gmail.com";
	String userName = "luulo8899";

	@Test(priority = 1)
	public void userRegisterSuccessfully() {
		homeObject = new HomePagePO(driver);
		homeObject.OpenRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, lName, email, OldPassword);
		Assert.assertTrue(userRegisterObject.successMessage.getText().contains("Your registration completed"));

	}

	@Test(priority = 2)
	public void userCanChangePassword() {

		MyAccountObject = new MyAccountPage(driver);
		userRegisterObject.OpenMyAccount();
		MyAccountObject.OpenChangePasswordPage();
		MyAccountObject.ChangePassword(OldPassword, NewPassword);
		Assert.assertTrue(MyAccountObject.Result.getText().contains("Password was changed"));

	}

	@Test(priority = 3)
	public void RegisteredUserCanLogOut() {
		userRegisterObject.userLogOut();

	}

	@Test(priority = 4)
	public void RegisteredUserCanLogin() {

		homeObject.OpenLoginPage();
		loginObject = new LoginPagePO(driver);
		loginObject.UserLogin(email, NewPassword);
		Assert.assertTrue(userRegisterObject.LogoutLink.getText().contains("Log out"));
	}

	@Test(priority = 5)
	public void UserLogout() {
		userRegisterObject.userLogOut();
	}

}
