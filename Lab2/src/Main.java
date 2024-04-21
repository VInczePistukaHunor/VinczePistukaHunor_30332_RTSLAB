public class Main {
    private static final int noOfThreads = 6;
    private static final int processorLoad = 1000000;

    public static void main(String[] args) {
        FirModel model = new FirModel(noOfThreads);
        Window win = new Window(noOfThreads, model);

        for (int i = 0; i < noOfThreads; i++) {
            new Fir(i, i + 2, model, processorLoad).start();
        }
    }
}
