package v3;

import java.util.LinkedList;

public class Table {
    private final int MAX = 1;
    private final LinkedList<Boar> boars = new LinkedList<>();

    public synchronized void serve(Boar boar) throws InterruptedException {
        while (boars.size() == MAX) {
            wait();
        }
        boars.add(boar);
        notify(); // not every thread is notified -> synchronization problems
    }

    public synchronized Boar eat() throws InterruptedException {
        while (boars.isEmpty()) {
            wait();
        }
        Boar boar = boars.pop();
        notify(); // not every thread is notified -> synchronization problems
        return boar;
    }
}
