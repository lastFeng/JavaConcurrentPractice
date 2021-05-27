package chapter15;

import annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@ThreadSafe
public class ConcurrentLinkedQueue<E> {
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    private final Node<E> dummy = new Node<>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);

        while (true) {
            Node<E> curTail = tail.get(); // 获取当前线程状态下的尾结点
            Node<E> tailNext = curTail.next.get(); // 获取尾结点的next
            // 如果没人处于更新状态，则可更新
            if (curTail == tail.get()) {
                if (tailNext != null) {
                    // 队列处于静止状态，推进尾结点
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    // 处于静止状态，尝试插入新节点
                    if (curTail.next.compareAndSet(null, newNode)) {
                        // 插入成功，尝试推进尾结点
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }
    }

    private static AtomicReferenceFieldUpdater<Node, Node> nextUpdater
            = AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");
}
