package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.AddToCartPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class AddToCartTests {

	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void launch()
	{
		try {
			CustomUtilities.launchtj();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void AddToCartTestCase() {
		
		new AddToCartPage(driver).ATC();

	}
}
