import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	

	public GoogleSearchPage(WebDriver driver) {
		this.driver= driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="logo")
	private WebElement logo;
	
	public boolean isDisplayed() {
		this.wait.until(ExpectedConditions.visibilityOf(logo));
		return true;
	}
	

}
