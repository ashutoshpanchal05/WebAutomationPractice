package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import library.CommonSteps;

public class GenericSteps {

	private CommonSteps commonSteps;
	private WebDriver driver;

	public GenericSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\resources\\chromedriver.exe");

	}

	@After
	public void deInit() {
		driver = commonSteps.getDriver();
		driver.quit();
	}

}
