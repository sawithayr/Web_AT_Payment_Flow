package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRegistrationPage extends PageBase {

	public userRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="gender-male")
	WebElement genderRdoBtn ;
	
	@FindBy(id="FirstName")
	WebElement firstNametxt;

	@FindBy(id="LastName")
	WebElement lastNametxt;

	@FindBy(id="Email")
	WebElement emailtxt;

	@FindBy(id="Password")
	WebElement passwordtxt;

	@FindBy(id="ConfirmPassword")
	WebElement confrimPassword;

	@FindBy(id="register-button")
	WebElement RegisterButton;

	@FindBy(css="div.result")
	public WebElement successMessage;

	@FindBy(linkText="Log out")
	public WebElement LogoutLink;

	@FindBy(linkText="My account")
	public WebElement MyAccountLink;

	public void userRegistration(String firstName, String lastName, String email, String password) {

		clickButton(genderRdoBtn);
		setText(firstNametxt, firstName, false);
		setText(lastNametxt, lastName, false);
		setText(emailtxt, email, false);
		setText(passwordtxt, password, false);
		setText(confrimPassword, password, false);
		clickButton(RegisterButton);

	}

	public void userLogOut() {

		clickButton(LogoutLink);
	}

	public void OpenMyAccount() {

		clickButton(MyAccountLink);
	}

}
