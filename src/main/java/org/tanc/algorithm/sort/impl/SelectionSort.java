package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 选择排序算法
 * Created by tanc on 2017/2/12.
 */
public class SelectionSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    @Override
    public E[] sort(E[] array) {

        int j;

        for (int i = 0; i < array.length; i++) {
            E min = array[i];
            for (j = i; j < array.length; j++) {
                if (min.compareTo(array[j]) > 0) {
                    min = array[j];
                }
            }
            array[j] = array[i];
            array[i] = min;
        }
        return array;
    }
}
