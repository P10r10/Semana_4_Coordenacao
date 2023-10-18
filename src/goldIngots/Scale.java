package goldIngots;

public class Scale {
    private double currentGold = 0;

    public synchronized void put(double gold) throws InterruptedException {
        while (currentGold >= 12.5) {
            wait();
        }
        currentGold += gold;
        notifyAll();
    }

    public synchronized double remove() throws InterruptedException {
        while (currentGold < 12.5) {
            wait();
        }
        currentGold -= 12.5;
        notifyAll();
        return 0; // ??
    }
}