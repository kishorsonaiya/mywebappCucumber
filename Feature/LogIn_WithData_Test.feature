Feature: Login Action

Scenario Outline: Successful Login with Valid Credentials
	Given User is on Login Page
	When User enters "<username>" and "<password>"
	Then Login Successfully
Examples:
	|	username					|	password	|
	|jiteshkumar.patel@infosys.com	| 1234			|	
	|jiteshkumar.patel@infosys.com	| 1234			|
