package inPractice.chapter5;

import inPractice.annotation.GuardedBy;

import java.util.HashMap;
import java.util.Map;

public class Memoizer<A, V> implements Computable<A, V>{
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);

        if (result == null) {
            result  = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
