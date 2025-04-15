import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        // Accepting 'n' integers from the user
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt()); // Adding numbers to ArrayList
        }

        // Display elements in reverse order using ListIterator
        System.out.println("\nElements in reverse order:");
        ListIterator<Integer> itr = numbers.listIterator(numbers.size());
        while (itr.hasPrevious()) {
            System.out.print(itr.previous() + " ");
        }

        sc.close();
    }
}
