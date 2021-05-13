package chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memoizer2 <A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            // 这里可能出现的问题是：多个线程同时对同一个值进行计算
            // 就会出现重复计算的情况
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return null;
    }
}
