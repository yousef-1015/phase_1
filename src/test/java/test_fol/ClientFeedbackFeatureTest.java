package test_fol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fitness3.Account;
import fitness3.Admin;
import fitness3.Client;
import fitness3.Instructor;
import fitness3.Programm;
import io.cucumber.java.en.*;

public class ClientFeedbackFeatureTest
{
	Account userAccount= new Account();
	Account userAccount3= new Account();

	 Programm fitnessProgram = new Programm();
	 Client client = new Client();
	 Client client2 = new Client();
	 Client client3 = new Client();

	 Instructor tempInstructor = new Instructor();

	  public static Admin CAdmin3	= new Admin();
private String testfeedback;
private double programRating;
private double expectedAverageRating; // Store the expected average rating

	
	@Given("I finished a program")
	public void i_finished_a_program() {
		// Initialize the user account, fitness program, and client
        userAccount = new Account("john_doe", "securePassword123", "trainer", "active", "01/01/1990", "123-456-7890");
        fitnessProgram = new Programm("Gym for Beginners", "6 weeks", "Beginner", "Improve flexibility and relaxation", "Mindfulness", 150.0, 18, 60);
        client = new Client(1, "Jane Doe", 28, "jane@example.com", "Lose weight", "Vegetarian", userAccount);
        Account userAccount2 = new Account("jane_doe", "securePassword456", "trainer", "active", "02/02/1992", "987-654-3210");
        client2 = new Client(2, "John Smith", 30, "john@example.com", "Gain muscle", "Non-Vegetarian", userAccount2);
        
        // Enroll the second client in the same program and complete it
        client2.enrollInProgram(fitnessProgram);
        client2.completeProgram(fitnessProgram);
        // Enroll the client in the program and complete it
        client.enrollInProgram(fitnessProgram);
        client.completeProgram(fitnessProgram);

	}
	@When("I want to send feedbacks or reviews")
	public void i_want_to_send_feedbacks_or_reviews() 
	{
		// Add the client and program to the admin
        CAdmin3.addClient(client);
        CAdmin3.addClient(client2);

        CAdmin3.addProgramm(fitnessProgram);
        
        // Send feedback, passing the existing Admin instance
        testfeedback = "bad timing";
        client.sendFeedback(fitnessProgram, testfeedback, CAdmin3);
        client2.sendFeedback(fitnessProgram, "good timing", CAdmin3);

    }
		
	 
	
	@Then("the feedback should be sent to the admin")
	public void the_feedback_should_be_sent_to_the_admin() 
	{
		   // Display feedback using the Admin's method
        CAdmin3.displayFeedback();
        
        // Check if feedback is available
        assertTrue("Feedback not sent", !CAdmin3.feedbackList.isEmpty());
	}

	@When("I want to rate the program out of five")
	public void i_want_to_rate_the_program_out_of_five()
	{
		
		 programRating = 3.5; // Store the rating
	        client.rateProgram(fitnessProgram, programRating);
	        client2.rateProgram(fitnessProgram, 1);

	        expectedAverageRating = fitnessProgram.getAverageRating(); 
	        fitnessProgram.displayProgramDetails();
	}
	@Then("the program rating should be updated")
	public void the_program_rating_should_be_updated() 
	{
		 double updatedAverageRating = fitnessProgram.getAverageRating(); // Get the program's average rating
	        assertEquals("The program average rating was not updated correctly.", expectedAverageRating, updatedAverageRating, 0.01);
	
	}
	
	
	
	@Given("I am enroled in the program")
	public void i_am_enroled_in_the_program()
	{
        client3 = new Client(2, "kareem malek", 20, "kareem@example.com", "Gain muscle", "Non-Vegetarian", userAccount3);
        userAccount3 = new Account("kareem_malek123", "Password123", "Client", "active", "01/01/1990", "123-456-7890");
        client3.setaccount(userAccount3);
		
	}
	@When("I want sent a suggestions to an instructor")
	public void i_want_sent_a_suggestions_to_an_instructor() 
	{
		
		client3.sendSuggestion(tempInstructor, "you should make the session easier");
		
	}
	@Then("the instructor should get it")
	public void the_instructor_should_get_it()
	{
		
		tempInstructor.viewSuggestionsSent();
		if(tempInstructor.suggestionsSent.isEmpty()) 
		{
			assertFalse("The isntructor didnt recieve any suggestions",true);			
			
		}

	
	}






}
