package chapter2;

import annotation.GuardedBy;
import annotation.ThreadSafe;

import java.math.BigInteger;
import java.util.Map;

/***
 * 使用粗粒度的线程安全，可能会降低性能
 */
@ThreadSafe
public class SynchronizedFactorizer {

    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    public synchronized void service(Map<String, BigInteger> params) {
        BigInteger i = params.getOrDefault("params", BigInteger.ZERO);

        if (i.equals(lastNumber)) {
            // do something
        } else {
            BigInteger[] factors = new BigInteger[1];
            lastNumber = i;
            lastFactors = factors;
        }
    }
}
