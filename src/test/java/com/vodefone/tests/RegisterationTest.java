package com.vodefone.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vodefone.pages.Accountpage;
import com.vodefone.pages.BlouseProductPage;
import com.vodefone.pages.Homepage;
import com.vodefone.pages.Loginpage;
import com.vodefone.pages.Registerpage;

import Data.ExcelReader;
import Data.JsonDataReader;


public class RegisterationTest extends TestBase {

	public RegisterationTest() throws IOException {
		super();
		
	}
	Homepage homeobject;
	Registerpage registerobject;
	Loginpage loginobject;
	Accountpage accountobject;
	


	@DataProvider(name="register")             //data provider with link between script and execl sheet
	public Object[][] data_for_register() throws IOException      //method to pass data to testcase
	{
		ExcelReader excelreader=new ExcelReader();     //object from class execl reader
		return excelreader.getExcelData();         //to get and return  data from excel sheet

	}
	

	@Test(priority=1,dataProvider="register")
	public void CreateNewAccount(String fname,String lname,String email,String passwordnum,String day,String month,String year,String firstnameaddress,String lastnameaddress,
			String comapnyname,String address,String city,String state,String postal,String country,String phone,String alixaddress) throws IOException, ParseException
	{

		JsonDataReader jsonreader = new JsonDataReader();
        jsonreader.JsonReader();
        
        homeobject =new Homepage(driver);
		homeobject.openLoginPage();
		loginobject=new Loginpage(driver);
		loginobject.send_email_to_create_new_account(jsonreader.email);
		
		registerobject=new Registerpage(driver);
		registerobject.RegisterNewUser(fname, lname, jsonreader.email, jsonreader.password, day, month, year, firstnameaddress, lastnameaddress, comapnyname, address, city, state,  jsonreader.zipcode, country, jsonreader.mobile, alixaddress);
		String ExpectedResult="http://automationpractice.com/index.php?controller=my-account";
		String ActualResult=driver.getCurrentUrl();
		Assert.assertEquals(ExpectedResult, ActualResult);
		accountobject=new Accountpage(driver);
		accountobject.logout();
	}
}
