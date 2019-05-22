package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class SearchPageLocators {

	public static By FIRST_PRODUCT = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tees & Sweatshirts'])[1]/following::img[1]");
	public	static By SIZE_SELECTION = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('What', \"'\", 's my size?')])[1]/following::label[2]");
	public static By QUANTITY = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add to Cart'])[3]/following::button[1]");
	public static By ATC_BUTTON = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='+'])[25]/following::button[1]");
}
