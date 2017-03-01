package org.tanc.algorithm.graph;

/**
 * 图
 * Created by tanc on 2017/2/28.
 */
public interface Graph {

    /**
     * 添加无权边（权为1）
     *
     * @param in  起点
     * @param out 终点
     */
    void addEdge(int in, int out);

    /**
     * 拓扑排序
     */
    void topologicalSorting();

    /**
     * 打印输出所有节点和连接
     */
    void print();
}
