package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.security.auth.login.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import utilities.Configurations;

public class CommonSteps {

	private WebDriver driver;
	Properties obj_prop;

	public CommonSteps() {
		obj_prop = new Properties();
		FileReader objFileReader;
		try {
			objFileReader = new FileReader("./src\\test\\resources\\web_objects\\Object.properties");
			obj_prop.load(objFileReader);
		} catch (FileNotFoundException e1) {
			System.out.println("Object property file not found");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Navigate(String URL) {
		if(Configurations.BROWSER_NAME.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(Configurations.BROWSER_NAME.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		
		driver.navigate().to(URL);
		driver.manage().window().maximize();

	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Set<String> getWindowHandles() {

		Set<String> availableWindows = driver.getWindowHandles();
		if (availableWindows.size() > 0) {
			return availableWindows;
		}
		System.out.println("Only one availabe window available");
		return availableWindows;
	}

	public void click(String webObject) {

		driver.findElement(By.xpath(obj_prop.getProperty(webObject))).click();

	}

	public void switchToWindow(String windowID) {
		
		Set<String> uniqueWindows = getWindowHandles();
		List<String> uniqueWindowList = new ArrayList<String>(uniqueWindows);
		if(uniqueWindowList.size()>0) {
		driver.switchTo().window(uniqueWindowList.get(Integer.parseInt(windowID)));
		}
		else {
			System.out.println("Cannot switch as number of windows tab is less");
		}
	}

	public void waitintTimeInSeconds(String sec) {
		int secTime =Integer.parseInt(sec);
		try {
			Thread.sleep((secTime * 1000));
		} catch (InterruptedException e) {
			System.out.println("Error in Delay");
			e.printStackTrace();
		}
		
	}

}
