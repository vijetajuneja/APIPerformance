package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class CollectionPageLocator {
//	public static By MENS_ALL_UNDERWEAR_FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image-container > a");
	public static By FIRST_PRODUCT_IMAGE = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > div:nth-child(1)");
	public static By FIRST_PRODUCT_HEAD_LINE_TEXT_LINK = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > a > h2");

}
