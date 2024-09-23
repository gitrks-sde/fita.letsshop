#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: Title of your feature
  I want to use this template for my feature file

  @Regression
  Scenario: User adding fashion product
  When user enter the email
  When user enter the password
  When user clicks on the login button
  Then check navigates to homepage
  When user add fashion product
  When user click on carts
  
  @parameterization
  Scenario Outline: User adding fashion product
    When user enter the email "wolverinek11@rahulshetty.com" with path "userEmail"
    When user enter the password
    When user clicks on the login button with id "loginButton"
    Then check navigates to homepage
    When user clicks on "<products>" product to add
    When user click on carts
    
    Examples:
				|products|
				|Zara|
				|AdIDas|
				|iphone|
