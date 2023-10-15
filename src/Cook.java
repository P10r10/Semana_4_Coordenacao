public class Cook extends Thread {
    private int cookID;
    private int maxBoars;
    private Table table;

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
        System.out.println(getName() + " has cooked " + i + "boars.");
    }

}
