import java.net.MalformedURLException;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	@Parameters ({"browser"})
	@BeforeTest
	public void setupDriver(@Optional("chrome") String browser) throws MalformedURLException {
		//String exePath = "D:/workspace/chromedriver.exe";
		//System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Ahmed.El-Shanwany\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", exePath);
		//driver = new ChromeDriver();
		
			if (browser.equals(null) || browser == "") {
				browser="chrome";
			}
		
		ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", browser);
		
		WebDriver driver = new RemoteWebDriver(capabilities);

		this.driver=driver;
	
	}
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}


}
