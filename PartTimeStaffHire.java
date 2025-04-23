
public class PartTimeStaffHire extends StaffHire {
    // Instance variables
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    
   //constructior
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, 
                            String staffName, String joiningDate, String qualification, 
                            String appointedBy, boolean joined, int workingHour, 
                            double wagesPerHour, String shifts) {
        // Call the superclass constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, 
             qualification, appointedBy, joined);
        
        // Initialize the attributes specific to part-time staff
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;  // Initially not terminated
    }
    
    //Get the working hour
    
    public int getWorkingHour() {
        return workingHour;
    }
    
    //Set the working hour
    
    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }
    
    // Get the wages per hour
    
    public double getWagesPerHour() {
        return wagesPerHour;
    }
    
    // Set the wages per hour
     
    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }
    
    //Get the shifts
     
    public String getShifts() {
        return shifts;
    }
    
    //Set the shifts
     
    public void setShifts(String shifts) {
        if(isJoined() && !terminated) {
            this.shifts = shifts;
        } else if(terminated) {
            System.out.println("Error: Cannot change shifts as the staff has been terminated.");
        } else {
            System.out.println("Error: Cannot change shifts as the staff has not joined yet.");
        }
    }
    
   // Get terminated status
    
    public boolean isTerminated() {
        return terminated;
    }
    
    //Terminate the part-time staff
     
    public void terminateStaff() {
        if(terminated) {
            System.out.println("This staff is already terminated.");
        } else {
            // Set staff details to empty
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            
            // Update the terminated status
            this.terminated = true;
            System.out.println("Staff has been terminated successfully.");
        }
    }
    
 
     //Override the display method from the parent class
     
    @Override
    public void display() {
        // Call the display method from the parent class
        super.display();
        
        // Display the attributes specific to part-time staff
        if(isJoined() && !terminated) {
            System.out.println("Working Hours per Day: " + workingHour);
            System.out.println("Wages per Hour: $" + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + (terminated ? "Yes" : "No"));
            
            // Calculate and display the income per day
            double incomePerDay = workingHour * wagesPerHour;
            System.out.println("Income per Day: $" + incomePerDay);
        } else if(terminated) {
            System.out.println("This staff has been terminated.");
        }
    }
}
