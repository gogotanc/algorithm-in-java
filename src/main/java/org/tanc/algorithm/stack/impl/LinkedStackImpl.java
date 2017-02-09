package org.tanc.algorithm.stack.impl;

import org.tanc.algorithm.stack.BaseStack;

/**
 * 单链表实现栈（带头节点的单链表）
 */
public class LinkedStackImpl<E> implements BaseStack<E> {

    private Node<E> head;
    private int size;

    public LinkedStackImpl() {
        size = 0;
        head = new Node<>(null, null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E element) {
        size++;
        head.next = new Node<>(element, head.next);
    }

    @Override
    public E top() {
        return head.next.item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        size--;
        Node<E> top = head.next;
        head.next = top.next;
        top.next = null;
        return top.item;
    }

    private class Node<T> {
        T item;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
