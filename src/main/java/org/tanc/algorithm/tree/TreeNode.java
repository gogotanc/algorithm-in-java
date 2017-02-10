package org.tanc.algorithm.tree;

/**
 * 树节点
 * Created by tanc on 2017/2/10.
 */
public class TreeNode {

    private Object element;
    private TreeNode firstChild;
    private TreeNode nextSibling;

    public TreeNode() {
        element = null;
        firstChild = null;
        nextSibling = null;
    }

    public TreeNode(Object element) {
        this.element = element;
        firstChild = null;
        nextSibling = null;
    }

    public TreeNode(Object element, TreeNode firstChild, TreeNode nextSibling) {
        this.element = element;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }
}
