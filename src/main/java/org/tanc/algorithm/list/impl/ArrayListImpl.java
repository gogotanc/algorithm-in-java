package org.tanc.algorithm.list.impl;

import org.tanc.algorithm.list.BaseList;

/**
 * 数组实现表
 * Created by tanc on 2017/2/8.
 */
public class ArrayListImpl<E> implements BaseList<E> {

    private Object[] list;
    private int size;

    public ArrayListImpl() {
        size = 0;
        list = new Object[2];
    }

    public void add(E element) {
        if (size == list.length) {
            addSize();
        }
        set(size++, element);
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        checkIndex(index);
        return getElement(index);
    }

    public void set(int index, E element) {
        checkIndex(index);
        list[index] = element;
    }

    public E remove(int index) {
        checkIndex(index);
        E oldValue = getElement(index);
        System.arraycopy(list, index, list, index, size - index - 1);
        list[--size] = null;
        return oldValue;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查下标是否合法
     * @param index 传入的下标
     */
    private boolean checkIndex(int index) {
        if (0 <= index && index < size) {
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        return (E) list[index];
    }

    private void addSize() {
        Object[] newList = new Object[size * 2];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }
}
