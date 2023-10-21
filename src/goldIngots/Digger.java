package goldIngots;

import java.util.Random;

public class Digger extends Thread {
    Random random = new Random();
    private final Scale scale;

    public Digger(Scale scale) {
        super("Digger");
        this.scale = scale;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins.");
        while (!interrupted()) {
            try {
                double gold = random.nextDouble(1); // gold amount in kg
                scale.put(gold);
//                System.out.printf("Digger places %.2f gold in the scale.\n", gold);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " ends.");
    }
}
