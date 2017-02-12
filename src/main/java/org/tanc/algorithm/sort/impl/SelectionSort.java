package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 选择排序算法
 * Created by tanc on 2017/2/12.
 */
public class SelectionSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    @Override
    public E[] sort(E[] a) {

        int i, j, min;
        int len = a.length;

        for (i = 0; i < len; i++) {
            min = i;
            for (j = i; j < len; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            E temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }
}
