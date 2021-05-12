package chapter1;

import annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * ++操作是线程不安全的
     * */
    public int gatNext() {
        return value++;
    }
}
