package inPractice.chapter16;

import inPractice.annotation.ThreadSafe;

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
