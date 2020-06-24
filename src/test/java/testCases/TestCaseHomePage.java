package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductCategory;
import pageObjects.Util;
import base.Base;

public class TestCaseHomePage extends Base {

	public WebDriver driver;
	@BeforeTest
 	public void initBrowser() throws IOException{
	driver = initializeDriver();
    }
	@Test
	public void getDetails() throws IOException{
		HomePage hp = new HomePage(driver);
		hp.clickLoginBtn().click();
		hp.emailId().sendKeys("jetblue@grr.la");
		hp.password().sendKeys("jetblue");
		hp.btnLogin().click();
		hp.btnTShirt().click();
		
		WebDriverWait wait = new WebDriverWait(driver, 7);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,720)");
	
		Actions action = new Actions(driver);
		ProductCategory pc = new ProductCategory(driver);
		action.moveToElement(pc.getProductContainer()).moveToElement(pc.clickAddToCartButton()).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".layer_cart_product > h2:nth-child(2)"))));
		String expectedProdDetails = driver.findElement(By.cssSelector(".layer_cart_product > h2:nth-child(2)")).getText();
		String str = expectedProdDetails.trim();
		String actualProdDetails = "Product successfully added to your shopping cart";
		Assert.assertEquals(str, actualProdDetails);
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
