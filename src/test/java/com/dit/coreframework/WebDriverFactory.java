package com.dit.coreframework;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import com.dit.configuration.Context;


@ContextConfiguration(classes = Context.class)
public class WebDriverFactory {
	
	@Value("${runMode}")
	private String runMode;
	
	
	public WebDriver initializeWebDriver() {
		
		WebDriver driver = null;
		
	
		String path=System.getProperty("user.dir")+"/src/resources/";
		
		
		switch (runMode)
		{
		
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", path+ "chromeDriver");
				driver = new ChromeDriver();
				break;
		
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", path+ "geckodriver");
				driver = new FirefoxDriver();
				break;
		
			default	: throw new InvalidParameterException(runMode + "is not a valid parameter - RunMode environment variable is not set!");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

}
