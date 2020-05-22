import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email :" + this.firstName + " " + this.lastName);

        // Call a method asking for department and return department name
        this.department = setDepartment();
        //System.out.println("Department is: " + this.department);

        // Call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("Your new email is: " + email);

    }


    // Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + ". Department Codes: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \nEnter department code: ");
        Scanner input = new Scanner(System.in);
        int deptChoice = input.nextInt();
        if (deptChoice == 1){
            return "sales";
        } else if (deptChoice == 2){
            return "dev";
        } else if (deptChoice == 3){
            return "acct";
        } else {
            return " ";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
        char[] password = new char[length];

        for(int i = 0; i<length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void setChangePassword(String password){
        this.password = password;
    }

    // Getters for Email class
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getChangePassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + 
               "\nCOMPANY EMAIL: " + email + 
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";

    }

    
}