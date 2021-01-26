package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageBase {

	public Homepage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Sign in")
	WebElement signinbutton;
	
	@FindBy(css="h3.page-subheading")
	public WebElement successuserenteremail;
	
	public void openLoginPage() //method to open login page
	{
		signinbutton.click();
	}
	

}
