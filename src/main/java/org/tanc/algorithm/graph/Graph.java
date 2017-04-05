package org.tanc.algorithm.graph;

/**
 * 图
 * Created by tanc on 2017/2/28.
 */
public interface Graph<E> {

    /**
     * 获取顶点数
     */
    int VCount();

    /**
     * 获取边数
     */
    int ECount();

    /**
     * 添加边
     *
     * @param v 有向的时候为起点
     * @param w 有向的时候为终点
     */
    void addEdge(int v, int w);

    /**
     * 获取 v 连接的顶点
     */
    Iterable<E> adj(int v);

//    /**
//     * 拓扑排序
//     */
//    void topologicalSorting();

    /**
     * 打印输出所有节点和连接
     */
    void print();

//    /**
//     * 打印无权图最短路径
//     *
//     * @param inNum 单源节点
//     */
//    void printShortestDist(int inNum);
}
