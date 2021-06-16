package inPractice.chapter16;

import inPractice.annotation.ThreadSafe;

@ThreadSafe
public class EagerInitialization {
    private EagerInitialization() {

    }

    private static EagerInitialization INSTANCE = new EagerInitialization();

    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
