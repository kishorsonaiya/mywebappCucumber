Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User enters UserName and Password
	Then Message displayed Login Successfully