package Application_Pages;

import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import utility.GenericUtility;

public class Women_TShirt_Page extends Hook{
	
	GenericUtility genUtil;
	public Women_TShirt_Page(WebDriver driver) 
	{
		
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//h1[text()='women-tshirt']") 
	public WebElement hd_womenTshirt;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='sorting_pagination'])[last()]") 
	public WebElement pagiation_Section;
	
	@FindBy(how = How.XPATH, using = "(//a[@title='Next'])[last()]") 
	public WebElement btn_Arrow;
	
	@FindBy(how = How.XPATH, using = "(//li[@class='col-md-3 img-thumbnail card'])[last()]") 
	public WebElement img_Last;  // this webelemt is used to scroll till pagination section
	
	
	
	public void verify_WomenTshirt_Pg_Header()
	{
		try
		{
		
		boolean isEventSuccess=false;
		if(hd_womenTshirt.isDisplayed())
		{
			isEventSuccess=true;
		}
		
		else
		{
			isEventSuccess=false;
		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void scrollDown_WomenTshirtPg()
	{
		
		try
		{
			genUtil.pageScrollDown(driver,img_Last);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void clickBtn_NextArrow()
	{
		try
		{
			genUtil.clickBtn(btn_Arrow);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
