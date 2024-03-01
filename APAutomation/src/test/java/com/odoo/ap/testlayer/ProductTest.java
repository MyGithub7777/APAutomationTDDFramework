package com.odoo.ap.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.ap.pagelayer.Cartpage;
import com.odoo.ap.pagelayer.Checkoutpage;
import com.odoo.ap.pagelayer.Homepage;
import com.odoo.ap.pagelayer.Loginpage;
import com.odoo.ap.pagelayer.Paymentpage;
import com.odoo.ap.pagelayer.Shoppage;
import com.odoo.ap.testbase.TestBase;

public class ProductTest extends TestBase {

	@Test
	public void buyProductTest() throws InterruptedException
	{
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Shoppage shoppage_obj = new Shoppage(driver);
		Cartpage cartpage_obj = new Cartpage(driver);
		Checkoutpage checkoutpage_obj = new Checkoutpage(driver);
		Paymentpage paymentpage_obj = new Paymentpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmail("test1@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		logger.info("logged in");
		
		//------------------------
		homepage_obj.clickOnShopLink();
		shoppage_obj.clickOnHPLaptopLink();
		shoppage_obj.clickOnAddTocartbutton();
		
		logger.info("product added to cart");
		
		shoppage_obj.clickOnMycartlink();
		cartpage_obj.clickOnCheckoutButton();
		
		logger.info("checkout");
		
		checkoutpage_obj.fillExtraInfo("Faizan", "THis is very good product to use", "C:\\Users\\232338\\Downloads\\Document from Great Zone.pdf");
		Thread.sleep(5000);
		checkoutpage_obj.clickOnCheckoutButton();
		
		paymentpage_obj.enterCardDetails("4111121212121212");
		paymentpage_obj.clickOnPayButton();
		
		logger.info("placed order");
		
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Payment Status | testing");
		
		
	}
}
