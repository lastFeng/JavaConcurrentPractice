package inPractice.chapter4;

import inPractice.annotation.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * 由于Collections.synchronizedList所获取的所对象是其自身
 * 那么在putIfAbsent中，使用的同步对象为list，就能确保在对于list的操作中使用的是同一把锁
 * @param <E>
 */
@ThreadSafe
public class SafeListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}
