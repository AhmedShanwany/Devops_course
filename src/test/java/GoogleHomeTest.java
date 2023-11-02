import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleHomeTest extends BaseTest  {
	
	@Test
	public void searchTest() {
	GoogleHomePage gp = new GoogleHomePage(driver);
	gp.launchURL();
	gp.isDisplayed();
	Assert.assertEquals(1,1);
	
	
	}
	
	
	



}