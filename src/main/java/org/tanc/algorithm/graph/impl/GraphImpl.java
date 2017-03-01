package org.tanc.algorithm.graph.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.graph.Graph;
import org.tanc.algorithm.queue.BaseQueue;
import org.tanc.algorithm.queue.impl.LinkedQueueImpl;

import java.util.*;

/**
 * 有向图
 * Created by tanc on 2017/3/1.
 */
public class GraphImpl implements Graph {

    private List<Vertex> vertexList;

    public GraphImpl() {
        vertexList = new ArrayList<>();
    }

    @Override
    public void addEdge(int in, int out) {
        Vertex begin = findVertex(in);
        Vertex end = findVertex(out);

        if (null == end) {
            end = new Vertex(out);
            vertexList.add(end);
        }
        if (null == begin) {
            begin = new Vertex(in);
            vertexList.add(begin);
        }
        begin.addLink(end);
    }

    @Override
    public void topologicalSorting() {
        Vertex vertex = findZeroIndegreeVertex();
        if (vertex == null) {
            throw new IllegalOperationException("拓扑排序出错");
        }
        BaseQueue<Vertex> zeroIndegreeVertexQueue = new LinkedQueueImpl<>();

        zeroIndegreeVertexQueue.push(vertex);

        for (Vertex item : vertex.links) {
            item.removeLink(vertex);
        }
    }

    @Override
    public void print() {
        for (Vertex vertex : vertexList) {
            System.out.print(vertex.item + " ==>");
            for (Vertex vertex1 : vertex.links) {
                System.out.print(vertex1.item + ",");
            }
            System.out.println();
        }
    }

    private Vertex findVertex(int value) {
        for (Vertex vertex : vertexList) {
            if (vertex.item == value) {
                return vertex;
            }
        }
        return null;
    }

    private Vertex findZeroIndegreeVertex() {
        for (Vertex vertex : vertexList) {
            if (vertex.indegree == 0) {
                return vertex;
            }
        }
        return null;
    }

    private class Vertex {
        int item;
        int indegree;
        List<Vertex> links;

        Vertex(int item) {
            indegree = 0;
            links = new ArrayList<>();
            this.item = item;
        }

        void addLink(Vertex vertex) {
            vertex.indegree++;
            links.add(vertex);
        }

        void removeLink(Vertex vertex) {
            vertex.indegree--;
            links.remove(vertex);
        }
    }
}
