package org.tanc.algorithm.list;

/**
 * 自定义列表接口
 */
public interface BaseList<E> {

    void add(E element);

    int size();

    E get(int index);

    void set(int index, E element);

    E remove(int index);

    boolean contains(E element);
}
