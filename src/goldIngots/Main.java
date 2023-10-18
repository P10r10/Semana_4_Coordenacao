package goldIngots;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scale scale = new Scale();
        Digger digger = new Digger(scale);
        Goldsmith goldsmith = new Goldsmith(scale);
        goldsmith.start();
        digger.start();

        Thread.sleep(2000);

        goldsmith.interrupt();
        digger.interrupt();
    }
}
