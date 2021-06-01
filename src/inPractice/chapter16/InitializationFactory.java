package inPractice.chapter16;

import inPractice.annotation.ThreadSafe;

@ThreadSafe
public class InitializationFactory {
    private InitializationFactory() {}

    private static class Holder {
        public static InitializationFactory INSTANCE = new InitializationFactory();
    }

    public static InitializationFactory getInstance() {
        return Holder.INSTANCE;
    }
}
