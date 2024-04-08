package App1;

public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
        Integer monitor2 = new Integer(2);
        new ExecutionThread1(monitor, 2, 4, 5).start();
        new ExecutionThread1(monitor, 2, 5, 5).start();
        new ExecutionThread2(monitor, monitor2, 3, 6, 3).start();
    }
}
