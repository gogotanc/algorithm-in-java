package org.tanc.algorithm.queue.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.queue.BaseQueue;

/**
 * 使用单链表实现的队列（包含首尾指针）
 * Created by tanc on 2017/2/9.
 */
public class LinkedQueueImpl<E> implements BaseQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueueImpl() {
        size = 0;
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E element) {
        Node<E> temp = new Node<>(element, null);
        if (head.next == null) {
            head.next = temp;
        }
        if (tail.next != null) {
            tail.next.next = temp;
        }
        tail.next = temp;
        size++;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new IllegalOperationException("队列中没有数据。");
        }
        Node<E> temp = head.next;
        head.next = temp.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
