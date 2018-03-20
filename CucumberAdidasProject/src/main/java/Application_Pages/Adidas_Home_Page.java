package Application_Pages;


import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.ApplicationUtility;
import utility.GenericUtility;


public class Adidas_Home_Page extends Hook{
	
	ApplicationUtility appUtil;
	GenericUtility genUtil;
	
	public Adidas_Home_Page(WebDriver driver) {
		//this.driver = Hook.getDriver();
		this.driver = driver;
	    PageFactory.initElements(driver, this);
}
	
	@FindBy(how = How.XPATH, using = "//img[@id='logoImg']") 
	public WebElement logo_Adidas;
	
	@FindBy(how = How.XPATH, using = "//a[@id='MEN']") 
	public WebElement men_Menu;
	
	@FindBy(how = How.XPATH, using = "//a[@id='WOMEN']") 
	public WebElement women_Menu;
	
	@FindBy(how = How.XPATH, using = "//a[@id='MEN-FOOTWEAR']") 
	public WebElement men_FootWearMenu;
	
	@FindBy(how = How.XPATH, using = "//a[@id='WOMEN-CLOTHING']") 
	public WebElement women_ClothingMenu;
	
	@FindBy(how = How.XPATH, using = "(//a[@id='MEN-FOOTWEAR']/..)//following-sibling::ul/li/a[@href='https://shop.adidas.co.in/#c/men-basketball-shoes/Pag-60/No-0/0']") 
	public WebElement basketBallLink;
	
	@FindBy(how = How.XPATH, using = "(//a[@id='WOMEN-CLOTHING']/..)//following-sibling::ul/li/a[@href='https://shop.adidas.co.in/#c/women-tshirt/Pag-60/No-0/0']") 
	public WebElement tShirtsLink;
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchTextBox']") 
	public WebElement txtBox_Search;
	
	
	public void verify_Adidas_Logo()
	{
		try
		{
			Assert.assertTrue(logo_Adidas.isDisplayed(), "PB home page is not displayed");
			System.out.println("Adidas online store HOME Page is displayed successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void hover_Over_Menu(String menuType)
	{
	
		try
		{
				switch(menuType) {
		
					case "Men" :
						//genUtil.menuSelection(driver, men_FootWearMenu);
						//	GenericUtility.menuSelection(driver, we);
						break;
				
				case "Women":					
					genUtil.menuSelection(driver,women_Menu);
					System.out.println("Exception");
					break;
					
					
					//menuSelection(driver,women_Menu);
					//  GenericUtility.menuSelection(driver, women_Menu);
					    //appUtil.menuSelection(driver, women_Menu);
			    
			    
		default: 
			System.out.println("Default Case");
			
		 }	
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void menuSelection(WebDriver driver1,WebElement women_Menu1)
	{
		System.out.println("Inside Women Menu Selection");
	}
	public void verify_Men_FootWear_Menu_Display()
	{
		//WebElement menWear=driver.findElement(By.xpath("//a[@id='MEN-FOOTWEAR']"));

		boolean flag=men_FootWearMenu.isDisplayed();
		Assert.assertTrue(flag, "Men Wear drop down is not displayed");
		System.out.println("Men Wear drop down is displayed successfully");
	}
	
	public void verify_Women_Clothing_Menu_Display()
	{
		//WebElement menWear=driver.findElement(By.xpath("//a[@id='MEN-FOOTWEAR']"));
		try
		{
		
			boolean flag=women_ClothingMenu.isDisplayed();
			Assert.assertTrue(flag, "Women Clothing menu drop down is not displayed");
			System.out.println("Women Clothing menu drop down is displayed successfully");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void click_BaseketBall_Option()
	{
		//WebElement basketBallLink=driver.findElement(By.xpath("(//a[@id='MEN-FOOTWEAR']/..)//following-sibling::ul/li/a[@href='https://shop.adidas.co.in/#c/men-basketball-shoes/Pag-60/No-0/0']"));
		if(basketBallLink.isDisplayed())
		{
			basketBallLink.click();
			
			//WebElement searchBox=driver.findElement(By.xpath("//input[@id='searchTextBox']"));
			if(txtBox_Search.isDisplayed())
			{
				txtBox_Search.click();
				System.out.println("Search box is clicked successfully");
			}
			
			else
			{
				System.out.println("Search box is not displayed");
			}
		}
		
		else
			System.out.println("Basketball link is not displayed");
		}
	
	public void click_WomenTShirt_Link()
	{
		//WebElement basketBallLink=driver.findElement(By.xpath("(//a[@id='MEN-FOOTWEAR']/..)//following-sibling::ul/li/a[@href='https://shop.adidas.co.in/#c/men-basketball-shoes/Pag-60/No-0/0']"));
		if(tShirtsLink.isDisplayed())
		{
			tShirtsLink.click();
			
			//WebElement searchBox=driver.findElement(By.xpath("//input[@id='searchTextBox']"));
			if(txtBox_Search.isDisplayed())
			{
				txtBox_Search.click();
				System.out.println("Search box is clicked successfully");
			}
			
			else
			{
				System.out.println("Search box is not displayed");
			}
		}
		
		else
			System.out.println("Basketball link is not displayed");
		}
}
