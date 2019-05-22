package com.tommyjohn.automation.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;




public class AddToCartPage {
	
	private WebDriver driver;

	private static final Logger logger = LogManager.getLogger(AddToCartPage.class);
	private String baseUrl = "https://tommyjohn.com";
	private WebElement element =null;
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void ATC()
	{
		/*
		 * driver.findElement(HomePageLocators.WOMEN_CATEGORY).click();
		 * driver.findElement(HomePageLocators.WOMEN_ALLCLOTHING_COLLECTION).click();
		 * driver.findElement(SearchPageLocators.FIRST_PRODUCT).click();
		 * driver.findElement(SearchPageLocators.SIZE_SELECTION).click();
		 * driver.findElement(SearchPageLocators.QUANTITY).click();
		 * driver.findElement(SearchPageLocators.ATC_BUTTON).click();
		 */
		
		
		Actions action =new Actions(driver);
		try {
			
			logger.info("In AddToCartScript.run()");
			driver.get(baseUrl);
			driver.get(baseUrl); // Hack to disregard the pop-up which appears when site loads
			logger.info("AddToCart: Base URL loaded...");
			
			element = driver.findElement(By.xpath("//*[@id=\"tommy-john-no-adjustment-needed\"]/header/div[2]/div[2]/ul/li[2]/a"));
			action.moveToElement(element).perform();
			logger.info("AddToCart : Mouse Hover...");

			
			driver.findElement(By.xpath("//*[@id=\"tommy-john-no-adjustment-needed\"]/header/div[2]/div[2]/ul/li[2]/div/ul/li[2]/ul/li[1]/a")).click();
			logger.info("AddToCart: AllUnderwear category clicked...");
			
			// scroll the window to find the elements
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,800)", "");
			
			// wait for complete scroll the page
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"shopify-section-mega-collection-sections\"]/section/div/div[5]/div[2]/div[1]/a/h2")).click();
		//	driver.findElement(By.xpath("//*[@id=\"shopify-section-mega-collection-sections\"]/section/div/div[5]/div[2]/div[1]/div[1]/a")).click();			
			logger.info("AddToCart: First item clicked...");
			
			driver.findElement(
					By.xpath("//*[@id=\"second-skin-dress-blues-titanium-flamingo-print-boxer-brief\"]/main/section[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/ul/li[1]/label"))
					.click();
			logger.info("AddToCart: Selected size...");
			
			driver.findElement(By.xpath("//*[@id=\"second-skin-dress-blues-titanium-flamingo-print-boxer-brief\"]/main/section[2]/div[2]/div[1]/div[1]/button")).click();
			logger.info("AddToCart: Add to Cart button clicked...");
			
			driver.findElement(By.xpath("//*[@id=\"second-skin-dress-blues-titanium-flamingo-print-boxer-brief\"]/section[1]/div[6]/div[3]/a[3]")).click();
			logger.info("AddToCart: Checkout button clicked... final step...");
		} catch (Exception e) {
			logger.error("AddToCart: In Catch Block : ", e);
			// Capture the screenshot and send email.
			// Use either AShot or TakeScreenshot
			
			}
		}
	}
	


