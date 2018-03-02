package com.dit.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.dit.coreframework.AbstractWebPage;

public class ditLoginPage extends AbstractWebPage {

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private WebElement signin;
	
	@FindBy(how = How.CSS, using = "#id_login")
	private WebElement userNameField;
	
	@FindBy(how = How.CSS, using = "#id_password")
	private WebElement userPasswordField;
	
	@FindBy(how = How.XPATH, using = "//button[contains(.,'Sign in')]")
	private List<WebElement> loginBtn;
	
	
	
	public ditLoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void Signin(){
		signin.click();
	}
	
	public void enterUserName(String userName){
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		 userPasswordField.sendKeys(password);
	}
	
	public ditLandingPage clickSignin(){
		JavascriptExecutor jscriptexec = (JavascriptExecutor)driver;
		jscriptexec.executeScript("arguments[0].click()", loginBtn.get(0));
		return new ditLandingPage(driver);
	}
}
