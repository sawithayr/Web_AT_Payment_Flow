package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement fName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Enquiry")
	WebElement Enquiry;

	@FindBy(name = "send-email")
	private WebElement submitBtn;

	@FindBy(css = "div.result")
	public WebElement successMessage;

	public void UserContactUs(String name, String emaiL, String inquiry)

	{
		setText(fName, name, false);
		setText(email, emaiL, false);
		setText(Enquiry, inquiry, false);
		clickButton(submitBtn);
	}

}
