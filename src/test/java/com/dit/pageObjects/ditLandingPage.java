package com.dit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.dit.coreframework.AbstractWebPage;

public class ditLandingPage extends AbstractWebPage {

	@FindBy(how = How.CSS, using = "#header-bar ul li:nth-child(1) a")
	private WebElement authenticate1;
	
	@FindBy(how = How.CSS, using = "#header-bar ul li:nth-child(2) a")
	private WebElement authenticate2;
	
	@FindBy(how = How.LINK_TEXT, using = "Profile")
	private WebElement profile;
	
	@FindBy(how = How.CSS, using = ".span8.sso-profile-toolbar-labels-container>div")
	private WebElement profileName;
	
	@FindBy(how = How.LINK_TEXT, using = "Start now")
	private WebElement startNow;
	
	public ditLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void userProfileAuthenticated(String profile, String signout){
		authenticate1.sendKeys(profile);
		authenticate2.sendKeys(signout);
	}
	
	public ditProfilePage checkUserProfile(){
		profile.click();
		return new ditProfilePage(driver);
	}
	
	public String validateUserProfile(){
		return profileName.getText();
	}
	
	public ditProfilePage startTheJourney(){
		startNow.click();
		return new ditProfilePage(driver);
	}

}
