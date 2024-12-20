package test_fol;

import static org.junit.Assert.*;

import fitness3.Account;
import fitness3.Admin;
import io.cucumber.java.en.*;

public class FeedbackFeatureTest 

{
	public Admin Fadmin = new Admin();
    private String Fmessage;
    private Account faccount = new Account();



@Given("the user exists in the system")
public void the_user_exists_in_the_system() 
{
	 faccount.setUsername("testUser");
     faccount.setPassword("testPass");
     faccount.setfeedback(""); // Initialize with no feedback
     Fadmin.addAccount(faccount);
    
}
@Given("the user is logged in")
public void the_user_is_logged_in()
{
    faccount.settest(true);

}
    
@When("the user submits feedback")
public void the_user_submits_feedback() 
{
	  Fmessage = "good";
      faccount.setfeedback(Fmessage);
  
}
@Then("the feedback for  should be updated")
public void the_feedback_for_should_be_updated() 
{
	 // Verify that the feedback is updated using an assertion
	
    String feedback = faccount.getfeedback();
    assertNotNull(feedback, "Feedback is null!");
    assertFalse("Feedback is empty!",feedback.isBlank());
    
    assertEquals(Fmessage, feedback);
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
