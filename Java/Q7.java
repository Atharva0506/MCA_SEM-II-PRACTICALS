import java.util.Scanner;
import java.util.TreeSet;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // TreeSet stores unique elements in sorted order
        TreeSet<Integer> numbers = new TreeSet<>();

        // Accepting 'n' integers from the user
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt()); // TreeSet will handle duplicates
        }

        // Displaying sorted elements
        System.out.println("\nSorted elements (No duplicates): " + numbers);

        // Searching for an element
        System.out.print("\nEnter a number to search: ");
        int searchElement = sc.nextInt();

        if (numbers.contains(searchElement)) {
            System.out.println(searchElement + " is found in the collection.");
        } else {
            System.out.println(searchElement + " is NOT found in the collection.");
        }

        sc.close();
    }
}
