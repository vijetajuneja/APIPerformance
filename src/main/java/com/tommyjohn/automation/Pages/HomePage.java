package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.HomePageComponents;

public class HomePage extends HomePageComponents {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void logoandcategoriespresence() throws Exception
	{
		ValidateLogoAndCategoriesPresence();
	}
	
	public void verifyfooterlinks() throws Exception
	{
		validateFooterLinks();
	}

	public void verifyhelp() throws Exception
	{
		
		validateHelpIcon();
	}

	public void verifycart() throws Exception
	{
		validateCartIcon();
	}

	public void verifyaccounticon() throws Exception
	{
		validateAccountIcon();

	}
	public void validateSearch() throws Exception
	{
		validateSearchFunctionality();

	}
	public void validateSearchPM() throws Exception
	{
		validateSearchFunction();

	}
	
	
	
	
}
