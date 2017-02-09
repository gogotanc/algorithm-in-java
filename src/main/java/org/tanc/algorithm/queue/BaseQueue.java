package org.tanc.algorithm.queue;

/**
 * 队列
 * Created by tanc on 2017/2/9.
 */
public interface BaseQueue<E> {

    int size();

    void push(E element);

    E pop();
}
