package v2;

public class Cook extends Thread {
    private final int cookID;
    private final int maxBoars;
    private final Table table;

    public Cook(int cookID, int maxBoars, Table table) {
        super("Cook #" + cookID);
        this.cookID = cookID;
        this.maxBoars = maxBoars;
        this.table = table;
    }

    @Override
    public void run() {
        int i = 0;
        for (; i < maxBoars; i++) {
            try {
                table.serve(new Boar(cookID, i));
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
            }
        }
        System.out.println("\t" + getName() + " has finished cooking " + i + " boars");
    }
}
