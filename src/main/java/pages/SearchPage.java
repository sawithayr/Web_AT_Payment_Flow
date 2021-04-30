package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "small-searchterms")
	WebElement SearchBox;

	@FindBy(css = "input.button-1.search-box-button")
	WebElement SearchBtn;

	@FindBy(id = "ui-id-1")
	List<WebElement> AutoList;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement ProductTitle;

	public void UserSearchProduct(String productTxt) {
		setText(SearchBox, productTxt, false);
		clickButton(SearchBtn);

	}

	public void ProductDetailsPage() {

		clickButton(ProductTitle);
	}

	public void ProductSearchUsingAutoSuggest(String searchTxt) {
		setText(SearchBox, searchTxt, false);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		AutoList.get(0).click();
	}

}
