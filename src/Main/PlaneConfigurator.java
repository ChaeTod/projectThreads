package Main;

public class PlaneConfigurator {
    private String planeMod;
    private int necessaryPlaneNum = 0;
    private int totalPlaneCounter = 0;

    public PlaneConfigurator(String planeMod, int necessaryPlaneNum) {
        this.planeMod = planeMod;
        this.necessaryPlaneNum = necessaryPlaneNum;
    }

    public String getPlaneMod() {
        return planeMod;
    }

    public int getNecessaryPlaneNum() {
        return necessaryPlaneNum;
    }

    public int calculateBuildTime() {
        switch (planeMod) {
            case "VIP":
                return 20000;
            case "WBP":
                return 15000;
            case "UP":
                return 10000;
            case "CP":
                return 5000;
            default:
                return 0;
        }
    }

    public synchronized void get() throws InterruptedException {
        while (totalPlaneCounter < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        totalPlaneCounter--;
        System.out.println("-1 plane has been collected from the warehouse which has mode - " +getPlaneMod());
        System.out.println("Total plane count after one plane has been removed from the warehouse - " + totalPlaneCounter + " with the mode - " + getPlaneMod());
        notify();
    }

    public synchronized void put() throws InterruptedException {
        while (totalPlaneCounter >= 2) {
            try {
                wait(calculateBuildTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        totalPlaneCounter++;
        System.out.println("+1 plane has been added to the warehouse with the mode " +getPlaneMod());
        System.out.println("Total count of the planes after one plane has been added to the warehouse - " + totalPlaneCounter+ " with the plane's mod - " +getPlaneMod());
        notify();
    }
}
