package Application_Pages;

import java.util.List;



import helpers.Hook;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import test.tmp.AssertEqualsTest;
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
	
	@FindBy(how = How.XPATH, using = "//ul[@id='pager1']/li[@class='current']") 
	public WebElement txt_PageNumber;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='plpDiv']//a[@class='productIdentifier productImageWrap'])[1]") 
	public WebElement img_FirstWomenTShirtProduct_ParentWindow;
	
	@FindBy(how = How.XPATH, using = "(//li[@class='col-md-3 img-thumbnail card']/div//ul//li//span[contains(@class,'PLPPriceColor')])[1]") 
	public WebElement txt_FirstWomenTShirtPrice_ParentWindow;
	
	
	@FindBy(how = How.XPATH, using = "(//ul[@class='productDescription clearfix productRowList']//li//a)[1]") 
	public WebElement txt_FirstWomenTShirtName_ParentWindow;
	
	@FindBy(how = How.XPATH, using = "//div[@id='productBody']//div[@id='productName']") 
	public WebElement txt_FirstTShirtProduct_Name_SecondWindow;

	
	@FindBy(how = How.XPATH, using = "//div[@id='productBody']//span[@id='currentPrice']") 
	public WebElement txt_FirstWomenTShirtPrice_SecondWindow;
	
	
	@FindBy(how = How.XPATH, using = "//button[@class='addToBagBtn']") 
	public WebElement btn_addToBag_SecondWindow;
	
	@FindBy(how = How.XPATH, using = "//div[@id='errorMessage']") 
	public WebElement txt_addToBag_Validation_Msg_SecondWindow;
	
	@FindBy(how=How.XPATH,using="//label[@class='productSizeLabel']")
	private List<WebElement> label_WomenTshirtSizes_SecondWindow;
	
	String womenTShirtName_Txt_ParentWindow;
	String womenTShirtPrice_Txt_ParentWindow;
	String womenTShirtName_Txt_SecondWindow;
	String womenTShirtPrice_Txt_SecondWindow;
	String womenTShirtPrice_Txt_SecondWindow1;
	
	
	
	
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
	
	public void verify_Pagination_LinkEnablity()
	{
		boolean flag;
		
		try
		{
		if(!txt_PageNumber.isEnabled())
		{
			flag=true;
			Thread.sleep(3000);
			System.out.println("Pagination page is disabled: User navigated to correct navigated page");
		}
		
		else
		{
			flag=false;
		}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String [] click_WomenTshirtProduct()
	{
		
		//commiting latest changes
		try
		{
			
			String [] productDetails;
			genUtil.wait_pageToLoad(driver, img_FirstWomenTShirtProduct_ParentWindow, "elementClickable", 30,"");
			Thread.sleep(3000);
			womenTShirtName_Txt_ParentWindow=genUtil.getElementText(txt_FirstWomenTShirtName_ParentWindow);
			womenTShirtPrice_Txt_ParentWindow=genUtil.getElementText(txt_FirstWomenTShirtPrice_ParentWindow);
			//genUtil.clickBtn_ActionClass(driver,img_FirstWomenTShirtProduct_ParentWindow);
			genUtil.clickBtn_JavaScript(driver,img_FirstWomenTShirtProduct_ParentWindow);
			genUtil.switchToBrowserTab(driver);
			womenTShirtName_Txt_SecondWindow=genUtil.getElementText(txt_FirstTShirtProduct_Name_SecondWindow);
			womenTShirtPrice_Txt_SecondWindow=genUtil.getElementText(txt_FirstWomenTShirtPrice_SecondWindow);
			womenTShirtPrice_Txt_SecondWindow1= womenTShirtPrice_Txt_SecondWindow.substring(0, 8);
			System.out.println(womenTShirtPrice_Txt_SecondWindow1);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new String [] {womenTShirtName_Txt_SecondWindow,womenTShirtPrice_Txt_SecondWindow1};
	}
	
	public void compareWomenTshirtName()
	{
		boolean flag,flag1 = false;
		flag=GenericUtility.campareText(womenTShirtName_Txt_ParentWindow, womenTShirtName_Txt_SecondWindow);
		flag1=GenericUtility.equalsText(womenTShirtPrice_Txt_ParentWindow, womenTShirtPrice_Txt_SecondWindow1);
		if(flag && flag1)
				System.out.println("Correct product is opened in new window");
		else
			System.out.println("Correct product is NOT opened in new window");
		}
	
	public void click_AddToBagButton()
	{
		genUtil.clickBtn(btn_addToBag_SecondWindow);
	}
	
	public void verify_AddToBag_ErrorMsg(String exp_ErrMsg)
	{
		
		try
		{
		boolean flag=false;
		String act_ErrMsg=txt_addToBag_Validation_Msg_SecondWindow.getText();
		flag=GenericUtility.campareText(exp_ErrMsg, act_ErrMsg);
		Assert.assertTrue(flag);
		System.out.println("Proper Valiation Message" + exp_ErrMsg + "is displayed");
		}
		
		catch(Exception e)
		{
			System.out.println("Proper Valiation Message" + exp_ErrMsg + "NOT is displayed");
			e.printStackTrace();
		}
		
	}
	
	public void selectDesiredTshirtSize(String size)
	
	{
		boolean flag=false;
		for (WebElement tShirtSize: label_WomenTshirtSizes_SecondWindow)
		{
			if(tShirtSize.isEnabled() && tShirtSize.getText().equals(size))
			{
				genUtil.clickBtn(tShirtSize);
				flag=true;
				System.out.println("Size"  + size + "is available");
				break;
			}
			
		}
		
		if(!flag)
		{
			for (WebElement tShirtSize: label_WomenTshirtSizes_SecondWindow)
			{
				if(tShirtSize.isEnabled())
				{
					genUtil.clickBtn(tShirtSize);
					System.out.println("Size"  + size + "is not available hence clicked on other available size");
					break;
				}
				
			} 
		}
	}

}