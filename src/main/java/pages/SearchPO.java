package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.ArrayList;
import java.util.List;

public class SearchPO extends SeleniumHelpers {

    public SearchPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement searchTextBar;

    @FindBy(xpath = "//*[@id='suggestionsBox']/div/div[2]/a[1]/div[2]/label[1]")
    private WebElement firstResult;

    //================================= ACTION METHOD ===================================

    /**
     * Enter Text in search bar
     *
     * @param word is text we want to search
     */
    public void inputKeyword(String word) {
        enterText(searchTextBar, word, false);
    }

    /**
     * List all listing result
     *
     * @return list of result (String)
     */
    public List<String> listResultKeyword() {
        String cssLocator = ".results-list label:nth-child(1)";
        List<WebElement> elements = waitTillAllElementsAreLocated(By.cssSelector(cssLocator));
        List<String> addressList = new ArrayList<>();
        for (WebElement a : elements) {
            addressList.add((getText(a)));
        }
        return addressList;
    }

    /**
     * Click the first result are
     *
     * @throws InterruptedException
     */
    public void clickTheFirstResultArea() throws InterruptedException {
        clickOn(firstResult);
    }
}