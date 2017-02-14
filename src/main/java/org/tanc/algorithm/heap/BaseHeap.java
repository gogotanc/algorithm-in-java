package org.tanc.algorithm.heap;

/**
 * 优先队列 （堆）
 * Created by tanc on 2017/2/12.
 */
public interface BaseHeap<T extends Comparable<? super T>> {

    T deleteMin();

    void insert(T element);
}
