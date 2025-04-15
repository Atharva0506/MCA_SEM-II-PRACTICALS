import java.util.Scanner;

// User-defined exception
class NumberIsZeroException extends Exception {
    public NumberIsZeroException(String message) {
        super(message);
    }
}

class PrimeChecker {
    // Static method to check prime number
    static void checkPrime(int num) throws NumberIsZeroException {
        if (num == 0) {
            throw new NumberIsZeroException("Number is 0");
        }

        boolean isPrime = true;
        if (num < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(num + " is a Prime Number.");
        } else {
            System.out.println(num + " is NOT a Prime Number.");
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Accept input from the user
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            // Call static method to check prime
            PrimeChecker.checkPrime(num);

        } catch (NumberIsZeroException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        } finally {
            sc.close();
        }
    }
}
