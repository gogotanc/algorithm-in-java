package org.tanc.algorithm.stack.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.stack.BaseStack;

/**
 * 使用数组实现栈
 * Created by tanc on 2017/2/9.
 */
public class ArrayStackImpl<E> implements BaseStack<E> {

    private Object[] objects;
    private int size;

    public ArrayStackImpl() {
        size = 0;
        objects = new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E element) {
        if (size == objects.length) {
            updateArraySize();
        }
        objects[size++] = element;
    }

    @Override
    public E top() {
        return getElement(objects[size-1]);
    }

    @Override
    public E pop() {
        if (size <= 0) {
            throw new IllegalOperationException("栈中没有数据");
        }
        return getElement(objects[--size]);
    }

    @SuppressWarnings("unchecked")
    private E getElement(Object o) {
        return (E) o;
    }

    private void updateArraySize() {
        Object[] newArray = new Object[size * 2];
        System.arraycopy(objects, 0, newArray, 0, size);
        objects = newArray;
    }
}
