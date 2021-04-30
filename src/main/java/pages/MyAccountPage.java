package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	@FindBy(linkText="Change password")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement OldPasswordtxt;

	@FindBy(id = "NewPassword")
	WebElement NewPasswordtxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordtxt;

	@FindBy(css = "input.button-1.change-password-button")
	WebElement ChangePasswordBtn;

	@FindBy(css = "div.result")
	public WebElement Result;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public void OpenChangePasswordPage() {
		clickButton(changePasswordLink);
	}

	public void ChangePassword(String oldPassword, String newPassword) {
		setText(OldPasswordtxt, oldPassword, false);
		setText(NewPasswordtxt, newPassword, false);
		setText(ConfirmNewPasswordtxt, newPassword, false);
		clickButton(ChangePasswordBtn);
	}

}
