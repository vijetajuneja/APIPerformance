package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class CollectionPageLocator {
	
	public static By STYLE_COROSALS = By.cssSelector("div.hero-interactive__slider.slick-initialized");
	public static By TOTAL_NO_OF_COROSALS = By.cssSelector(".hero-interactive-slide.slick-slide");
//	public static By MENS_ALL_UNDERWEAR_FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image-container > a");
//	public static By THIRD_PRODUCT_IMAGE = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > div:nth-child(1) > a > img");
//	public static By THIRD_PRODUCT_HEAD_LINE_TEXT = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > a > h2");
//	public static By THIRD_PRODUCT_REVIEW_STARS = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > a > div");
//	public static By FIRST_PRODUCT_IMAGE = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(1) > div > a > img");
//	public static By FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image");
	public static By FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image-container");
	public static By FIRST_PRODUCT_HEAD_LINE_TEXT_LINK = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(1) > a > h2");
	public static By FIRST_PRODUCT_REVIEW_STARS = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(1) > a > div");
	
	public static By THIRD_PRODUCT_IMAGE = By.cssSelector(".product-image");
	public static By THIRD_PRODUCT_HEAD_LINE_TEXT = By.cssSelector(".product-meta__title");
	public static By THIRD_PRODUCT_REVIEW_STARS = By.cssSelector(".yotpo");
	
	public static By MAIN_HEADING_OF_SELECTED_CATEGORY = By.cssSelector("div.collection-title-bar__content > h1");
	public static By ALL_FILTERS = By.cssSelector("div.mega-collection-filters > div > a");
	public static By DISPLAYED_ALL_SELECTED_OPTIONS = By.cssSelector("div.js-mega-collection-desktop-filter-tags > button");
	public static By CLEAR_FILTER_BUTTON = By.cssSelector("div.mega-collection-filters--controls > a");
	public static By FIRST_ITEM_IN_DISPLAYED_LIST = By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child(1)");
	public static By TOTAL_COUNTS_OF_ITEMS = By.cssSelector("div.mega-collection-filters--controls__count > span");
	public static By LAST_FILTER = By.cssSelector(".mega-collection-filters > select");
	public static By SORTBYPRICE_HIGH_TO_LOW_FILTER_OPTION = By.cssSelector(".js-mega-collection-filters-sort > option:nth-child(2)");
	
	//Quick shop
		public static By QUICK_SHOP_ATC = By.cssSelector(".product-grid-controls.has-quickshop>button");
		public static By QUICK_SHOP_SIZE_OVERLAY = By.cssSelector(".inline-quick-shop");
		public static By QUICK_SHOP_SIZE_OVERLAY_CLOSE = By.cssSelector(".inline-quick-shop>.inline-quick-shop__close");
		public static By QUICK_SHOP_SIZE_OVERLAY_HEADING = By.cssSelector(".inline-quick-shop>.inline-quick-shop__option-heading");
		public static By QUICK_SHOP_SIZE_LIST = By.cssSelector(".quickshop-open>.inline-quick-shop>ul>li>label");
		public static By QUICK_SHOP_SIZE_OVERLAY_ATC = By.cssSelector(".inline-quick-shop>.inline-quick-shop__button");
		public static By PRODUCT_TITLE_ON_COLLECTION = By.cssSelector(".product-meta__title");
		public static By PRODUCT_ITEM_SWATCH_CIRCLE = By.cssSelector(".product-item__swatch-wrapper>div");
		public static By PRODUCT_AMOUNT_ON_Collection = By.cssSelector(".product-meta__price");
		public static By PRODUCT_TITLE_ON_FLYCART = By.cssSelector("div.inline-cart__col1 > div:nth-child(6) > .line-item >.line-item__summary>a");
	    public static By PRODUCT_LINE_ITEM_OPTION = By.cssSelector(" div.line-item__summary > div.line-item__option");
	    public static By PRODUCT_AMOUNT_ON_FLYCART = By.cssSelector(".line-item__price>span");
}
