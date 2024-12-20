package test_fol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import fitness3.Account;
import fitness3.Admin;
import fitness3.Client;
import io.cucumber.java.en.*;

public class UserManagerFeatureTest {
	  private String Message;
	    public Account TAccount,tempaccount;
	    public  Admin TAdmin2	= new Admin();
	    public static Admin TAdmin	= new Admin();
	    public String USERNAME,PASSWORD,PHONENUM,BDATE,ROLE,statuss;
	    public boolean exsits;
	    public Client Uclient = new Client();
	    ArrayList<Account>  accounts= TAdmin.getAccounts();


@Given("the username is filled {string}")
public void the_username_is_filled(String username) {
	
	USERNAME=username;
}
@Given("the password is filled {string}")
public void the_password_is_filled(String pass) {
	
	PASSWORD=pass;
}
@Given("the role is selected {string}")
public void the_role_is_selected(String role) {
	ROLE=role;
	}
@Given("the phone number is entered {string}")
public void the_phone_number_is_entered(String phonenumber) {
	
	
	PHONENUM=phonenumber;
	
}
@Given("the status is enterd {string}")
public void the_status_is_enterd(String status) {
	
	statuss=status;
}
@Given("the birthdate is entered {string}")
public void the_birthdate_is_entered(String birthdate) {
	
   BDATE=birthdate;
}
@When("I attempt to add the account")
public void i_attempt_to_add_the_account() {
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

   
    if (ROLE.isEmpty()) {
        Message = "Role required";
        assertFalse("Role required", true);
        return; 
    }

    if (TAdmin.usernameExists(USERNAME)) {
        Message = "Username is already taken";
        assertFalse("Username is already taken", true);
        return; 
    }

    TAccount = new Account();
    TAccount.setBirthdate(BDATE);
    TAccount.setPassword(PASSWORD);
    TAccount.setPhonenumber(PHONENUM);
    TAccount.setUsername(USERNAME);
    TAccount.setRole(ROLE);
    TAdmin.addAccount(TAccount);
    Uclient.setaccount(TAccount);
    Message = "Account added successfully";
    TAdmin.displayAccounts();

}


@When("I attempt to update the account")
public void i_attempt_to_update_the_account() {
	
	TAdmin2.Addfaccount("instructor11", "pass123", "INSTRUCTOR","1234567890","1985-03-12");
    if (USERNAME.isEmpty()) {
        Message = "Username cannot be empty";
        assertFalse("Username cannot be empty", true);
        return; // Exit the method
    }
    if (!TAdmin.usernameExists(USERNAME)) {
        Message = "Username doesnt exsist";
        assertFalse("Username doesnt exsist", true);
        return; 
    }
    
   
    
    if (PASSWORD != null && !PASSWORD.isEmpty()) {

    TAdmin.updatePassword(USERNAME, PASSWORD);
    }
    
    if (PHONENUM != null && !PHONENUM.isEmpty()) {

    TAdmin.updatePhoneNumber(USERNAME, PHONENUM);
    }
    
    if (ROLE != null && !ROLE.isEmpty()) {

    TAdmin.updateRole(USERNAME, ROLE);
    }
    if (BDATE != null && !BDATE.isEmpty()) {
    	
        TAdmin.updateBirthdate(USERNAME, BDATE);

    }

    

    TAdmin.updateStatus(USERNAME, statuss);
    Message="Account updated successfully";
    
    TAdmin.displayAccounts();
    

}



@When("I attempt to deactivate the account")
public void i_attempt_to_deactivate_the_account() {
	
	 if (USERNAME.isEmpty()) {
	        Message = "Username cannot be empty";
	        assertFalse("Username cannot be empty", true);
	        return; // Exit the method
	    }
	  if (!TAdmin.usernameExists(USERNAME)) {
	        Message = "Username doesnt exsist";
	        assertFalse("Username doesnt exsist", true);
	        return; 
	    }
	 if (TAdmin.deactivateAccount(USERNAME)) {
	        Message = "Account deactivated successfully";
	    } else {
	        Message = "Username Does Not Exist";
	    }
		TAdmin.displaystatus(USERNAME);

}

@Then("the message should appear {string}")
public void the_message_should_appear(String expectedMessage) {
	

    assertEquals(expectedMessage, Message);

   // JOptionPane.showMessageDialog(null, expectedMessage, "Test", JOptionPane.INFORMATION_MESSAGE);    
}



@When("I attempt to approve the registration")
public void i_attempt_to_approve_the_registration() {

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
	
	if (TAdmin.usernameExists(USERNAME)) {
       Message = "Username is already taken";
       assertFalse("Username is already taken", true);
       return; 
   }


if (!USERNAME.isEmpty() && !PASSWORD.isEmpty() && !PHONENUM.isEmpty() && !BDATE.isEmpty()) {
   tempaccount = new Account();
   tempaccount.setBirthdate(BDATE);
   tempaccount.setPassword(PASSWORD);
   tempaccount.setPhonenumber(PHONENUM);
   tempaccount.setUsername(USERNAME);
   tempaccount.setRole("INSTRUTCOR");

   TAdmin.addRequest(tempaccount);
   TAdmin.displayRequests();

}
	
 
}

@Then("add details to accounts list")
public void add_details_to_accounts_list() {
	
	
	
	TAdmin.approveRequest(tempaccount);
	TAdmin.displayAccounts();
}

@When("I attempt to retrieve the activity statistics")
public void i_attempt_to_retrieve_the_activity_statistics() {
	 if (USERNAME.isEmpty()) {
	        Message = "Username cannot be empty";
	        assertFalse("Username cannot be empty", true);
	        return;
	    }

		if (!TAdmin.usernameExists(USERNAME)) {
	       Message = "Username does Not Exist";
	       assertFalse("Username does Not Exist", true);
	       return; 
	   }
		
		Account account = null;
	    for (Account acc : TAdmin.getAccounts()) {
	        if (acc.getUsername().equals(USERNAME)) {
	            account = acc;
	            break;
	        }
	    }

	    if (account != null) {
	        Message = account.getActivityStatistics(); // Get the activity statistics
	    } else {
	        Message = "Account not found.";
	    }
	}

   

@Then("the activity statistics should be displayed for {string}")
public void the_activity_statistics_should_be_displayed_for(String Username) 
{
    Uclient.setName("khaled");

	TAdmin.viewClientActivity(Uclient);
	 assertEquals(Username, USERNAME);
	    // Display the message which contains the activity statistics
	    JOptionPane.showMessageDialog(null, Message, "Activity Statistics", JOptionPane.INFORMATION_MESSAGE);
	
   
}


}
