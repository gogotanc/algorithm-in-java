package org.tanc.algorithm.heap.impl;

import org.tanc.algorithm.heap.BaseHeap;

/**
 * 二项队列
 * Created by tanc on 2017/2/16.
 */
public class BinomialQueue<E extends Comparable<? super E>> implements BaseHeap<E>{

    private int size;
    private Node<E> [] roots;

    @SuppressWarnings("unchecked")
    public BinomialQueue() {
        roots = new Node[10];
        size = 0;
    }

    @Override
    public E deleteMin() {
        return null;
    }

    @Override
    public void insert(E element) {
        if (size == 0) {
            roots[0] = new Node<>(element);
        }
    }

    @Override
    public void printHeap() {

    }

    public void merge(BinomialQueue<E> queue) {
    }

    private Node<E> combineTrees(Node<E> r1, Node<E> r2) {
        int result = r1.data.compareTo(r2.data);
        if (result < 0) {
            r2.nextSibling = r1.firstChild;
            r1.firstChild = r2;
            return r1;
        } else {
            r1.nextSibling = r2.firstChild;
            r2.firstChild = r1;
            return r2;
        }
    }

    private class Node<T extends Comparable<? super T>> {
        T data;
        Node<T> firstChild;
        Node<T> nextSibling;

        Node(T element) {
            this(element, null, null);
        }

        Node(T element, Node<T> firstChild, Node<T> nextSibling) {
            this.data = element;
            this.firstChild = firstChild;
            this.nextSibling = nextSibling;
        }
    }
}
