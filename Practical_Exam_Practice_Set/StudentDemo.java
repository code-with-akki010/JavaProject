import java.util.Scanner;

// Custom Exception
class StudentAgeOutOfPermissibleRange extends Exception {
    public StudentAgeOutOfPermissibleRange(String message) {
        super(message);
    }
}

// Student Class
class Student {
    private String name;
    private int age;
    private String address;
    private String parentName;
    private String subject;

    // Constructor
    public Student(String name, int age, String address, String parentName, String subject) 
            throws StudentAgeOutOfPermissibleRange {
        if (age < 16 || age > 40) {
            throw new StudentAgeOutOfPermissibleRange(
                "Invalid Age: " + age + ". Age must be between 16 and 40."
            );
        }
        this.name = name;
        this.age = age;
        this.address = address;
        this.parentName = parentName;
        this.subject = subject;
    }

    // Display details
    public void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Address    : " + address);
        System.out.println("Parent Name: " + parentName);
        System.out.println("Subject    : " + subject);
    }
}

// Driver Class
public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input student details
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            System.out.print("Enter Parent's Name: ");
            String parentName = sc.nextLine();

            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();

            // Create Student object (may throw exception)
            Student st = new Student(name, age, address, parentName, subject);

            // If no exception, display details
            st.display();

        } catch (StudentAgeOutOfPermissibleRange e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid Input!");
        } finally {
            sc.close();
        }
    }
}

