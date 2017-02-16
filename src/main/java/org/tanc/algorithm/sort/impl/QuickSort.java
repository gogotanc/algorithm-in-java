package org.tanc.algorithm.sort.impl;

import org.tanc.algorithm.sort.BaseSortAlgorithm;

/**
 * 快速排序
 * Created by tanc on 2017/2/16.
 */
public class QuickSort<E extends Comparable<? super E>> implements BaseSortAlgorithm<E> {

    private InsertionSort<E> insertSort;

    public QuickSort() {
        insertSort = new InsertionSort<>();
    }

    @Override
    public E[] sort(E[] array) {

        sort(array, 0, array.length - 1);

        return array;
    }

    private void sort(E[] a, int left, int right) {

        int length = right - left + 1;

        if (length <= 3) {
            // 不多于三个元素的数组使用插入排序
            insertSort.sort(a, left, right);
            return;
        }

        int center = (left + right) / 2;
        int first = left;
        int last = right;

        update3Elements(a, left, center, right);

        E temp = a[right - 1];
        a[right - 1] = a[right];
        a[right] = a[center];
        a[center] = temp;

        right = right - 2;
        left = left + 1;

        while (true) {
            while (a[left].compareTo(a[last]) <= 0) {
                left++;
            }
            while (a[right].compareTo(a[last]) >= 0) {
                right--;
            }
            if (left < right) {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            } else {
                break;
            }
        }

        temp = a[last];
        a[last] = a[left];
        a[left] = temp;

        sort(a, first, left - 1);
        sort(a, left + 1, last);
    }

    private void swap(E[] a, int b, int c) {
        E temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    private void update3Elements(E[] a, int left, int center, int right) {
        if (a[left].compareTo(a[center]) >= 0) {
            swap(a, left, center);
        }
        if (a[left].compareTo(a[right]) >= 0) {
            swap(a, left, right);
        }
        if (a[center].compareTo(a[right]) >= 0) {
            swap(a, center, right);
        }
    }
}
