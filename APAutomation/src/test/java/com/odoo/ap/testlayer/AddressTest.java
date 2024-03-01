package com.odoo.ap.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.ap.pagelayer.AccountDetailpage;
import com.odoo.ap.pagelayer.Accountpage;
import com.odoo.ap.pagelayer.Homepage;
import com.odoo.ap.pagelayer.Loginpage;
import com.odoo.ap.testbase.TestBase;

public class AddressTest extends TestBase {

	@Test
	public void addNewAddress()
	{
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmail("test1@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		//-------------------------------------
		Accountpage accountpage_obj = new Accountpage(driver);
		AccountDetailpage accountdetail_obj = new AccountDetailpage(driver);
		
		accountpage_obj.clickOnAddressLink();
		accountdetail_obj.fillAllAddressDetails("testname1", "test1@gmail.com", "company 2", "1234656885", "Madhya Pradesh State Highway 100", "Indore", "481880", "India", "Madhya Pradesh");
		accountdetail_obj.clickOnSaveButton();
		
		Assert.assertEquals(accountpage_obj.getTextFromPage(), "company 2");
	}
//	
//	@Test
//	public void editAddress()
//	{
//		
//	}
}
