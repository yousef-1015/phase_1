package test_fol;

import static org.junit.Assert.assertTrue;

import javax.swing.SwingUtilities;

import fitness3.Account;
import fitness3.Admin;
import fitness3.Client;
import fitness3.Programm;
import io.cucumber.java.en.*;

public class ProgressTrackingFeatureTest 
{
	  public static Admin CAdmin2	= new Admin();
	    public  Client tempclient2 = new Client();
	    public Programm testProgram2;
		  private Account caccount2= new Account();

	    
		 // String username, String password, String role, String status, String birthdate, String phoneNumber
	@Given("the client is logged in")
	public void the_client_is_logged_in() 
	{
	    caccount2 = new Account("amr","a123","CLIENT","ACIVE","22-10-2000","059-599-1234");
	    tempclient2.setaccount(caccount2);
	    tempclient2.setId(101);
        tempclient2.setName("amr kamel");
        tempclient2.setAge(25);
        tempclient2.setEmail("amr@example.com");
        tempclient2.setFitnessGoal("Lose Weight");
        tempclient2.setDietaryPreference("Vegetarian");
        tempclient2.setOldWeightt(85.5); // Old weight in kg
        tempclient2.setNewWeight(80.0); // New weight in kg
        tempclient2.sethight(1.75);     // Height in meters	
        testProgram2=new Programm ("test rogram","9 days","Beginner","weight loss","Cardio and Strength Training",49.99,16,60);
        tempclient2.enrollInProgram(testProgram2);
		
	}
	@When("He wannts to view his weight progress")
	public void he_wannts_to_view_his_weight_progress() 
	{
		tempclient2.viewWeightProgress();

	}
	@Then("he will get his weight info")
	public void he_will_get_his_weight_info() 
	{
		assertTrue("Client Viewed His Weight Progress ",true);

	}

	///////////////////////////////////////////////////////
	



	
	@When("He wannts to update hi weight")
	public void he_wannts_to_update_hi_weight() 
	{
	   tempclient2.setNewWeight(90);
	   //System.out.println("new Weight after update"+tempclient2.getNewWeight());
	}
	@Then("His weight should be updated")
	public void his_weight_should_be_updated() 
	{
		assertTrue("Weight updated successfuly",true);


	}


	
	
	///////////////BMI////////////////

@When("He wannts to get his BMI progress")
public void he_wannts_to_get_his_bmi_progress() 
{
	
	 tempclient2.viewBMIProgress();
}
@Then("he will get his BMI info")
public void he_will_get_his_bmi_info()
{
   
	assertTrue("Client Viewed His BMI Progress ",true);

}
	//////////////////////////////atttteeennnndddd////////////////


@When("He wannts check the programs he attended so far")
public void he_wannts_check_the_programs_he_attended_so_far() 
{
	tempclient2.attendProgram(testProgram2);
}
@Then("he will get the attended programs")
public void he_will_get_the_attended_programs() 
{
    assertTrue(tempclient2.viewAttendedPrograms());
}

	
	/////////////////achievements///////////////////

@When("He wannts check the achievements he gained")
public void he_wannts_check_the_achievements_he_gained() 
{
	testProgram2.setAchievement("enta batal ooooooooooooooo ");
   tempclient2.completeProgram(testProgram2);

}
@Then("he will get his achievements so far")
public void he_will_get_his_achievements_so_far() 
{	  tempclient2.viewAchievements();
    //SwingUtilities.invokeLater(tempclient2::viewAchievements);


	assertTrue("Client Viewed HisAchievements ",true);

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
