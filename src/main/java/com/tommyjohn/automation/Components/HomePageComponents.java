package com.tommyjohn.automation.Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class HomePageComponents extends HomePageLocators {
	
	public static WebDriver driver = CustomUtilities.driver;
	public static String baseUrl = CustomUtilities.baseUrl;
	public String currentUrl1;
	public String currentUrl2;
	boolean flag = false;
	public static WebElement element;
	public static Actions action = new Actions(driver);
	String text;
	
	//Verify logo and all category
	public void ValidateLogoAndCategoriesPresence() throws Exception
	{
		if(driver.findElement(HOMEPAGE_LOGO).isDisplayed())
		{
			currentUrl1 = driver.getCurrentUrl();
			driver.findElement(HOMEPAGE_LOGO).click();
			String currentUrl2 = driver.getCurrentUrl();
			if(!currentUrl1.equals(currentUrl2))
				throw new Exception("HomePage logo not working correctly");
			Reporter.log("TommyJohnLogo is displayed and clickable :: home page opens on clicking logo");
		}
		else
			throw new Exception("HomePage logo is not present");
		
		//Verify new arrivals
		if(driver.findElement(NEWARRIVALS_CATEGORY).isDisplayed()) {
			element = driver.findElement(NEWARRIVALS_CATEGORY);
			action.moveToElement(element).perform();
			if(!driver.findElement(MEN_IN_NEWARRIVALS_CATEGORY).isEnabled())
				throw new Exception("New Arrivals category not hoverable"); 
		}
		else
			throw new Exception("New Arrivals category is not present");
		Reporter.log("New Arrivals category is Displayed :: Hoverable");
		Thread.sleep(3000);
		
		// Verifiy Men category
		if(!driver.findElement(MEN_CATEGORY).isDisplayed())
			throw new Exception("Men category is not present");		
		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(WHATS_NEW_IN_MEN_CATEGORY).isEnabled())
			throw new Exception("Men Category is not hoverable");
		driver.findElement(MEN_CATEGORY).click();
		Thread.sleep(3000);
		currentUrl2 = driver.getCurrentUrl();
		if(!currentUrl2.equalsIgnoreCase("https://tommyjohn.com/collections/mens"))
			throw new Exception("Men category clicked but not opened correct page");
		Reporter.log("Men category is Displayed :: Hoverable :: Clickable");
		Thread.sleep(3000);
		// Verify Women category
		if(!driver.findElement(WOMEN_CATEGORY).isDisplayed())
			throw new Exception("Women category is not displayed");
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(WHATS_NEW_IN_WOMEN_CATEGORY).isDisplayed())
			throw new Exception("Men Category is not hoverable");
		driver.findElement(WOMEN_CATEGORY).click();
		Thread.sleep(3000);
		currentUrl2 = driver.getCurrentUrl();
		if(!currentUrl2.equalsIgnoreCase("https://tommyjohn.com/collections/womens"))
			throw new Exception("Women category is clicked but not opened correct page");
		Reporter.log("Women category is Displayed :: Hoverable :: Clickable");

		// Verify Underwear category
		if(!driver.findElement(UNDERWEAR_CATEGORY).isDisplayed())
			throw new Exception("Underwear category is not displayed");
		element = driver.findElement(UNDERWEAR_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(MEN_IN_UNDERWEAR_CATEGORY).isDisplayed())
			throw new Exception("Underwear Category is not hoverable");

		Reporter.log("Underwear category is Displayed :: Hoverable");

		Thread.sleep(3000);
		// Verify Shop by collection category
		if(!driver.findElement(SHOPBYCOLLECTION).isDisplayed())
			throw new Exception("Shop By Collection category is not displayed");
		element = driver.findElement(SHOPBYCOLLECTION);
		action.moveToElement(element).perform();
		if(!driver.findElement(MEN_IN_SHOPBYCOLLECTION).isDisplayed())
			throw new Exception("Shop By Collection category is not hoverable");

		Reporter.log("Shop By Collection category is Displayed :: Hoverable");

		Thread.sleep(3000);
		// Verify Packs category
		if(!driver.findElement(PACKS).isDisplayed())
			throw new Exception("Packs category is not displayed");
		element = driver.findElement(PACKS);
		action.moveToElement(element).perform();
		if(!driver.findElement(MEN_IN_PACKS).isDisplayed())
			throw new Exception("Packs category is not hoverable");
		Reporter.log("Packs category is Displayed :: Hoverable");
	}
	
	
	// validate search icon
	public void validateSearchIcon() throws Exception {
		String allClasses = null;
		
		if(!driver.findElement(SEARCH_ICON).isDisplayed())
			throw new Exception("Search icon is not present");
		driver.findElement(SEARCH_ICON).click();
		// check searchbox is opened or not using active class
		flag = false;
		element = driver.findElement(SEARCH_ICON_FORM_TAG);
		allClasses = element.getAttribute("class");
		for (String c : allClasses.split(" ")) {
			if (c.equals("active")) {
				flag = true;
			}
		}
		if(!flag)
			throw new Exception("Search input box is not opened");
		Reporter.log("Search Icon is Displayed :: Clickable :: Search textbox is Opened after click");
	}
	
	
	// check for Help icon
	public void validateHelpIcon() throws Exception {
		if(!driver.findElement(HELP_ICON).isDisplayed())
			throw new Exception("Help icon is not present");
		
		currentUrl1 = driver.getCurrentUrl();
		element = driver.findElement(HELP_ICON);
		action.moveToElement(element).perform();
		if(!driver.findElement(HELP_ICON_HELP_OPTION).isDisplayed())
			throw new Exception("In Help icon help option not displayed");
		Reporter.log("Help icon is Displayed :: Hoverable");
		driver.findElement(HELP_ICON_HELP_OPTION).click();
		Thread.sleep(3000);
		currentUrl2 = driver.getCurrentUrl();
		if(!currentUrl2.equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us"))
			throw new Exception("Wrong page opened after clicked on help option");
		Reporter.log("Help option is Displayed :: Clickable");
		
		// check chat with us option
		driver.get(baseUrl);
		element = driver.findElement(HELP_ICON);
		action.moveToElement(element).perform();
		if(!driver.findElement(CHAT_WITH_US).isDisplayed())
			throw new Exception("Chat With Us Option is not present");
		driver.findElement(CHAT_WITH_US).click();
		Thread.sleep(3000);
		// switch to another frame
		element = driver.findElement(CHAT_WITH_US_IFRAME);
		driver.switchTo().frame(element);
		element = driver.findElement(CHAT_WITH_US_POPUP);
		if(!element.isEnabled())
			throw new Exception("Chat With Us Popup is not opened");
		if(element.isEnabled()) {
			if(!driver.findElement(CHAT_WITH_US_POPUP_MINIMIZE).isDisplayed())
				throw new Exception("Chat With Us Popup Minimize button is not present");
			driver.findElement(CHAT_WITH_US_POPUP_MINIMIZE).click();
			driver.get(baseUrl);
		}
		else
			throw new Exception("Chat With Us Popup is not opened");
		Reporter.log("Chat With Us Popup is Displayed :: Minimize Button working");
		
		// Validating Call Us option
		element = driver.findElement(HELP_ICON);
		action.moveToElement(element).perform();
		
		if(!driver.findElement(CALL_US_OPTION).isDisplayed())
			throw new Exception("Call US Option is not present");
		
		text = driver.findElement(CALL_US_OPTION).getText();
		if(!text.equals("Call Us: 1-800-708-3490"))
			throw new Exception("Text or Number for Call Us changed");
		
		// valaditing Email Us option
		driver.get(baseUrl);
		element = driver.findElement(HELP_ICON);
		action.moveToElement(element).perform();
		if(!driver.findElement(EMAIL_US).isDisplayed())
			throw new Exception("Email Us option is not present");
		driver.findElement(EMAIL_US).click();
		Thread.sleep(4000);
		if(!driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/contact-us"))
			throw new Exception("Wrong page opened after clicked on Emails Us");
		Reporter.log("Call Us option and Email Us is Displayed :: Clickable");
	}
	
	
	// check Account/Login icon
	public void validateAccountIcon() throws Exception {
		if(!driver.findElement(ACCOUNT_ICON).isDisplayed())
			throw new Exception("Account Icon is not present");
		driver.findElement(ACCOUNT_ICON).click();
		Thread.sleep(4000);
		if(!driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/account/login"))
			throw new Exception("Wrong page opened after clicked on Account Icon");
		Reporter.log("Account Icon is Displayed :: Clickable");

	}
	public void validateCartIcon() throws Exception {
		// Check for Cart icon
		if(!driver.findElement(CART_ICON).isDisplayed())
			throw new Exception("Cart Icon is not present");
		driver.findElement(CART_ICON).click();
		Thread.sleep(2000);
		if(!driver.findElement(CART_HEADING_TEXT).isDisplayed())
			throw new Exception("Mini Cart is not opened");
		driver.get(baseUrl);
		Reporter.log("Cart Icon is Displayed :: Clickable :: Mini Cart is Opened");	
	}
	
	// validate homepage links
	public void validateFooterLinks() throws Exception {
		Set<String> handles = null;
		List<String> list = null;
		
		driver.get(baseUrl);
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// check About link
		text = driver.findElement(ABOUT_LINK).getText();
		if(!text.equals("About"))
			throw new Exception("About footer link text is changed");	
		driver.findElement(ABOUT_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/about-us")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after About footer link clicked");
		Reporter.log("About link is Displayed :: Clickable");
		
		// check Press link
		text = driver.findElement(PRESS_LINK).getText();
		if(!text.equals("Press"))
			throw new Exception("Press link text is changed");	
		driver.findElement(PRESS_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/press")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Press footer link clicked");
		Reporter.log("Press fotter link is Displayed :: Clickable");
		
		// check military discount link
		text = driver.findElement(MILITARY_DISCOUNT_LINK).getText();
		if(!text.equals("Military Discount"))
			throw new Exception("Military Discount link text is changed");	
		driver.findElement(MILITARY_DISCOUNT_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.sheerid.com/")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Military Discount footer link clicked");
		Reporter.log("Military Discount fotter link is Displayed :: Clickable");
		
		// check Teacher Discount  link
		text = driver.findElement(TEACHER_DISCOUNT_LINK).getText();
		if(!text.equals("Teacher Discount"))
			throw new Exception("Teacher Discount link text is changed");	
		driver.findElement(TEACHER_DISCOUNT_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn-teacher.sheerid.com/")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Teacher Discount footer link clicked");
		Reporter.log("Teacher Discount fotter link is Displayed :: Clickable");


		// check  Jobs  link
		text = driver.findElement(JOBS_LINK).getText();
		if(!text.equals("Jobs"))
			throw new Exception("Jobs link text is changed");	
		driver.findElement(JOBS_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.theresumator.com/apply")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Jobs footer link clicked");
		Reporter.log("Jobs fotter link is Displayed :: Clickable");

		// check  Privacy Policy  link
		text = driver.findElement(PRIVACY_POLICY_LINK).getText();
		if(!text.equals("Privacy Policy"))
			throw new Exception("Privacy Policy link text is changed");	
		driver.findElement(PRIVACY_POLICY_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/tommy-john-website-privacy-policy")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Privacy Policy footer link clicked");
		Reporter.log("Privacy Policy fotter link is Displayed :: Clickable");

		// check  Terms & Conditions  link
		text = driver.findElement(TERMS_AND_CONDITION_LINK).getText();
		if(!text.equals("Terms & Conditions"))
			throw new Exception("Terms & Conditions link text is changed");	
		driver.findElement(TERMS_AND_CONDITION_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/tommy-john-terms-and-conditions")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Terms & Conditions footer link clicked");
		Reporter.log("Terms & Conditions footer link is Displayed :: Clickable");

		// check  Help  link
		text = driver.findElement(HELP_LINK).getText();
		if(!text.equals("Help"))
			throw new Exception("Help link text is changed");	
		driver.findElement(HELP_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Help footer link clicked");
		Reporter.log("Help fotter link is Displayed :: Clickable");

		// check  Contact Us  link
		text = driver.findElement(CONTACT_US_LINK).getText();
		if(!text.equals("Contact Us"))
			throw new Exception("Contact Us link text is changed");	
		driver.findElement(CONTACT_US_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/contact-us")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Contact Us footer link clicked");
		Reporter.log("Contact Us footer link is Displayed :: Clickable");

		// check  Retailers  link
		text = driver.findElement(RETAILERS_LINK).getText();
		if(!text.equals("Retailers"))
			throw new Exception("Retailers link text is changed");	
		driver.findElement(RETAILERS_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/retailers")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Retailers footer link clicked");
		Reporter.log("Retailers footer link is Displayed :: Clickable");

		// check  King of Prussia Store  link
		text = driver.findElement(KING_OF_PURSSIA_STORE_LINK).getText();
		if(!text.equals("King of Prussia Store"))
			throw new Exception("King of Prussia Store link text is changed");	
		driver.findElement(KING_OF_PURSSIA_STORE_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/king-of-prussia")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after King of Prussia Store footer link clicked");
		Reporter.log("King of Prussia Store footer link is Displayed :: Clickable");

		
		// check Charlotte Store Store  link
		text = driver.findElement(CHARLOTTE_STORE_LINK).getText();
		if(!text.equals("Charlotte Store"))
			throw new Exception("Charlotte Store link text is changed");	
		driver.findElement(CHARLOTTE_STORE_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/south-park-landing-page")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Charlotte Store footer link clicked");
		Reporter.log("Charlotte Store footer link is Displayed :: Clickable");

		// check Store Locator  link
		text = driver.findElement(STORE_LOCATOR_LINK).getText();
		if(!text.equals("Store Locator"))
			throw new Exception("Store Locator link text is changed");	
		driver.findElement(STORE_LOCATOR_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/store-locator")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Store Locator footer link clicked");
		Reporter.log("Store Locator footer link is Displayed :: Clickable");

		// check Shipping & Returns  link
		text = driver.findElement(SHIPPING_AND_RETURNS_LINK).getText();
		if(!text.equals("Shipping & Returns"))
			throw new Exception("Shipping & Returns link text is changed");	
		driver.findElement(SHIPPING_AND_RETURNS_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us/articles/360000507746-Shipping-Returns")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Shipping & Returns footer link clicked");
		Reporter.log("Shipping & Returns footer link is Displayed :: Clickable");

		
		// check 1-800-708-3490  link
		text = driver.findElement(NUMBER_LINK).getText();
		if(!text.equals("1-800-708-3490"))
			throw new Exception("1-800-708-3490 link text is changed");	
		Reporter.log("1-800-708-3490 footer link is Displayed");
		
		// check Loyalty  link
		text = driver.findElement(LOYALTY_LINK).getText();
		if(!text.equals("Loyalty"))
			throw new Exception("Loyalty link text is changed");	
		driver.findElement(LOYALTY_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us/sections/360000067306-Loyalty-Rewards")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Loyalty footer link clicked");
		Reporter.log("Loyalty footer link is Displayed :: Clickable");

		// check Tommy John Rewards  link
		text = driver.findElement(TOMMYJOHN_REWARDS_LINK).getText();
		if(!text.equals("Tommy John Rewards"))
			throw new Exception("Tommy John Rewards link text is changed");	
		driver.findElement(TOMMYJOHN_REWARDS_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/loyalty")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Tommy John Rewards footer link clicked");
		Reporter.log("Tommy John Rewards footer link is Displayed :: Clickable");

		// check Gift Cards  link
		text = driver.findElement(GIFT_CARD_LINK).getText();
		if(!text.equals("Gift Cards"))
			throw new Exception("Gift Cards link text is changed");	
		driver.findElement(GIFT_CARD_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/products/e-gift-card")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Gift Cards footer link clicked");
		Reporter.log("Gift Cards footer link is Displayed :: Clickable");

		// check Fabric Guide  link
		text = driver.findElement(FABRIC_GUIDE_LINK).getText();
		if(!text.equals("Fabric Guide"))
			throw new Exception("Fabric Guide link text is changed");	
		driver.findElement(FABRIC_GUIDE_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/fabric-guide")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Fabric Guide footer link clicked");
		Reporter.log("Fabric Guide footer link is Displayed :: Clickable");

		// check Facebook link
		text = driver.findElement(FACEBOOK_LINK).getText();
		if(!text.equals("Facebook"))
			throw new Exception("Facebook link text changed");
		driver.findElement(FACEBOOK_LINK).click();
		Thread.sleep(3000);
		handles = driver.getWindowHandles();
		list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(1));
		if(!driver.getCurrentUrl().equals("https://www.facebook.com/TommyJohnWear"))
			throw new Exception("Wrong page opened after clicked on Facebook link");
		driver.switchTo().window(list.get(0));
		Reporter.log("Facebook footer link is Displayed :: Clickable");
		
		// check Twitter link
		text = driver.findElement(TWITTER_LINK).getText();
		if(!text.equals("Twitter"))
			throw new Exception("Twitter link text changed");
		driver.findElement(TWITTER_LINK).click();
		Thread.sleep(3000);
		handles = driver.getWindowHandles();
		list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(2));
		if(!driver.getCurrentUrl().equals("https://twitter.com/TommyJohn"))
			throw new Exception("Wrong page opened after clicked on Twitter link");
		driver.switchTo().window(list.get(0));
		Reporter.log("Twitter footer link is Displayed :: Clickable");

		// check Pinterest link
		text = driver.findElement(PINTEREST_LINK).getText();
		if(!text.equals("Pinterest"))
			throw new Exception("Pinterest link text changed");
		driver.findElement(PINTEREST_LINK).click();
		Thread.sleep(3000);
		handles = driver.getWindowHandles();
		list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(3));
		if(!driver.getCurrentUrl().equals("https://www.pinterest.com/tommyjohnwear/"))
			throw new Exception("Wrong page opened after clicked on Pinterest link");
		driver.switchTo().window(list.get(0));
		Reporter.log("Pinterest footer link is Displayed :: Clickable");

		// check Instagram link
		text = driver.findElement(INSTAGRAM_LINK).getText();
		if(!text.equals("Instagram"))
			throw new Exception("Instagram link text changed");
		driver.findElement(INSTAGRAM_LINK).click();
		Thread.sleep(3000);
		handles = driver.getWindowHandles();
		list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(4));
		if(!driver.getCurrentUrl().equals("https://www.instagram.com/tommyjohnwear/"))
			throw new Exception("Wrong page opened after clicked on Instagram link");
		driver.switchTo().window(list.get(0));
		Reporter.log("Instagram footer link is Displayed :: Clickable");

		// check YouTube link
		text = driver.findElement(YOUTUBE_LINK).getText();
		if(!text.equals("YouTube"))
			throw new Exception("YouTube link text changed");
		driver.findElement(YOUTUBE_LINK).click();
		Thread.sleep(3000);
		handles = driver.getWindowHandles();
		list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(5));
		if(!driver.getCurrentUrl().equals("https://www.youtube.com/user/tommyjohnwear"))
			throw new Exception("Wrong page opened after clicked on YouTube link");
		driver.switchTo().window(list.get(0));
		Reporter.log("YouTube footer link is Displayed :: Clickable");

		// check Google+ link
		text = driver.findElement(GOOGLE_PLUS_LINK).getText();
		if(!text.equals("Google+"))
			throw new Exception("Google+ link text changed");
		driver.findElement(GOOGLE_PLUS_LINK).click();
		Thread.sleep(3000);
		handles = driver.getWindowHandles();
		list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(6));
		if(!driver.getCurrentUrl().contains("https://accounts.google.com"))
			throw new Exception("Wrong page opened after clicked on Google+ link");
		driver.switchTo().window(list.get(0));
		Reporter.log("Google+ footer link is Displayed :: Clickable");
		
	}
	
	
	// nevigate new arrival in men category
	public void nevigateToNewArrivalsInMenCategory() throws Exception {
		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(NEW_ARRIVALS_IN_MEN_CATEGORY).click();
		Thread.sleep(3000);
	}
	
	// nevigate to all underwear in men category 
	public static void nevigateToAllUnderwearInMenCategory() throws Exception {
		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(ALL_UNDERWEAR_IN_MEN_CATEGORY).click();	
		Thread.sleep(3000);
	}
	
	// nevigate to tank in men category
	public void nevigateToTankInMenCategory() throws Exception {
		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(TANK_IN_MEN_CATEGORY).click();
		Thread.sleep(3000);
	}
	
	// nevigate to dress shirts in men category
	public void nevigateToDressShirtsInMenCategory() throws Exception {
		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(DRESS_SHIRTS_IN_MEN_CATEGORY).click();
		Thread.sleep(3000);
	}

	// nevigate to all mens collections in men category
	public void nevigateToAllMensCollectionsInMenCategory() throws Exception {
		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(ALL_MENS_COLLECTIONS_IN_MEN_CATEGORY).click();
		Thread.sleep(3000);
	}

	// nevigate to New Arrivals in Women category
	public void nevigateToNewArrivalsInWomenCategory() throws Exception {
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(NEW_ARRIVALS_IN_WOMEN_CATEGORY).click();
		Thread.sleep(3000);
	}

	// nevigate to All Panties in Women category
	public void nevigateToAllPantiesnInWomenCategory() throws Exception {
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(ALL_PANTIES_IN_WOMEN_CATEGORY).click();
		Thread.sleep(3000);
	}

	// nevigate to Tees and Polos in Women category
	public void nevigateToTeesAndPolosInWomenCategory() throws Exception {
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(TEES_AND_POLOS_IN_WOMEN_CATEGORY).click();
		Thread.sleep(3000);
	}
	
	// nevigate to All Womens Collections in Women category
	public void nevigateToAllWomensCollectionsInWomenCategory() throws Exception {
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		driver.findElement(ALL_WOMENS_COLLECTIONS_IN_WOMEN_CATEGORY).click();
		Thread.sleep(3000);
	}

	// nevigate to All Mens Packs in Packs category
	public void nevigateToAllMensPacksInPacksCategory() throws Exception {
		element = driver.findElement(PACKS);
		action.moveToElement(element).perform();
		driver.findElement(ALL_MENS_PACKS_IN_PACKS_CATEGORY).click();
		Thread.sleep(3000);
	}

	// nevigate to All Womens Packs in Packs category
	public void nevigateToAllWomensPacksInPacksCategory() throws Exception {
		element = driver.findElement(PACKS);
		action.moveToElement(element).perform();
		driver.findElement(ALL_WOMENS_PACKS_IN_PACKS_CATEGORY).click();
		Thread.sleep(3000);
	}
}
