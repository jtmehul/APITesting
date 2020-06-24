package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	public WebDriver driver;
	
	public Util(WebDriver driver){
		this.driver = driver;
	}
	public void getUtil(){
		
		WebDriverWait wait = new WebDriverWait(driver, 7);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,720)");
	}
}
