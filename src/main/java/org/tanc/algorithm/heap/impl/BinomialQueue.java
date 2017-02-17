package org.tanc.algorithm.heap.impl;

import org.tanc.algorithm.heap.BaseHeap;

/**
 * 二项队列
 * Created by tanc on 2017/2/16.
 */
public class BinomialQueue<E extends Comparable<? super E>> implements BaseHeap<E>{

    private int size;
    private Node<E> [] roots;

    @SuppressWarnings("unchecked")
    public BinomialQueue() {
        roots = new Node[10];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private BinomialQueue(E item){
        size = 1;
        roots = new Node[1];
        roots[0] = new Node<>(item, null, null);
    }

    @Override
    public E deleteMin() {
        Node<E> min = getMin();

        delete();

        return min.data;
    }

    private void delete() {
        int minIndex = getMinIndex();
        Node<E> min = getMin();
        int size = pow(2, minIndex);
        this.roots[minIndex] = null;
        this.size -= size;

        BinomialQueue<E> queue = new BinomialQueue<>();
        queue.size = size;

        Node<E> temp = min.firstChild;
        queue.roots[0] = temp;
        for (int i = 1; i < minIndex; i++) {
            Node<E> e = temp.nextSibling;
            temp = temp.nextSibling;
            queue.roots[i] = e;
        }

        for (Node<E> node : queue.roots) {
            if (null != node) {
                node.nextSibling = null;
            }
        }

        merge(queue);

    }

    private int pow(int src, int count) {
        int result = 1;
        for (int i = 0; i < count; i++) {
            result *= src;
        }
        return result;
    }

    private int getMinIndex() {
        E min = null;
        int index = 0;
        for (int i = 0; i < roots.length; i++) {
            if (null == roots[i]) {
                continue;
            }
            if (null == min) {
                min = roots[i].data;
                continue;
            }
            if (min.compareTo(roots[i].data) > 0) {
                min = roots[i].data;
                index = i;
            }
        }
        return index;
    }

    private Node<E> getMin() {
        Node<E> min = null;
        for (Node<E> root : roots) {
            if (null == root) {
                continue;
            }
            if (null == min) {
                min = root;
                continue;
            }
            if (min.data.compareTo(root.data) > 0) {
                min = root;
            }
        }
        return min;
    }

    @Override
    public void insert(E element) {
        merge(new BinomialQueue<>(element));
    }

    @Override
    public void printHeap() {
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == null) {
                continue;
            }
            System.out.println("----- B(" + i + ") -----:");
            printTree(roots[i]);
            System.out.println();
        }
    }

    private void printTree(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ",");
        printTree(node.nextSibling);
        printTree(node.firstChild);
    }

    /**
     * 合并操作
     * @param queue 待合并的二项队列
     */
    private void merge(BinomialQueue<E> queue) {

        if (this == queue) {
            return;
        }

        int add = queue.size;
        this.size += add;

        Node<E> temp = null;
        Node<E> r1;
        Node<E> r2;
        for (int i = 0; i < roots.length; i++) {
            r1 = roots[i];
            r2 = i < queue.roots.length ? queue.roots[i] : null;

            int a = r1 == null ? 0 : 1;
            int b = r2 == null ? 0 : 1;
            int c = temp == null ? 0 : 1;

            int flag = a + b + c;

            switch (flag) {
                case 0:
                    break;
                case 1:
                    if (a == 1) {
                        break;
                    } else if (b == 1) {
                        roots[i] = r2;
                    } else if (c == 1) {
                        roots[i] = temp;
                        temp = null;
                    }
                    break;
                case 2:
                    if (a == 0) {
                        temp = combineTrees(r2, temp);
                    } else if (b == 0) {
                        temp = combineTrees(r1, temp);
                    } else if (c == 0) {
                        temp = combineTrees(r2, r1);
                    }
                    roots[i] = null;
                    break;
                case 3:
                    temp = combineTrees(r2, temp);
                default:
            }
        }
    }

    private Node<E> combineTrees(Node<E> r1, Node<E> r2) {
        int result = r1.data.compareTo(r2.data);
        if (result > 0) {
            return combineTrees(r2, r1);
        } else {
            Node<E> temp;
            if (r1.firstChild != null) {
                temp = r1.firstChild;
                while (temp.nextSibling != null) {
                    temp = temp.nextSibling;
                }
                temp.nextSibling = r2;
            } else {
                r1.firstChild = r2;
            }
            return r1;
        }
    }

    private class Node<T extends Comparable<? super T>> {
        T data;
        Node<T> firstChild;
        Node<T> nextSibling;

        Node(T element) {
            this(element, null, null);
        }

        Node(T element, Node<T> firstChild, Node<T> nextSibling) {
            this.data = element;
            this.firstChild = firstChild;
            this.nextSibling = nextSibling;
        }
    }
}
