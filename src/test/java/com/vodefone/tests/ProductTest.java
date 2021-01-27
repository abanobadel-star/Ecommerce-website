package com.vodefone.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vodefone.pages.BlouseProductPage;
import com.vodefone.pages.Processcheckoutpage;

import junit.framework.Assert;

public class ProductTest extends TestBase {

	public ProductTest() throws IOException {
		super();
		
	}
	
	BlouseProductPage blouseobject;
	Processcheckoutpage processobject;
	
	@Test(priority=4)
	public void add_blouse_to_cart()
	{
		blouseobject=new BlouseProductPage(driver);
		blouseobject.add_product_to_cart();
		String ExpectedResult="Product";
		String ActualResult=blouseobject.successmessageproductaddtocart.getText();
		System.out.println(ActualResult);
		Assert.assertEquals(ExpectedResult, ActualResult);
		
	}
	
	@Test(priority=5)

	public void payment_checkout()
	{
		processobject=new Processcheckoutpage(driver);
		processobject.checkout_product();
		Assert.assertEquals("Your order on My Store is complete.",processobject.ordercompletemssage.getText());
	}

}
