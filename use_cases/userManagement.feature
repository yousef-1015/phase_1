Feature: User Management
  Manage accounts for instructors and clients, including adding, updating, and deactivating accounts.

  @addAccount
  Scenario Outline: Add a new account
    Given the username is filled "<username>"
    And the password is filled "<password>"
    And the role is selected "<role>"
    And the phone number is entered "<phonenumber>"
    And the birthdate is entered "<birthdate>"
    When I attempt to add the account
    Then the message should appear "<message>"

    Examples:
  | username      | password   | role       | phonenumber  | birthdate   | message                   |
  | instructor11  | pass123    | CLIENT | 1234567890   | 1985-03-2  | Account added successfully |
 # | instructor11  | diffpass   | CLIENT     | 9876543210   | 1992-11-22  | Username is already taken  |
 # |               | pass123    | INSTRUCTOR | 1234567890   | 1985-03-12  | Username cannot be empty   |

#@updateAccount
Scenario Outline: Update an existing account
    Given the username is filled "<username>"
    And the password is filled "<password>"
    And the role is selected "<role>"
    And the phone number is entered "<phonenumber>"
    And the birthdate is entered "<birthdate>"
    And the status is enterd "<status>"
    When I attempt to update the account
    Then the message should appear "<message>"

    Examples:
 # | username      | password   | role       | phonenumber  | birthdate   | status | message                   |
 # | instructor11  | newpass123 | INSTRUCTOR | 1234567890   | 1985-03-11  | ACTIVE        | Account updated successfully |
 # | instructor11  |             | CLIENT     | 9876543210   | 1992-11-22 |    INACCTIVE  | Account updated successfully |
 # | instructorwqrw11  |             | CLIENT     | 9876543210   | 1992-11-22 |    INACCTIVE  | Username doesnt exsist |
  
 @DeactivateAccount
Scenario Outline: Deactivate existing account
    Given the username is filled "<username>"
    When I attempt to deactivate the account
    Then the message should appear "<message>"

Examples:
  #| username      | message                     |
 # | instructor11  | Account deactivated successfully |
  #| nonExistentUser  |Username doesnt exsist    |
  # |    | Username cannot be empty  |
  
  
  @ApproveInstructorRegistration
Scenario Outline: Approve new instructor registrations
Given the username is filled "<username>"
    And the password is filled "<password>"
    And the phone number is entered "<phonenumber>"
    And the birthdate is entered "<birthdate>"
    When I attempt to approve the registration
    Then add details to accounts list
    
       Examples:
    | username | password | phonenumber | birthdate   |
    | mohammad |  osama   | 1234567897  |  2020-7-7   |
#    | mohammad |  osama   | 1234567897  |  2020-7-7   |
 #   | testuser |          | 1234567890  | 1990-01-01  | 
 #   | testuser | testpass |             | 1990-01-01  | 
 #  | testuser | testpass | 1234567890  |             |
    
    @monitorUserActivity 
  Scenario Outline: Monitor user activity
    Given the username is filled "<username>"
    When I attempt to retrieve the activity statistics
    Then the activity statistics should be displayed for "<username>"

    Examples:
  | username      |
 # | instructor11  |
  #| clientUser233 |
    
  