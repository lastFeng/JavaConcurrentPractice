package chapter16;

import annotation.ThreadSafe;

@ThreadSafe
public class SafeLazyInitialization {
    private static SafeLazyInitialization INSTANCE;

    private SafeLazyInitialization() {}

    public synchronized static SafeLazyInitialization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SafeLazyInitialization();
        }
        return INSTANCE;
    }
}
