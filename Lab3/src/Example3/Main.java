package Example3;

class JoinTestThread extends Thread {
    private static int sumOfDividers = 0; // Static variable to hold the sum of dividers

    private int startNumber; // Number to start calculating dividers from

    JoinTestThread(String n, int startNumber) {
        super(n);
        this.startNumber = startNumber;
    }

    public void run() {
        System.out.println("Thread " + this.getName() + " has entered the run() method");

        int dividersSum = calculateDividers(startNumber);

        if (this.getName().equals("Thread 1")) {
            sumOfDividers = dividersSum;
        } else if (this.getName().equals("Thread 2")) {
            while (sumOfDividers == 0) {
                try {
                    Thread.sleep(100); // Wait for sumOfDividers to be set by Thread 1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sumOfDividers += dividersSum;
        }

        System.out.println("Thread " + this.getName() + " has finished. Sum of dividers: " + dividersSum);
    }

    private int calculateDividers(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int getSumOfDividers() {
        return sumOfDividers;
    }
}
public class Main {

    public static void main(String[] args) {

        JoinTestThread w1 = new JoinTestThread("Thread 1", 50000);
        JoinTestThread w2 = new JoinTestThread("Thread 2", 20000);

        w1.start();
        w2.start();

        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = JoinTestThread.getSumOfDividers();
        System.out.println("Total sum of dividers: " + totalSum);
    }
}
