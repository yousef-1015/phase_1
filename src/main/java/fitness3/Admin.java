package fitness3;
import java.awt.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.util.List;

public class Admin 
{
	 public ArrayList <Account> accounts;
	 public ArrayList <Client> clients;
	 public   ArrayList<String> feedbackList;
	 public ArrayList <Account> requests;
	 public static ArrayList <Programm> programs;
	private final List<File> approvedPDFs = new ArrayList<>();

	 

	 
	 public Admin() {
	        accounts = new ArrayList<>(); 
	        requests= new ArrayList<>();
	        clients= new ArrayList<>();
	        programs= new ArrayList<>();
	        feedbackList= new ArrayList<>();


	    }
	 
	 public void addClient(Client coc) {
		 
		 clients.add(coc);
		 
	 }
	 
	 
	 
	 
	 
	    public void addAccount(String username, String password, String role) {
	    	 if (usernameExists(username)) {
	    	        JOptionPane.showMessageDialog(null, "Username is already taken", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	        return; // Exit the method to prevent adding a duplicate account
	    	    }
	        Account newAccount = new Account();
	        newAccount.setUsername(username);
	        newAccount.setPassword(password);
	        newAccount.setRole(role); // Set the role
  
	        accounts.add(newAccount); 
// Add the new account to the ArrayList
	    }
	    public void Addfaccount(String username , String password,String Role,String phnoenumber,String birthdate) {
	    	 if (usernameExists(username)) {
	    	        JOptionPane.showMessageDialog(null, "Username is already taken", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	        return; // Exit the method to prevent adding a duplicate account
	    	    }
	    	
	    	Account newAccount = new Account();
	        newAccount.setUsername(username);
	        newAccount.setPassword(password);
	        newAccount.setRole(Role); 
	        newAccount.setBirthdate(birthdate);
	        newAccount.setPhonenumber(phnoenumber);
	        
	        accounts.add(newAccount); 

	    	
	    	
	    	
	    }
	    
	    public boolean updateAccount1(String username, String newPassword, String newRole, String newBirthdate, String newPhoneNumber) {
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username)) {
	                account.setPassword(newPassword);
	                account.setRole(newRole);
	                account.setBirthdate(newBirthdate);
	                account.setPhonenumber(newPhoneNumber);
	                return true; 
	            }
	        }
	        
	        JOptionPane.showMessageDialog(null, "Username Does Not Exist ", "ERROR", JOptionPane.ERROR_MESSAGE);

	        
	        return false; 
	    
	    }
	    public boolean usernameExists(String username) {
	      
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username)) {
	                return true; 
	            }
	        }
	        return false; 
	    }
	    
	    public boolean updatePassword(String username, String newPassword) {
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username)) {
	                account.setPassword(newPassword);
	                return true; 
	            }
	            else {	    
	            	JOptionPane.showMessageDialog(null, "Username Does Not Exist ", "ERROR", JOptionPane.ERROR_MESSAGE);
}
	        }

	        return false; 
	    }
	    public boolean updateRole(String username, String newRole) {
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username)) 
	            {
	                account.setRole(newRole);
	                return true; 
	            }
	            else {	    
	            	JOptionPane.showMessageDialog(null, "Username Does Not Exist ", "ERROR", JOptionPane.ERROR_MESSAGE);
}
	        }

	        return false; 
	    }
	    public boolean updateBirthdate(String username, String newBirthdate) {
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username)) {
	                account.setBirthdate(newBirthdate);
	                return true; 
	            }
	            else {	    
	            	JOptionPane.showMessageDialog(null, "Username Does Not Exist ", "ERROR", JOptionPane.ERROR_MESSAGE);
}
	        }

	        return false; 
	    }
	    
	    
	    
	    public boolean updateStatus (String username,String ustatus) 
	    {
	    	 for (Account account : accounts) {
		            if (account.getUsername().equals(username))
		            {
		            	account.setStatus(ustatus);
		    	    	return true;
		            	
		            }
		            else {	    
		            	JOptionPane.showMessageDialog(null, "Username Does Not Exist ", "ERROR", JOptionPane.ERROR_MESSAGE);
}
		            	
		            }
	        
	    	return false;

	    	
	    	
	    }
	    public boolean updatePhoneNumber(String username, String newPhoneNumber) {
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username)) {
	                account.setPhonenumber(newPhoneNumber);
	                return true; 
	            }
	            else {	    
	            	JOptionPane.showMessageDialog(null, "Username Does Not Exist ", "ERROR", JOptionPane.ERROR_MESSAGE);
}
	        }

	        return false; 
	    }
	    
	    
	    
	    
 
	    // Method to get the list of accounts
	    public ArrayList<Account> getAccounts() {
	        return accounts;
	    }
	    
	    public String checkinfo(String username, String password) {
	        for (Account account : accounts) {
	            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
	                return account.getRoleAsString(); // Return the role if credentials are valid
	            }
	        }
	        return null; 
	    }





		public boolean updateAccount(String username, String newPassword, String newRole) {
			 for (Account account : accounts) {
		            if (account.getUsername().equals(username)) {
		                account.setPassword(newPassword);
		                account.setRole(newRole);
		                return true; 
		            }
			
			
			
		}
				return false;

	
	    }





		public boolean deactivateAccount(String username) {
			 for (Account account : accounts) {
		            if (account.getUsername().equals(username)) {
		            	account.setStatus("INACTIVE");
		            	account.settest(false);

		            	return true; 
		            }
			
			
		}
			return false;
		}





		public String updateAccount(String uSERNAME, String pASSWORD, String rOLE, String pHONENUM, String bDATE) {
			// TODO Auto-generated method stub
			return null;
		}





		public void addAccount(Account tAccount)
		{
			Addfaccount(tAccount.getUsername(),tAccount.getPassword(),tAccount.getRole(),tAccount.getPhonenumber(),tAccount.getBirthdate());
		}
		
		
		public void updateAccount2(String username, String newPassword, String newRole, String newPhoneNumber, String newBirthdate) {
		    for (Account account : accounts) {
		        if (account.getUsername().equals(username)) {
		            if (newPassword != null && !newPassword.isEmpty()) {
		                account.setPassword(newPassword);
		            }
		            if (newRole != null && !newRole.isEmpty()) {
		                account.setRole(newRole);
		            }
		            if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
		                account.setPhonenumber(newPhoneNumber);
		            }
		            if (newBirthdate != null && !newBirthdate.isEmpty()) {
		                account.setBirthdate(newBirthdate);
		            }
		            JOptionPane.showMessageDialog(null, "Account updated successfully", "INFO", JOptionPane.INFORMATION_MESSAGE);
		            return; // Exit the method after successful update
		        }
		    }
		    JOptionPane.showMessageDialog(null, "Username Does Not Exist", "ERROR", JOptionPane.ERROR_MESSAGE);
		}





		public void displayAccounts() {
		    StringBuilder accountDetails = new StringBuilder();
		    
		    if (accounts.isEmpty()) {
		        accountDetails.append("No accounts available.");
		    } else {
		        for (Account account : accounts) {
		            accountDetails.append("Username: ").append(account.getUsername())
                    				.append(", Password: ").append(account.getPassword())

		                          .append(", Role: ").append(account.getRole())
		                          .append(", Status: ").append(account.getStatus())
		                          .append(", Birthdate: ").append(account.getBirthdate())
		                          .append(", Phone Number: ").append(account.getPhonenumber())
		                          .append("\n");
		        }
		    }
		    
		    // Display the account details in a dialog
		    JOptionPane.showMessageDialog(null, accountDetails.toString(), "Account Details", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		public void Deactivate(String username) {
			for (Account account : accounts) {
	            if (account.getUsername().equals(username)) {
	            	
	            	account.settest(false);
	            	
	            }
	            

			
			
			
			}
			
			
		}
		
		
		 public void displaystatus(String username) {
		    	
		    	for (Account account : accounts) {
		            if (account.getUsername().equals(username)) {
					    JOptionPane.showMessageDialog(null, username +"'s Status "+ account.getStatus(), "Account Details", JOptionPane.INFORMATION_MESSAGE);

		            	
		            }}
		    	

		    }
		
		 
		 public void addRequest(String username , String password,String phnoenumber,String birthdate)
		 {
			 if (usernameExists(username)) {
	 	        JOptionPane.showMessageDialog(null, "Username is already taken", "ERROR", JOptionPane.ERROR_MESSAGE);
	 	        return; 
	 	    }
			 Account newAccount = new Account();
		        newAccount.setUsername(username);
		        newAccount.setPassword(password);
		        newAccount.setRole("INACTIVE"); 
		        newAccount.setBirthdate(birthdate);
		        newAccount.setPhonenumber(phnoenumber);
		        
		        requests.add(newAccount); 
			 
		 }	
		 public void displayRequests() {
			    StringBuilder accountDetails = new StringBuilder();
			    
			    if (requests.isEmpty()) {
			        accountDetails.append("No accounts available.");
			    } else {
			        for (Account account : requests) {
			            accountDetails.append("Username: ").append(account.getUsername())
	                 				.append(", Password: ").append(account.getPassword())
			                          .append(", Role: ").append(account.getRole())
			                          .append(", Status: ").append(account.getStatus())
			                          .append(", Birthdate: ").append(account.getBirthdate())
			                          .append(", Phone Number: ").append(account.getPhonenumber())
			                          .append("\n");
			        }
			    }
			    
			    // Display the account details in a dialog
			    JOptionPane.showMessageDialog(null, accountDetails.toString(), "Requests", JOptionPane.INFORMATION_MESSAGE);
			}
		 
		 public void addRequest(Account newRequest) {
			    if (usernameExists(newRequest.getUsername())) {
			        JOptionPane.showMessageDialog(null, "Username is already taken", "ERROR", JOptionPane.ERROR_MESSAGE);
			        return; 
			    }

			    newRequest.setStatus("INACTIVE");

			    requests.add(newRequest);}

		 
		 
		 	public void approveRequest(Account toApprove) 
		 	{
		 		 if (requests.contains(toApprove)) {
		 	        toApprove.setStatus("ACTIVE");
		 	        
		 	        requests.remove(toApprove);
		 	        
		 	        accounts.add(toApprove);
		 	       JOptionPane.showMessageDialog(null, "Request approved and account activated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		 	    } else {
		 	        // Notify error if the account does not exist in requests
		 	        JOptionPane.showMessageDialog(null, "Account not found in requests.", "Error", JOptionPane.ERROR_MESSAGE);
		 	    }
		 		
		 	}
		 	
		 	
		 	public void getallfeedbacks() {
		 	    for (Account account : accounts) {
		 	        String feedback = account.getfeedback();
		 	        if (feedback == null || feedback.isEmpty()) {
		 	            System.out.println(account.getUsername() + "'s Feedback: No feedback provided");
		 	        } else {
		 	            System.out.println(account.getUsername() + "'s Feedback: " + feedback);
		 	        }
		 	    }
		 	}
		 	
		 	
		 	public void addClient() 
		 	{
		 		
		 		
		 		
		 	};
		 	
		 	
		 	
		 	
		 	public void viewAllPrograms() {
		 	    StringBuilder programDetails = new StringBuilder();

		 	    if (programs.isEmpty()) {
		 	        programDetails.append("No programs available.");
		 	    } else {
		 	        for (Programm program : programs) {
		 	            programDetails.append("Title: ").append(program.getProgramTitle())
		 	                          .append(", Duration: ").append(program.getDuration())
		 	                          .append(", Difficulty Level: ").append(program.getDifficultyLevel())
		 	                          .append(", Goals: ").append(program.getGoals())
		 	                          .append(", Price: ").append(program.getRevenue())
		 	                          .append(", Enrolled Clients: ").append(program.getEnrollment())
		 	                          .append("\n");
		 	        }
		 	    }

		 	    // Display the program details in a dialog
		 	    JOptionPane.showMessageDialog(null, programDetails.toString(), "Program Details", JOptionPane.INFORMATION_MESSAGE);
		 	}
		 	
		 	
		 	
		 	
		 	 public void viewProgramsByGoal(String goal) {
		         StringBuilder programDetails = new StringBuilder();
		         ArrayList<Programm> filteredPrograms = new ArrayList<>();

		         for (Programm program : programs) {
		             if (program.getGoals().equalsIgnoreCase(goal)) {
		                 filteredPrograms.add(program);
		             }
		         }
		         

		         if (filteredPrograms.isEmpty()) {
		        	 return;
		             //programDetails.append("No programs found for the specified goal: ").append(goal);
		         } else {
		             for (Programm program : filteredPrograms) {
		                 programDetails.append("Title: ").append(program.getProgramTitle())
		                         .append(", Duration: ").append(program.getDuration())
		                         .append(", Difficulty Level: ").append(program.getDifficultyLevel())
		                         .append(", Goals: ").append(program.getGoals())
		                         .append(", Price: ").append(program.getRevenue())
		                         .append(", Enrolled Clients: ").append(program.getEnrollment())
		                         .append("\n");
		             }
		         }

		         // Display the program details in a dialog
		         JOptionPane.showMessageDialog(null, programDetails.toString(), "Filtered Program Details by Goal", JOptionPane.INFORMATION_MESSAGE);
		     }

		     // Method to view programs by difficulty level
		     public void viewProgramsByDifficulty(String difficultyLevel) {
		         StringBuilder programDetails = new StringBuilder();
		         ArrayList<Programm> filteredPrograms = new ArrayList<>();

		         for (Programm program : programs) {
		             if (program.getDifficultyLevel().equalsIgnoreCase(difficultyLevel)) {
		                 filteredPrograms.add(program);
		             }
		         }

		         if (filteredPrograms.isEmpty()) {
		        	 return;
		           //  programDetails.append("No programs found for the specified difficulty level: ").append(difficultyLevel);
		         } else {
		             for (Programm program : filteredPrograms) {
		                 programDetails.append("Title: ").append(program.getProgramTitle())
		                         .append(", Duration: ").append(program.getDuration())
		                         .append(", Difficulty Level: ").append(program.getDifficultyLevel())
		                         .append(", Goals: ").append(program.getGoals())
		                         .append(", Price: ").append(program.getRevenue())
		                         .append(", Enrolled Clients: ").append(program.getEnrollment())
		                         .append("\n");
		             }
		         }

		         // Display the program details in a dialog
		         JOptionPane.showMessageDialog(null, programDetails.toString(), "Filtered Program Details by Difficulty", JOptionPane.INFORMATION_MESSAGE);
		     }


		  // Method to view programs by both goal and difficulty level
		     public void viewProgramsByGoalAndDifficulty(String goal, String difficultyLevel) {
		         StringBuilder programDetails = new StringBuilder();
		         ArrayList<Programm> filteredPrograms = new ArrayList<>();

		         for (Programm program : programs) {
		             boolean matchesGoal = program.getGoals().equalsIgnoreCase(goal);
		             boolean matchesDifficulty = program.getDifficultyLevel().equalsIgnoreCase(difficultyLevel);

		             if (matchesGoal && matchesDifficulty) {
		                 filteredPrograms.add(program);
		             }
		         }

		         if (filteredPrograms.isEmpty()) {
		             programDetails.append("No programs found for the specified goal: ")
		                           .append(goal)
		                           .append(" and difficulty level: ")
		                           .append(difficultyLevel);
		         } else {
		             for (Programm program : filteredPrograms) {
		                 programDetails.append("Title: ").append(program.getProgramTitle())
		                         .append(", Duration: ").append(program.getDuration())
		                         .append(", Difficulty Level: ").append(program.getDifficultyLevel())
		                         .append(", Goals: ").append(program.getGoals())
		                         .append(", Price: ").append(program.getRevenue())
		                         .append(", Enrolled Clients: ").append(program.getEnrollment())
		                         .append("\n");
		             }
		         }

		         // Display the program details in a dialog
		         JOptionPane.showMessageDialog(null, programDetails.toString(), "Filtered Program Details", JOptionPane.INFORMATION_MESSAGE);
		     }
		     
		     
		     public void addProgram(String title, String duration, String difficultyLevel, String goals, double price) {
		         // Create a new program object
		         Programm newProgram = new Programm(title, duration, difficultyLevel, goals, price);
		         
		         // Add the new program to the programs list
		         programs.add(newProgram);
		         
		         // Show a success message
		         JOptionPane.showMessageDialog(null, "Program added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		     }
		     
		     
		     
		     
		     
		     
		     public void addProgramm(Programm program) {
		         if (program != null) {
		             // Add the new program to the programs list
		             programs.add(program);
		             
		             // Show a success message
		             JOptionPane.showMessageDialog(null, "Program added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		         } else {
		             // Show an error message if the program is null
		             JOptionPane.showMessageDialog(null, "Failed to add program: Program cannot be null.", "Error", JOptionPane.ERROR_MESSAGE);
		         }
		     }

		     public void receiveFeedback(Client client, Programm program, String feedback) {
		         String feedbackMessage = "Feedback from " + client.getName() + " on program " + program.getProgramTitle() + ": " + feedback;
		         feedbackList.add(feedbackMessage); // Store feedback
		         JOptionPane.showMessageDialog(null, "Feedback received from " + client.getName(), "Feedback Received", JOptionPane.INFORMATION_MESSAGE);
		     }

		     public void displayFeedback() {
		         StringBuilder feedbackDetails = new StringBuilder();
		         if (feedbackList.isEmpty()) {
		             feedbackDetails.append("No feedback available.");
		         } else {
		             for (int i = 0; i < feedbackList.size(); i++) {
		                 feedbackDetails.append(i).append(": ").append(feedbackList.get(i)).append("\n");
		             }
		         }
		         JOptionPane.showMessageDialog(null, feedbackDetails.toString(), "Feedback Details", JOptionPane.INFORMATION_MESSAGE);
		     }
		     
		     
		     public void reviewFeedback(int index, Client client, Programm program) {
		    	    if (index < 0 || index >= feedbackList.size()) {
		    	        JOptionPane.showMessageDialog(null, "Invalid feedback index.", "Error", JOptionPane.ERROR_MESSAGE);
		    	        return;
		    	    }

		    	    // Get the feedback to review
		    	    String feedback = feedbackList.get(index);
		    	    
		    	    // Remove the feedback from the list
		    	    feedbackList.remove(index);

		    	    // Construct the message
		    	    String message = "Your feedback on program " + program.getProgramTitle() + " was reviewed. Thank you!";

		    	    // Send the message to the client
		    	    client.addAdminMessage(message); // Send message to the client
		    	    JOptionPane.showMessageDialog(null, "Feedback reviewed and message sent to client.", "Feedback Reviewed", JOptionPane.INFORMATION_MESSAGE);
		    	} 
		     public void viewClientActivity(Client client) {
		         if (client == null) {
		             JOptionPane.showMessageDialog(null, "Client not found.", "Error", JOptionPane.ERROR_MESSAGE);
		             return;
		         }

		         StringBuilder activityDetails = new StringBuilder();
		         activityDetails.append("Client Activity for: ").append(client.getName()).append("\n");

		         // Enrolled Programs
		         activityDetails.append("Enrolled Programs:\n");
		         for (Programm program : client.getEnrolledPrograms()) {
		             activityDetails.append("- ").append(program.getProgramTitle()).append("\n");
		         }

		         // Attended Programs
		         activityDetails.append("Attended Programs:\n");
		         for (Programm program : client.getAttendedPrograms()) {
		             activityDetails.append("- ").append(program.getProgramTitle()).append("\n");
		         }

		         // Completed Programs
		         activityDetails.append("Completed Programs:\n");
		         for (Programm program : client.getCompletedPrograms()) {
		             activityDetails.append("- ").append(program.getProgramTitle()).append("\n");
		         }

		         // Display the activity details in a dialog
		         JOptionPane.showMessageDialog(null, activityDetails.toString(), "Client Activity", JOptionPane.INFORMATION_MESSAGE);
		     }

		     //////////////////////////////////
		     
		 	
		 	
		     public void openPDF(File file) {
		         if (file != null && Desktop.isDesktopSupported()) {
		             try {
		                 Desktop.getDesktop().open(file);
		                 System.out.println("Opening PDF: " + file.getName());
		             } catch (IOException e) {
		                 System.err.println("Failed to open PDF: " + e.getMessage());
		             }
		         } else {
		             System.out.println("Cannot open file. Desktop is not supported.");
		         }
		     }

		     public void launchAdminInterface(Instructor instructor) {
		         SwingUtilities.invokeLater(() -> {
		             JFrame frame = new JFrame("Admin PDF Management");
		             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		             frame.setSize(800, 600);

		             JPanel panel = new JPanel(new BorderLayout());

		             JLabel titleLabel = new JLabel("Manage PDFs", SwingConstants.CENTER);
		             titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		             panel.add(titleLabel, BorderLayout.NORTH);

		             JPanel centerPanel = new JPanel();
		             centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		             JScrollPane scrollPane = new JScrollPane(centerPanel);
		             panel.add(scrollPane, BorderLayout.CENTER);

		             JButton viewApprovedButton = new JButton("View Approved PDFs");
		             JButton viewSubmittedButton = new JButton("View Submitted PDFs");
		             JButton approveButton = new JButton("Approve Selected PDF");
		             JButton viewSelectedButton = new JButton("View Selected PDF");

		             JPanel buttonPanel = new JPanel();
		             buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		             buttonPanel.add(viewApprovedButton);
		             buttonPanel.add(viewSubmittedButton);
		             buttonPanel.add(viewSelectedButton);
		             buttonPanel.add(approveButton);

		             panel.add(buttonPanel, BorderLayout.SOUTH);

		             frame.add(panel);
		             frame.setVisible(true);

		             ButtonGroup buttonGroup = new ButtonGroup();

		             viewApprovedButton.addActionListener(e -> {
		                 centerPanel.removeAll();
		                 buttonGroup.clearSelection();
		                 for (File file : approvedPDFs) {
		                     JRadioButton radioButton = new JRadioButton(file.getName() + " (Approved)");
		                     radioButton.setEnabled(false);
		                     centerPanel.add(radioButton);
		                 }
		                 centerPanel.revalidate();
		                 centerPanel.repaint();
		             });

		             viewSubmittedButton.addActionListener(e -> {
		                 centerPanel.removeAll();
		                 buttonGroup.clearSelection();
		                 for (File file : instructor.getSubmittedPDFs()) {
		                     JRadioButton radioButton = new JRadioButton(file.getName() + " (Not Approved)");
		                     radioButton.setActionCommand(file.getAbsolutePath());
		                     buttonGroup.add(radioButton);
		                     centerPanel.add(radioButton);
		                 }
		                 centerPanel.revalidate();
		                 centerPanel.repaint();
		             });

		             viewSelectedButton.addActionListener(e -> {
		                 String selectedFilePath = buttonGroup.getSelection() != null
		                         ? buttonGroup.getSelection().getActionCommand()
		                         : null;
		                 if (selectedFilePath != null) {
		                     File file = new File(selectedFilePath);
		                     openPDF(file);
		                 } else {
		                     JOptionPane.showMessageDialog(frame, "Please select a PDF to view.", "No Selection", JOptionPane.WARNING_MESSAGE);
		                 }
		             });

		             approveButton.addActionListener(e -> {
		                 String selectedFilePath = buttonGroup.getSelection() != null
		                         ? buttonGroup.getSelection().getActionCommand()
		                         : null;
		                 if (selectedFilePath != null) {
		                     List<File> submittedFiles = instructor.getSubmittedPDFs();
		                     File approvedFile = null;
		                     for (File file : submittedFiles) {
		                         if (file.getAbsolutePath().equals(selectedFilePath)) {
		                             approvedFile = file;
		                             break;
		                         }
		                     }
		                     if (approvedFile != null) {
		                         approvedPDFs.add(approvedFile);
		                         instructor.getSubmittedPDFs().remove(approvedFile);
		                         JOptionPane.showMessageDialog(frame, "PDF approved: " + approvedFile.getName(), "Approval Success", JOptionPane.INFORMATION_MESSAGE);
		                         viewSubmittedButton.doClick();
		                     }
		                 } else {
		                     JOptionPane.showMessageDialog(frame, "Please select a PDF to approve.", "No Selection", JOptionPane.WARNING_MESSAGE);
		                 }
		             });
		         });
		     }

		     public List<File> getApprovedPDFs() {
		         return approvedPDFs;
		     }
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	}
		 	
		 	
		 	
		 	
		 	



	    
	   

	    

	    
	


