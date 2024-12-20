package test_fol;
import javax.swing.JOptionPane;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import fitness3.Admin;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
    
public class LoginFeatureTest {
    public  String Username, Password;
    public Admin loginaccount;
    
    
    
    
  
    public LoginFeatureTest() {
    	
        loginaccount = new Admin();
        loginaccount.addAccount("ahmad", "ahmadpass","ADMIN");
        loginaccount.addAccount("kareem", "kareempass", "INSTRUCTOR");
        loginaccount.addAccount("fawzi", "fawzipass", "CLIENT");
        loginaccount.addAccount("khaled", "khaledpass", "CLIENT");
        
    
    }
  

    @Given("the username should be filled {string}")
    public void the_username_should_be_filled(String username) {
        this.Username = username;
    }

    @Given("the password should be filled {string}")
    public void password_should_be_filled(String password) {
    	this.Password = password;
    }

    @When("I choose to login")
    public void i_choose_to_login() {
        // This method can remain empty or be used for additional logic if needed.
    }
    @Then("display a message {string}")
    public void display_a_message(String expectedMessage) {
        String role = loginaccount.checkinfo(Username, Password);
        String actualMessage;

        if (role != null) {
            actualMessage = "Login successful. Role: " + role;
            JOptionPane.showMessageDialog(null, actualMessage, "Login Status", JOptionPane.INFORMATION_MESSAGE);
            assertTrue(true); // Login successful
        } else {
            actualMessage = "Login failed";
            JOptionPane.showMessageDialog(null, actualMessage, "Login Status", JOptionPane.ERROR_MESSAGE);
            assertTrue(false); // Login failed
        }
		
		
	}}

