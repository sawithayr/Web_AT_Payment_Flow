package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class HomePagePO extends SeleniumHelpers {

	public HomePagePO(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

    //============================== ELEMENTS DECLARATION ===============================

    //-------------- Navbar -------------
    @FindBy(className = "nav-login-button")
    private WebElement enterButton;

    @FindBy(xpath = "//a[.='Masuk']")
    private WebElement theEnterButton;

    //-------- Homepage Upper Section --------
    @FindBy(css = ".product-btn-container .btn-cta-search .btn-cta-label")
    private WebElement searchBar;


    //================================= ACTION METHOD ===================================

    /**
     * Click on Login button
     *
     * @throws InterruptedException
     */
    public void clickLoginButtonNavbar() throws InterruptedException {
        if (waitTillElementIsVisible(enterButton,3) != null) {
            clickOn(enterButton);
            hardWait(2);
        } else {
            clickOn(theEnterButton);
        }
    }

    /**
     * Click on 'Search' bar
     *
     * @throws InterruptedException
     */
    public void clickSearchBar() throws InterruptedException {
        waitTillElementIsVisible(searchBar);
        clickOn(searchBar);
    }
}
