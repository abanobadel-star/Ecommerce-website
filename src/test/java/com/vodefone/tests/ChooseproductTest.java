package com.vodefone.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vodefone.pages.Accountpage;

public class ChooseproductTest extends TestBase {

	public ChooseproductTest() throws IOException {
		super();
		
	}

	Accountpage accountobject;
	
	@Test(priority=4)
	public void SelectBlouse()
	{
		accountobject=new Accountpage(driver);
		accountobject.chooseBlousesPage();
       
		
	}
}
