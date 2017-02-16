package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 冒泡排序
 * Created by tanc on 2017/2/16.
 */
public class BubbleSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    @Override
    public E[] sort(E[] array) {

        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                }
            }
        }
        return array;
    }

    private void swap(E[] a, int b, int c) {
        E temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}
