package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategory {

	public WebDriver driver;
	
	public ProductCategory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css="div[class='product-image-container']")
	WebElement productContainer;
	
	@FindBy(css=".ajax_add_to_cart_button span")
	WebElement addToCart;
	
	@FindBy(css=".layer_cart_product > h2:nth-child(2)")
	WebElement successMessage;
	
	public WebElement getProductContainer(){
		return productContainer;
	}
	
	public WebElement clickAddToCartButton(){
		return addToCart;
	}
	public WebElement messageSuccess(){
		return successMessage;
	}
	
}
