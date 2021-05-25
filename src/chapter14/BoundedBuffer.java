package chapter14;

public class BoundedBuffer<V> extends BaseBoundedBuffer<V>{
    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        boolean empty = isEmpty();
        doPut(v);
        if (empty) {
            notifyAll();
        }
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        boolean full = isFull();
        V v = doTake();
        if (full) {
            notifyAll();
        }
        return v;
    }
}
