package com.dit.coreframework;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.dit.configuration.Context;
import com.dit.pageObjects.ditLoginPage;

@ContextConfiguration(classes = Context.class, initializers = ConfigFileApplicationContextInitializer.class)
public abstract class AbstractTestCase {

protected WebDriver driver;
	
	
	@Value("${ditJourney}")
	private String ditJourney;
	
	public void printUrl(){
		System.out.println(ditJourney);
	}
	public String navigateToDitJourney(){
		return ditJourney;
	}
	
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public void printRestTemplate(){
		System.out.println(restTemplate);
	}
	
	
	@Autowired
	private WebDriverFactory webDriverFactory;
	
	public void printWebDriverFactory(){
		System.out.println(webDriverFactory);
	}
	
	
	protected ditLoginPage openDitLoginPage() {
		driver = webDriverFactory.initializeWebDriver();
		driver.get(navigateToDitJourney());
		System.out.println(driver.getTitle());
		return new ditLoginPage(driver);
	}

}
