package chapter10;

import annotation.EasyDeadLock;

import java.math.BigDecimal;

@EasyDeadLock
public class LeftRightDeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                // do something
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                // do other
            }
        }
    }

    /**
     * 两个线程同时调用，一个从x向y转账，另一个从y向x转账，就会发生死锁
     * */
    public void transferMoney(final Object fromAccount, final Object toAccount, final BigDecimal amount) {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                // do transfer money operation
            }
        }
    }

    private static final Object tieLock = new Object();
    public void transferMoneyAvoidDeadLock(final Object fromAccount, final Object toAccount, final BigDecimal amount) {
        class Helper {
            public void transfer() {
                // do transfer money operation
            }
        }

        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}
