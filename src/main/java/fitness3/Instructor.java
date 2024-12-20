package fitness3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Instructor {
    private ArrayList<File> submittedPDFs = new ArrayList<>();
    private ArrayList<String> fileStatuses = new ArrayList<>();
	 public ArrayList <Client> Requests = new ArrayList<>();
	 //public ArrayList <Account> requests;
	    public ArrayList<String> suggestionsSent= new ArrayList<>();



    
    public void addRequest(int id , String name, int age ,String email, String fitnessGoal ,String dietaryPreference)
	 {
		
		 Client newAccount = new Client(id,name,age,email,fitnessGoal,dietaryPreference);
	      
	        
	        Requests.add(newAccount); 
		 
	 }

	/**
	 * @return the suggestionsSent
	 */
	public ArrayList<String> getSuggestionsSent() {
		return suggestionsSent;
	}

	/**
	 * @param suggestionsSent the suggestionsSent to set
	 */
	public void setSuggestionsSent(ArrayList<String> suggestionsSent) {
		this.suggestionsSent = suggestionsSent;
	}
   
    
	public void viewSuggestionsSent() {
	    if (suggestionsSent.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No Suggestions Sent");
	    } else {
	        String output = "Suggestions Sent:\n";
	        for (String suggestion : suggestionsSent) {
	            output += "- " + suggestion + "\n";
	        }
	        JOptionPane.showMessageDialog(null, output);
	    }
	}
	
//	public void addsuggestion() {}
    	
    	
    	
    
    
//    public void addRequest(Account newRequest) {
//	    if (usernameExists(newRequest.getUsername())) {
//	        JOptionPane.showMessageDialog(null, "Username is already taken", "ERROR", JOptionPane.ERROR_MESSAGE);
//	        return; 
//	    }
//
//	    newRequest.setStatus("INACTIVE");
//
//	    Requests.add(newRequest);}
//    

    public List<File> submitPDFs() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));
            fileChooser.setMultiSelectionEnabled(true);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();
                    for (File file : selectedFiles) {
                            if (file.getName().endsWith(".pdf")) {
                                    submittedPDFs.add(file);
                                    System.out.println("PDF submitted: " + file.getAbsolutePath());
                            } else {
                                    JOptionPane.showMessageDialog(null, "Invalid file type: " + file.getName());
                            }
                    }
            } else {
                    System.out.println("File submission canceled.");
            }
            return submittedPDFs;
    }

    public List<File> getSubmittedPDFss() {
            return submittedPDFs;
    }

    public void launchInstructorInterface() {
            SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Instructor PDF Submission");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 300);

                    JPanel panel = new JPanel(new BorderLayout());

                    JLabel titleLabel = new JLabel("Submit PDFs", SwingConstants.CENTER);
                    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    panel.add(titleLabel, BorderLayout.NORTH);

                    JPanel fileListPanel = new JPanel();
                    fileListPanel.setLayout(new BoxLayout(fileListPanel, BoxLayout.Y_AXIS));
                    JScrollPane scrollPane = new JScrollPane(fileListPanel);
                    panel.add(scrollPane, BorderLayout.CENTER);

                    JButton submitButton = new JButton("Submit PDFs");
                    panel.add(submitButton, BorderLayout.SOUTH);

                    submitButton.addActionListener(e -> {
                            List<File> submittedFiles = submitPDFs();
                            fileListPanel.removeAll();
                            for (File file : submittedFiles) {
                                    JLabel fileLabel = new JLabel(file.getName());
                                    fileListPanel.add(fileLabel);
                            }
                            fileListPanel.revalidate();
                            fileListPanel.repaint();
                    });

                    frame.add(panel);
                    frame.setVisible(true);
            });
    }
    public ArrayList<File> getSubmittedPDFs() {
        return submittedPDFs;
    }

    // Method to submit a file
    public void submitFile(File file) {
        if (file.getName().endsWith(".pdf")) {
            submittedPDFs.add(file);
            fileStatuses.add(file.getName() + " (Not Approved)");
        }
    }

    // Method to get the status of a submitted file
    public String getFileStatus(File file) {
        int index = submittedPDFs.indexOf(file);
        if (index != -1) {
            return fileStatuses.get(index);
        }
        return "File not found";
    }

    // Method to update the status of a file (e.g., to "Approved")
    public void approveFile(File file) {
        int index = submittedPDFs.indexOf(file);
        if (index != -1) {
            fileStatuses.set(index, file.getName() + " (Approved)");
        }
    }
    
    
    
}

