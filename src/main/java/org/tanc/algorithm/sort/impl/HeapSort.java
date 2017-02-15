package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.heap.BaseHeap;
import org.tanc.algorithm.heap.impl.BinaryHeapArrayImpl;
import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 堆排序
 * Created by tanc on 2017/2/15.
 */
public class HeapSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    private BaseHeap<E> heap;

    public HeapSort() {
        heap = new BinaryHeapArrayImpl<>();
    }

    @Override
    public E[] sort(E[] array) {
        for (E e : array) {
            heap.insert(e);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.deleteMin();
        }
        return array;
    }
}
