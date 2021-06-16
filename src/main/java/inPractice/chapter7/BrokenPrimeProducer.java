package inPractice.chapter7;

import inPractice.annotation.NotRecommend;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

@NotRecommend
public class BrokenPrimeProducer extends Thread{
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                // 线程处于阻塞状态时，无法对取消操作进行处理的
                queue.put(p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
        }
    }
}
