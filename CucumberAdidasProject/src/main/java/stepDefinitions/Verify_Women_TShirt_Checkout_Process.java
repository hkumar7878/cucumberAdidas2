package stepDefinitions;

import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Application_Pages.Add_To_Bag_Page;
import Application_Pages.Adidas_Home_Page;
import Application_Pages.Men_BaseketBall_Shoes_Page;
import Application_Pages.Sign_In_Page;
import Application_Pages.Women_TShirt_Page;
import Application_Pages.Your_Shopping_Bag_Page;

public class Verify_Women_TShirt_Checkout_Process{
	
	Adidas_Home_Page homePage;
	Women_TShirt_Page womenTshirtPage;
	Add_To_Bag_Page addToBagPage;
	Sign_In_Page signinPage;
	Your_Shopping_Bag_Page yourShoppingPage;
	public static WebDriver driver;
	String [] productDetails_SecondWindow=null;
	Hook hook;
	
	@Test
	@When("^Open a browser and open Adidas online store site$")
	public void i_open_a_browser_and_open_policy_baazzar_site() throws Throwable {
		
		try
		{
		
			driver=	Hook.getDriver();
			homePage=new Adidas_Home_Page(driver);
			System.out.println("Adidas site is opened successfully");
			Thread.sleep(3000);
		}
				
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Adidas online store Home Page$")
	public void Verify_Adidas_Online_Store_Home_Page() throws Throwable {
				
		try
		{
		System.out.println("Inside Adidas Online Store home page verification step");
		//homePage=new Adidas_Home_Page(driver);
		homePage.verify_Adidas_Logo();
		}
		
		catch(Exception e)
		
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
	
	@And("^Hover over Women Menu$")
		public void Hover_Over_Men_Menu() throws Throwable {
		String menuChoice="Women";
		homePage.hover_Over_Menu(menuChoice);		
		}
	
	@Then("^Verify Women Menu opens$")
	public void Verify_Men_Menu_opens() throws Throwable {
		homePage.verify_Women_Clothing_Menu_Display();
	}
	
	@Then("^Click on T Shirts link$")
	public void click_on_T_Shirts_link() throws Throwable {
	   homePage.click_WomenTShirt_Link();
	    
	}
	
	@Then("^verify Women T Shirt page appears$")
	public void verify_Women_T_Shirt_page_appears() throws Throwable {
		womenTshirtPage = new Women_TShirt_Page(driver);
		womenTshirtPage.verify_WomenTshirt_Pg_Header();
	  
	}

	@Then("^Scroll down to the bottom of the Page$")
	public void scroll_down_to_the_bottom_of_the_Page() throws Throwable {
		womenTshirtPage.scrollDown_WomenTshirtPg();
	   
	}

	@Then("^Click on navigation arrow button$")
	public void click_on_navigation_arrow_button() throws Throwable {
		womenTshirtPage.clickBtn_NextArrow();
	   
	}

	@Then("^Validate user is routed to second women tshirts page$")
	public void validate_user_is_routed_to_second_women_tshirts_page() throws Throwable {
		womenTshirtPage.verify_Pagination_LinkEnablity();
	   
	}

	@Then("^Click first Women Tshirt item$")
	public void click_first_Women_Tshirt_item() throws Throwable {
		productDetails_SecondWindow= womenTshirtPage.click_WomenTshirtProduct();
	  
	}

	@Then("^Verify correct selected product open in next window$")
	public void verify_correct_selected_product_open_in_next_window() throws Throwable {
		womenTshirtPage.compareWomenTshirtName();
	   
	}

	@Then("^Click on Add to bag button without selecting a size$")
	public void click_on_Add_to_bag_button_without_selecting_a_size() throws Throwable {
		womenTshirtPage.click_AddToBagButton();
	   
	}

	@Then("^Verify the validation message about the selection of size$")
	public void verify_the_validation_message_about_the_selection_of_size() throws Throwable {
	   womenTshirtPage.verify_AddToBag_ErrorMsg("please select a size");
	  
	}

	@Then("^Select the correct size and verify validation message disappears$")
	public void select_the_correct_size_and_verify_validation_message_disappears() throws Throwable {
	    womenTshirtPage.selectDesiredTshirtSize("30");
	   
	}

	@Then("^Now click on Add To Bag button$")
	public void now_click_on_Add_To_Bag_button() throws Throwable {
		womenTshirtPage.click_AddToBagButton();
	    
	}

	@Then("^Verify that user is routed to Bag page$")
	public void verify_that_user_is_routed_to_Bag_page() throws Throwable {
	   
		addToBagPage = new Add_To_Bag_Page(driver);
		addToBagPage.verify_AddToBag_ShoppingPage("YOUR SHOPPING BAG");
		
	}

	@Then("^Verify correctness of details for selected product$")
	public void verify_correctness_of_details_for_selected_product() throws Throwable {
		addToBagPage.compareSelectedProductDetails(productDetails_SecondWindow);
	    
	}

	@Then("^Click on Checkout button$")
	public void click_on_Checkout_button() throws Throwable {
		addToBagPage.click_CheckOut_Button();
	   
	}

	@Then("^Verify User is routed to Sign in page$")
	public void verify_User_is_routed_to_Sign_in_page() throws Throwable {
		signinPage = new Sign_In_Page(driver);
		signinPage.verify_Sign_In_Page("SIGN IN");
	   
	}
	
	@And("^Enter New Customer Details$")
	public void Enter_New_Customer_Details() throws Throwable {
		signinPage.enterCustomerDetails("Hitesh", "Ghai", "test@gmail.com", "test","test");
	   
	}

	@Then("^click on Continue as Guest User checkbox$")
	public void click_on_Continue_as_Guest_User_checkbox() throws Throwable {
	   signinPage.check_Guest_User_Checkbox();
	    
	}

	@Then("^Click on Continue as Guest button with entering the email id$")
	public void click_on_Continue_as_Guest_button_without_entering_the_email_id() throws Throwable {
	    signinPage.click_Continue_As_Guest_Btn();
	}
	
	@Then("^Verify that Your Shopping bag page appears$")
	public void Verify_that_Your_Shopping_bag_Page_appears() throws Throwable {
		
		yourShoppingPage = new Your_Shopping_Bag_Page(driver);
		yourShoppingPage.verify_Your_Shopping_Page_Appears();
	}

	

	
}