package com.odoo.ap.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.ap.pagelayer.Homepage;
import com.odoo.ap.pagelayer.Loginpage;
import com.odoo.ap.testbase.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void validate_user_should_be_log_in_entering_all_valid_inputs()
	{
		
		String expected_result = "https://ap-automation.odoo.com/my";
		
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmail("test@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		logger.info("Logged in");
		
		String actual_result = driver.getCurrentUrl();
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void validate_user_should_be_log_in_by_entering_invalid_inputs()
	{
		
		String expected_result = "Wrong login/password";
		
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmail("test@gmail.com");
		loginpage_obj.enterPassword("Test");
		loginpage_obj.clickOnLoginButton();
		
		logger.info("Not Logged in");
		
		String actual_result = loginpage_obj.getErrorMessage();
		
		logger.info("The error message is :- " +actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	
}
