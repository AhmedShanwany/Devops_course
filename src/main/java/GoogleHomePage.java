import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {

		
		private WebDriver driver;
		private WebDriverWait wait;
		
		public GoogleHomePage(WebDriver driver) {
			this.driver=driver;
			this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			PageFactory.initElements(driver, this);
		}
		public void searchText(String text) {
			this.searchBox.sendKeys(text);
			this.wait.until((d) -> this.searchSuggestion.size()>3);
			
		}
		public void clickSuggestionByIndex(int index) {
			this.searchSuggestion.get(index-1).click();
		}
		
		@FindBy(name="q")
		private WebElement searchBox;
		

		
		@FindBy (css = "li.sbct")
		private List<WebElement> searchSuggestion;
		
		
		public void launchURL() {
			this.driver.get("https://www.google.com");
			
		}
		
		public boolean isDisplayed() {
			this.wait.until(ExpectedConditions.visibilityOf(searchBox));
			return true;
		}
		
}
