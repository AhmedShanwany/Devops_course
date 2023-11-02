import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleResultPageTest extends BaseTest{
	
	
	@Test (dataProvider= "getData")
	public void searchPageTest(String Keyword,int index) {
		GoogleHomePage gp = new GoogleHomePage(driver);
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		gp.launchURL();
		gp.searchText(Keyword);
		gp.clickSuggestionByIndex(index);
		searchPage.isDisplayed();
		Assert.assertEquals(1,1);
		}
@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"Docker",3},
			{"Selenium,",2}
		};
	}
}
