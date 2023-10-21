package goldIngots;

import javax.swing.*;

public class Scale {
    private double currentGold = 0;
    private final JTextField tf;

    public Scale(JTextField tf) {
        this.tf = tf;
    }

    public synchronized void put(double gold) throws InterruptedException {
        while (currentGold >= 12.5) {
            wait();
        }
        currentGold += gold;
        tf.setText(Double.toString(currentGold));
        Thread.sleep(250);
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while (currentGold < 12.5) {
            wait();
        }
        currentGold -= 12.5;
        tf.setText(Double.toString(currentGold));
        System.out.println("Producing ingot...");
        Thread.sleep(3000); // sleeps 3 seconds
        notifyAll();
    }
}
