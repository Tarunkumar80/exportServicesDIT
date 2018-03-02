package com.dit.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.dit.coreframework.AbstractWebPage;

public class ditProfilePage extends AbstractWebPage {

	@FindBy(how = How.CSS, using = ".span8.sso-profile-toolbar-labels-container>div")
	private WebElement profileName;
	
	@FindBy(how = How.LINK_TEXT, using = "Start now")
	private WebElement startNow;
		
	@FindBy(how = How.CSS, using = "#js-sector-select")
	private WebElement whatDoYouWantToExport;
	
	@FindBy(how = How.CSS, using = ".button.button")
	private WebElement Continue;
	
	@FindBy(how = How.XPATH, using = "//label[contains(.,'Yes')]")
	private WebElement radioSelectionYes;
	
	@FindBy(how = How.XPATH, using = "//label[contains(.,'No')]")
	private WebElement radioSelectionNo;
	
	@FindBy(how = How.CSS, using = "#js-typeahead-company-name")
	private WebElement YourCompanyName;
	
	@FindBy(how = How.CSS, using = ".answers dl dd.answer")
	private List<WebElement> answers;
	
	@FindBy(how = How.CSS, using = ".button.next")
	private WebElement continueMyExportJourney;
	
	@FindBy(how = How.CSS, using = "h1")
	private WebElement YourExportJourney;
	
	
	public ditProfilePage(WebDriver driver) {
		super(driver);
	}

	
	public String validateUserProfile(){
		return profileName.getText();
	}
	
	public ditProfilePage startTheJourney(){
		startNow.click();
		return new ditProfilePage(driver);
	}
		
	public void createUserJourney(String exportItem, String companyName){
		whatDoYouWantToExport.clear();
		whatDoYouWantToExport.sendKeys(exportItem, Keys.ARROW_DOWN, Keys.ENTER);
		Continue.click();
		radioSelectionYes.click();
		Continue.click();
		radioSelectionYes.click();
		Continue.click();
		radioSelectionYes.click();
		Continue.click();
		YourCompanyName.clear();
		YourCompanyName.sendKeys(companyName);
		Continue.click();
	}
	
	public void userVerifiesAnswers(String exportItem, String companyIncorporated, String companyName){
		answers.get(0).getText().contains(exportItem);
		System.out.println(answers.get(0).getText());
		answers.get(3).getText().contains(companyIncorporated);
		System.out.println(answers.get(3).getText().contains(companyIncorporated));
		answers.get(4).getText().contains(companyName);
		System.out.println(answers.get(4).getText().contains(companyName));
		continueMyExportJourney.click();
	}
	
	public String verifyYourExportJourney(){
		return YourExportJourney.getText();
	}

}
