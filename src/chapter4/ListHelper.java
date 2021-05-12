package chapter4;

import annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * // 这里虽然使用了synchronized，但是这里锁的对象与list自身的锁的对象并非同一个对象
 *     // 即使调用putIfAbsent，获取了锁，还是可能存在不安全的情况 -- 同步幻象
 * @param <E>
 */
@NotThreadSafe
public class ListHelper<E>{
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    // 这里虽然使用了synchronized，但是这里锁的对象与list自身的锁的对象并非同一个对象
    // 即使调用putIfAbsent，获取了锁，还是可能存在不安全的情况
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);

        if (absent) {
            list.add(x);
        }
        return absent;
    }
}
