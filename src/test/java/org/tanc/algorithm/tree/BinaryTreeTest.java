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
    public void binarySearchTree() {
        BinaryTree<Integer> tree = new BinarySearchTreeImpl<>();
        testCase(tree);
    }

    @Test
    public void AVLTree() {
        BinaryTree<Integer> tree = new AVLTreeImpl<>();
        testCase(tree);
    }

    private void testCase(BinaryTree<Integer> tree) {
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
        assertEquals(1, tree.findMin().intValue());
        assertEquals(16, tree.findMax().intValue());
        assertEquals(true, tree.contains(5));
        assertEquals(false, tree.contains(18));
        tree.makeEmpty();
        assertEquals(true, tree.isEmpty());
    }
}