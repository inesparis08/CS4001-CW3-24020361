// Staff main class
public class StaffHire {
    // Staff info
    int vacancyNumber;
    String designation;
    String jobType;
    String staffName;
    String joiningDate;
    String qualification;
    String appointedBy;
    boolean joined;
    
    // Constructor
    public StaffHire(int vacancyNumber, String designation, String jobType, 
                    String staffName, String joiningDate, String qualification, 
                    String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }
    
    // Getters and setters
    
    // Get vacancy number
    public int getVacancyNumber() {
        return vacancyNumber;
    }
    
    // Change vacancy number
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }
    
    // Get job title
    public String getDesignation() {
        return designation;
    }
    
    // Set job title
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    // Get job type
    public String getJobType() {
        return jobType;
    }
    
    // Set job type
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    // Get staff name
    public String getStaffName() {
        return staffName;
    }
    
    // Set staff name
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    // Get join date
    public String getJoiningDate() {
        return joiningDate;
    }
    
    // Set join date
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    // Get qualification
    public String getQualification() {
        return qualification;
    }
    
    // Set qualification
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    // Get who appointed
    public String getAppointedBy() {
        return appointedBy;
    }
    
    // Set who appointed
    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }
    
    // Check if joined
    public boolean isJoined() {
        return joined;
    }
    
    // Set joined status
    public void setJoined(boolean joined) {
        this.joined = joined;
    }
    
    // Show staff details
    public void display() {
        System.out.println("Vacancy #: " + vacancyNumber);
        System.out.println("Job: " + designation);
        System.out.println("Type: " + jobType);
        System.out.println("Name: " + staffName);
        System.out.println("Date: " + joiningDate);
        System.out.println("Qual: " + qualification);
        System.out.println("Appointer: " + appointedBy);
        System.out.println("Joined: " + (joined ? "Yes" : "No"));
    }
}
