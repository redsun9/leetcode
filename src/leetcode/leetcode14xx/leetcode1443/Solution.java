package leetcode.leetcode14xx.leetcode1443;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] neighbours = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            neighbours[edge[0]].add(edge[1]);
            neighbours[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return getPath(0, hasApple, neighbours, visited).path;
    }

    private static Pair getPath(int idx, List<Boolean> hasApple, List<Integer>[] neighbours, boolean[] visited) {
        visited[idx] = true;
        int path = 0;
        boolean apple = hasApple.get(idx);
        for (Integer neighbour : neighbours[idx]) {
            if (!visited[neighbour]) {
                Pair pair = getPath(neighbour, hasApple, neighbours, visited);
                apple |= pair.hasApple;
                if (pair.hasApple) path += pair.path + 2;
            }
        }
        return new Pair(apple, path);
    }

    private static class Pair {
        boolean hasApple;
        int path;

        public Pair(boolean hasApple, int path) {
            this.hasApple = hasApple;
            this.path = path;
        }
    }
}
