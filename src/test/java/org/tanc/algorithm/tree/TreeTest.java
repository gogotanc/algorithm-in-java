package org.tanc.algorithm.tree;

import org.junit.Test;

/**
 * 树相关测试
 * Created by tanc on 2017/2/10.
 */
public class TreeTest {

    @Test
    public void testTree() throws Exception {
        SimpleTree tree = new SimpleTree();
        tree.setRoot(createTree());
        printTree(tree.getRoot());
    }

    private void printTree(TreeNode root) {

        if (null == root) {
            return;
        }

        printTree(root.getFirstChild());
        System.out.print(root.getElement());
        printTree(root.getNextSibling());

    }

    private TreeNode createTree() {

        TreeNode n = new TreeNode("N");
        TreeNode g = new TreeNode("G", n, null);

        TreeNode m = new TreeNode("M");
        TreeNode l = new TreeNode("L", null, m);
        TreeNode k = new TreeNode("K", null, l);
        TreeNode f = new TreeNode("F", k, g);

        TreeNode q = new TreeNode("Q");
        TreeNode p = new TreeNode("P", null, q);
        TreeNode j = new TreeNode("J", p, null);
        TreeNode i = new TreeNode("I", null, j);
        TreeNode e = new TreeNode("E", i, f);

        TreeNode h = new TreeNode("H");
        TreeNode d = new TreeNode("D", h, e);

        TreeNode c = new TreeNode("C", null, d);

        TreeNode b = new TreeNode("B", null, c);

        TreeNode a = new TreeNode("A", b, null);

        return a;

        /*
         * a
         * b c d  e      f      g
         *     h  i j    k l m  n
         *          p q
         *
         * pre order  : ABCDHEIJPQFKLMGN
         * post order : HQPJIMLKNGFEDCBA
         * in order   : BCHDIPQJEKLMFNGA
         */
    }
}