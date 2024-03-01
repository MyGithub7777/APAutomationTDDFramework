package com.odoo.ap.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

	private WebDriver driver;
	public SignupPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//------------ Obj repo ------------
	
	private By email_textbox = By.xpath("//input[@id='login']");
	private By name_textbox = By.xpath("//input[@id='name']");
	private By password_textbox = By.xpath("//input[@id='password']");
	private By confirm_password_textbox = By.xpath("//input[@id='confirm_password']");
	private By signup_btn = By.xpath("//button[contains(text(),'Sign up')]");
	
	//------------ Action Methods ------
	
	public void enterEmailAddress(String email)
	{
		driver.findElement(email_textbox).sendKeys(email);
	}
	
	public void enterUsername(String name)
	{
		driver.findElement(name_textbox).sendKeys(name);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(password_textbox).sendKeys(password);
	}
	
	public void enterConfirmPassword(String c_password)
	{
		driver.findElement(confirm_password_textbox).sendKeys(c_password);
	}
	
	public void clickOnSignupButton()
	{
		driver.findElement(signup_btn).click();;
	}
}
