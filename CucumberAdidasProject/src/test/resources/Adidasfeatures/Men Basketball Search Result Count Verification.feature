
#@FunctionalTest
Feature: Men Basketball Test Cases feature


	#@web
	@RegressionTest1
  Scenario: Validate Basketball Search Result Count Verification
    When Open a browser and open Adidas online store site
    Then Verify Adidas online store Home Page
    And Hover over Men Menu
    Then Verify Men Menu opens
    Then Click on Basketball link
    Then verify Men Basketball page appears
    Then Validate Search Count of Men basketball
    
  @RegressionTest2
  Scenario: Validate Men's Basketball shoes price Low to high filter
    When Open a browser and open Adidas online store site
    Then Verify Adidas online store Home Page
    And Hover over Men Menu
    Then Verify Men Menu opens
    Then Click on Basketball link
    Then verify Men Basketball page appears
    Then Validate Search Count of Men basketball
    Then Click on Price Low to High button
    And Verify Products are shown with lower to hightest price
    
  @RegressionTest3
  Scenario: Validate the placing of order of Women's T-Shirt
   When Open a browser and open Adidas online store site
   Then Verify Adidas online store Home Page
   And Hover over Women Menu
   Then Verify Women Menu opens
   Then Click on T Shirts link
   Then verify Women T Shirt page appears
   And Scroll down to the bottom of the Page
   And Click on navigation arrow button
   Then Validate user is routed to second women tshirts page
   Then Click first Women Tshirt item
   And Verify correct selected product open in next window
   Then Click on Add to bag button without selecting a size
   Then Verify the validation message about the selection of size
   Then Select the correct size and verify validation message disappears
  	And Now click on Add To Bag button
  	Then Verify that user is routed to Bag page
   And Verify correctness of details for selected product
  Then Click on Checkout button
  And Verify User is routed to Sign in page
  Then Enter New Customer Details
  Then click on Continue as Guest User checkbox
   And Click on Continue as Guest button with entering the email id
   Then Verify that Your Shopping bag page appears
 
    
    
    
    
    
    
    