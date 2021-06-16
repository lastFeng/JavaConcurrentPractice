package inPractice.chapter14;

public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V>{
    private static final long SLEEP_GRANULARITY = 1000;
    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }
}
