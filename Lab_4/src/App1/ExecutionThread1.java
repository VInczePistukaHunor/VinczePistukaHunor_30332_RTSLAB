package App1;

public class ExecutionThread1 extends Thread {
    Integer monitor;
    int sleep_min, sleep_max, activity;

    public ExecutionThread1(Integer monitor, int sleep_min, int
            sleep_max, int activity) {
        this.monitor = monitor;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity = activity;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep(Math.round(Math.random() * (sleep_max
                    - sleep_min) + sleep_min) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2");
        synchronized (monitor) {
            System.out.println(this.getName() + " - STATE 3");
            int k = (int) Math.round(Math.random() * activity);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
        System.out.println(this.getName() + " - STATE 4");
    }
}
