package org.tanc.algorithm.graph.impl;

import org.tanc.algorithm.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向图
 * Created by tanc on 2017/4/5.
 */
public class Digraph implements Graph {

    private final int v;
    private int e;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = (List<Integer>[]) new List[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @Override
    public int VCount() {
        return v;
    }

    @Override
    public int ECount() {
        return e;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        e++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public void print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < adj.length; i++) {
            builder.append(i).append(" ==> ");
            for (Integer integer : adj[i]) {
                builder.append(integer).append(",");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
