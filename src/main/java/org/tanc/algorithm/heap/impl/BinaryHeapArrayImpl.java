package org.tanc.algorithm.heap.impl;

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

    @SuppressWarnings("unchecked")
    public BinaryHeapArrayImpl() {
        heap = (E[]) new Comparable[24];
        count = 0;
    }

    @Override
    public E deleteMin() {
        return null;
    }

    @Override
    public void insert(E element) {
        int index = ++count;
        for (heap[0] = element; heap[index / 2].compareTo(element) > 0; index /= 2) {
            heap[index] = heap[index / 2];
        }
        heap[index] = element;
    }
}
