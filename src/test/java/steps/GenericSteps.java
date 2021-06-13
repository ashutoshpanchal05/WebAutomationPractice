package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import library.CommonSteps;
import utilities.Configurations;

public class GenericSteps {
	
	private CommonSteps commonSteps;
	private WebDriver driver;

	public GenericSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Before
	public void init() {

		if(System.getProperty("BROWSER")!=null)
		{
			Configurations.BROWSER_NAME=System.getProperty("BROWSER");
		}
		
		if(Configurations.BROWSER_NAME.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\resources\\chromedriver.exe");

		}
		else if(Configurations.BROWSER_NAME.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\resources\\geckodriver.exe");
		}
		
	}

	@After
	public void deInit() {
		driver = commonSteps.getDriver();
		driver.quit();
	}

}
