package com.odoo.ap.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odoo.ap.utility.CommonMethods;

public class Shoppage {

	public Shoppage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//==================0bj repo==================
	@FindBy(xpath="//a[contains(text(),'HP Laptop 15s, 12th Gen Intel')]")
	private WebElement hp_laptop_link;
	
	@FindBy(xpath="//a[@id='add_to_cart']")
	private WebElement add_to_cart_button;
	
	@FindBy(xpath="//span[contains(text(),'My Cart')]")
	private WebElement my_cart_link;
	
	
	//================action methods ==================
	public void clickOnHPLaptopLink()
	{
		hp_laptop_link.click();
	}
	public void clickOnAddTocartbutton()
	{
		add_to_cart_button.click();
	}
	public void clickOnMycartlink()
	{
		CommonMethods.waitForElementToBeClickablle(my_cart_link).click();
//		my_cart_link.click();
	}
}
