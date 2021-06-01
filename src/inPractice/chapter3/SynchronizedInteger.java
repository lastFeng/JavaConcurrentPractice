package inPractice.chapter3;

import inPractice.annotation.GuardedBy;
import inPractice.annotation.ThreadSafe;

@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this") private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
