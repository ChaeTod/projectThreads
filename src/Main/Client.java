package Main;

public class Client implements Runnable {
    PlaneConfigurator planeConfigurator;

    public Client(PlaneConfigurator planeConfigurator) {
        this.planeConfigurator = planeConfigurator;
    }

    @Override
    public void run() {
        for (int i = 1; i <= planeConfigurator.getNecessaryPlaneNum(); i++) {
            try {
                planeConfigurator.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
