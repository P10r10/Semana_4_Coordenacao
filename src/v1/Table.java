package v1;

import java.util.LinkedList;

public class Table {
    private final int MAX = 10;
    private final LinkedList<Boar> boars = new LinkedList<>();

    public synchronized void serve(Boar boar) throws InterruptedException {
        while (boars.size() == MAX) {
            wait();
        }
        boars.add(boar);
        notifyAll();
    }

    public synchronized Boar eat() throws InterruptedException {
        while (boars.isEmpty()) {
            wait();
        }
        Boar boar = boars.pop();
        notifyAll();
        return boar;
    }
}
