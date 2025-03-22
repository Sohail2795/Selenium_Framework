package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;   // WebDriver instance, which is used to interact with the browser.
	
	public BasePage(WebDriver driver)   // Constructor takes the WebDriver instance as a parameter and initializes the driver field.
	{
		this.driver = driver;   // this.driver refers to the instance variable driver of the BasePage class.
		//   driver is the parameter passed into the constructor.

		PageFactory.initElements(driver, this); // PageFactory is used to initialize all the web elements that are defined in the page class. 
		// It will locate elements using annotations like @FindBy
	}

}