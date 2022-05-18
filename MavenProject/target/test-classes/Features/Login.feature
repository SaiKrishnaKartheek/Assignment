
@Assignment
Feature: Sauce Demo Validations
  I want to use this template for my feature file


  @scenario_1
  Scenario Outline: To verify adding multiple options in cart and checkout
    Given user is on saucedemo homepage
    And user logged in using "<username>" , "<password>" credentials
     
     And user adds required item to cart
     And user proceeds to checkout
     And user enters "<FirstName>" , "<LastName>" , "<PostalCode>" details for checkout
     When User Confirms checkout
     Then User Verify Final Confirmation Message
     
     Examples: 
      | username  		| password 		|FirstName | LastName | PostalCode |
      | standard_user |secret_sauce | abc      | def      |     400087 |
      
   
      
     @scenario_2
  Scenario Outline: To verify adding removing then adding and checkout
  	Given user is on saucedemo homepage
    And user logged in using "<username>" , "<password>" credentials
    And user adds one item and then remove that item to go back
    And user adds required item to cart
     And user proceeds to checkout
     And user enters "<FirstName>" , "<LastName>" , "<PostalCode>" details for checkout
     When User Confirms checkout
     Then User Verify Final Confirmation Message
    
     Examples: 
      | username  		| password 		|FirstName | LastName | PostalCode |
      | standard_user |secret_sauce | abc      | def      |     400087 |
      
   	@scenario_3
  	Scenario Outline: To verify adding removing then adding and checkout
	  	Given user is on saucedemo homepage
	    And user logged in using "<username>" , "<password>" credentials
	    And user sorts item low to high
	    And user adds required item to cart
	    And user proceeds to checkout
	    And user enters "<FirstName>" , "<LastName>" , "<PostalCode>" details for checkout
	    When User Confirms checkout
	    Then User Verify Final Confirmation Message
    
     Examples: 
      | username  		| password 		|FirstName | LastName | PostalCode |
      | standard_user |secret_sauce | abc      | def      |     400087 |
    
  	