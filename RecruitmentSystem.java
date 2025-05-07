import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.util.*;
 

public class RecruitmentSystem {
    // List for staff
    ArrayList<StaffHire> staffList;
    
    // Window
    JFrame frame;
    JPanel mainPanel, inputPanel, buttonPanel;
    
    // Text boxes
    JTextField txtVacancyNumber, txtDesignation, txtJobType, txtStaffName;
    JTextField txtJoiningDate, txtQualification, txtAppointedBy;
    JCheckBox chkJoined;
    JTextField txtSalary, txtWeeklyFractionalHours;
    JTextField txtWorkingHour, txtWagesPerHour, txtShifts;
    JTextField txtDisplayNumber, txtTerminateNumber;
    
    // Buttons
    JButton btnAddFullTimeStaff, btnAddPartTimeStaff;
    JButton btnSetSalary, btnSetShifts, btnTerminateStaff, btnDisplay, btnDisplayAll;
    
    // Start program
    public RecruitmentSystem() {
        staffList = new ArrayList<>();
        makeWindow();
    }
    
    // Make window
    private void makeWindow() {
        frame = new JFrame("Staff System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        inputPanel = new JPanel(new GridLayout(15, 2));
        buttonPanel = new JPanel();
        
        top.add(new JLabel("Staff System"));
        
        addFields();
        addButtons();
        
        mainPanel.add(top, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        
        frame.setVisible(true);
    }
    
    // Add fields
    private void addFields() {
        // Make all labels and text boxes
        inputPanel.add(new JLabel("Vacancy #:"));
        txtVacancyNumber = new JTextField(8);
        inputPanel.add(txtVacancyNumber);
        
        inputPanel.add(new JLabel("Job:"));
        txtDesignation = new JTextField(8);
        inputPanel.add(txtDesignation);
        
        inputPanel.add(new JLabel("Type:"));
        txtJobType = new JTextField(8);
        inputPanel.add(txtJobType);
        
        inputPanel.add(new JLabel("Name:"));
        txtStaffName = new JTextField(8);
        inputPanel.add(txtStaffName);
        
        inputPanel.add(new JLabel("Join Date:"));
        txtJoiningDate = new JTextField(8);
        inputPanel.add(txtJoiningDate);
        
        inputPanel.add(new JLabel("Qualification:"));
        txtQualification = new JTextField(8);
        inputPanel.add(txtQualification);
        
        inputPanel.add(new JLabel("Appointer:"));
        txtAppointedBy = new JTextField(8);
        inputPanel.add(txtAppointedBy);
        
        inputPanel.add(new JLabel("Joined:"));
        chkJoined = new JCheckBox();
        inputPanel.add(chkJoined);
        
        inputPanel.add(new JLabel("Salary:"));
        txtSalary = new JTextField(8);
        inputPanel.add(txtSalary);
        
        inputPanel.add(new JLabel("Weekly Hrs:"));
        txtWeeklyFractionalHours = new JTextField(8);
        inputPanel.add(txtWeeklyFractionalHours);
        
        inputPanel.add(new JLabel("Work Hrs:"));
        txtWorkingHour = new JTextField(8);
        inputPanel.add(txtWorkingHour);
        
        inputPanel.add(new JLabel("Wage:"));
        txtWagesPerHour = new JTextField(8);
        inputPanel.add(txtWagesPerHour);
        
        inputPanel.add(new JLabel("Shifts:"));
        txtShifts = new JTextField(8);
        inputPanel.add(txtShifts);
        
        inputPanel.add(new JLabel("Display #:"));
        txtDisplayNumber = new JTextField(8);
        inputPanel.add(txtDisplayNumber);
        
        inputPanel.add(new JLabel("Terminate #:"));
        txtTerminateNumber = new JTextField(8);
        inputPanel.add(txtTerminateNumber);
    }
    
    // make all buttons
    private void addButtons() {
        // create buttons
        btnAddFullTimeStaff = new JButton("Add Full-Time");
        btnAddPartTimeStaff = new JButton("Add Part-Time");
        btnSetSalary = new JButton("Set Salary");
        btnSetShifts = new JButton("Set Shifts");
        btnTerminateStaff = new JButton("Terminate");
        btnDisplay = new JButton("Display");
        btnDisplayAll = new JButton("Display All");
        
        // button actions
        btnAddFullTimeStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { addFullTimeStaff(); }
        });
        
        btnAddPartTimeStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { addPartTimeStaff(); }
        });
        
        btnSetSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { setSalary(); }
        });
        
        btnSetShifts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { setShifts(); }
        });
        
        btnTerminateStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { terminateStaff(); }
        });
        
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { displayStaff(); }
        });
        
        btnDisplayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { displayAllStaff(); }
        });
        
        // add to panel
        buttonPanel.add(btnAddFullTimeStaff);
        buttonPanel.add(btnAddPartTimeStaff);
        buttonPanel.add(btnSetSalary);
        buttonPanel.add(btnSetShifts);
        buttonPanel.add(btnTerminateStaff);
        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnDisplayAll);
    }
    
    // add a full time staff
    private void addFullTimeStaff() {
        try {
            // get the values from text boxes
            int vacancyNum = validateAndParseInt(txtVacancyNumber.getText(), "Vacancy Number");
            String designation = validateNotEmpty(txtDesignation.getText(), "Designation");
            String jobType = validateNotEmpty(txtJobType.getText(), "Job Type");
            String name = validateNotEmpty(txtStaffName.getText(), "Name");
            String date = validateNotEmpty(txtJoiningDate.getText(), "Date");
            String qual = validateNotEmpty(txtQualification.getText(), "Qualification");
            String appointer = validateNotEmpty(txtAppointedBy.getText(), "Appointer");
            boolean joined = chkJoined.isSelected();
            
            // get salary info
            double salary = validateAndParseDouble(txtSalary.getText(), "Salary");
            int hours = validateAndParseInt(txtWeeklyFractionalHours.getText(), "Hours");
            
            // make the new staff
            FullTimeStaffHire staff = new FullTimeStaffHire(
                vacancyNum, designation, jobType, name, date, 
                qual, appointer, joined, salary, hours
            );
            
            // Add to list
            staffList.add(staff);
            
            // Show message
            JOptionPane.showMessageDialog(frame, "Added full time staff!");
            
            // Clear the boxes
            clearInputFields();
        } catch (Exception ex) {
            // Show error
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
    
    // add a part time staff
    private void addPartTimeStaff() {
        try {
            // get the values from text boxes
            int vacancyNum = validateAndParseInt(txtVacancyNumber.getText(), "Vacancy Number");
            String designation = validateNotEmpty(txtDesignation.getText(), "Designation");
            String jobType = validateNotEmpty(txtJobType.getText(), "Job Type");
            String name = validateNotEmpty(txtStaffName.getText(), "Name");
            String date = validateNotEmpty(txtJoiningDate.getText(), "Date");
            String qual = validateNotEmpty(txtQualification.getText(), "Qualification");
            String appointer = validateNotEmpty(txtAppointedBy.getText(), "Appointer");
            boolean joined = chkJoined.isSelected();
            
            // get part time info
            int hours = validateAndParseInt(txtWorkingHour.getText(), "Hours");
            double wage = validateAndParseDouble(txtWagesPerHour.getText(), "Wage");
            String shifts = validateNotEmpty(txtShifts.getText(), "Shifts");
            
            // make new staff
            PartTimeStaffHire staff = new PartTimeStaffHire(
                vacancyNum, designation, jobType, name, date, 
                qual, appointer, joined, hours, wage, shifts
            );
            
            // Add to list
            staffList.add(staff);
            
            // Show message
            JOptionPane.showMessageDialog(frame, "Added part time staff!");
            
            // Clear the boxes
            clearInputFields();
        } catch (Exception ex) {
            // Show error
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
    
    // set salary for full time staff
    private void setSalary() {
        try {
            // Get input values
            int vacancyNum = validateAndParseInt(txtVacancyNumber.getText(), "Vacancy Number");
            String name = validateNotEmpty(txtStaffName.getText(), "Name");
            double salary = validateAndParseDouble(txtSalary.getText(), "Salary");
            
            // Find the staff
            boolean found = false;
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNum && staff.getStaffName().equals(name)) {
                    // Check if full time
                    if (staff instanceof FullTimeStaffHire) {
                        // Change salary
                        FullTimeStaffHire fullStaff = (FullTimeStaffHire) staff;
                        fullStaff.setSalary(salary);
                        
                        // Show message
                        JOptionPane.showMessageDialog(frame, "Salary updated!");
                        found = true;
                        break;
                    } else {
                        // Wrong type
                        JOptionPane.showMessageDialog(frame, "Not a full-time staff!");
                        found = true;
                        break;
                    }
                }
            }
            
            // Not found
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Staff not found!");
            }
        } catch (Exception ex) {
            // Error
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
    
    // Set shifts for part time staff
    private void setShifts() {
        try {
            // Get input values
            int vacancyNum = validateAndParseInt(txtVacancyNumber.getText(), "Vacancy Number");
            String name = validateNotEmpty(txtStaffName.getText(), "Name");
            String shifts = validateNotEmpty(txtShifts.getText(), "Shifts");
            
            // Find the staff
            boolean found = false;
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNum && staff.getStaffName().equals(name)) {
                    // Check if part time
                    if (staff instanceof PartTimeStaffHire) {
                        // Change shifts
                        PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;
                        partStaff.setShifts(shifts);
                        
                        // Show message
                        JOptionPane.showMessageDialog(frame, "Shifts updated!");
                        found = true;
                        break;
                    } else {
                        // Wrong type
                        JOptionPane.showMessageDialog(frame, "Not a part-time staff!");
                        found = true;
                        break;
                    }
                }
            }
            
            // Not found
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Staff not found!");
            }
        } catch (Exception ex) {
            // Error
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
    
    // Terminate a part time staff
    private void terminateStaff() {
        try {
            // Get vacancy number
            int vacancyNum = validateAndParseInt(txtTerminateNumber.getText(), "Number");
            
            // Find the staff
            boolean found = false;
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNum) {
                    // Check if part time
                    if (staff instanceof PartTimeStaffHire) {
                        // Terminate
                        PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;
                        partStaff.terminateStaff();
                        
                        // Show message
                        JOptionPane.showMessageDialog(frame, "Staff terminated!");
                        found = true;
                        break;
                    } else {
                        // Wrong type
                        JOptionPane.showMessageDialog(frame, "Not a part-time staff!");
                        found = true;
                        break;
                    }
                }
            }
            
            // Not found
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Staff not found!");
            }
        } catch (Exception ex) {
            // Error
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
    
    // Method to show a single staff member
    private void displayStaff() {
        try {
            // Get the display number from text field
            int displayNumber = validateAndParseDisplayNumber(txtDisplayNumber.getText());
            
            // Check if number is valid
            if (displayNumber >= 0 displayNumber < staffList.size()) {
                // Get the staff from list
                StaffHire staff = staffList.get(displayNumber);
                
                // Make a message with all the details
                String message = "";
                
                // Add staff type
                if (staff instanceof FullTimeStaffHire) {
                    message += "FULL-TIME STAFF DETAILS";
                } else if (staff instanceof PartTimeStaffHire) {
                    message += "PART-TIME STAFF DETAILS";
                } else {
                    message += "STAFF DETAILS";
                }
                
                // Add basic info
                message += "Vacancy Number: " + staff.getVacancyNumber() + "\n";
                message += "Designation: " + staff.getDesignation() + "\n";
                message += "Job Type: " + staff.getJobType() + "\n";
                message += "Name: " + staff.getStaffName() + "\n";
                message += "Joining Date: " + staff.getJoiningDate() + "\n";
                message += "Qualification: " + staff.getQualification() + "\n";
                message += "Appointed By: " + staff.getAppointedBy() + "\n";
                message += "Joined: " + (staff.isJoined() ? "Yes" : "No") + "\n";
                
                // Add type info
                if (staff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire fullStaff = (FullTimeStaffHire) staff;
                    message += "Salary: $" + fullStaff.getSalary() + "\n";
                    message += "Weekly Hours: " + fullStaff.getWeeklyFractionalHours() + "\n";
                } else if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;
                    message += "Working Hours: " + partStaff.getWorkingHour() + "\n";
                    message += "Hourly Wage: $" + partStaff.getWagesPerHour() + "\n";
                    message += "Shifts: " + partStaff.getShifts() + "\n";
                    message += "Terminated: " + (partStaff.isTerminated() ? "Yes" : "No") + "\n";
                    
                    // Calculate daily pay
                    double dailyPay = partStaff.getWorkingHour() * partStaff.getWagesPerHour();
                    message += "Daily Pay: $" + dailyPay + "\n";
                }
                
                // Show message in a dialog
                JOptionPane.showMessageDialog(frame, message, "Staff Info", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                // Show error if number is invalid
                JOptionPane.showMessageDialog(frame, "No staff with number " + displayNumber);
            }
        } catch (Exception ex) {
            // show error for any problems
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
    
    // get a number
    private int validateAndParseInt(String input, String field) {
        if(input.equals(""))
            throw new IllegalArgumentException("Enter " + field);
        
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(field + " must be a number");
        }
    }
    
    // get a decimal
    private double validateAndParseDouble(String input, String field) {
        if(input.equals(""))
            throw new IllegalArgumentException("Enter " + field);
        
        try {
            return Double.parseDouble(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(field + " must be a number");
        }
    }
    
    // check not empty
    private String validateNotEmpty(String input, String field) {
        if(input.equals(""))
            throw new IllegalArgumentException("Enter " + field);
        return input;
    }
    
    // get display number
    private int validateAndParseDisplayNumber(String input) {
        if(input.equals(""))
            throw new IllegalArgumentException("Enter a number");
        
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Must be a number");
        }
    }
    
    // clear all boxes
    private void clearInputFields() {
        // clear everything
        txtVacancyNumber.setText("");
        txtDesignation.setText("");
        txtJobType.setText("");
        txtStaffName.setText("");
        txtJoiningDate.setText("");
        txtQualification.setText("");
        txtAppointedBy.setText("");
        chkJoined.setSelected(false);
        txtSalary.setText("");
        txtWeeklyFractionalHours.setText("");
        txtWorkingHour.setText("");
        txtWagesPerHour.setText("");
        txtShifts.setText("");
        txtDisplayNumber.setText("");
        txtTerminateNumber.setText("");
    }
    
    // Show all staff
    private void displayAllStaff() {
        // Check if no staff
        if(staffList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No staff yet!");
            return;
        }
        
        // Make panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Title
        panel.add(new JLabel("Staff List"), BorderLayout.NORTH);
        
        // Text box
        JTextArea text = new JTextArea(20, 40);
        text.setEditable(false);
        text.setLineWrap(true);
        
        // Make text for display
        String allText = "";
        
        // Loop through staff
        for(int i = 0; i < staffList.size(); i++) {
            StaffHire staff = staffList.get(i);
            
            // Line between each staff
            if(i > 0) {
                allText += "\n-----\n\n";
            }
            
            // Show staff number
            allText += "Staff #" + i + "\n";
            
            // Show type
            if(staff instanceof FullTimeStaffHire) {
                allText += "Type: Full-Time\n";
            } else if(staff instanceof PartTimeStaffHire) {
                allText += "Type: Part-Time\n";
            } else {
                allText += "Type: Unknown\n";
            }
            
            // Show basic info
            allText += "Vacancy #: " + staff.getVacancyNumber() + "\n";
            allText += "Job: " + staff.getDesignation() + "\n";
            allText += "Type: " + staff.getJobType() + "\n";
            allText += "Name: " + staff.getStaffName() + "\n";
            allText += "Date: " + staff.getJoiningDate() + "\n";
            allText += "Qual: " + staff.getQualification() + "\n";
            allText += "Appointed By: " + staff.getAppointedBy() + "\n";
            allText += "Joined: " + (staff.isJoined() ? "Yes" : "No") + "\n";
            
            // Show special info
            if(staff instanceof FullTimeStaffHire) {
                FullTimeStaffHire fullStaff = (FullTimeStaffHire)staff;
                allText += "Salary: $" + fullStaff.getSalary() + "\n";
                allText += "Hours: " + fullStaff.getWeeklyFractionalHours() + "\n";
            } else if(staff instanceof PartTimeStaffHire) {
                PartTimeStaffHire partStaff = (PartTimeStaffHire)staff;
                allText += "Hours: " + partStaff.getWorkingHour() + "\n";
                allText += "Wage: $" + partStaff.getWagesPerHour() + "\n";
                allText += "Shifts: " + partStaff.getShifts() + "\n";
                allText += "Terminated: " + (partStaff.isTerminated() ? "Yes" : "No") + "\n";
                
                // Calculate pay
                double pay = partStaff.getWorkingHour() * partStaff.getWagesPerHour();
                allText += "Daily Pay: $" + pay + "\n";
            }
        }
        
        // Show text
        text.setText(allText);
        panel.add(new JScrollPane(text), BorderLayout.CENTER);
        
        // Add close button
        JButton close = new JButton("Close");
        JPanel btnPanel = new JPanel();
        btnPanel.add(close);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        // Make window
        final JDialog dialog = new JDialog(frame, "All Staff", true);
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        
        // Make close button work
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        
        // Show window
        dialog.setVisible(true);
    }
    
    // Main method
    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
