import java.util.Observable;

class FirProgress {
    private int id;
    private int progress;

    public FirProgress(int id, int progress) {
        this.id = id;
        this.progress = progress;
    }

    public int getId() {
        return id;
    }

    public int getProgress() {
        return progress;
    }
}

public class FirModel extends Observable {
    private int[] progressValues;

    public FirModel(int nrThreads) {
        progressValues = new int[nrThreads];
    }

    public void setProgress(int id, int progress) {
        progressValues[id] = progress;
        setChanged();
        notifyObservers(new FirProgress(id, progress));
    }
}
