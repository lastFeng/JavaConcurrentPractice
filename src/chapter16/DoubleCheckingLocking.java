package chapter16;

import annotation.NotThreadSafe;

@NotThreadSafe
public class DoubleCheckingLocking {
    private DoubleCheckingLocking(){}
    @NotThreadSafe
    private static DoubleCheckingLocking INSTANCE;

    // if use volatile is ThreadSafe
//    private volatile static DoubleCheckingLocking INSTANCE;
    public static DoubleCheckingLocking getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckingLocking.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckingLocking();
                }
            }
        }
        return INSTANCE;
    }
}
