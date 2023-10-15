import java.util.LinkedList;

public class Table {
    private final int MAX = 10;
    private final LinkedList<Boar> boars;

    public Table() {
        boars = new LinkedList<>();
    }

    private boolean isFull() {
        return boars.size() == MAX;
    }

    public synchronized void serve(Boar boar) {
        if (!isFull()) {
            boars.add(boar);
        }
    }
}
