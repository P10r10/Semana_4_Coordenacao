package goldIngots;

import java.util.Random;

public class Digger extends Thread {
    Random random = new Random();
    private Scale scale;

    public Digger(Scale scale) {
        this.scale = scale;
    }

    @Override
    public void run() {
        double gold = random.nextDouble(1); // gold amount in kg
        try {
            scale.put(gold);
            System.out.printf("Digger places %.2f gold in the scale.", gold);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted");
        }
    }
}
