package inPractice.chapter2;

import inPractice.annotation.GuardedBy;
import inPractice.annotation.ThreadSafe;

import java.math.BigInteger;
import java.util.Map;

/***
 * 细粒度的加锁，保证线程安全的前提下确保性能
 */
@ThreadSafe
public class SafeCachingFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void service(Map<String, BigInteger> params) {
        BigInteger i = params.getOrDefault("params", BigInteger.ZERO);
        BigInteger[] factors = null;

        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = new BigInteger[1];
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors;
            }
        }
    }
}
