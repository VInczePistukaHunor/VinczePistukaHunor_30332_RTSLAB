public class Fir extends Thread {
    int id;
    FirModel model;
    int processorLoad;

    Fir(int id, int priority, FirModel model, int procLoad) {
        this.id = id;
        this.model = model;
        this.processorLoad = procLoad;
        this.setPriority(priority);
    }

    public void run() {
        int c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
                j--;
            }
            c++;
            model.setProgress(id, c);
        }
    }
}
