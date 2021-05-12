package chapter2;

import annotation.NotThreadSafe;

import java.math.BigInteger;
import java.util.Map;

/***
 * 由于count是有状态的，对于有状态的内容进行无同步的操作会造成不安全问题
 */
@NotThreadSafe
public class UnsafeCountingFactorizer {
    private long count = 0;
    public long getCount() {
        return count;
    }

    public void service(Map<String, BigInteger> params) {
        BigInteger i = params.getOrDefault("params", BigInteger.ZERO);
        // ++ is not thread safe
        count++;
    }
}
