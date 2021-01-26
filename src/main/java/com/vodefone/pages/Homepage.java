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
	
	public void openLoginPage() //method to open login page
	{
		//clickonbutton(signinbutton);
		signinbutton.click();
	}
	

}
