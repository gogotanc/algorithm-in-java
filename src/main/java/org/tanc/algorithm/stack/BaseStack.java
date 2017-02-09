package org.tanc.algorithm.stack;

/**
 * 栈
 */
public interface BaseStack<E> {

    int size();

    void push(E element);

    E top();

    E pop();
}
