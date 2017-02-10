package org.tanc.algorithm.tree;

import org.junit.Test;
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
}