package v2;

public class Cook extends Thread {
    private final int cookID;
    private final Table table;

    public Cook(int cookID, Table table) {
        super("Cook #" + cookID);
        this.cookID = cookID;
        this.table = table;
    }

    @Override
    public void run() {
        int i = 0;
        while (!interrupted()) {
            try {
                table.serve(new Boar(cookID, i++));
            } catch (InterruptedException e) {
                interrupt();
                System.out.println(getName() + " was interrupted");
            }
        }
        System.out.println("\t" + getName() + " has finished cooking " + i + " boars");
    }
}
