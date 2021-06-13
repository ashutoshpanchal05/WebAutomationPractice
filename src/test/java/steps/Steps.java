package steps;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import library.CommonSteps;

public class Steps {

	private CommonSteps commonSteps;
	
	public Steps(CommonSteps commonSteps) {
		this.commonSteps=commonSteps;
		
	}

@Given("User navigated to {string}")
public void user_navigated_to(String URL) {
	commonSteps.Navigate(URL);
}

@When("User gets the count of open tab")
public void user_gets_the_count_of_open_tab() {
	
	Set<String> availableWindows = commonSteps.getWindowHandles();
	System.out.println("Count of avalable window is " + availableWindows.size());
    
}

@When("User switch to tab {string}")
public void user_switch_to_tab(String WindowID) {
		commonSteps.switchToWindow(WindowID);
   
}

@Then("Test is successfully")
public void test_is_successfully() {
    System.out.println("TEST EXECUTED SUCESSFULLY");
}

@When("User clicks on {string}")
public void user_clicks_on(String webObject) {
    commonSteps.click(webObject);
}


@When("Wait for {string} Seconds")
public void wait_for_seconds(String sec) {
    commonSteps.waitintTimeInSeconds(sec);
}

}
