package v3;

public class Main {
    public static void main(String[] args) {
        final int COOKS = 2;
        final int EATERS = 2;
        Table table = new Table();
        Cook[] cooks = new Cook[COOKS];
        Eater[] eaters = new Eater[EATERS];

        for (int i = 0; i < COOKS; i++) {
            cooks[i] = new Cook(i, 100, table); // 100 boars
        }
        for (int i = 0; i < EATERS; i++) {
            eaters[i] = new Eater(i, 100, table); // 100 boars
        }
        for (Cook cook : cooks) {
            cook.start();
        }
        for (Eater eater : eaters) {
            eater.start();
        }
    }
}
