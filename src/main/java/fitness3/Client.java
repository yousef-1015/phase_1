package fitness3;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Client {
	
	private Account clinetAccount= new Account();
    private int id; 
    private String name;
    private int age;
    private String email;
    private String fitnessGoal; 
    private String dietaryPreference; 
    private double oldWeight; 
    private double newWeight;
    private double hight; 
    private ArrayList<String> medicalRestrictions=new ArrayList<>();
    private ArrayList<Programm> enrolledPrograms; 
    private ArrayList<Programm> attendedPrograms; 
    private ArrayList<Programm> finishedPrograms = new ArrayList<>();
    private HashMap<Programm, String> achievements; 
    private ArrayList<String> feedbacks; 
    private ArrayList<String> AdminMessages; 

    
    
    
    public Client() 
    {
    	this.id = 0;
        this.name = null;
        this.age = 0;
        this.email = null;
        this.fitnessGoal = null;
        this.dietaryPreference = null;
        this.oldWeight = 0.0;
        this.hight = 0.0;
        this.enrolledPrograms = new ArrayList<>();
        this.achievements = new HashMap<>();
        this.feedbacks = new ArrayList<>();
        this.attendedPrograms = new ArrayList<>(); // Initialize the attended sessions list

    	
    	
    	
    	
    }
    // Constructor
    public Client(int id, String name, int age, String email, String fitnessGoal, String dietaryPreference,Account cc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.fitnessGoal = fitnessGoal;
        this.dietaryPreference = dietaryPreference;
        this.oldWeight = 0.0;
        this.hight = 0.0;
        this.enrolledPrograms = new ArrayList<>();
        this.achievements = new HashMap<>();
        this.feedbacks = new ArrayList<>();
        this.attendedPrograms = new ArrayList<>(); 
        this.setClinetAccount(cc);

    }
    
    // Constructor
    public Client(int id, String name, int age, String email, String fitnessGoal, String dietaryPreference) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.fitnessGoal = fitnessGoal;
        this.dietaryPreference = dietaryPreference;
        this.oldWeight = 0.0;
        this.hight = 0.0;
        this.enrolledPrograms = new ArrayList<>();
        this.achievements = new HashMap<>();
        this.feedbacks = new ArrayList<>();
        this.attendedPrograms = new ArrayList<>(); // Initialize the attended sessions list

    }


    // Methods

    // Getters and Setters
    public void setaccount(Account cc) 
    {
    	this.setClinetAccount(cc);
    	
    	
    	
    }
    
    
    
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) 
    {
    	this.age=age;
    }

    public String getEmail() {
        return email;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public void setDietaryPreference(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }

    public double getOldWeight() {
        return oldWeight;
    }

    public void setOldWeightt(double weight) {
        this.oldWeight = weight;
    }

    public double gethight() {
        return hight;
    }

    public void sethight(double hight) {
        this.hight = hight;
    }

    // Enroll in a program
    public boolean enrollInProgram(Programm program) {
        // Check if the client's age meets the program's age requirements
        if (age < program.getMinAge() || age > program.getMaxAge()) {
            System.out.println("Cannot enroll in " + program.getProgramTitle() + ": Age requirement not met. \nThis program is for ages from: " + program.getMinAge() + " to " + program.getMaxAge());
            return false; // Exit the method if the age requirement is not met
        }

        // Check if the client has any medical restrictions that conflict with the program's restrictions
        for (String restriction : program.getMedicalRestrictions()) {
            if (medicalRestrictions != null && medicalRestrictions.contains(restriction)) {
                System.out.println("Cannot enroll in " + program.getProgramTitle() + ": Medical restriction conflict.");
                return false; // Exit the method if there is a medical restriction conflict
            }
        }

        // If all checks pass, enroll the client in the program
        if (!enrolledPrograms.contains(program)) {
            enrolledPrograms.add(program);
            program.addClient(this);
            System.out.println("Successfully enrolled in " + program.getProgramTitle());
            return true; // Enrollment successful
        }
        return false; // If the program was already enrolled in, return false

    }
    
    // View enrolled programs
    public ArrayList<Programm> getEnrolledPrograms() {
        return new ArrayList<>(enrolledPrograms);
    }

    // Add achievement for a completed program
    public void addAchievement(Programm program, String badge) {
        achievements.put(program, badge);
    }

    // View achievements
    public HashMap<Programm, String> getAchievements() {
        return new HashMap<>(achievements);
    }

    // Submit feedback
    public void submitFeedback(String feedbackMessage) {
        feedbacks.add(feedbackMessage);
    }

    // Get all feedback
    public ArrayList<String> getFeedback() {
        return new ArrayList<>(feedbacks);
    }
    
    public double calculateBMI() {
        return oldWeight / (hight * hight);
    			}
    
    
    
    
    
    public double calculateNewBMI() {
        return newWeight / (hight * hight);
    			}
	/**
	 * @return the medicalRestrictions
	 */
	
	public double getNewWeight() {
		return newWeight;
	}
	/**
	 * @param newWeight the newWeight to set
	 */
	public void setNewWeight(double newWeight) {
		this.newWeight = newWeight;
	}

	public void addRestriction(String newRes) {
		
		
		medicalRestrictions.add(newRes);
		
		
	}
	
	public void printMedicalRestrictions() {
	    if (medicalRestrictions.isEmpty()) {
	        System.out.println("No medical restrictions found.");
	    } else {
	        System.out.println("Medical Restrictions:");
	        for (String restriction : medicalRestrictions) {
	            System.out.println("- " + restriction);
	        }
	    }
	}
	
	public int getAttendedProgramsCount() {
        return attendedPrograms.size(); 
    }
	
    public ArrayList<Programm> getAttendedPrograms() {
        return attendedPrograms;
    }

    public ArrayList<Programm> getCompletedPrograms() {
        return finishedPrograms;
    }
	public int getFinishedProgramsCount() {
        return finishedPrograms.size(); 
    }

	public void completeProgram(Programm pToComplete) {
		
	    if (enrolledPrograms.contains(pToComplete)) {
	    	
	        enrolledPrograms.remove(pToComplete);

	        finishedPrograms.add(pToComplete);

	        String achievement = pToComplete.getAchievement();

	        if (achievement != null && !achievement.isEmpty()) {
	        	
	            achievements.put(pToComplete, achievement);
	        }

	        System.out.println("Program " + pToComplete.getProgramTitle() + " completed successfully.");
	        System.out.println("The goal of this program was: " + pToComplete.getGoals());
	        System.out.println("Your starting weight was: " + oldWeight + " kg.");
	        System.out.println("You managed to lose " + (oldWeight - newWeight) + " kg.");
	    } else {
	        System.out.println("You are not enrolled in the program " + pToComplete.getProgramTitle() + ".");
	    }
	}



	
	
	public ArrayList<Programm> getFinishedPrograms() {
	    return new ArrayList<>(finishedPrograms);
	}
	public void setEmail(String string) {
		this.email=string;
	}
	public void setId(int idd) {
		this.id=idd;		
	}
	public void setName(String namee) {
		this.name=namee;
	}
    
    
    
	 public void viewWeightProgress() {
	        System.out.println("Weight Progress for " + name + ":");
	        System.out.println("Starting Weight: " + oldWeight + " kg");
	        System.out.println("Current Weight: " + newWeight + " kg");

	        double weightChange = oldWeight - newWeight;

	        if (weightChange > 0) {
	            System.out.println("Congratulations! You have lost " + weightChange + " kg.");
	        } else if (weightChange < 0) {
	            System.out.println("You have gained " + Math.abs(weightChange) + " kg. Keep going!");
	        } else {
	            System.out.println("Your weight has not changed. Stay consistent with your goals!");
	        }
	    }
    
	 public void viewBMIProgress() {
		    System.out.println("BMI Progress for " + name + ":");
		    
		    // Calculate starting and current BMI
		    double startingBMI = calculateBMI(); // Assuming oldWeight is the starting weight
		    double currentBMI = calculateNewBMI(); // Assuming newWeight is the current weight

		    System.out.printf("Starting BMI: %.2f\n", startingBMI);
		    System.out.printf("Current BMI: %.2f\n", currentBMI);

		    double bmiChange = startingBMI - currentBMI;

		    if (bmiChange > 0) {
		        System.out.println("Congratulations! Your BMI has decreased by " + Math.abs(bmiChange) + ".");
		    } else if (bmiChange < 0) {
		        System.out.println("Your BMI has increased by " + Math.abs(bmiChange) + ". Keep working towards your goals!");
		    } else {
		        System.out.println("Your BMI has not changed. Stay consistent with your fitness routine!");
		    }
		}
	 public boolean attendProgram(Programm program) {
		    if (enrolledPrograms.contains(program)) {
		        attendedPrograms.add(program);
		        System.out.println("Successfully attended the program: " + program.getProgramTitle());
		        return true; 
		    } else {
		        System.out.println("Cannot attend the program " + program.getProgramTitle() + ": You are not enrolled in it.");
		        return false; 
		    }
		}
	 public boolean viewAttendedPrograms() {
		    if (attendedPrograms.isEmpty()) {
		        System.out.println("You have not attended any programs yet.");
		        return false; // No programs attended
		    } else {
		        System.out.println("Attended Programs for " + name + ":");
		        for (Programm program : attendedPrograms) {
		            System.out.println("- " + program.getProgramTitle());
		        }
		        return true; // Programs attended
		    }
		}
    
    
	  public void viewAchievements() {
	        if (achievements.isEmpty()) {
	            System.out.println("You have not earned any achievements yet. Keep working towards your goals!");
	        } else {
	            System.out.println("🎉 Achievements Earned 🎉");
	            System.out.println("-------------------------");
	            for (Programm program : achievements.keySet()) {
	                String achievement = achievements.get(program);
	                System.out.println("Program: " + program.getProgramTitle());
	                System.out.println("Achievement: " + achievement);
	                System.out.println("-------------------------");
	            }
	            System.out.println("Keep up the great work! 🌟");
	        }
	    }
    
    
	  public void sendFeedback(Programm program, String feedback, Admin admin) {
		    if (finishedPrograms.contains(program)) {
		        feedbacks.add(feedback); // Store feedback locally
		        admin.receiveFeedback(this, program, feedback); // Send feedback to the existing Admin instance
		        JOptionPane.showMessageDialog(null, "Feedback sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        JOptionPane.showMessageDialog(null, "You can only send feedback for finished programs.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
	  public void addAdminMessage(String message) {
	        AdminMessages.add(message);
	    }

	    // Method to view admin messages
	    public void viewAdminMessages() {
	        if (AdminMessages.isEmpty()) {
	            System.out.println("No messages from admin.");
	        } else {
	            System.out.println("Admin Messages:");
	            for (String message : AdminMessages) {
	                System.out.println("- " + message);
	            }
	        }
	    }
	    public void rateProgram(Programm program, double rating) {
	        if (finishedPrograms.contains(program)) {
	            program.addRating(rating); // Add the rating to the program
	            JOptionPane.showMessageDialog(null, "Program rated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "You can only rate finished programs.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		/**
		 * @return the clinetAccount
		 */
		public Account getClinetAccount() {
			return clinetAccount;
		}
		/**
		 * @param clinetAccount the clinetAccount to set
		 */
		public void setClinetAccount(Account clinetAccount) {
			this.clinetAccount = clinetAccount;
		}
		
    
		public void sendSuggestion(Instructor instructorToSend , String suggestion)
		{
			
			instructorToSend.getSuggestionsSent().add("Suggestion from: "+name+" :- \n"+suggestion);
			
		}		
		
		
		
		
		
		
    
}