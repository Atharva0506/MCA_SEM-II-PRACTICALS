class PrintTextThread extends Thread {
    private String text;
    private int count;

    // Constructor to initialize text and count
    public PrintTextThread(String text, int count) {
        this.text = text;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(getName() + ": " + text);
            try {
                Thread.sleep(100); // Adding a small delay for better visibility
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

public class Q12 {
    public static void main(String[] args) {
        // Creating 3 threads with different texts and counts
        PrintTextThread t1 = new PrintTextThread("COVID19", 10);
        PrintTextThread t2 = new PrintTextThread("LOCKDOWN2020", 20);
        PrintTextThread t3 = new PrintTextThread("VACCINATED2021", 30);

        // Starting the threads
        t1.start();
        t2.start();
        t3.start();
    }
}
