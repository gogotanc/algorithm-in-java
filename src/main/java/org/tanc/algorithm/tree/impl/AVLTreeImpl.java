package org.tanc.algorithm.tree.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.tree.BinaryTree;

/**
 * AVL (Adelson-Belskii Landis) 树
 * 带有平衡条件的二叉查找树
 * Created by tanc on 2017/2/10.
 */
public class AVLTreeImpl<E extends Comparable<? super E>> implements BinaryTree<E> {

    private Node<E> root;

    public AVLTreeImpl() {
        root = null;
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
        return false;
    }

    @Override
    public E findMin() {
        return null;
    }

    @Override
    public E findMax() {
        return null;
    }

    @Override
    public void insert(E element) {
        root = insert(element, root);
    }

    private Node<E> insert(E element, Node<E> node) {

        if (null == node) {
            return new Node<>(element);
        }

        int result = element.compareTo(node.element);

        if (result > 0) {
            node.right = insert(element, node.right);
        } else if (result < 0) {
            node.left = insert(element, node.left);
        } else {
            throw new IllegalOperationException("不能添加重复数据");
        }

        return balance(node);
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public void printTree() {
        printTree(root);
    }

    private void printTree(Node<E> root) {
        if (null == root) {
            return;
        }
        // 中序遍历
        printTree(root.left);
        System.out.print(root.element + ",");
        printTree(root.right);
    }

    /**
     * 进行插入操作后进行平衡操作
     * @param node 根节点
     */
    private Node<E> balance(Node<E> node) {

        if (null == node) {
            return null;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if ((leftHeight - rightHeight) > 1) {
            if (height(node.left.left) > height(node.right)) {
                // 右单旋转
                node = rotateWithLeftChild(node);
            } else {
                // 左、右双旋转
                node = doubleWithLeftChild(node);
            }
        } else if (rightHeight - leftHeight > 1) {
            if (height(node.right.right) > height(node.left)) {
                // 左单旋转
                node = rotateWithRightChild(node);
            } else {
                // 右、左双旋转
                node = doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    /**
     * 单旋转 （右旋转）
     * 详情见《数据结构与算法分析 - Java 语言描述》 P87
     *
     * T1, T2, T3 and T4 are subtrees.
     *          z                                      y
     *         / \                                   /   \
     *        y   T4      Right Rotate (z)          x      z
     *       / \          - - - - - - - - ->      /  \    /  \
     *      x   T3                               T1  T2  T3  T4
     *     / \
     *   T1   T2
     *
     * @param k2 旋转开始前的根结点
     * @return k1 作为新的根结点返回
     */
    private Node<E> rotateWithLeftChild(Node<E> k2) {
        Node<E> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /**
     * 单旋转 （左旋转）
     * @param k1 旋转开始前的根结点
     * @return k2 作为新的根结点返回
     */
    private Node<E> rotateWithRightChild(Node<E> k1) {
        Node<E> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) +1;

        return k2;
    }

    /**
     * 双旋转（先左后右） P93
     *
     *      z                               z                           x
     *     / \                            /   \                        /  \
     *    y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
     *   / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
     * T1   x                          y    T3                    T1  T2 T3  T4
     *     / \                        / \
     *   T2   T3                    T1   T2
     *
     *
     * @param k3 初始根节点 (z)
     * @return k3.left.right (x) 作为根返回
     */
    private Node<E> doubleWithLeftChild(Node<E> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 双旋转（先右后左）
     * @param k3 初始根节点
     * @return k3.right.left 作为根返回
     */
    private Node<E> doubleWithRightChild(Node<E> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private int height(Node<E> node) {
        return null == node ? -1 : node.height;
    }

    /**
     * 定义 AVL Tree 节点
     */
    private class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        int height;

        Node() {
            this(null, null, null);
        }

        Node(T element) {
            this(element, null, null);
        }

        Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }
}
