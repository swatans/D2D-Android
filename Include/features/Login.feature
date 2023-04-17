Feature: Login

  Background: Open D2D App
    * I open default app

	 @NegativeCase 
     Scenario: Login with InValid Credentials
   * I should see 'Production/Login/SelamatDatang_Text' 
   * I click 'Production/Login/Lewati_Button'
   * I click 'Production/Login/Mulai_Button'
   * I click 'Production/Login/Email_Field'
   * I type 'test312@gmail.com' on 'Production/Login/Email_Field'
   * I hide keyboard
   * I click 'Production/Login/Password_Field'
   * I type '123456' on 'Production/Login/Password_Field'
   * I hide keyboard
   * I click 'Production/Login/Login_Button'
   * I wait for 5 seconds
   * I should see 'Production/Login/LoginGagal' 
   * I wait for 5 seconds
   * I kill app
   
   
     @PositiveCase
  Scenario: User in Login Page and Succesfully Logged in
    Given User in Login Page
    When User fill username and password correctly
    Then User succesfully logged in
    
   