
public class FullTimeStaffHire extends StaffHire {
    // class variables 
    private double salary;
    private int weeklyFractionalHours;
    
    //constructor
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, 
                            String staffName, String joiningDate, String qualification, 
                            String appointedBy, boolean joined, double salary, 
                            int weeklyFractionalHours) {
        // Call the superclass construtor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, 
             qualification, appointedBy, joined);
        
        // init the attributes for the class
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    //Get the salary
    
    public double getSalary() {
        return salary;
    }
    
    //Set the salary
     
    public void setSalary(double salary) {
        if(isJoined()) {
            this.salary = salary;
        } else {
            System.out.println("Error: Cannot set salary as the staff has not joined yet.");
        }
    }
    
    //Get the weekly fractional hours
     
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }
    
   
     //Set the weekly fractional hours
     
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    //Override parent call
    @Override
    public void display() {
        // Call the display method from the parent class
        super.display();
        
        // Display the attributes for full-time staff
        if(isJoined()) {
            System.out.println("Salary: $" + salary);
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
        }
    }
}
