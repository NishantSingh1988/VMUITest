Feature: Registartion in fego application

Scenario: Verification of registartion 

	Given Open the chrome browser and launch the application
	When Navigate to login		
	And Select account tab		
	And Enter the "Test1", "test@test.com", "9812364564" and "Test111!"			
	Then click on submit button
	And verify "Test1" user registered