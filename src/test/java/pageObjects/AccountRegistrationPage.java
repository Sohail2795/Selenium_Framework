package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
		
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id=\"input-confirm\"]")
	WebElement txtPasswordConfirm;
	
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement clkPolicy;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")  
	// When you're dealing with text in HTML elements, there might be extra spaces, tabs, or newlines before or after the actual content, which can interfere with finding the element using a simple XPath. 
	// The normalize-space() function ensures that you match the element based on its actual content, ignoring any unnecessary whitespace..
	WebElement msgConfirmation;

	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cpwd)
	{
		txtPasswordConfirm.sendKeys(cpwd);
	}
	
	public void setPrivacyPolicy()
	{
		clkPolicy.click();
	}
	
	public void clickContinue()
	{
//		sol1 :
		btnContinue.click();
		
//		sol2 :
//		btnContinue.submit();
		
//		sol3 :
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();
		
//		sol4 :
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("argument[0].click();", btnContinue);
		
//		sol5 :
//		btnContinue.sendKeys(Keys.RETURN);
		
//		sol6 :
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click());
		
	}
	
		public String getConfirmationMsg()
		{
			try 
			{
				return (msgConfirmation.getText());
			}
			catch (Exception e)
			{
				return (e.getMessage());   // getMessage() method returns the exception message
			}
		}
	}