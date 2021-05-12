package chapter2;

import annotation.NotThreadSafe;
import chapter1.Sequence;

/***
 * 惰性初始化中存在竞争条件
 */
@NotThreadSafe
public class LazyInitRance {
    private Sequence instance = null;

    /***
     * 多线程进入时，会出现竞争条件，导致线程不安全
     * @return
     */
    public Sequence getInstance() {
        if (instance == null) {
            instance = new Sequence();
        }
        return instance;
    }
}
