package Main;

public class Factory implements Runnable {
    PlaneConfigurator planeConfigurator;

    public Factory(PlaneConfigurator planeConfigurator) {
        this.planeConfigurator = planeConfigurator;
    }

    @Override
    public void run() {
        for (int i = 1; i <= planeConfigurator.getNecessaryPlaneNum(); i++){
            try {
                planeConfigurator.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
    }
}
