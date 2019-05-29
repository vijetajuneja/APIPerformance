package com.tommyjohn.automation.Pages;

import com.tommyjohn.automation.Components.HomePageComponents;

public class HomePage extends HomePageComponents {

	public void logoandcategoriespresence() throws Exception
	{
		ValidateLogoAndCategoriesPresence();
	}
	
	public void verifyfooterlinks() throws Exception
	{
		validateFooterLinks();
	}

	public void verifysearchandhelp() throws Exception
	{
		validateSearchIcon();
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
}
