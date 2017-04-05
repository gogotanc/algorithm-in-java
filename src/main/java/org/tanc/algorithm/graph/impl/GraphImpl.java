package org.tanc.algorithm.graph.impl;

import org.tanc.algorithm.exception.IllegalOperationException;
import org.tanc.algorithm.queue.BaseQueue;
import org.tanc.algorithm.queue.impl.LinkedQueueImpl;

import java.util.*;

/**
 * 有向图
 * Created by tanc on 2017/3/1.
 */
public class GraphImpl {

    private static final int INFINITY = 10000;

    /* 保存所有顶点的链表 */
    private List<Vertex> vertexList;

    public GraphImpl() {
        vertexList = new ArrayList<>();
    }

    /**
     * 添加边
     */
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

    /**
     * 拓扑排序
     */
    public void topologicalSorting() {

        /* 保存 0 入度顶点的队列 */
        BaseQueue<Vertex> zero = new LinkedQueueImpl<>();
        /* 复制顶点的链表 */
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

    public void print() {
        for (Vertex vertex : vertexList) {
            System.out.print(vertex.number + " ==>");
            for (Vertex vertex1 : vertex.links) {
                System.out.print(vertex1.number + ",");
            }
            System.out.println();
        }
    }

    /**
     * 打印无权图最短路径
     *
     * @param inNum 单源节点
     */
    public void printShortestDist(int inNum) {

        Vertex vertex = findVertex(inNum);

        BaseQueue<Vertex> queue = new LinkedQueueImpl<>();

        if (null == vertex) {
            throw new IllegalOperationException("顶点不存在");
        }

        for (Vertex v : vertexList) {
            v.dist = INFINITY;
        }

        vertex.dist = 0;
        queue.push(vertex);

        while (queue.size() != 0) {

            Vertex v = queue.pop();

            System.out.println(v.number + "==>" + v.dist);

            //v.links.stream().filter(w -> w.dist == INFINITY).forEach(w -> w.dist = v.dist + 1);

            v.links.forEach(w -> {
                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    queue.push(w);
                }
            });
        }
    }

    /**
     * 查找节点
     *
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
     *
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

        /* 距离源节点的路径长 */
        int path;

        /* 节点的链接点 */
        List<Vertex> links;

        Vertex(int number) {
            inDegree = 0;
            links = new ArrayList<>();
            this.number = number;
        }

        /**
         * 添加链接顶点
         *
         * @param vertex 给顶点添加链接的顶点
         */
        void addLink(Vertex vertex) {
            vertex.inDegree++;
            links.add(vertex);
        }

        /**
         * 删除链接顶点
         *
         * @param vertex 要删除的顶点
         */
        void removeLink(Vertex vertex) {
            vertex.inDegree--;
            links.remove(vertex);
        }
    }
}
