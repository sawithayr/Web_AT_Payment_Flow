package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagePO extends PageBase {

	public LoginPagePO(WebDriver driver) {
		super(driver);
	}

    //------------- ELEMENTS DECLARATION -------------

    //-------------- First Login Page --------------
    @FindBy(className = "login-user-home")
    private WebElement tenantButton;

    //-------------- Tenant Login Page -------------
    @FindBy(xpath = "//*[@name='Nomor Handphone']")
    private WebElement phoneTextbox;

    @FindBy(xpath = "//*[@name='Password']")
    private WebElement passwordTextbox;

    @FindBy(css = "button .track-login-tenant")
    private WebElement enterTenantButton;

	@FindBy(id="Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtbox;

	@FindBy(css="input.button-1.login-button")
	WebElement loginButton;

	public void UserLogin(String email, String password)

	{
		setText(emailTxtBox, email, false);
		setText(passwordTxtbox, password, false);
		clickButton(loginButton);
	}

    /**
     * Login as Tenant user to application
     * @param number    phone
     * @param password password
     * @throws InterruptedException
     */
    public void loginAsTenantToApplication(String number, String password) throws InterruptedException {
        clickButton(tenantButton);
        setText(phoneTextbox, number, false);
        setText(passwordTextbox, password, false);
        hardWait(2);
//        scrollToBottom();
        pageScrollInView(enterTenantButton);
        clickButton(enterTenantButton);
        hardWait(5);
    }
}
