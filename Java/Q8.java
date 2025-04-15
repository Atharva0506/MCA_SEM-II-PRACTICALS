import java.util.Hashtable;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a Hashtable to store city names and their STD codes
        Hashtable<String, String> cityCodes = new Hashtable<>();

        // Adding city and STD codes
        cityCodes.put("Mumbai", "022");
        cityCodes.put("Delhi", "011");
        cityCodes.put("Pune", "020");
        cityCodes.put("Chennai", "044");
        cityCodes.put("Kolkata", "033");

        // Displaying all city-STD codes
        System.out.println("\nCity Name - STD Code:");
        for (String city : cityCodes.keySet()) {
            System.out.println(city + " - " + cityCodes.get(city));
        }

        // Searching for a specific city
        System.out.print("\nEnter a city name to find its STD code: ");
        String searchCity = sc.nextLine();

        // Checking if city exists
        if (cityCodes.containsKey(searchCity)) {
            System.out.println("The STD code of " + searchCity + " is: " + cityCodes.get(searchCity));
        } else {
            System.out.println("City not found in the database.");
        }

        sc.close();
    }
}

