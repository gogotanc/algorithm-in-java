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

    /* 保存所有顶点的链表 */
    private List<Vertex> vertexList;

    public GraphImpl() {
        vertexList = new ArrayList<>();
    }

    @Override
    public void addEdge(int inNum, int outNum) {
        Vertex begin = findVertex(inNum);
        Vertex end = findVertex(outNum);

        if (null == end) {
            end = new Vertex(outNum);
            vertexList.add(end);
        }
        if (null == begin) {
            begin = new Vertex(inNum);
            vertexList.add(begin);
        }
        begin.addLink(end);
    }

    @Override
    public void topologicalSorting() {

        BaseQueue<Vertex> zero = new LinkedQueueImpl<>();
        List<Vertex> temp = new ArrayList<>(vertexList);

        while (temp.size() > 0) {
            Vertex vertex = findZeroInDegreeVertex(temp);
            if (vertex == null) {
                throw new IllegalOperationException("拓扑排序出错");
            }

            zero.push(vertex);
            temp.remove(vertex);

            for (Vertex item : vertex.links) {
                item.removeLink(item);
            }
        }

        while (zero.size() > 0) {
            Vertex vertex = zero.pop();
            System.out.println(vertex.number);
        }
    }

    @Override
    public void print() {
        for (Vertex vertex : vertexList) {
            System.out.print(vertex.number + " ==>");
            for (Vertex vertex1 : vertex.links) {
                System.out.print(vertex1.number + ",");
            }
            System.out.println();
        }
    }

    @Override
    public void showLength(int inNum) {
        Vertex vertex = findVertex(inNum);

    }

    /**
     * 查找节点
     * @param number 节点的序号
     * @return 找到的节点
     */
    private Vertex findVertex(int number) {
        for (Vertex vertex : vertexList) {
            if (vertex.number == number) {
                return vertex;
            }
        }
        return null;
    }

    /**
     * 查找 0 入度的节点
     * @param list 节点列表
     * @return 返回首先找到的 0 入度的节点
     */
    private Vertex findZeroInDegreeVertex(List<Vertex> list) {
        for (Vertex vertex : list) {
            if (vertex.inDegree == 0) {
                return vertex;
            }
        }
        return null;
    }

    /**
     * 图顶点数据结构
     */
    private class Vertex {
        /* 节点的序号 */
        int number;
        /* 节点的入度 */
        int inDegree;
        /* 距源节点的距离 */
        int dist;
        /* 节点的链接点 */
        List<Vertex> links;

        Vertex(int number) {
            inDegree = 0;
            links = new ArrayList<>();
            this.number = number;
        }

        void addLink(Vertex vertex) {
            vertex.inDegree++;
            links.add(vertex);
        }

        void removeLink(Vertex vertex) {
            vertex.inDegree--;
            links.remove(vertex);
        }
    }
}
