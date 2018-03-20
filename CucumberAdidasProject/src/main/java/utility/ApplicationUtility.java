package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ApplicationUtility {
	WebDriver driver;
	
	public ApplicationUtility(WebDriver driver) {
		this.driver=driver;
	    
	}
	public void menuSelection(WebDriver driver,WebElement we)
	{
		
		
		try {
			
		Actions Action= new Actions(driver);
		Action.moveToElement(we).build().perform();
		Thread.sleep(5000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
