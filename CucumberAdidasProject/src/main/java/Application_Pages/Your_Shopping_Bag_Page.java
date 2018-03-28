package Application_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.GenericUtility;
import helpers.Hook;

public class Your_Shopping_Bag_Page extends Hook{

	GenericUtility genUtil;
	public Your_Shopping_Bag_Page(WebDriver driver) 
	{
		
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//h1[text()='your shopping bag']") 
	public WebElement hd_ShoppingBag;
	
	
	public void verify_Selected_Product_Details()
	{
		
	}
	
	public void verify_Your_Shopping_Page_Appears()
	{
		
		boolean flag;
		genUtil.wait_pageToLoad(driver, hd_ShoppingBag, "", 20, "//h1[text()='your shopping bag']");
		flag=genUtil.pg_Header_Verification(hd_ShoppingBag, "YOUR SHOPPING BAG");
		if(flag)
			System.out.println("User is routed to correct page i.e Your Shopping bag page");
		else
			System.out.println("User is NOT routed to correct page i.e Your Shopping bag page");
	}
	
}
