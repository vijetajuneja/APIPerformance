package com.tommyjohn.automation.Components;

import java.util.List;

import org.omg.CORBA.portable.ValueOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.CollectionPageLocator;
import com.tommyjohn.automation.utils.CustomUtilities;

public class CollectionPageComponent extends CollectionPageLocator {
	public static WebDriver driver = CustomUtilities.driver;
	WebElement element;

	public static String navigateToProductDetailsPage() throws Exception {
		String text = null;
		
		// get text and click on the first product
		if(!driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).isDisplayed())
			throw new Exception("Product head line text is not displayed");
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).click();
		Thread.sleep(3000);
		return text;
	}
	
	@SuppressWarnings("static-access")
	public void validateProductImageOnCollectionPage() throws Exception {
		String text = null;
		
		// nevigate to Collection page
		HomePageComponents.nevigateToAllUnderwearInMenCategory();
		
		// get product title and click on image if present
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		if(!driver.findElement(THIRD_PRODUCT_IMAGE).isDisplayed())
			throw new Exception("Product image is not present");
		driver.findElement(THIRD_PRODUCT_IMAGE).click();
		Thread.sleep(3000);
		
		// check correct Product details page opened or not
		new ProductDetailsPageComponents().checkCorrectProductDetailsPageOpenedOrNot(text);	

		// validate product details page by calling the method
		new ProductDetailsPageComponents().validatePage();
		
		Reporter.log("Product image on collection page is Displayed :: Clickable and validated successfully");
	}
	
	@SuppressWarnings("static-access")
	public void validateProductHeadingTextOnCollectionPage() throws Exception {
		String text = null;
		
		// nevigate to Collection page
		HomePageComponents.nevigateToAllUnderwearInMenCategory();
		
		// get product title and click on product heading text if present
		if(!driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).isDisplayed())
			throw new Exception("Product heading text is not present");
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).click();
		Thread.sleep(3000);
		
		// check correct Product details page opened or not
		new ProductDetailsPageComponents().checkCorrectProductDetailsPageOpenedOrNot(text);	

		// validate product details page by calling the method
		new ProductDetailsPageComponents().validatePage();
		
		Reporter.log("Product head line text on collection page is Displayed :: Clickable and validated successfully");
		
	}

	@SuppressWarnings("static-access")
	public void validateProductReviewStarsOnCollectionPage() throws Exception {
		String text = null;
		
		// nevigate to Collection page
		HomePageComponents.nevigateToAllUnderwearInMenCategory();
		
		// get product title and click on product heading text if present
		try {
			if(!driver.findElement(THIRD_PRODUCT_REVIEW_STARS).isDisplayed())
				throw new Exception("Product review stars are not present");
			text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
			driver.findElement(THIRD_PRODUCT_REVIEW_STARS).click();
			Thread.sleep(3000);
		// check correct Product details page opened or not
		new ProductDetailsPageComponents().checkCorrectProductDetailsPageOpenedOrNot(text);	

		// validate product details page by calling the method
		new ProductDetailsPageComponents().validatePage();

		Reporter.log("Product review stars on collection page is Displayed :: Clickable and validated successfully");
		
		}catch(Exception e) {
			Reporter.log("Review Stars were not present for the selected product");
		}
	}
	
	//----------------------------Single collection------------------------------
	
	@SuppressWarnings("static-access")
	public void validateProductImageForSingleCollection() throws Exception {
		String text = null;
		
		// nevigate to cool cotton Collection page
		HomePageComponents.nevigateToCoolCottonInMensCollection();
		
		// get product title and click on image if present
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		if(!driver.findElement(THIRD_PRODUCT_IMAGE).isDisplayed())
			throw new Exception("Product image is not present");
		driver.findElement(THIRD_PRODUCT_IMAGE).click();
		Thread.sleep(3000);
		
		// check correct Product details page opened or not
		new ProductDetailsPageComponents().checkCorrectProductDetailsPageOpenedOrNot(text);	

		// validate product details page by calling the method
		new ProductDetailsPageComponents().validatePage();
		
		Reporter.log("Product image on single collection page is Displayed :: Clickable and validated successfully");

	}
	// validate product headline text for single collection
	@SuppressWarnings("static-access")
	public void validateProductHeadlineTextForSingleCollection() throws Exception {
		String text = null;
		
		// nevigate to cool cotton Collection page
		HomePageComponents.nevigateToCoolCottonInMensCollection();
		
		// get product title and click on image if present
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		if(!driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).isDisplayed())
			throw new Exception("Product image is not present");
		driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).click();
		Thread.sleep(3000);
		
		// check correct Product details page opened or not
		new ProductDetailsPageComponents().checkCorrectProductDetailsPageOpenedOrNot(text);	

		// validate product details page by calling the method
		new ProductDetailsPageComponents().validatePage();
		
		Reporter.log("Product image on single collection page is Displayed :: Clickable and validated successfully");

	}

	// validate product review stars for single collection
	@SuppressWarnings("static-access")
	public void validateProductReviewStarsForSingleCollection() throws Exception {
		String text = null;
		
		// nevigate to cool cotton Collection page
		HomePageComponents.nevigateToCoolCottonInMensCollection();
		
		// get product title and click on image if present
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		if(!driver.findElement(THIRD_PRODUCT_REVIEW_STARS).isDisplayed())
			throw new Exception("Product image is not present");
		driver.findElement(THIRD_PRODUCT_REVIEW_STARS).click();
		Thread.sleep(3000);
		
		// check correct Product details page opened or not
		new ProductDetailsPageComponents().checkCorrectProductDetailsPageOpenedOrNot(text);	

		// validate product details page by calling the method
		new ProductDetailsPageComponents().validatePage();
		
		Reporter.log("Product image on single collection page is Displayed :: Clickable and validated successfully");

	}
	
	//----------------------------validate single collections----------------------------------
	
	public void validateSingleCollectionSecondSkinInMenCategory() throws Exception {
		// call the method to nevigate to second skin in mens category
		HomePageComponents.navigateToSecondSkinInMenCategory();
		
		// check the heading of selected category collection page
		if(!driver.findElement(MAIN_HEADING_OF_SELECTED_CATEGORY).isDisplayed())
			throw new Exception("Heading on collection page for selected category is not displayed");
		
		try {
			// validate corosals if present on top of page
			if(driver.findElement(STYLE_COROSALS).isDisplayed()) {
				methodToCheckCorosalsOnTopOfPageIsActiveWhenRelatedStyleIsChecked();
			}
		}catch(Exception e) {
			System.out.println("Corosals are not there");
		}
		
		// call method to check all filters
		methodToCheckAllFilters();
		
	}
	
	//--------------------------------validate mega collections------------------------------------
	
	public void validateMegaCollectionAllClothingInWomensCategory() throws Exception {
		
		// call the method to nevigate to all clothing in womens category
		HomePageComponents.navigateToAllClothingInWomensCategory();
		
		// check the heading of selected category collection page
		if(!driver.findElement(MAIN_HEADING_OF_SELECTED_CATEGORY).isDisplayed())
			throw new Exception("Heading on collection page for selected category is not displayed");

		try {
			// validate corosals if present on top of page
			if(driver.findElement(STYLE_COROSALS).isDisplayed()) {
				methodToCheckCorosalsOnTopOfPageIsActiveWhenRelatedStyleIsChecked();
			}
		}catch(Exception e) {
			System.out.println("Corosals are not there");
		}
		
		// call method to check all filters
		methodToCheckAllFilters();
	}
	
	public void validateMegaCollectionAllPantiesInWomensCategory() throws Exception {
		
		// call the method to nevigate to all clothing in womens category
		HomePageComponents.navigateToAllPantiesInWomenCategory();
		
		// check the heading of selected category collection page
		if(!driver.findElement(MAIN_HEADING_OF_SELECTED_CATEGORY).isDisplayed())
			throw new Exception("Heading on collection page for selected category is not displayed");

		try {
			// validate corosals if present on top of page
			if(driver.findElement(STYLE_COROSALS).isDisplayed()) {
				methodToCheckCorosalsOnTopOfPageIsActiveWhenRelatedStyleIsChecked();
			}
		}catch(Exception e) {
			System.out.println("Corosals are not there");
		}

		
		// call method to check all filters
		methodToCheckAllFilters();
	}

	
	//-------------------------------------------------------------------------------------------
	
	// method to validate all filters
	public void methodToCheckAllFilters() throws Exception {
		List<WebElement> allElements = null;
		int filterList = 0;
		int optionsList = 0;
		String selectedOption = null;
		int optionsList1 = 0;
		int count = 0;
		List<WebElement> allProductsOnPage = null;
		String totalDisplayedCount = null;
		
		// get total no of filters
		allElements = driver.findElements(ALL_FILTERS);
		filterList = allElements.size();
        System.out.println("All filters list :: "+ filterList);
        
        // loop for total not of filters
        for(int i = 2; i <= filterList+1; i++) {
        	driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > a")).click();
        	
        	// get all the options list available in ith filter
    		allElements = driver.findElements(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li"));
    		optionsList = allElements.size();
            System.out.println("All options list :: "+ optionsList);
            
            int ct = 0;
            //loop for clicking all the options in ith filter
            for(int j = 1; j <= optionsList; j++) {
            	// check if element is not displayed but present then continue at this step
            	System.out.println("i = "+i+" j = "+j);
            	if(!driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).isDisplayed())
            		continue;
            	count++;
            	driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).click();
            	Thread.sleep(1000);
            	
            	// get the name of selected option
            	selectedOption = driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).getAttribute("data-filter-btn");
            	System.out.println("selected option :: "+selectedOption);
            	
            	
            	// get all selected displayed optioins
            	allElements = driver.findElements(DISPLAYED_ALL_SELECTED_OPTIONS);
            	optionsList1 = allElements.size();
            	
            	System.out.println("count :: "+count);
            	System.out.println("optionlist1 :: "+optionsList1);
            	// check selected options count and displayed selected list count is same or not
            	if(count != optionsList1)
            		throw new Exception("Selected options and selected displayed options are not same");
            	
            	System.out.println("ct :: "+ct);
            	System.out.println("ct th ele :: "+allElements.get(ct).getText());
            	if(!(allElements.get(ct).getText()).equals(selectedOption))
            		throw new Exception("Selected item is not present in displayed item list");
            	
                // check total no of count is displayed or not
                if(!driver.findElement(TOTAL_COUNTS_OF_ITEMS).isDisplayed())
                	throw new Exception("Total counts of items is not displayed for filter :: "+i);
                
                // check total not of count and products are correct
                totalDisplayedCount = driver.findElement(TOTAL_COUNTS_OF_ITEMS).getText();
                allProductsOnPage = driver.findElements(FIRST_PRODUCT_IMAGE);
                int allProductsOnPage1 = allProductsOnPage.size();
                // check for hoverable class (if image is hoverable then it count two images for one image)
                element = driver.findElement(FIRST_PRODUCT_IMAGE);
    			String classes = element.getAttribute("class");
    			for (String c : classes.split(" ")) {
    				System.out.println("C ::::: "+c);
    				if (c.equals("product-image-container--has-hover")) {
    					allProductsOnPage1 = (allProductsOnPage1)/2;
    					System.out.println("In ddd :: "+allProductsOnPage1);
    				}
    			}
                
                System.out.println("total displayed product on page :: "+allProductsOnPage1);
                System.out.println("total displayed count of product :: "+totalDisplayedCount);
                if(allProductsOnPage1 != (Integer.parseInt(totalDisplayedCount)))
                	throw new Exception("Total displayed count is not same as all products on page");
                
            	ct++;
            	
            }
            // click on last item to remove it from list
            driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > a")).click();
            Thread.sleep(1000);
            System.out.println("last item :: "+driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child("+ct+")")).getText());
            driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child("+ct+")")).click();
            // after last element removed decrease ct by 1
            ct--;
            // check when we click on item then it remove from list or not
        	if((allElements.get(ct).getText()).equals(driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child("+ct+")")).getText()))
        		throw new Exception("Item is not removed from displayed list when click on it");
            ct = 0;
            
            // clear the filters
            driver.findElement(CLEAR_FILTER_BUTTON).click();
            Thread.sleep(3000);
            allElements = null;
            count = 0;
        }
        Reporter.log("All filters are working correctly");
        Reporter.log("All selected items are displayed in list and removing from list");
        Reporter.log("Clear filters button works correctly");
        if(driver.findElement(LAST_FILTER).isDisplayed()) {
        	driver.findElement(LAST_FILTER).click();
        	
        	// click on second option
        	driver.findElement(SORTBYPRICE_HIGH_TO_LOW_FILTER_OPTION).click();
        	Thread.sleep(3000);
        	allProductsOnPage = driver.findElements(FIRST_PRODUCT_IMAGE);
        	System.out.println("All product on page :: "+allProductsOnPage);
        	for(int i=1; i < allProductsOnPage.size(); i++) {
        		String text = null;
        		String text1 = null;
        		String text2 = null;
        		
        		text = driver.findElement(By.cssSelector(".mega-collection-grid__row > div.product-item:nth-child("+i+") > div.product-meta__prices")).getText();
        		System.out.println("Text :: "+text);
        		for (String a : text.split("\\$")) 
        			 text1 = a;
        		System.out.println("text 1 :: "+text1);
        		 // loop to check previous and next price
        		int j = i+1;
           		System.out.println("Text :: "+driver.findElement(By.cssSelector(".mega-collection-grid__row > div.product-item:nth-child("+j+") > div.product-meta__prices")).getText());
            		for (String a : driver.findElement(By.cssSelector(".mega-collection-grid__row > div.product-item:nth-child("+j+") > div.product-meta__prices")).getText().split("\\$")) 
            			text2 = a;
            		System.out.println("text2 :: "+text2);
            		if(Float.parseFloat(text1) < Float.parseFloat(text2))
            			throw new Exception("Product is not sorted by price");
        		 
        	}
        	Reporter.log("All Products are sorted as selected option");
    
        }
        	

	}
	public void  methodToCheckCorosalsOnTopOfPageIsActiveWhenRelatedStyleIsChecked() throws Exception {
		boolean flag1 = false;
		int i = 2;
		List<WebElement> allElements = null;
		List<WebElement> allCorosals = null;
		
		// check carosals are displayed on top of page or not
		if(!driver.findElement(STYLE_COROSALS).isDisplayed())
			throw new Exception("Corosals are not displayed on top of page");

	    allCorosals = driver.findElements(TOTAL_NO_OF_COROSALS);
	    System.out.println("Total no of corosals :: "+allCorosals.size());
		
	    // first check all corosals are not active by default
	    for(int k = 1;k <= allCorosals.size();k++) {
	    	element = driver.findElement(By.cssSelector(".hero-interactive-slide.slick-slide:nth-child("+k+")"));
			String classes = element.getAttribute("class");
			for (String c : classes.split(" ")) {
				if (c.equals("active")) {
					flag1 = true;
				}
			}
			if(flag1 == true)
				throw new Exception("All corosals are not deactive by default");
			flag1= false;
	    }
	    Reporter.log("All corosals are Displayed :: And by default not active");
    	// check selected option in style and respected corosal is active or not
	    driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > a")).click();
	        	
	    // get all the options list available in ith filter
	    allElements = driver.findElements(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li"));
	    //loop for clicking all the options in ith filter
	    for(int j = 1; j <= allElements.size(); j++) {
	    // check if element is not displayed but present then continue at this step
	    System.out.println("i = "+i+" j = "+j);
	    if(!driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).isDisplayed())
	    	continue;
	            	
	    driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).click();
	    Thread.sleep(1000);
	    
	    String selectedOption = driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).getAttribute("data-filter-btn");  
//	    System.out.println("Selected Option :: "+selectedOption);
	    
	    // check selected option related carosal is active or not
	    for(int k = 1;k <= allCorosals.size();k++) {
	    	String corosalName = driver.findElement(By.cssSelector(".hero-interactive-slide.slick-slide:nth-child("+k+") > button")).getAttribute("data-hero-filter-name");
	    	if(selectedOption == corosalName) {
	    		element = driver.findElement(By.cssSelector(".hero-interactive-slide.slick-slide:nth-child("+k+")"));
	    		String classes = element.getAttribute("class");
	    		for (String c : classes.split(" ")) {
	    			if (c.equals("active")) {
	    				flag1 = true;
	    			}
	    		}
	    		if(!flag1 == true)
	    			throw new Exception("Corosal related to "+selectedOption+" is not gets active");
	    		flag1= false;
	    	}
	    }
	  }	    
	    // clear all filters
	    driver.findElement(CLEAR_FILTER_BUTTON).click();
	    Reporter.log("Corosals gets active when respected option selected");
	}
	
}
