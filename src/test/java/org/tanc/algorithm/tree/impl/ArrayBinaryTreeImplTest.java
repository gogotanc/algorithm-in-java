package org.tanc.algorithm.tree.impl;

import org.junit.Test;
import org.tanc.algorithm.tree.BinaryTree;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * 使用数组实现二叉树测试
 * Created by tanc on 2017/8/11.
 */
public class ArrayBinaryTreeImplTest {

    @Test
    public void case1() throws Exception {

        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        ArrayList<Integer> asdf = new ArrayList<>();

        for (int i : data) {
            asdf.add(i);
        }

        BinaryTree<Integer> tree = new ArrayBinaryTreeImpl<>(asdf);

        tree.printTree();
    }
}