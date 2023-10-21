package blockingQ;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue <T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number.");
        }
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T toReturn = queue.poll();
        notifyAll();
        return toReturn;
    }

    public int size() {
        return queue.size();
    }

    public synchronized void clear() {
        queue.clear();
        notifyAll();
    }
}
