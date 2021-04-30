package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNameDetails;

	@FindBy(css = "input.button-2.email-a-friend-button")
	public WebElement sendEmailBtn;

	@FindBy(css = "span.price-value-4")
	public WebElement productPricelbl;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn ; 

	@FindBy(linkText="Add your review")
	WebElement addReviewLink; 

	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn ; 
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn ; 


	public void openSendEmail() {
		clickButton(sendEmailBtn);
	}

	public void openAddReviewPage() 
	{
		clickButton(addReviewLink);
	}

	public void AddProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}

	public void AddProductToCompare() 
	{
		clickButton(addToCompareBtn);
	}

	public void AddToCart() 
	{
		clickButton(addToCartBtn);
	}

}
