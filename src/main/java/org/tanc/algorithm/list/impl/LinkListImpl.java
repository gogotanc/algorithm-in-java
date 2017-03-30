package org.tanc.algorithm.list.impl;

import org.tanc.algorithm.list.BaseList;

/**
 * 使用 带头节点单向链表 实现表
 * Created by tanc on 2017/2/8.
 */
public class LinkListImpl<E> implements BaseList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkListImpl() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public void add(E element) {
        Node<E> node = tail;
        tail = new Node<>(element);
        if (null == node) {
            head = tail;
        } else {
            node.next = tail;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        Node<E> node = getNode(index);
        node.item = element;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Node<E> current = head;
        Node<E> prev = head;

        if (0 == index) {
            // 删除的是头结点
            head = head.next;
            prev.next = null;
            size--;
            return prev.item;
        }

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;

        if (size - 1 == index) {
            // 删除的是尾结点
            tail = prev;
        }

        size--;
        return current.item;
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.item.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private Node<E> getNode(int index) {
        checkIndex(index);
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void checkIndex(int index) {
        if (0 <= index && index < size) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

        Node(E element) {
            this(element, null);
        }

        Node() {
            this(null, null);
        }
    }
}
