package com.odoo.ap.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//----------- Obj repo --------------	
	@FindBy(xpath = "//input[@id='login']")
	private WebElement email_textbox;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_textbox;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement login_btn;
	
	@FindBy(xpath="//p[@class='alert alert-danger']")
	private WebElement error_message;
	
	@FindBy(xpath="//a[contains(text(),\"Don't have an account?\")]")
	private WebElement create_acc_link;
	
	//--------- action methods -------------
	
	public void enterEmail(String email)
	{
		email_textbox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		password_textbox.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		login_btn.click();
	}
	
	public String getErrorMessage()
	{
		return error_message.getText();
	}
	
	public void clickOnDonthaveAccountLink()
	{
		create_acc_link.click();
	}
}
