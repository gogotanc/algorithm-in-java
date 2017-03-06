package org.tanc.algorithm.graph;

/**
 * 无权图
 * Created by tanc on 2017/2/28.
 */
public interface Graph {

    /**
     * 添加边
     *
     * @param inNum  起点
     * @param outNum 终点
     */
    void addEdge(int inNum, int outNum);

    /**
     * 拓扑排序
     */
    void topologicalSorting();

    /**
     * 打印输出所有节点和连接
     */
    void print();

    /**
     * 打印无权图最短路径
     *
     * @param inNum 单源节点
     */
    void printShortestDist(int inNum);
}
