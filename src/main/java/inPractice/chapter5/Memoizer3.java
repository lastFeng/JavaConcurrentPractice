package inPractice.chapter5;

import java.util.Map;
import java.util.concurrent.*;

public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> futureTask = new FutureTask<>(eval);
            future = futureTask;
            cache.put(arg, futureTask);
            futureTask.run();
        }

        try {
            return future.get();
        } catch (ExecutionException e) {
            cache.remove(arg, future);
            return null;
        }
    }
}
