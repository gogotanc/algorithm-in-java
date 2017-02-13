package org.tanc.algorithm.tree;

import org.junit.Test;
import org.tanc.algorithm.tree.impl.AVLTreeImpl;
import org.tanc.algorithm.tree.impl.BinarySearchTreeImpl;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * 二叉树测试
 * Created by tanc on 2017/2/10.
 */
public class BinaryTreeTest {

    @Test
    public void test() {

        BinaryTree<Integer> tree = new BinarySearchTreeImpl<>();

        Random random = new Random(46);
        for (int i =0; i<14; i++) {
            tree.insert(random.nextInt(100));
        }
        tree.printTree();
    }

    @Test
    public void AVLTree() {
        BinaryTree<Integer> tree = new AVLTreeImpl<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(16);
        tree.insert(15);
        tree.insert(14);
        tree.insert(13);
        tree.insert(12);
        tree.insert(11);
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.printTree();
    }
}