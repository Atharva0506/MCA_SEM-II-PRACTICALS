class Student {
    void SetDetails(int rollNo, String name) {
        // Default implementation (can be empty)
    }
}

public class Q2 {
    public static void main(String[] args) {
        // Creating an anonymous class implementing SetDetails method
        Student student = new Student() {
            @Override
            void SetDetails(int rollNo, String name) {
                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
            }
        };

        // Calling SetDetails with example values
        student.SetDetails(101, "Luffy");
    }
}
