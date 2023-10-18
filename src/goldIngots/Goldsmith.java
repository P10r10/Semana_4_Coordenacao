package goldIngots;

public class Goldsmith extends Thread {

    private final Scale scale;
    private int ingot = 0;

    public Goldsmith(Scale scale) {
        this.scale = scale;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().toString() + " begins");
        while (!interrupted()) {
            try {
                scale.remove();
//                wait(3000);
                ingot++;
            } catch (InterruptedException e) {
                interrupt();
                System.out.println(getName() + " was interrupted");
            }
        }
        System.out.println(Thread.currentThread().toString() + " ends");
        System.out.println("Goldsmith produced " + ingot + " ingots");
    }
}
