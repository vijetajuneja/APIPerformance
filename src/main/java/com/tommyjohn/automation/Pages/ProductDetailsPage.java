package com.tommyjohn.automation.Pages;

import com.tommyjohn.automation.Components.ProductDetailsPageComponents;

public class ProductDetailsPage {
	
	public void verifyProductDetailsPage() throws Exception {
		
		new ProductDetailsPageComponents().validateProductDetailsPage();
	}
}
