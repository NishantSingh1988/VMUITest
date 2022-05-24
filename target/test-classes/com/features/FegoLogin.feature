Feature: Login in fego application

Scenario: Verification of Login 

	Given Open the chrome browser and launch the application	
	When Navigate to login		
	And Select login tab
	And Enter the "test@test.com" and "test123!"			
	Then click on submit button
	And verify "test" user logged in
	
