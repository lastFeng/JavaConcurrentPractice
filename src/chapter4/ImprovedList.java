package chapter4;

import java.util.*;

public class ImprovedList <T> implements List<T> {
    private final List<T> list;

    public ImprovedList(List<T> list) {
        this.list = list;
    }

    public ImprovedList() {
        this.list = new ArrayList<T>();
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean contain = list.contains(x);
        if (!contain) {
            list.add(x);
        }
        return !contain;
    }

    @Override
    public synchronized int size() {
        return list.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public synchronized boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return list.toArray();
    }

    @Override
    public synchronized  <T1> T1[] toArray(T1[] a) {
        return (T1[]) list.toArray();
    }

    @Override
    public synchronized boolean add(T t) {
        return list.add(t);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends T> c) {
        return list.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        list.clear();
    }

    @Override
    public synchronized T get(int index) {
        return list.get(index);
    }

    @Override
    public synchronized T set(int index, T element) {
        return list.set(index, element);
    }

    @Override
    public synchronized void add(int index, T element) {
        list.add(index, element);
    }

    @Override
    public synchronized T remove(int index) {
        return list.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator<T> listIterator() {
        return list.listIterator();
    }

    @Override
    public synchronized ListIterator<T> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public synchronized List<T> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public static void main(String[] args) throws Exception {
        ImprovedList improvedList = new ImprovedList<Integer>();
        new Thread(() -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                improvedList.putIfAbsent(i);
            }
            System.out.println("1: " + (System.currentTimeMillis() - start));
        }).start();
        new Thread(() -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100001; i++) {
                improvedList.putIfAbsent(i);
            }
            System.out.println("2: " + (System.currentTimeMillis() - start));
        }).start();

        Thread.sleep(5000);
        System.out.println(improvedList.size());
    }
}
