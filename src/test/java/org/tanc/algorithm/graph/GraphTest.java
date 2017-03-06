package org.tanc.algorithm.graph;

import org.junit.Test;
import org.tanc.algorithm.graph.impl.GraphImpl;

import static org.junit.Assert.*;

/**
 * 图相关测试
 * Created by tanc on 2017/3/1.
 */
public class GraphTest {

    @Test
    public void test() throws Exception {

        Graph graph = new GraphImpl();

        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);

        graph.print();

        graph.topologicalSorting();
    }
}