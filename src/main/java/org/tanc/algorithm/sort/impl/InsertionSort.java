package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 插入排序
 * Created by tanc on 2017/2/12.
 */
public class InsertionSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    @Override
    public E[] sort(E[] array) {

        int j;

        for (int i = 1; i < array.length; i++) {
            E temp = array[i];
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }
}
