package com.tommyjohn.automation.Components;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.PageLocators.CollectionPageLocator;
import com.tommyjohn.automation.utils.CustomUtilities;

public class CollectionPageComponent extends CollectionPageLocator {
	public static WebDriver driver = CustomUtilities.driver;

	public static String navigateToProductDetailsPage() throws Exception {
		String text = null;
		
		// get text and click on the first product
		if(!driver.findElement(FIRST_PRODUCT_HEAD_LINE_TEXT_LINK).isEnabled())
			throw new Exception("Product head line text is not displayed");
		text = driver.findElement(FIRST_PRODUCT_HEAD_LINE_TEXT_LINK).getText();
		driver.findElement(FIRST_PRODUCT_HEAD_LINE_TEXT_LINK).click();
		Thread.sleep(3000);
		return text;
	}
}
