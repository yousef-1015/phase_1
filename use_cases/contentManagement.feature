
Feature: Content Management

  As an instructor
  I want to submit PDF files
  So that they can be reviewed and approved by the admin

  Scenario: Successfully submit a valid PDF file
    Given the instructor has opened the file submission dialog
    When the instructor selects a valid PDF file "FilePath.pdf"
    Then the file is added to the list of submitted files
    And the file name is displayed in the list as "Not Approved"

  Scenario: Attempt to submit a non-PDF file
   Given the instructor has opened the file submission dialog
    When the instructor selects a non-PDF file "filePath"
    Then the system shows an error message "Invalid file type: filePath"
    And the file is not added to the list of submitted files

    
    
    