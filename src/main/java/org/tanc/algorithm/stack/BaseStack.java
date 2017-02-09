package org.tanc.algorithm.stack;

/**
 * 栈
 * Created by tanc on 2017/2/9.
 */
public interface BaseStack<E> {

    int size();

    void push(E element);

    E top();

    E pop();
}
