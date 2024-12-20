
@tag
Feature: Client Feedback

  @tag1
  Scenario: send feedback to Completed Program
    Given I finished a program
    When I want to send feedbacks or reviews
    Then the feedback should be sent to the admin 
    

  @tag2
  Scenario: Rate Completed Program
    Given I finished a program
    When I want to rate the program out of five
    Then the program rating should be updated
    
  @tag3
  Scenario: submit suggestions
    Given I am enroled in the program
    When I want sent a suggestions to an instructor
    Then the instructor should get it 
    