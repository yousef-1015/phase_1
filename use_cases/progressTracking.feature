
@tag
Feature:  Progress Tracking

  @tag1
  Scenario: view weight milestone
    Given the client is logged in
    When He wannts to view his weight progress
    Then he will get his weight info 
   

   @tag2
  Scenario: Track weight
    Given the client is logged in
    When He wannts to update hi weight
    Then His weight should be updated

  @tag3
  Scenario: Track BMI
    Given the client is logged in
    When He wannts to get his BMI progress
    Then he will get his BMI info 

  @tag4
  Scenario: Track Attended programs
    Given the client is logged in
    When He wannts check the programs he attended so far
    Then he will get the attended programs

  @tag5
  Scenario: Track achievements
    Given the client is logged in
    When He wannts check the achievements he gained 
    Then he will get his achievements so far

  