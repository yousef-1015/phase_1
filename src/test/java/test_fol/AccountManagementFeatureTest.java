package test_fol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;

import fitness3.Account;
import fitness3.Admin;
import fitness3.Client;
import fitness3.Programm;
import io.cucumber.java.en.*;

public class AccountManagementFeatureTest 

{
	
	
    public static Admin CAdmin	= new Admin();
    public  Client tempclient = new Client();
    public Programm testProgram;

	  private String Message;
	  public String USERNAME,PASSWORD,PHONENUM,BDATE,ROLE="CLIENT",NAME,EMAIL,FITNESSGOAL,DIET,MED,LEVEL,AREA;
	  private Account caccount= new Account();
	  private int AGE;
	  private double WEIGHT,height;
	@Given("the client username is filled {string}")
	public void the_client_username_is_filled(String username) 
	{
		this.USERNAME=username;
		CAdmin.addProgram("program one", "six weeks","Beginner" ,"mucle building" ,500 );
		CAdmin.addProgram("program two", "sven weeks","Beginner" ,"Muscle Gain" ,500 );
		
	}
	@Given("the client password is filled {string}")
	public void the_client_password_is_filled(String pass) {
		PASSWORD=pass;
	}
	
	@Given("the client phone number is entered {string}")
	public void the_client_phone_number_is_entered(String phonenumber) {
		this.PHONENUM=phonenumber;
	   
	}
	@Given("the client birthdate is entered {string}")
	public void the_client_birthdate_is_entered(String birthdate) {
	    this.BDATE = birthdate;
	}
	@Given("the client name is filled {string}")
	public void the_client_name_is_filled(String name) {
	    this.NAME=name;
	}
	@Given("the client age is filled {string}")
	public void the_client_age_is_filled(String age) {
	   this.AGE=Integer.parseInt(age);
	}
	@Given("the client email is filled {string}")
	public void the_client_email_is_filled(String email) {
		this.EMAIL=email;
}
	@Given("the client fitness goal is filled {string}")
	public void the_client_fitness_goal_is_filled(String goal) {
this.FITNESSGOAL=goal;	
}
	@Given("the client dietary preference is filled {string}")
	public void the_client_dietary_preference_is_filled(String diet) {
	    // Write code here that turns the phrase above into concrete actions
this.DIET=diet;
}
	
	
	
	
	@Given("the client hight is filled {string}")
	public void the_client_hight_is_filled(String height) {
	    // Write code here that turns the phrase above into concrete actions
		   this.height=Integer.parseInt(height);
	}

	@Given("the client weight is filled {string}")
	public void the_client_weight_is_filled(String weight) {
		   this.WEIGHT=Integer.parseInt(weight);

	}
	@Given("the client medical info is filled {string}")
	public void the_client_medical_info_is_filled(String med) {
	   this.MED=med;
	}



	@When("I attempt to create the client profile")
	public void i_attempt_to_create_the_client_profile() 
	{

		if (USERNAME.isEmpty()) {
	        Message = "Username cannot be empty";
	        assertFalse("Username cannot be empty", true);
	        return;
	    }

	    if (PASSWORD.isEmpty()) {
	        Message = "Password cannot be empty";
	        assertFalse("Password cannot be empty", true);
	        return; 
	    }

	    if (PHONENUM.isEmpty()) {
	        Message = "Phone number required";
	        assertFalse("Phone number required", true);
	        return; 
	    }

	    if (BDATE.isEmpty()) {
	        Message = "Birthdate required";
	        assertFalse("Birthdate required", true);
	        return; 
	    }

	   
	   

	    if (CAdmin.usernameExists(USERNAME)) {
	        Message = "Username is already taken";
	        assertFalse("Username is already taken", true);
	        return; 
	    }
	    if(NAME.isEmpty()) 
	    {
	    	Message = "name cannot be empty";
	        assertFalse("empty name", true);
	        return; 
	    	
	    }
	    if(AGE<=0) 
	    {
	    	Message = "invalid age";
	        assertFalse("invalid age", true);
	        return; 
	    	
	    }
	    if(height<=0) 
	    {
	    	Message = "invalid height";
	        assertFalse("invalid height", true);
	        return; 
	    	
	    }
	    if(WEIGHT<=0) 
	    {
	    	Message = "invalid WEIGHT";
	        assertFalse("invalid WEIGHT", true);
	        return; 
	    	
	    }
	    if(EMAIL.isEmpty()) 
	    {
	    	Message = "email cannot be empty";
	        assertFalse("empty email", true);
	        return; 
	       
	    }
	    if(!EMAIL.contains("@")) 
	    {
	    	
	    	Message = "email is inavlid";
	        assertFalse("inavlid email", true);
	        return; 
	    	
	    }
	    if(FITNESSGOAL.isEmpty()) 
	    {
	    	Message = "please enter fitness goal";
	        assertFalse("empty fitness goal", true);
	        return; 
	    	
	    }
	    if(DIET.isEmpty()) 
	    {
	    	Message = "please enter dietry preference";
	        assertFalse("empty dietry preference", true);
	        return; 
	    	
	    }
	    if(MED.isEmpty()) 
	    {
	    	MED="no medical restrictions";
	    	
	    	
	    }
	     if (!USERNAME.isEmpty() && !PASSWORD.isEmpty() && !PHONENUM.isEmpty() && !BDATE.isEmpty()&&!NAME.isEmpty()&& !(AGE<=0) 
	    		&& !EMAIL.isEmpty() &&!FITNESSGOAL.isEmpty() &&!DIET.isEmpty() ) {

	    caccount = new Account();
	    caccount.setBirthdate(BDATE);
	    caccount.setPassword(PASSWORD);
	    caccount.setPhonenumber(PHONENUM);
	    caccount.setUsername(USERNAME);
	    caccount.setRole(ROLE);
	    tempclient.setaccount(caccount);
	    CAdmin.addClient(tempclient);
	    //Message = "Client added successfully"; 

	    }

	    
	}
	@Then("the message will appear {string}")
	public void the_message_will_appear(String MESSAGE) 
	{
//		if(Message!=null) {
//		MESSAGE=Message;
//		assertTrue(true);
//		
//		}
	   // JOptionPane.showMessageDialog(null, Message, "Activity Statistics", JOptionPane.INFORMATION_MESSAGE);

		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("I choose a Difficulty level {string}")
	public void i_choose_a_difficulty_level(String level) 
	{
		this.LEVEL=level;
	   
	}
	@Given("I choose a Focus area {string}")
	public void i_choose_a_focus_area(String FArea) 
	{
	    this.AREA=FArea;
	}
	@When("I want to view the programs")
	public void i_want_to_view_the_programs() 
	{
		
		
	}
	
	

@Then("I should see programs that match the difficultyLevel and focusArea")
public void i_should_see_programs_that_match_the_difficulty_level_and_focus_area() {
    // Write code here that turns the phrase above into concrete actions
  

	
		
		
	if(!AREA.isEmpty() && !LEVEL.isEmpty()) {
		
		assertTrue("the user picked a focus area and a Difficulty Level",true);

		CAdmin.viewProgramsByGoalAndDifficulty(AREA, LEVEL);

	}
	if(AREA.isEmpty() && LEVEL.isEmpty()) 
	{
		assertTrue("the user didnt choose a seach filter",true);

		CAdmin.viewAllPrograms();
		
	}
	if(AREA.isEmpty()) 
	{
		assertTrue("the user only picked Difficulty Level",true);

		CAdmin.viewProgramsByDifficulty(LEVEL);

		
	}
	if(LEVEL.isEmpty()) 
	{
		assertTrue("the user only picked focus area",true);
		CAdmin.viewProgramsByGoal(AREA);
	}

	
	
	
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Given("I choose a program to enroll in")
public void i_choose_a_program_to_enroll_in() 
{
	testProgram=new Programm(
		    "Yoga Basics",         // program_title
		    "4 Weeks",             // duration
		    "Beginner",            // difficulty_level
		    "Flexibility", // goals
		    "Body & Mind",         // focusArea
		    150.0,                 // price
		    18,                    // minAge
		    60                     // maxAge
		);
	testProgram.addRestriction("asthma");
	testProgram.addRestriction("back pain");

}
@Given("I met all the requirments")
public void i_met_all_the_requirments() 
{
	
	tempclient.addRestriction("asthma");
	tempclient.setAge(10);
   
}
@Then("I should be a part of that program")
public void i_should_be_a_part_of_that_program() 
{
	assertTrue(tempclient.enrollInProgram(testProgram));
   
}




	
	

}
