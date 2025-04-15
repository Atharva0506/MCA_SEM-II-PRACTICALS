import java.util.Scanner;

// Abstract class Staff
abstract class Staff {
    protected int id;
    protected String name;

    // Parameterized constructor
    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract method to display details
    abstract void display();
}

// Subclass OfficeStaff
class OfficeStaff extends Staff {
    private String department;

    // Parameterized constructor
    public OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    // Overriding display method
    @Override
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("--------------------------");
    }
}

// Main class
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of Office Staff: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        OfficeStaff[] staffArray = new OfficeStaff[n];

        // Taking input for n staff members
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Staff " + (i + 1) + ":");

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            staffArray[i] = new OfficeStaff(id, name, department);
        }

        System.out.println("\nDisplaying Office Staff Details:");
        System.out.println("===========================");
        for (OfficeStaff staff : staffArray) {
            staff.display();
        }

        

        scanner.close();
    }
}
