package Application_Pages;


import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.GenericUtility;

public class Add_To_Bag_Page extends Hook {
	
	GenericUtility genUtil;
	public Add_To_Bag_Page(WebDriver driver) 
	{
		
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//h1[text()='your shopping bag']") 
	public WebElement hd_ShoppingBag;
	
	@FindBy(how = How.XPATH, using = "//p[@class='prod-detail-cart']//a") 
	public WebElement txt_TshirtName;
	
	@FindBy(how = How.XPATH, using = "//td[@class='center']/div") 
	public WebElement txt_TshirtPrice;
	
	
	@FindBy(how = How.XPATH, using = "//button[@button='checkForRedirectBtn']") 
	public WebElement btn_Checkout;
	
	
	
	public void verify_AddToBag_ShoppingPage(String pg_Header_Txt)
	{
		boolean flag=false;
		flag=genUtil.pg_Header_Verification(hd_ShoppingBag, pg_Header_Txt);
		if(flag)
			System.out.println("Correct Add to bag page is displayed ");
		else
		{
			System.out.println("Correct Add to bag page is NOT displayed ");
			return;
		}
	}
	
	public void compareSelectedProductDetails(String [] prodDetails)
	{
		
		String tshirtName_ShopingBag_Pg=prodDetails[0].toUpperCase();
		String tshirtprice_ShopingBag_Pg=prodDetails[1].toUpperCase();
		System.out.println(tshirtName_ShopingBag_Pg);
		System.out.println(tshirtprice_ShopingBag_Pg);
		if(tshirtName_ShopingBag_Pg.equals(txt_TshirtName.getText()) && tshirtprice_ShopingBag_Pg.equals(txt_TshirtPrice.getText()))
			System.out.println("Correct product is being displayed on the Add to bag shopping page");
		else
			System.out.println("Correct product is NOT being displayed on the Add to bag shopping page");
	}
	
	public void click_CheckOut_Button()
	{
		try
		{
			genUtil.clickBtn(btn_Checkout);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}