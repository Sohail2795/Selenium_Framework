package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
		
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMYAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstname(randomString());
		regpage.setLastname(randomString());
		regpage.setEmail(randomString() + "@gmail.com");  
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumberic();
				
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		Thread.sleep(3000);
		regpage.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug loads..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
	}
}