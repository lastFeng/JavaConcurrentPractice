package chapter2;

import annotation.ThreadSafe;

import java.math.BigInteger;
import java.util.Map;

/***
 * 这里通过传入的参数进行线程内部处理，而不将处理结果发布，可以视为是线程安全的
 * 即：无状态的线程是线程安全的
 */
@ThreadSafe
public class StatelessFactorizer {
    public void service(Map<String, BigInteger> params) {
        BigInteger i = params.getOrDefault("request", BigInteger.ZERO);
        // do something for i in the class, not publish is thread safe
    }
}
