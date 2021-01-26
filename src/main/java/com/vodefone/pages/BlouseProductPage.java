package com.vodefone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BlouseProductPage extends PageBase {

	public BlouseProductPage(WebDriver driver) {
		super(driver);
		Action=new Actions(driver);
	}
	@FindBy(xpath="//img[@title='Blouse']")
	WebElement blouseproduct;
	
	@FindBy(xpath="//a[@title='Add to cart']")
	WebElement addtocartbutton;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedtocheckoutbutton;
	
	@FindBy(css="span.ajax_cart_product_txt ")
	public WebElement successmessageproductaddtocart;
	
	
	public void add_product_to_cart()
	{
		Action.moveToElement(blouseproduct).build().perform();
		addtocartbutton.click();
		proceedtocheckoutbutton.click();
	}

}
