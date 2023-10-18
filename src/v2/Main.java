package v2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int COOKS = 3;
        final int EATERS = 5;
        Table table = new Table();
        Cook[] cooks = new Cook[COOKS];
        Eater[] eaters = new Eater[EATERS];

        for (int i = 0; i < COOKS; i++) {
            cooks[i] = new Cook(i, table);
        }
        for (int i = 0; i < EATERS; i++) {
            eaters[i] = new Eater(i, table);
        }
        for (Cook cook : cooks) {
            cook.start();
        }
        for (Eater eater : eaters) {
            eater.start();
        }

        Thread.sleep(1000);
        for (Cook cook : cooks) {
            cook.interrupt();
        }
        for (Eater eater : eaters) {
            eater.interrupt();
        }
    }
}
