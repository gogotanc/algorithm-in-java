package org.tanc.algorithm.heap.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.heap.BaseHeap;

/**
 * 二叉堆（数组实现）
 * <p>
 * （1）任意节点小于（或大于）它的所有后裔，最小元（或最大元）在堆的根上（堆序性）。
 * （2）堆总是一棵完全树。即除了最底层，其他层的节点都被元素填满，且最底层尽可能地从左到右填入。
 * <p>
 * Created by tanc on 2017/2/14.
 */
public class BinaryHeapArrayImpl<E extends Comparable<? super E>> implements BaseHeap<E> {

    // 数组第一位没有使用，第一个插入元素从下标 1 开始
    private E[] heap;
    private int count;

    private static final int INIT_SIZE = 24;

    @SuppressWarnings("unchecked")
    public BinaryHeapArrayImpl() {
        heap = (E[]) new Comparable[INIT_SIZE];
        count = 0;
    }

    @Override
    public E deleteMin() {

        if (count == 0) {
            throw new IllegalOperationException("没有数据");
        }

        E min = heap[1];
        E last = heap[count];

        for (int i = 1; i <= count;) {

            if (i == count) {
                heap[i] = last;
                break;
            }

            E left = heap[i * 2];
            E right = heap[i * 2 + 1];

            if (null == left) {
                heap[i] = last;
                break;
            } else if (null == right) {
                heap[i] = heap[i * 2];
                heap[i * 2] = last;
                break;
            }

            int result = left.compareTo(right);
            if (result > 0) {
                heap[i] = heap[i * 2 + 1];
                i = i * 2 + 1;
            } else {
                heap[i] = heap[i * 2];
                i = i * 2;
            }
        }

        heap[count--] = null;
        return min;
    }

    @Override
    public void insert(E element) {

        if ((count + 1) == heap.length) {
            enlargeArray();
        }

        int index = ++count;
        for (heap[0] = element; heap[index / 2].compareTo(element) > 0; index /= 2) {
            heap[index] = heap[index / 2];
        }
        heap[index] = element;
    }

    @Override
    public void printHeap() {
        for (int i = 1; i <= count; i++) {
            System.out.print(heap[i] + ",");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    private void enlargeArray() {
        E[] temp = (E[]) new Comparable[(count + 1) * 2];
        System.arraycopy(heap, 1, temp, 1, count);
        heap = temp;
    }
}
