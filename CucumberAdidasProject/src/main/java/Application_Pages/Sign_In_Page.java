package Application_Pages;

import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.GenericUtility;

public class Sign_In_Page  extends Hook{
	
	GenericUtility genUtil;
	public Sign_In_Page(WebDriver driver) 
	{
		
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//h1[text()='your shopping bag']") 
	public WebElement hd_ShoppingBag;
	
	@FindBy(how = How.ID, using = "userName") 
	public WebElement input_firstName;
	
	@FindBy(how = How.ID, using = "surName") 
	public WebElement input_lastName;
	
	@FindBy(how = How.ID, using = "email") 
	public WebElement input_Email;
	
	@FindBy(how = How.ID, using = "password") 
	public WebElement input_pswd;
	
	@FindBy(how = How.ID, using = "confirmPwd") 
	public WebElement input_reTypepswd;
	
	@FindBy(how = How.ID, using = "gender3") 
	public WebElement radialBtn_Gender;
	
	@FindBy(how = How.ID, using = "guestCheck") 
	public WebElement checkBox_GuestUser;
	
	@FindBy(how = How.ID, using = "guestRegisterButton") 
	public WebElement btn_ContAsGuestUser;
	
	
	
	

	public void verify_Sign_In_Page(String signInPgHeader)
	{
		boolean flag=false;
		flag=genUtil.pg_Header_Verification(hd_ShoppingBag, signInPgHeader);
		if(flag)
		{
			System.out.println("Correct Add to bag page is displayed ");
		}
		else
		{
			System.out.println("Correct Add to bag page is NOT displayed ");
			return;
		}
	}
	
	public void enterCustomerDetails(String fName,String lName,String email,String pswd,String rePswd)
	{
		genUtil.enterText(input_firstName, fName);
		genUtil.enterText(input_lastName, lName);
		genUtil.enterText(input_pswd, email);
		genUtil.enterText(input_pswd, pswd);
		genUtil.enterText(input_reTypepswd, rePswd);
	}
	
	public void check_Guest_User_Checkbox()
	{
		genUtil.check_Checkbox(checkBox_GuestUser);
		System.err.println("Gueset user checkbox is selected");
	}
	
	public void click_Continue_As_Guest_Btn()
	{
		genUtil.clickBtn(btn_ContAsGuestUser);
	}
}
