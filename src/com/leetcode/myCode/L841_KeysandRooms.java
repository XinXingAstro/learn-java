package com.leetcode.myCode;

import java.util.List;

public class L841_KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(visited, 0, rooms);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false)
                return false;
        }
        return true;
    }
    public void dfs(boolean[] visited, int node, List<List<Integer>> rooms) {
        if (visited[node] == true)
            return;

        visited[node] = true;

        for (Integer i : rooms.get(node)) {
            dfs(visited, i, rooms);
        }
    }
}
