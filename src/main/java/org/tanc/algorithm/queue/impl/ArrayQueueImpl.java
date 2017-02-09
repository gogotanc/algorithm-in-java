package org.tanc.algorithm.queue.impl;

import org.tanc.algorithm.queue.BaseQueue;

/**
 * 使用数组实现队列
 * Created by tanc on 2017/2/9.
 */
public class ArrayQueueImpl<E> implements BaseQueue<E> {

    private static final int INIT_SIZE = 24;

    private Object[] objects;
    private int head;
    private int tail;
    private int size;

    public ArrayQueueImpl() {
        head = -1;
        tail = -1;
        size = 0;
        objects = new Object[INIT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E element) {
        if (head == -1) {
            headMove();
        }
        tailMove();
        objects[tail] = element;
        size++;
    }

    @Override
    public E pop() {
        E e = getElement(objects[head]);
        headMove();
        size--;
        return e;
    }

    private void headMove() {
        head = (head + 1) % INIT_SIZE;
    }

    private void tailMove() {
        tail = (tail + 1) % INIT_SIZE;
    }

    @SuppressWarnings("unchecked")
    private E getElement(Object o) {
        return (E) o;
    }
}
