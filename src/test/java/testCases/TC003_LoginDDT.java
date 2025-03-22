package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")   // getting data provider from different package and class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("**** Starting TC003_LoginDDT ****");
		try
		{
//		HomePage :
		HomePage hp = new HomePage(driver);
		hp.clickMYAccount();
		hp.clickLogin();
		
//		Login :
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.setLogin();
		
//		My Account :
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
// 		Data is Valid - login success - test pass - logout
//		login failed - test fail 

//		Data is InValid - login success - test fail - logout
//      login failed - test pass 
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("InValid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}

}