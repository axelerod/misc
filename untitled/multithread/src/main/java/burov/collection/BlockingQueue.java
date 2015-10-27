package burov.collection;

interface BlockingQueue<T> {
    void put(T element) throws InterruptedException;

    T take() throws InterruptedException;

    int size();
}
