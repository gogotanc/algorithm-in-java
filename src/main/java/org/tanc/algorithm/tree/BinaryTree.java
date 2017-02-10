package org.tanc.algorithm.tree;

/**
 * 二叉树
 * Created by tanc on 2017/2/10.
 */
public interface BinaryTree<E> {

    void makeEmpty();

    boolean isEmpty();

    boolean contains(E element);

    E findMin();

    E findMax();

    void insert(E element);

    void remove(E element);

    void printTree();
}
