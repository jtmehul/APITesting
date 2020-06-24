package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[class='login']")
	WebElement login;
	
	@FindBy(css="#email")
	WebElement email;
	
	@FindBy(css="#passwd")
	WebElement password;
	
	@FindBy(css="#SubmitLogin span")
	WebElement loginBtn;
	
	@FindBy(css=".sf-menu > li:nth-child(3) > a")
	WebElement tShirt;
	
	
	public WebElement clickLoginBtn(){
		return login;
	}
	public WebElement emailId(){
		return email;
	}
	public WebElement password(){
		return password;
	}
	public WebElement btnLogin(){
		return loginBtn;
	}
	public WebElement btnTShirt(){
		return tShirt;
	}
}
