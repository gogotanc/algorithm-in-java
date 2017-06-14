package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 归并排序
 * Created by tanc on 2017/2/15.
 */
public class MergeSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    @Override
    @SuppressWarnings("unchecked")
    public E[] sort(E[] array) {

        E[] temp = (E[]) new Comparable[array.length];

        sort(array, temp, 0, array.length - 1);

        return array;
    }

    private void sort(E[] src, E[] result, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        int secondStart = mid + 1;

        sort(src, result, start, mid);
        sort(src, result, secondStart, end);
        merge(src, result, start, secondStart, end);
    }

    private void merge(E[] src, E[] result, int leftPos, int rightPos, int rightEnd) {

        int leftEnd = rightPos - 1;
        int p = leftPos;
        int count = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            int flag = src[leftPos].compareTo(src[rightPos]);
            if (flag >= 0) {
                result[p++] = src[rightPos++];
            } else {
                result[p++] = src[leftPos++];
            }
        }

        // Copy rest of left half
        while (leftPos <= leftEnd) {
            result[p++] = src[leftPos++];
        }
        // Copy rest of right half
        while (rightPos <= rightEnd) {
            result[p++] = src[rightPos++];
        }

        // 将 merge 结果复制到源数组中
        for (int i = 0; i < count; i++, rightEnd--) {
            src[rightEnd] = result[rightEnd];
        }
    }
}
