class ContinuousNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(100); // Small delay for better visibility
            } catch (InterruptedException e) {
                System.out.println("ContinuousNumbers Interrupted");
            }
        }
    }
}

class EvenNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("EvenNumbers Interrupted");
            }
        }
    }
}

class OddNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("OddNumbers Interrupted");
            }
        }
    }
}

public class Q11 {
    public static void main(String[] args) {
        // Creating Runnable objects
        Runnable continuous = new ContinuousNumbers();
        Runnable even = new EvenNumbers();
        Runnable odd = new OddNumbers();

        // Creating Threads
        Thread t1 = new Thread(continuous);
        Thread t2 = new Thread(even);
        Thread t3 = new Thread(odd);

        // Starting Threads
        t1.start();
        t2.start();
        t3.start();
    }
}
