package chapter16;

import annotation.ThreadSafe;

@ThreadSafe
public class EagerInitialization {
    private EagerInitialization() {

    }

    private static EagerInitialization INSTANCE = new EagerInitialization();

    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
