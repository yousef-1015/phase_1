package fitness3;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Programm {
	
	
	private String program_title, duration, difficulty_level, goals,focusArea,achievement;
	double price, revenue;
	public ArrayList<Client> enrolledClients, attendedClients;	
	private ArrayList<String> medicalRestrictions; 
	  private int minAge; 
	    private int maxAge; 
	    private double totalRating; // Total of all ratings
	    private int ratingCount; // Number of ratings given
	    private double averageRating; // Average rating
	
	 
	  public Programm(String program_title, String duration, String difficulty_level, String goals, double price) {
		    revenue = 0.0;
		    this.price=price;
	        this.program_title = program_title;
	        this.duration = duration;
	        this.difficulty_level = difficulty_level;
	        this.goals = goals;
	        this.enrolledClients = new ArrayList<>();
	        this.attendedClients = new ArrayList<>();
	        this.totalRating = 0.0;
	        this.ratingCount = 0;
	        this.averageRating = 0.0;
	        
	    }
	  
	  
	  
	  public Programm(String program_title, String duration, String difficulty_level, String goals, String focusArea, double price, int minAge, int maxAge) {
		    this.program_title = program_title;
		    this.duration = duration;
		    this.difficulty_level = difficulty_level;
		    this.goals = goals;
		    this.focusArea = focusArea;
		    this.price = price;
		    this.minAge = minAge;
		    this.maxAge = maxAge;
		    this.totalRating = 0.0;
	        this.ratingCount = 0;
	        this.averageRating = 0.0;
		    // Initialize the ArrayLists to avoid null pointer exceptions
		    this.enrolledClients = new ArrayList<>();
		    this.attendedClients = new ArrayList<>();
		    this.medicalRestrictions = new ArrayList<>();
		}
	  public Programm() {
		  enrolledClients=new ArrayList<>();

		  attendedClients=new ArrayList<>();

		  medicalRestrictions=new ArrayList<>();
		  this.totalRating = 0.0;
	        this.ratingCount = 0;
	        this.averageRating = 0.0;
	}
	  
	  
	  
	  
	  
		// Getters and Setters
	    public String getProgramTitle() {
	        return program_title;
	    }

	    public void setProgramTitle(String program_title) {
	        this.program_title = program_title;
	    }

	    public String getDuration() {
	        return duration;
	    }

	    public void setDuration(String duration) {
	        this.duration = duration;
	    }

	    public String getDifficultyLevel() {
	        return difficulty_level;
	    }

	    public void setDifficultyLevel(String difficulty_level) {
	        this.difficulty_level = difficulty_level;
	    }

	    public String getfocusArea() {
	        return focusArea;
	    }

	    public void setfocusArea(String area) {
	        this.focusArea = area;
	    }
 
	    public String getGoals() {
	        return goals;
	    }

	    public void setGoals(String goals) {
	        this.goals = goals;
	    }
	    

	    public ArrayList<Client> getEnrolledClients() {
	        return enrolledClients;
	    }

	    public void setEnrolledClients(ArrayList<Client> clientList) {
	        this.enrolledClients = clientList;
	    }
	    
	    public ArrayList<Client> getAttendedClients() {
	        return attendedClients;
	    }

	    public void setAttendedClients(ArrayList<Client> clientList) {
	        this.attendedClients = clientList;
	    }
	    
	    public double getAttendanceRate() {
	    	
	    	double attended = attendedClients.size();
	    	double enrolled = enrolledClients.size();
	    	return attended/enrolled;
	    	
	    }
	    
	    
	    public void addAttendant(Client client) {
	    	
	    	if (!enrolledClients.contains(client))
	    		JOptionPane.showMessageDialog(null, "Client does not exist in the list.", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	else if (attendedClients.contains(client))
	    		JOptionPane.showMessageDialog(null, "Client already exists in the list.", "Information", JOptionPane.INFORMATION_MESSAGE);

	    	else attendedClients.add(client);
	    	
	    }
	    
	   

	    // Method to get enrollment count
	    public int getEnrollment() {
	        return enrolledClients.size();
	    }
	    
	    public double getRevenue() {
	        return this.getEnrollment()* this.price;
	    }

	    // Method to add a client to the program
	    public void addClient(Client client) {
	        if (!enrolledClients.contains(client)) {
	            enrolledClients.add(client);
	        }
	    }

	    // Method to remove a client from the program
	    public void removeClient(Client client) {
	        enrolledClients.remove(client);
	    }
	    public void setDifficultyBeginner() 
	    {
	    	
	    	difficulty_level="Beginner";
	    	
	    	
	    }
	    public void setDifficultyIntermediate() 
	    {
	    	
	    	difficulty_level="Intermediate";
	    	
	    	
	    }
	    public void setDifficultyAdvanced() 
	    {
	    	
	    	difficulty_level="Advanced";
	    	
	    	
	    }
	    public ArrayList<String> getMedicalRestrictions() {
	        return medicalRestrictions;
	    }

	   
	    public void addRestrictions(String newres)
	    {
	    	
	    	medicalRestrictions.add(newres);
	    	
	    	
	    }
	    public void viewMedicalRestrictions() {
	        if (medicalRestrictions != null && !medicalRestrictions.isEmpty()) {
	            System.out.println("Medical Restrictions for " + program_title + ":");
	            for (String Restriction : medicalRestrictions) {
	                System.out.println("- " + Restriction);
	            }
	        } else {
	            System.out.println("No medical Restrictions for " + program_title + ".");
	        }
	    }
		/**
		 * @return the maxAge
		 */
		public int getMaxAge() {
			return maxAge;
		}
		/**
		 * @param maxAge the maxAge to set
		 */
		public void setMaxAge(int maxAge) {
			this.maxAge = maxAge;
		}
		/**
		 * @return the minAge
		 */
		public int getMinAge() {
			return minAge;
		}
		/**
		 * @param minAge the minAge to set
		 */
		public void setMinAge(int minAge) {
			this.minAge = minAge;
		}

   

		/**
		 * @return the achievement
		 */
		public String getAchievement() {
			return achievement;
		}



		/**
		 * @param achievement the achievement to set
		 */
		public void setAchievement(String achievement) {
			this.achievement = achievement;
		}


		  public void addRating(double rating) {
		        if (rating >= 0 && rating <= 5) { // Ensure rating is between 0 and 5
		            totalRating += rating; // Add the new rating to the total
		            ratingCount++; // Increment the count of ratings
		            averageRating = totalRating / ratingCount; // Calculate the new average
		        } else {
		            throw new IllegalArgumentException("Rating must be between 0 and 5.");
		        }
		    }

		    public double getAverageRating() {
		        return averageRating; // Return the average rating
		    }
	    
	    
	    
		 // Method to display program details
		    public void displayProgramDetails() {
		        System.out.println("Program Title: " + program_title);
		        System.out.println("Duration: " + duration);
		        System.out.println("Difficulty Level: " + difficulty_level);
		        System.out.println("Goals: " + goals);
		        System.out.println("Focus Area: " + focusArea);
		        System.out.println("Achievement: " + achievement);
		        System.out.printf("Price: $%.2f\n", price);
		        System.out.println("Age Range: " + minAge + " - " + maxAge);
		        System.out.printf("Average Rating: %.2f / 5.0\n", averageRating); // Display average rating formatted to 2 decimal places
		    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	 
	 

	
	
	
	
	
	
	
	
	

