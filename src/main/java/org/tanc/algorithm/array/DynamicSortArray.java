package org.tanc.algorithm.array;

import org.tanc.algorithm.exception.IllegalOperationException;

/**
 * 实现一个大小固定的有序数组，支持动态增删改查操作
 *
 * @author tanc
 */
public class DynamicSortArray<T extends Comparable<? super T>> {

    private Object[] array;
    private int size;

    public DynamicSortArray() {
        array = new Object[10];
        this.size = 0;
    }

    public DynamicSortArray(int size) {
        if (size <= 0) {
            array = new Object[10];
        } else {
            array = new Object[size];
        }
        this.size = 0;
    }

    public void add(T element) {
        checkSize();
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (getElement(i).compareTo(element) >= 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            array[size++] = element;
        } else {
            if (size - index >= 0) {
                System.arraycopy(array, index, array, index + 1, size - index);
            }
            array[index] = element;
            size++;
        }
    }

    public T delete(T element) {
        int index = binarySearch(element);
        if (index == -1) {
            return null;
        } else {
            T result = get(index);
            if (size - 1 - index >= 0) {
                System.arraycopy(array, index + 1, array, index, size - 1 - index);
            }
            size--;
            return result;
        }
    }

    public T get(int index) {
        return getElement(index);
    }

    @SuppressWarnings("unchecked")
    private T getElement(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    private int binarySearch(T element) {
        return binarySearch(element, 0, size - 1);
    }

    private int binarySearch(T element, int start, int end) {
        if (end < start) {
            return -1;
        } else if (end == start) {
            if (getElement(start).compareTo(element) == 0) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (end - start) / 2;
        if (getElement(mid).compareTo(element) == 0) {
            return mid;
        } else if (getElement(mid).compareTo(element) > 0) {
            return binarySearch(element, start, mid);
        } else {
            return binarySearch(element, mid + 1, end);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalOperationException();
        }
    }

    private void checkSize() {
        if (size < array.length) {
            return;
        }
        if (size == array.length) {
            Object[] newArray = new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(getElement(i).toString());
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
