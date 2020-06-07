package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlaneConfigurator DC3 = new PlaneConfigurator("CP", 4);
        PlaneConfigurator C17 = new PlaneConfigurator("VIP", 2);
        PlaneConfigurator F15E = new PlaneConfigurator("WBP", 3);
        PlaneConfigurator Cessna = new PlaneConfigurator("UP", 5);

        List<PlaneConfigurator> planes = new ArrayList<PlaneConfigurator>();

        planes.add(DC3);
        planes.add(C17);
        planes.add(F15E);
        planes.add(Cessna);

        Factory factory = null;
        Client client = null;
        for (PlaneConfigurator plane : planes) {
            factory = new Factory(plane);
            client = new Client(plane);

            new Thread(factory).start();
            new Thread(client).start();
        }
    }
}
