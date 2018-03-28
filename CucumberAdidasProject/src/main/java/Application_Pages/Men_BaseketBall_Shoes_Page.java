package Application_Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.GenericUtility;

public class Men_BaseketBall_Shoes_Page {
	
	WebDriver driver;
	
	public Men_BaseketBall_Shoes_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	List<String>  MenbasketBallShoesPrices = new ArrayList<String>();
	List<String>  basketBallShoesPrices1 = new ArrayList<String>();
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchTextBox']") 
	public WebElement hd_menBasketball;
	
	@FindBy(how = How.XPATH, using = "//div[@id='searchResultHeader']/span") 
	public WebElement searchedRsult;
	
	////a[text()='Price Low to High']
	
	@FindBy(how = How.XPATH, using = "//a[text()='Price Low to High']") 
	public WebElement lnk_PriceLowToHigh;
	
	@FindBy(how = How.XPATH, using = "//span[@class='PLPPriceColor']") 
	private List<WebElement> hd_MenBBShoesPrice;
	
	public void verify_Men_BaseketBall_Shoes_Page_Appears()
	{
		
		if(hd_menBasketball.isDisplayed())
		{
			String menBasketballText=hd_menBasketball.getText();
			String pageTitle=driver.getTitle();
			if(menBasketballText.contains("basketball shoes") && pageTitle.contains("Buy adidas Basketball"))
			{
				System.out.println("Landed on Menbasketball page correctly");
			}
			
			else
				System.out.println("Failed to display Menbasketball page");
			
				
		}
		else
		{
			System.out.println("Not Landed on Menbasketball page");
		}
		
		}
	
	public void validate_Search_Count_Men_BasketBall_Shoes()
	{
		List<WebElement> noOfSearchedShoes=driver.findElements(By.xpath("//div[@id='searchTemplateDiv']/div/ul/li/div/a"));
		int noOfSearchedShoesCount=noOfSearchedShoes.size();
		System.out.println("Searched results are " + searchedRsult.getText());
		String searchResulStrings=searchedRsult.getText();
		String s2=searchResulStrings.trim();
		String[] arrSplit = s2.split(" ");
		String count=null;
		for (String s: arrSplit)
		{
			//if(!s.equals(" "))
			{
				if(Integer.parseInt(s)==noOfSearchedShoesCount)
			{
				count=s;
				System.out.println("Count of number of shoes are matching");
				break;
			}
			
			else {
				System.out.println("Count of number of shoes are not matching");
			}
			
		}
			System.out.println("Total shoes baseket count is " + count);
	}
 }
	
	public void click_Price_Low_To_High()
	{
		if(lnk_PriceLowToHigh.isDisplayed())
		{
			System.out.println("Price low to high link is displayed");
			lnk_PriceLowToHigh.click();
			GenericUtility.wait_pageToLoad(driver,lnk_PriceLowToHigh,"elementClickable",10,"");
		}
		
		else
		{
			System.out.println("Price low to high link is NOT displayed");
		}
	}
	
	public boolean verifyPriceLowestToHighest_MenBaseketBallShoes()
	{
		boolean flag=true;
		
		List<Integer> sortedPrices=new ArrayList<Integer>();
		try
		{
		
			int i,j;
			
			for(int k=0;k<hd_MenBBShoesPrice.size();k++)
				{
					String str1_BaseketBallPr=hd_MenBBShoesPrice.get(k).getText().trim();
					String str1_BaseketBallPr2=str1_BaseketBallPr.replace("RS."," ").trim();
					String str1_BaseketBallPr3=str1_BaseketBallPr2.replace(",", "");
		
					basketBallShoesPrices1.add(str1_BaseketBallPr3);
				}
			System.out.println(basketBallShoesPrices1);
		
			for (i=1,j=0;i<basketBallShoesPrices1.size();i++,j++)
				{
					
				//int p =sortedPrices.get(i-1);
				//int n =sortedPrices.get(i);
				if(Integer.parseInt(basketBallShoesPrices1.get(i-1))<=Integer.parseInt(basketBallShoesPrices1.get(i)))
				//if(p<=n)
						{
							flag=true;
							System.out.println(basketBallShoesPrices1.get(j));	
							if(i==basketBallShoesPrices1.size()-1)
								System.out.println(basketBallShoesPrices1.get(i));			
						}		
					else 
					{
						flag=false;
						break;
					}
			
		
		
		}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
		
		
		
		
	}
	
	
}

