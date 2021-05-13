package chapter5;

import java.util.concurrent.*;

public class MemoizerFinal<A, V> implements Computable<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public MemoizerFinal(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(arg);

            if (future == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> futureTask = new FutureTask<>(eval);
                future = cache.putIfAbsent(arg, futureTask);

                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (ExecutionException e) {
                cache.remove(arg, future);
            }
        }
    }
}
