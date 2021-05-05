package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginPagePO extends SeleniumHelpers {

	public LoginPagePO(WebDriver driver) {
		super(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

    //============================== ELEMENTS DECLARATION ===============================

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

    //-------------- Owner Login Page --------------
    @FindBy(className = "login-owner-home")
    private WebElement kosOwnerButton;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-mamigreen login-button track-login-owner']")
    private WebElement enterButton;

    //================================= ACTION METHOD ===================================

    /**
     * Login as Tenant user to application
     * @param number    phone
     * @param password password
     * @throws InterruptedException
     */
    public void loginAsTenantToApplication(String number, String password) throws InterruptedException {
        clickOn(tenantButton);
        enterText(phoneTextbox, number, false);
        enterText(passwordTextbox, password, false);
        hardWait(2);
        pageScrollInView(enterTenantButton);
        clickOn(enterTenantButton);
        hardWait(5);
    }

    /**
     * Login as Owner to application
     * @param phone    phone
     * @param password password
     * @throws InterruptedException
     */
    public void loginAsOwnerToApplication(String phone, String password) throws InterruptedException {
        clickOn(kosOwnerButton);
        enterText(phoneTextbox, phone, false);
        enterText(passwordTextbox, password, false);
        pageScrollInView(enterButton);
        clickOn(enterButton);
        hardWait(5);
    }
}
