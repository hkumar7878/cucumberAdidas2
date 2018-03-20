package utility;

import helpers.Hook;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtility {
	
//static WebDriver driver;
	
	/*public GenericUtil(WebDriver driver) {
		//this.driver=driver;
		this.driver = Hook.getDriver();
	    //PageFactory.initElements(driver, this);
	}
*/
	public static void menuSelection(WebDriver driver,WebElement we)
	{
		
		
		try 
		{
			
			Actions Action= new Actions(driver);
			Action.moveToElement(we).build().perform();
			Thread.sleep(5000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void wait_pageToLoad(WebDriver driver, WebElement we,String waitTypeOption,int timeToWait)
	{
		switch (waitTypeOption) 
		{
			case "elementClickable":
			
			WebDriverWait wait=new WebDriverWait(driver,timeToWait);
			WebElement we1=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(we));
			break;
		
		default:		
			break;
		}
	}
	
	public static void pageScrollDown(WebDriver driver,WebElement we)
	{
		
		try
		{
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,12250)", "");
		js.executeScript("arguments[0].scrollIntoView();", we);
		System.out.println("Page is scrolled successfully");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void clickBtn(WebElement we)
	{
		try
		{
			if(we.isDisplayed() && we.isEnabled())
			{
				we.click();
			}
			
			else
			{
				System.out.println(we + "button is not displayed or enabled");
			}
		}
	
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}