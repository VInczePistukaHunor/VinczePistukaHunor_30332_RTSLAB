package App1;

public class ExecutionThread2 extends Thread {
    Integer monitor, monitor2;
    int sleep_min, sleep_max, activity;

    public ExecutionThread2(Integer monitor2,Integer monitor, int sleep_min, int
            sleep_max, int activity) {
        this.monitor2 = monitor2;
        this.monitor = monitor;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity = activity;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 5");
        try {
            Thread.sleep(Math.round(Math.random() * (sleep_max
                    - sleep_min) + sleep_min) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 6");
        synchronized (monitor) {
            synchronized (monitor2) {
                System.out.println(this.getName() + " - STATE 7");
                int k = (int) Math.round(Math.random() * activity);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }
        }
        System.out.println(this.getName() + " - STATE 8");
    }
}

