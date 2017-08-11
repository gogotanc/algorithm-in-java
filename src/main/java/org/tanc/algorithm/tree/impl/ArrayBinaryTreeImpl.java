package org.tanc.algorithm.tree.impl;

import org.tanc.algorithm.tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 使用数组实现二叉树
 * Created by tanc on 2017/8/11.
 */
public class ArrayBinaryTreeImpl<E extends Comparable<? super E>> implements BinaryTree<E> {

    private ArrayList<E> data;

    public ArrayBinaryTreeImpl() {
        this(new ArrayList<>());
    }

    public ArrayBinaryTreeImpl(ArrayList<E> data) {
        this.data = data;
    }

    @Override
    public void makeEmpty() {
        data.clear();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(E element) {
        return data.contains(element);
    }

    @Override
    public E findMin() {

        E min = null;

        for (E element : data) {
            if (null == min) {
                min = element;
            } else if (min.compareTo(element) > 0) {
                min = element;
            }
        }

        return min;
    }

    @Override
    public E findMax() {
        E max = null;

        for (E element : data) {
            if (null == max) {
                max = element;
            } else if (max.compareTo(element) < 0) {
                max = element;
            }
        }

        return max;
    }

    @Override
    public void insert(E element) {
        throw new IllegalStateException("这个实现类不允许这个操作");
    }

    @Override
    public void remove(E element) {
        throw new IllegalStateException("这个实现类不允许这个操作");
    }

    @Override
    public void printTree() {

        if (isEmpty()) {
            return;
        }

        LinkedList<E> stack = new LinkedList<E>();

        int index = 1;

        stack.push(data.get(index));

        while (!stack.isEmpty()) {

            E temp = stack.pop();

            index = data.indexOf(temp);

            System.out.print(temp + ",");

            if (2 * index < data.size() && data.get(2 * index) != null) {
                stack.push(data.get(2 * index));
            }
            if (2 * index + 1< data.size() && data.get(2 * index + 1) != null) {
                stack.push(data.get(2 * index + 1));
            }
        }
    }
}
