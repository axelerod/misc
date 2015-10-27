package burov.collection;

import java.util.LinkedList;
import java.util.List;

public class DIYBlockingQueue<T> implements BlockingQueue<T> {

    private List<T> storage;
    private int maxSize;
    private Object lock = new Object();

    public DIYBlockingQueue(int maxSize) {

        this.maxSize = maxSize;
        this.storage = new LinkedList<T>();
    }

    public void put(T element) throws InterruptedException {
        synchronized (lock) {
            putSynchronized(element);
        }
    }

    private void putSynchronized(T element) throws InterruptedException {
        boolean added = false;
        while (!added) {
            if (storage.size() == maxSize) {
                lock.notifyAll();
                lock.wait();
            } else {
                storage.add(element);
                added = true;
                lock.notifyAll();
            }
        }
    }

    public T take() throws InterruptedException {
        return takeSychronized();
    }

    private T takeSychronized() throws InterruptedException {
        synchronized (lock) {
            T value = null;
            while (value == null) {
                if (storage.isEmpty()) {
                    lock.notifyAll();
                    lock.wait();
                } else {
                    value = storage.remove(0);
                    lock.notifyAll();
                }
            }
            return value;
        }
    }

    public int size() {
        synchronized (lock) {
            return storage.size();
        }
    }
}
