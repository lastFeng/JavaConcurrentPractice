package inPractice.chapter2;

import inPractice.annotation.NotThreadSafe;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/***
 * 线程安全的引用类，但是在类中存在竞争条件，会导致整体线程不安全
 */
@NotThreadSafe
public class UnsafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public void service(Map<String, BigInteger> params) {
        BigInteger i = params.getOrDefault("params", BigInteger.ZERO);

        // 多线程情况下，一个线程进行set，同时，另外一个线程进行get会导致结果不正确
        if (i.equals(lastNumber.get())) {
            // do something
        } else {
            BigInteger[] factors = new BigInteger[1];
            lastNumber.set(i);
            lastFactors.set(factors);
        }
    }
}
