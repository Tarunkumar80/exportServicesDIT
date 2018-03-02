package com.dit.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.dit.coreframework.AbstractTestCase;
import com.dit.pageObjects.ditLandingPage;
import com.dit.pageObjects.ditLoginPage;
import com.dit.pageObjects.ditProfilePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ditStepDefs extends AbstractTestCase{
	
	private ditLoginPage ditloginPage = null;
	private ditLandingPage ditlandingPage = null;
	private ditProfilePage ditprofilePage = null;
	
	@Given("^user is able to login with registered details$")
	public void user_is_able_to_login_with_registered_details(DataTable userData) throws Throwable {
	    ditloginPage = openDitLoginPage();
	    ditloginPage.Signin();
	    ditloginPage.enterUserName(userData.asList(String.class).get(2));
	    ditloginPage.enterPassword(userData.asList(String.class).get(3));
	    ditlandingPage = ditloginPage.clickSignin();
	}

	@When("^user checks the login is successful and authenticated$")
	public void user_checks_the_login_is_successful_and_authenticated(DataTable checkUser) throws Throwable {
		ditlandingPage
	    	.userProfileAuthenticated(checkUser.asList(String.class).get(0), checkUser.asList(String.class).get(1));
	    
	    String UserAuthentication1 = driver.findElement(By.cssSelector("#header-bar ul li:nth-child(1) a")).getText();
	    String UserAuthentication2 = driver.findElement(By.cssSelector("#header-bar ul li:nth-child(2) a")).getText();
	    
	    if (UserAuthentication1 == checkUser.asList(String.class).get(0) && UserAuthentication2 == checkUser.asList(String.class).get(1)) {
			Assert.assertTrue(UserAuthentication1.contains(checkUser.asList(String.class).get(0)));
			Assert.assertTrue(UserAuthentication2.contains(checkUser.asList(String.class).get(1)));
			}else
				{
				Assert.assertFalse(false);
		 		}
	    System.out.println("\n UserAuthenticated1 :" +UserAuthentication1+"\n UserAuthenticated2 :" +UserAuthentication2);
	}
	
	@Then("^user verifies the profile page$")
	public void user_verifies_the_profile_page(DataTable verifyProfile) throws Throwable {
		ditprofilePage= ditlandingPage.checkUserProfile();
	    String profile = ditlandingPage.validateUserProfile();
	    if (profile == verifyProfile.asList(String.class).get(0)){
	    	Assert.assertTrue(profile.contains(verifyProfile.asList(String.class).get(0)));
	    }else
	    	{
	    	Assert.assertFalse(false);
	    	}
	    System.out.println("Verified Profile : "+profile);
	    	driver.navigate().back();
	}
	
	@When("^user is on export Journey Page$")
	public void user_is_on_export_Journey_Page() throws Throwable {
		ditprofilePage.startTheJourney();
	}

	@Then("^the user should be able to create the journey$")
	public void the_user_should_be_able_to_create_the_journey(DataTable journeyData) throws Throwable {
	    ditprofilePage.createUserJourney(journeyData.asList(String.class).get(0), journeyData.asList(String.class).get(1));
	}

	@And("^the user checks the answers$")
	public void the_user_checks_the_answers(DataTable userAnswers) throws Throwable {
		ditprofilePage.userVerifiesAnswers(userAnswers.asList(String.class).get(0), userAnswers.asList(String.class).get(1), userAnswers.asList(String.class).get(2));
	}

	@Then("^export Journey is created$")
	public void export_Journey_is_created() throws Throwable {
		String titleHeading = "Your Export Journey";
		if (titleHeading == ditprofilePage.verifyYourExportJourney()){	
			Assert.assertTrue(ditprofilePage.verifyYourExportJourney().contains(titleHeading));	
		}else
			{
			Assert.assertFalse(false);
			}
		System.out.println(ditprofilePage.verifyYourExportJourney());
		driver.close();
	}
	
}
