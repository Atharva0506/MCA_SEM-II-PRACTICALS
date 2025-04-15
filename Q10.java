import java.util.Random;

class MyThread extends Thread {
    // Constructor to set thread name
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " - Thread created");

        // Generate a random sleep time between 0 to 4999 ms
        int sleepTime = new Random().nextInt(5000);
        System.out.println(getName() + " - Sleeping for " + sleepTime + " ms");

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println(getName() + " - Interrupted");
        }

        System.out.println(getName() + " - Thread is now dead");
    }
}

public class Q10 {
    public static void main(String[] args) {
        // Creating two threads with hardcoded names
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");

        // Start the threads (moves to RUNNABLE state)
        thread1.start();
        thread2.start();
    }
}
