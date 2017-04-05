package org.tanc.algorithm.graph;

import org.junit.Test;
import org.tanc.algorithm.graph.Graph;
import org.tanc.algorithm.graph.impl.SimpleGraph;

import static org.junit.Assert.*;

/**
 * 无向简单图测试
 * Created by tanc on 2017/4/5.
 */
public class SimpleGraphTest {

    @Test
    public void case1() throws Exception {
        Graph graph = new SimpleGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.print();
    }

}