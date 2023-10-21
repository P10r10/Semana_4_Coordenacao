package goldIngots;

public class Goldsmith extends Thread {

    private final Scale scale;
    private int ingot = 0;

    public Goldsmith(Scale scale) {
        super("Goldsmith");
        this.scale = scale;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins.");
        while (!interrupted()) {
            try {
                scale.remove();
                ingot++;
                System.out.println("Ingot ready!");
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " ends.");
        System.out.println("Goldsmith produced " + ingot + " ingots.");
    }
}
