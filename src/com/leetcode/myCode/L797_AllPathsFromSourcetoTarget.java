package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L797_AllPathsFromSourcetoTarget {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0)
            return res;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        DFS(graph, 0, path);
        return res;
    }
    public void DFS(int[][] graph, int node, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            DFS(graph, nextNode, path);
            path.remove(path.size() - 1);
        }
    }
}
