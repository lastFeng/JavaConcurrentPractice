package chapter10;

import annotation.EasyDeadLock;

import java.math.BigDecimal;
import java.util.Random;

@EasyDeadLock
public class DemonstrateDeadLock {
    private static final int NUM_THREAD = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        final Random random = new Random();
        final Object[] objects = new Object[NUM_ACCOUNTS];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
        }

        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = random.nextInt(NUM_ACCOUNTS);
                    int toAcct = random.nextInt(NUM_ACCOUNTS);
                    BigDecimal bigDecimal = BigDecimal.valueOf(random.nextInt(1000));
                    transferMoney(objects[fromAcct], objects[toAcct], bigDecimal);
                }
            }

            /**
             * 两个线程同时调用，一个从x向y转账，另一个从y向x转账，就会发生死锁
             * */
            public void transferMoney(final Object fromAccount, final Object toAccount, final BigDecimal amount) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        // do transfer money operation
                        try {
                            System.out.println("CurrentThread: " + Thread.currentThread().getName());
                            Thread.sleep(100000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        for (int i = 0; i < NUM_THREAD; i++) {
            new TransferThread().start();
        }
    }
}
