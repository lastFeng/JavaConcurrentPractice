package chapter1;

import annotation.GuardedBy;
import annotation.ThreadSafe;

/***
 * 使用synchronized对不安全的设置进行了内部加锁，保证了线程安全性
 */
@ThreadSafe
public class Sequence {
    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }
}
