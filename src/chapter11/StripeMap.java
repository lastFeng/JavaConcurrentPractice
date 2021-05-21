package chapter11;

import annotation.ThreadSafe;

@ThreadSafe
public class StripeMap {
    // 同步策略： buckets[n] 由locks[n%N_LOCKS]保护
    private static final int N_LOCKS = 16;
    private final Node[] buckets;
    private final Object[] locks;

    private static class Node{
        Object key;
        int value;
        Node next;
    }

    public StripeMap(int numBuckets) {
        this.buckets = new Node[numBuckets];
        this.locks = new Object[N_LOCKS];

        for (int i = 0; i < N_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % N_LOCKS]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) {
                    return m.value;
                }
            }
        }
        return null;
    }


}
