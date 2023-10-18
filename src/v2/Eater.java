package v2;

public class Eater extends Thread {
    private final Table table;

    public Eater(int eaterID, Table table) {
        super("Eater #" + eaterID);
        this.table = table;
    }

    @Override
    public void run() {
        int i = 0;
        while (!interrupted()) {
            try {
                table.eat();
                i++;
            } catch (InterruptedException e) {
                interrupt();
                System.out.println(getName() + " was interrupted");
            }
        }
        System.out.println("\t" + getName() + " finished eating " + i + " boars");
    }
}
