package org.tanc.algorithm.tree.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.tree.BinaryTree;

/**
 * 二叉查找树
 * Created by tanc on 2017/2/10.
 */
public class BinarySearchTreeImpl<E extends Comparable<? super E>> implements BinaryTree<E> {

    private Node<E> root;

    public BinarySearchTreeImpl() {
        root = null;
    }

    public BinarySearchTreeImpl(Node<E> root) {
        this.root = root;
    }

    @Override
    public void makeEmpty() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(E element) {
        return contains(element, root);
    }

    @Override
    public E findMin() {
        // 使用递归实现
        return findMin(root);
    }

    private E findMin(Node<E> node) {
        if (null == node) {
            throw new IllegalOperationException("二叉树为空");
        }
        Node<E> min = node;
        while (min.left != null) {
            min = min.left;
        }
        return min.element;
    }

    @Override
    public E findMax() {
        if (null == root) {
            throw new IllegalOperationException("二叉树为空");
        }
        Node<E> max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max.element;
    }

    @Override
    public void insert(E element) {
        if (root == null) {
            root = new Node<>(element, null, null);
            return;
        }
        insert(element, root);
    }

    private void insert(E element, Node<E> node) {
        if (node == null) {
            return;
        }
        int result = element.compareTo(node.element);
        if (result > 0) {
            if (node.right != null) {
                insert(element, node.right);
            } else {
                node.right = new Node<>(element, null, null);
            }
        } else if (result < 0) {
            if (node.left != null) {
                insert(element, node.left);
            } else {
                node.left = new Node<>(element, null, null);
            }
        }
    }

    @Override
    public void remove(E element) {
        // todo remove method need to being finished
    }

    @Override
    public void printTree() {
        printTree(root);
    }

    private void printTree(Node<E> root) {

        if (null == root) {
            return;
        }

        printTree(root.left);
        System.out.print(root.element + ",");
        printTree(root.right);
    }

    private boolean contains(E element, Node<E> node) {
        if (node == null) {
            return false;
        }
        int result = element.compareTo(node.element);
        if (result > 0) {
            return contains(element, node.right);
        } else if (result < 0) {
            return contains(element, node.left);
        } else {
            return true;
        }
    }

    private class Node<T> {

        T element;
        Node<T> left;
        Node<T> right;

        Node() {
            element = null;
            left = null;
            right = null;
        }

        Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
