package chapter2;

import annotation.ThreadSafe;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/***
 * 使用线程安全的类，来确保有状态的内容安全性
 */
@ThreadSafe
public class SafeCountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void service(Map<String, BigInteger> params) {
        BigInteger i = params.getOrDefault("params", BigInteger.ZERO);
        // thread safe class op is safe
        count.incrementAndGet();
    }
}
