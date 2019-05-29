package TestScenario;

import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.CollectionPage;

public class ValidateCollectionPage {
//	@Test
//	public void TC_ValidateProductImageOnCollectionPage() throws Exception
//	{
//		new CollectionPage().validateProductImage();
//	}
//
//	@Test
//	public void TC_ValidateProductHeadingTextOnCollectionPage() throws Exception
//	{
//		new CollectionPage().validateProductHeadingText();
//	}
//
//	@Test
//	public void TC_ValidateProductReviewStarsOnCollectionPage() throws Exception
//	{
//		new CollectionPage().validateProductReviewStars();
//	}
//
//	@Test
//	public void TC_ValidateProductImageOnSingleCollectionPage() throws Exception
//	{
//		new CollectionPage().validateProductImageOnSingleCollectionPage();
//	}
//
//	@Test
//	public void TC_ValidateProductHeadingTextOnSingleCollectionPage() throws Exception
//	{
//		new CollectionPage().validateProductHeadingTextOnSingleCollectionPage();
//	}
//	@Test
//	public void TC_ValidateProductReviewStarsOnSingleCollectionPage() throws Exception
//	{
//		new CollectionPage().validateProductReviewStarsOnSingleCollectionPage();
//	}

	//--------------------------validate mega collections----------------------------
//	@Test
//	public void TC_ValidateMegaCollectionAllClothingInWomensCategory() throws Exception
//	{
//		new CollectionPage().validateAllClothingOnCollectionPage();
//	}
	
	@Test
	public void TC_ValidateMegaCollectionAllPantiesInWomenCategory() throws Exception {
		new CollectionPage().validateWomensAllPantiesOnCollectionPage();
	}

	
	//---------------------------validate single collections---------------
//	@Test
//	public void TC_ValidateSingleCollectionSecondSkinInMenCategory() throws Exception {
//		new CollectionPage().validateSecondSkinOnSingleCollectionPage();
//	}


}
