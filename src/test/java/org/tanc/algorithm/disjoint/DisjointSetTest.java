package org.tanc.algorithm.disjoint;

import org.junit.Test;
import org.tanc.algorithm.disjoint.impl.DisjointSetArrayImpl;

import static org.junit.Assert.*;

/**
 * 并查集测试
 * Created by tanc on 2017/2/20.
 */
public class DisjointSetTest {

    @Test
    public void simpleTest() throws Exception {
        DisjointSet disjointSet = new DisjointSetArrayImpl();
        disjointSet.union(3, 5);
        disjointSet.union(2, 8);
        assertEquals(true, disjointSet.find(3) == disjointSet.find(5));
        assertEquals(false, disjointSet.find(2) == disjointSet.find(7));
        assertEquals(true, disjointSet.find(2) == disjointSet.find(8));
    }
}