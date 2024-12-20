Feature: Signup 
  
  @tag2
  Scenario Outline: Invalid or missing fields during signup
    Given the username "<username>" is entered
    And the password "<password>" is entered
    And the phone number "<phonenumber>" is entered
    And the birthdate "<birthdate>" is entered
    When I attempt to sign up
    Then display the message "<message>"

    Examples:
    | username | password | phonenumber | birthdate   | message                  |
    | testuser |          | 1234567890  | 1990-01-01  | Password cannot be empty |
    | testuser | testpass |             | 1990-01-01  | Phone number required    |
    | testuser | testpass | 1234567890  |             | Birthdate required       |
    | mohammad |  osama   | 1234567897  |  0-0-00     |signup successful         |
    
    
    
   

  