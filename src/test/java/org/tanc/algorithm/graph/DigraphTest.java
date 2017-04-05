package org.tanc.algorithm.graph;

import org.junit.Test;
import org.tanc.algorithm.graph.impl.Digraph;

import static org.junit.Assert.*;

/**
 * 有向图的测试
 * Created by tanc on 2017/4/5.
 */
public class DigraphTest {

    @Test
    public void VCount() throws Exception {
        Graph graph = new Digraph(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);

        graph.print();

        assertEquals(3, graph.VCount());
        assertEquals(3, graph.ECount());
    }

}