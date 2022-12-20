package stepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reciproci.base.Base;
import reciproci.pages.LoginPageAct;

class LoginValidation {
	
	LoginPageAct lp;
	
	@Before
	public void initialize() {
		lp = new LoginPageAct();
	}
	
	
	@Given("Browser is opened and enter URL")
	public void browser_is_opened_and_enter_URL() {
	   
	}

	@When("Entered correct username and password")
	public void entered_correct_username_and_password() {
	  lp.enterUserAndPass("admin", "test@123");
	}

	@When("Click on login button")
	public void click_on_login_button() {
	    lp.submit();
	}

	@Then("Success message alert will be displayed.")
	public void success_message_alert_will_be_displayed() {
	    lp.verifySuccMsg();
	}

	@When("Entered invalid username and password")
	public void entered_invalid_username_and_password() {
		 lp.enterUserAndPass("admin", "admin");
	}

	@Then("Error alert message will be displayed.")
	public void error_alert_message_will_be_displayed() {
	    lp.verifyErrMsg();
	}
	
	@After
	public void tearDown() {
		Base.driver=null;
	}
}
