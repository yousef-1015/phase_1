package test_fol;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fitness3.Instructor;
import fitness3.Admin;
import io.cucumber.java.en.*;

public class contentManagementFeatureTest {
    private String message;
    private Admin admin = new Admin();
    private  Instructor instructor = new Instructor();
    private File selectedFile;
    private ArrayList<File> submittedPDFs;

    public contentManagementFeatureTest() {
        submittedPDFs = (ArrayList<File>) instructor.getSubmittedPDFs();
    }
    
    
    

    @Given("the instructor has opened the file submission dialog")
    public void the_instructor_has_opened_the_file_submission_dialog() {
        // Simulate opening the file chooser
        submittedPDFs.clear(); // Clear any previously submitted files
        message = null;
    }
   

    @When("the instructor selects a valid PDF file {string}")
    public void the_instructor_selects_a_valid_pdf_file(String filePath) {
        selectedFile = new File(filePath);
        if (filePath.endsWith(".pdf")) {
            instructor.submitFile(selectedFile);
            message = "PDF submitted successfully";
        } else {
            message = "Invalid file type: " + selectedFile.getName();
        }
    }

    @Then("the file is added to the list of submitted files")
    public void the_file_is_added_to_the_list_of_submitted_files() {
       assertTrue("The file should be added to the list", submittedPDFs.contains(selectedFile));
  }

    @Then("the file name is displayed in the list as {string}")
    public void the_file_name_is_displayed_in_the_list_as(String status) {
        String expectedStatus = selectedFile.getName() + " (" + status + ")";
        assertEquals("The file name and status should match", expectedStatus, instructor.getFileStatus(selectedFile));
    }

    @When("the instructor selects a non-PDF file {string}")
    public void the_instructor_selects_a_non_pdf_file(String filePath) {
        selectedFile = new File(filePath);
        if (!filePath.endsWith(".pdf")) {
            message = "Invalid file type: " + selectedFile.getName();
        } else {
            instructor.submitFile(selectedFile);
        }
    }

    @Then("the system shows an error message {string}")
    public void the_system_shows_an_error_message(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }

    @Then("the file is not added to the list of submitted files")
    public void the_file_is_not_added_to_the_list_of_submitted_files() {
        assertFalse("The file should not be added to the list", submittedPDFs.contains(selectedFile));
    }

    
}
