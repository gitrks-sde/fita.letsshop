#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: 
  letsshop web application automation

  #Background: 
    #Given Letsshop URL is loaded
    #When user enter the email
    #When user enter the password
    #When user clicks on the login button
    
	@smoke
  Scenario: User login with valid credential
    When user enter the email
    When user enter the password
    When user clicks on the login button
    Then check navigates to homepage

	@Regression @test
  Scenario: User adding electronic product
    When user enter the email
    When user enter the password
    When user clicks on the login button
    Then check navigates to homepage
    When user add electronic product
    When user click on carts
    

