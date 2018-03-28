package stepDefinitions;

import helpers.Hook;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Application_Pages.Adidas_Home_Page;
import Application_Pages.Men_BaseketBall_Shoes_Page;

public class Adidas_Verify_Search_Criteria_Price_Low_To_High {

	private WebDriver driver;
	Adidas_Home_Page homePage=new Adidas_Home_Page(driver);
	Men_BaseketBall_Shoes_Page menBaseketBallShoesPg=new Men_BaseketBall_Shoes_Page(driver);
	
	public Adidas_Verify_Search_Criteria_Price_Low_To_High() {
		this.driver = Hook.getDriver();
	}
	@When("^Open a browser and open Adidas online store site$")
	public void i_open_a_browser_and_open_policy_baazzar_site() throws Throwable {
		driver.get("https://shop.adidas.co.in/");
		
		System.out.println("Adidas site is opened successfully");
		Thread.sleep(3000);
	}
	
	@Then("^Verify Adidas online store Home Page$")
	public void Verify_Adidas_Online_Store_Home_Page() throws Throwable {
				
		System.out.println("Inside Adidas Online Store home page verification step");
		homePage=new Adidas_Home_Page(driver);
		homePage.verify_Adidas_Logo();
	}
	
	@And("^Hover over Men Menu$")
		public void Hover_Over_Men_Menu() throws Throwable {
		homePage.hover_Over_Men_Menu();		
		}
	
	@Then("^Verify Men Menu opens$")
	public void Verify_Men_Menu_opens() throws Throwable {
		homePage.verify_Men_FootWear_Menu_Display();
	}
	
	@Then("^Click on Basketball link$")
	public void Click_On_Basketball_Link() throws Throwable {		
		homePage.click_BaseketBall_Option();
	}
	
	@Then("^verify Men Basketball page appears$")
	public void Verify_Men_Basketball_Page_Appears() throws Throwable {
		menBaseketBallShoesPg = new Men_BaseketBall_Shoes_Page(driver);
		menBaseketBallShoesPg.verify_Men_BaseketBall_Shoes_Page_Appears();
		}
	
	@Then("^Validate Search Count of Men basketball$")
	public void Verify_Men_Basketball_Page_Search_Count() throws Throwable {
	
		menBaseketBallShoesPg.validate_Search_Count_Men_BasketBall_Shoes();
	}	
	
	@Then("^Click on Price Low to High button$")
	public void click_on_Price_Low_to_High_button() throws Throwable {
		menBaseketBallShoesPg.click_Price_Low_To_High();
	    
	}
	
	@And("^Verify Products are shown with lower to hightest price$")
	public void verify_Products_are_shown_with_lower_to_hightest_price() throws Throwable {
	   boolean flag=menBaseketBallShoesPg.verifyPriceLowestToHighest_MenBaseketBallShoes();
	   if(flag)
		  System.out.println("Men basketball shoes are correctly according to lowest to highest price"); 
	   else	   
		   System.out.println("Men basketball shoes are NOT correctly according to lowest to highest price");
	}

}