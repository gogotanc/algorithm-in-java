package org.tanc.algorithm.disjoint;

/**
 * 并查集 (Disjoint set或者Union-find set)
 * Created by tanc on 2017/2/20.
 */
public interface DisjointSet {

    int find(int x);

    void union(int x, int y);
}
