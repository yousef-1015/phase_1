
@tag
Feature: Feedback Submission 

  @tag1
  Scenario: Submitting valid feedback
    Given the user exists in the system
    And the user is logged in
    When the user submits feedback 
    Then the feedback for  should be updated
    
  #@tag2
 # Scenario: Submitting invalid feedback
   # Given the user exists in the system
   # And the user is logged in
  #  When the user submits empty feedback
   # Then an error message "Feedback cannot be empty" should be displayed
  #  And the feedback for the user should not be updated