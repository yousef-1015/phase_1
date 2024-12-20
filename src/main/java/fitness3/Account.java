package fitness3;

import java.util.Date;


import javax.swing.JOptionPane;

public class Account 
{
	private String username;
	private String password;
	private String C;
	private String role;
	private String Status;
	private Integer hours;
	private String birthdate;
	private String phonenumber;
	private String Feedback;
	
	public boolean check;
	public boolean test;
	private double hoursWorkedThisMonth;
	private double totalHoursWorked;
	private double payRate;
	private double totalPay;
	private Date joinDate;
	private int clientsManaged;
	
	
	
	
	   
	public Account(String username, String password, String role, String status, String birthdate, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.Status = status;
        this.birthdate = birthdate;
        this.phonenumber = phoneNumber;
        this.hoursWorkedThisMonth = 0;
        this.totalHoursWorked = 0;
        this.payRate = 10; // default pay rate
        this.totalPay = 0;
        this.joinDate = new Date();
        this.clientsManaged = 0;
        this.Feedback=null;
    }
	// Default constructor
    public Account() {
        this.username = "defaultUser ";
        this.password = "defaultPass";
        this.role = "defaultrole"; // Default role
        this.Status = "active";
        this.birthdate = "0/0/0" ;// Default to current date
        this.phonenumber = "000-000-0000"; // Default phone number
        this.hoursWorkedThisMonth = 0;
        this.totalHoursWorked = 0;
        this.payRate = 10; // default pay rate
        this.totalPay = 0;
        this.joinDate = new Date();
        this.clientsManaged = 0;
        this.Feedback=null;

    }



	public void setUsername(String username)
	{
		this.username=username;
	} 
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setRole(String role2) {
		
		this.role = role2;
	}
	
	public String getRole( ) {
		return role;
	}
	
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getStatus() {
    	
        return Status;
    }
   
    public void setStatus(String status) {
        this.Status = status;
    }
    public void Deactivate() {
    	Status=null;
       
    }
    public String getRoleAsString() {
        if (role != null) {
            return role;
        } else {
            return "No role assigned";
        }
    }
	
	
	 public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }
	    
	    public String getBirthdate() {
	        return birthdate;
	    }

	    public void setBirthdate(String birthdate) {
	        this.birthdate = birthdate;
	    }

	
	
	
	public void loginone(String usernamekk , String passwordkk) 
	{
		if (usernamekk.equals(username) && passwordkk.equals(password)) 
		{
			
			check = true;
			
		}
		else
		{
			check= false;
			
			
		}
		
		
		
	}
	
	
	public void checkstatus(String username) {
		if (Status.equalsIgnoreCase("active")) {
			test= true;
		
			
	}
		test =false;
		
		
		
	}
	public boolean gettest(String username) {
		return test;
	}
	public void settest(boolean r) {
		test=r;
		
	}
	public void addHoursWorked(double hours) {
		this.hoursWorkedThisMonth += hours;
		this.totalHoursWorked += hours;
		this.totalPay += hours * this.payRate;
	}
	
	public double getHoursWorkedThisMonth() {
		return this.hoursWorkedThisMonth;
	}
	
	public double getTotalHoursWorked() {
		return this.totalHoursWorked;
	}
	
	public double getTotalPay() {
		return this.totalPay;
	}
	
	public Date getJoinDate() {
		return this.joinDate;
	}
	public void setJoinDate(Date joinDate) {
	    this.joinDate = joinDate;
	}
	public void addClient() {
		this.clientsManaged++;
	}
	
	public int getNumClientsManaged() {
		return this.clientsManaged;
	}
	
	public String getActivityStatistics() {
	    StringBuilder stats = new StringBuilder();
	    stats.append("Hours Worked This Month: ").append(hoursWorkedThisMonth).append("\n");
	    stats.append("Total Hours Worked: ").append(totalHoursWorked).append("\n");
	    stats.append("Pay Rate: $").append(payRate).append("\n");
	    stats.append("Total Pay: $").append(totalPay).append("\n");
	    stats.append("Join Date: ").append(joinDate.toString()).append("\n");
	    stats.append("Clients Managed: ").append(clientsManaged).append("\n");
	    return stats.toString();
	}
	
	
	public String getfeedback() {
		
		return Feedback ;
		
	}
	
	
	
	
	public void setfeedback(String newfeedback) {
		
		
		this.Feedback=newfeedback;
	}
}
	
	
	
	
	
	
	

