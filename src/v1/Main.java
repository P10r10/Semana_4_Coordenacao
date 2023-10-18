package v1;

public class Main {
    public static void main(String[] args) {
        final int COOKS = 5;
        final int EATERS = 10;
        Table table = new Table();
        Cook[] cooks = new Cook[COOKS];
        Eater[] eaters = new Eater[EATERS];

        for (int i = 0; i < COOKS; i++) {
            cooks[i] = new Cook(i, 10, table); // 10 boars
        }
        for (int i = 0; i < EATERS; i++) {
            eaters[i] = new Eater(i, 5, table); // 5 boars
        }
        for (Cook cook : cooks) {
            cook.start();
        }
        for (Eater eater : eaters) {
            eater.start();
        }
    }
}
