package inPractice.chapter5;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public void timeTask(int nThread, final Runnable task) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(nThread / 2);

        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread(() -> {
                try {
                    semaphore.acquire();
                    task.run();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                } finally {
                    semaphore.release();
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.timeTask(4, () -> System.out.println("task: " + Thread.currentThread().getName()));
    }
}
