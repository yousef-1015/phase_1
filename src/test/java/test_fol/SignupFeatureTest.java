package test_fol;

import static org.junit.Assert.assertEquals;

import javax.swing.JOptionPane;

import static org.junit.Assert.*;

import fitness3.Account;
import fitness3.Admin;
import fitness3.UserRole;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Date;

public class SignupFeatureTest {
    private String signupMessage;
    public Account tempAccount;
    public  Admin signupaccounts;
    public String USERNAME,PASSWORD,PHONENUM,BDATE;

    public SignupFeatureTest() {
    	signupaccounts = new Admin();
    	
         }
    
    public Account gettempAccount() {
    	
    	
    	return tempAccount;
    	
    }
    @Given("the username {string} is entered")
    public void the_username_is_entered(String username) 
    {
    	USERNAME=username;
    	
    	
    }

    @Given("the password {string} is entered")
    public void the_password_is_entered(String password) 
    {
    	PASSWORD=password;
    	

    }

    @Given("the phone number {string} is entered")
    public void the_phone_number_is_entered(String phonenumber) {
    	
    	
    	
    	PHONENUM=phonenumber;
    	

    }

    @Given("the birthdate {string} is entered")
    public void the_birthdate_is_entered(String birthdate) {
    	
    	BDATE=birthdate;
    	
        }
    
    
    
    
    @When("I attempt to sign up")
    public void i_attempt_to_sign_up() {
    	
      
    }

    @Then("display the message {string}")
    public void display_the_message(String expectedMessage) 
    {if (!USERNAME.isEmpty() && !PASSWORD.isEmpty() && !PHONENUM.isEmpty() && !BDATE.isEmpty()) {
        tempAccount = new Account();
        tempAccount.setBirthdate(BDATE);
        tempAccount.setPassword(PASSWORD);
        tempAccount.setPhonenumber(PHONENUM);
        tempAccount.setUsername(USERNAME);
        signupMessage = "signup successful"; 
    }
    	
    	
    	
    	
    signupMessage = ""; 

    	
    	if (USERNAME.isEmpty()) {
    	    signupMessage = "Username cannot be empty";
    	    assertFalse("missing username", true);
    	}
    	if (PASSWORD.isEmpty()) {
    	    signupMessage = "Password cannot be empty";
    	    assertFalse("missing password", true);
    	}
    	if (PHONENUM.isEmpty()) {
    	    signupMessage = "Phone number required";
    	    assertFalse("missing phone number", true);
    	}
    	if (BDATE.isEmpty()) {
    	    signupMessage = "Birthdate required";
    	    assertFalse("missing birthdate", true);
    	}
    	System.out.println(expectedMessage);
    	//assertEquals(expectedMessage, signupMessage);

    }
}
