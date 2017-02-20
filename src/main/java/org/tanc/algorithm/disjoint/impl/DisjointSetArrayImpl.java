package org.tanc.algorithm.disjoint.impl;

import org.tanc.algorithm.disjoint.DisjointSet;

/**
 * 并查集 （数组实现）
 * Created by tanc on 2017/2/20.
 */
public class DisjointSetArrayImpl implements DisjointSet {

    private int[] arr;

    public DisjointSetArrayImpl() {
        arr = new int[24];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    @Override
    public int find(int x) {
        if (arr[x] < 0) {
            return x;
        }
        return find(arr[x]);
    }

    @Override
    public void union(int x, int y) {
        if (same(x, y)) {
            return;
        }
        arr[y] = x;
    }

    private boolean same(int a, int b) {
        return find(a) == find(b);
    }
}
