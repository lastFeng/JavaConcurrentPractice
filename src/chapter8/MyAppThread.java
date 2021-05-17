package chapter8;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAppThread extends Thread{

    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static volatile AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();

    public MyAppThread(Runnable target) {
        this(target, DEFAULT_NAME);
    }

    public MyAppThread(Runnable r, String poolName) {
        super(r, poolName + created.incrementAndGet());
        // set more settings
//        setUncaughtExceptionHandler();
        setUncaughtExceptionHandler((thread, e) -> {
            System.out.println("UNCAUGHT in thread " +thread.getName() + e);
        });
    }

    @Override
    public void run() {
        boolean debug = debugLifecycle;
        if (debug) {
            System.out.println("Debug " + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                System.out.println("Exiting " + getName());
            }
        }
    }

    public static boolean isDebugLifecycle() {
        return debugLifecycle;
    }

    public static int getCreated() {
        return created.get();
    }

    public static int getAlive() {
        return alive.get();
    }

    public static void setDebugLifecycle(boolean debugLifecycle) {
        MyAppThread.debugLifecycle = debugLifecycle;
    }
}
