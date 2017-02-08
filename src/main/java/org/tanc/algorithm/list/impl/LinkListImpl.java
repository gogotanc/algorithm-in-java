package org.tanc.algorithm.list.impl;

import org.tanc.algorithm.list.BaseList;

/**
 * 使用 带头节点单向链表 实现表
 */
public class LinkListImpl<E> implements BaseList<E> {

    private Node<E> head;
    private int size;

    public LinkListImpl() {
        size = 0;
        head = new Node<>(null, null);
    }

    @Override
    public void add(E element) {
        size++;
        Node<E> temp = head.next;
        head.next = new Node<>(element, temp);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        if ( node == null) {
            return null;
        }
        return node.item;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);

        Node<E> current = head;
        Node<E> prev = head;
        Node<E> newNode = new Node<>(element, null);

        for(int i = 0; i <= index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Node<E> current = head;
        Node<E> prev = head;

        for(int i = 0; i <= index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
        size--;
        return current.item;
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = head;
        if (null == temp.next) {
            return null == element;
        }
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            if (temp.item == element) {
                return true;
            }
        }
        return false;
    }

    private Node<E> getNode(int index) {
        checkIndex(index);
        Node<E> temp = head;
        if (null != temp.next) {
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }

    private void checkIndex(int index) {
        if (0 < index && index < size) {
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
    }
}
