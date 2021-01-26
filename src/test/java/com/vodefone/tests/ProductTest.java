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
	
	@Test(priority=5)
	public void add_blouse_to_cart()
	{
		blouseobject=new BlouseProductPage(driver);
		blouseobject.add_product_to_cart();
	}
	
	@Test(priority=6)

	public void payment_checkout()
	{
		processobject=new Processcheckoutpage(driver);
		processobject.checkout_product();
		Assert.assertEquals("Your order on My Store is complete.",processobject.ordercompletemssage.getText());
	}

}
