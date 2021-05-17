package chapter8;

import java.util.concurrent.*;

public class MyThreadFactory implements ThreadFactory {

    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        // this can custom the thread
        return new MyAppThread(r, poolName);
    }

    public static void main(String[] args) {
        new ThreadPoolExecutor(4, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new MyThreadFactory("Hello"),
                new MyThreadPolicy());
    }
}

class MyThreadPolicy implements RejectedExecutionHandler{
    public MyThreadPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // here set the rejected policy
    }
}
