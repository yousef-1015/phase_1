
@tag
Feature: Account Management

@tag1
Scenario Outline: Create client profile
    Given the client username is filled "<username>"
    And the client password is filled "<password>"
    And the client phone number is entered "<phonenumber>"
    And the client birthdate is entered "<birthdate>"
    And the client name is filled "<name>"
    And the client age is filled "<age>"
    And the client email is filled "<email>"
    And the client fitness goal is filled "<fitnessGoal>"
    And the client dietary preference is filled "<dietaryPreference>"
    And the client hight is filled "<height>"
    And the client weight is filled "<weight>"
    And the client medical info is filled "<med>"
    When I attempt to create the client profile
    Then the message will appear "<message>"

    Examples: 
      | username      | password   | phonenumber  | birthdate   | name        | age | email               | fitnessGoal       | dietaryPreference | height | weight | med  | message                          |
      | jane_smith    | pass456    | 0987654321   | 1995-05-05  | Jane Smith  | 25  | jane@example.com    | Muscle Building   | Keto              | 165    | 60     |  azma |Profile created successfully      |
      #| invalid_user   | pass789    | 1234567890   | 1992-11-22  |              | 28  | invalidEmail        | Cardio            | Vegan             | 170    | 70   | sick |Username cannot be empty         |
     # | alice_brown   | pass101    | 1234567890   | 1988-03-12  | Alice Brown | -5  | alice@example.com   | Flexibility       | None              | 160    | 55     |  bronchites |Age must be a positive number    |
     # | charlie_black  | pass303    | 1234567890   | 1999-09-09  | Charlie Black| 22 | charlie@example.com | Muscle Building   | None              | 180    | 75     | cancer | Profile created successfully      |
      #| dave_green     | pass404    | 1234567890   | 1993-12-12  | Dave Green  | 35  | dave@example.com    |                    | Vegetarian        | 175    | 80     | flu |Fitness goal cannot be empty     |
     # | emma_white     | pass505    | 1234567890   | 1990-01-01  | Emma White  | 30  | inavlidd    | Weight Loss       | Gluten-Free       | 158    | 65     |      |Profile created successfully      |
      #| frank_black    | pass606    | 1234567890   | 1995-05-05  | Frank Black | 20  | frank@example.com   | Muscle Building   | None              | 172    | 68     |   |Profile created successfully      |
      #| gina_green     | pass707    | 1234567890   | 1992-11-22  | Gina Green  | 28  | gina@example.com    | Cardio            | Vegan             | 165    | -10    |   |Weight must be a positive number  |
      
      
     
 	@tag2
  Scenario Outline: Browse fitness programs by difficulty level
    Given I choose a Difficulty level "<difficultyLevel>"
    And   I choose a Focus area "<focusArea>"
    When I want to view the programs
    Then I should see programs that match the difficultyLevel and focusArea

 Examples:
      | difficultyLevel | focusArea         |
     # | Beginner        |                   |
     # | Beginner        | Muscle Gain       |
     # | Intermediate    | Flexibility       |
    
    @tag3
    Scenario Outline: Enroll in programs
          Given I choose a program to enroll in
          And I met all the requirments 
          Then I should be a part of that program
          
      
      
      
      
      
      
      
      
      