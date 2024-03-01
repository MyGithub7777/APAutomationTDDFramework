package com.odoo.ap.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.ap.pagelayer.Homepage;
import com.odoo.ap.pagelayer.Loginpage;
import com.odoo.ap.pagelayer.SignupPage;
import com.odoo.ap.testbase.TestBase;

public class SignupTest extends TestBase {

	@Test
	public void validate_sign_up_entering_all_valid_inputs()
	{
		String expected_result = "https://ap-automation.odoo.com/my";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		SignupPage signuppage_obj = new SignupPage(driver);
		
		//------------------------------------------
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDonthaveAccountLink();
		signuppage_obj.enterEmailAddress("test3@gmail.com");
		signuppage_obj.enterUsername("testname1");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = driver.getCurrentUrl();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
		
			
	}
	
	@Test
	public void validate_sign_up_entering_invalid_inputs()
	{
		String expected_result = "user is already registered";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		SignupPage signuppage_obj = new SignupPage(driver);
		
		//------------------------------------------
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDonthaveAccountLink();
		signuppage_obj.enterEmailAddress("test2@gmail.com");
		signuppage_obj.enterUsername("testname1");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String error = loginpage_obj.getErrorMessage();
		System.out.println(error);
		boolean actual_result = error.contains(expected_result);
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, true);	
	}
}
