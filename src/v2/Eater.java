package v2;

public class Eater extends Thread {
    private final int maxBoars;
    private final Table table;

    public Eater(int eaterID, int maxBoars, Table table) {
        super("Eater #" + eaterID);
        this.maxBoars = maxBoars;
        this.table = table;
    }

    @Override
    public void run() {
        int i = 0;
        for (; i < maxBoars; i++) {
            try {
                Boar boar = table.eat();
                System.out.println(getName() + " ate " + boar);

            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
            }
        }
        System.out.println("\t" + getName() + " finished eating " + i + " boars");
    }
}
