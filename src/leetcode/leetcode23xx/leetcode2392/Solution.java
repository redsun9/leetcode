package leetcode.leetcode23xx.leetcode2392;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rows = new int[k], cols = new int[k];
        int[] indegree = new int[k];
        List<Integer>[] outEdges = new List[k];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int[] rowCondition : rowConditions) {
            int u = rowCondition[0] - 1, v = rowCondition[1] - 1;
            indegree[v]++;
            if (outEdges[u] == null) outEdges[u] = new ArrayList<>();
            outEdges[u].add(v);
        }
        for (int i = 0; i < k; i++) if (indegree[i] == 0) queue.offer(i);

        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            rows[u] = idx++;
            if (outEdges[u] == null) continue;
            for (Integer v : outEdges[u]) if (--indegree[v] == 0) queue.offer(v);
            outEdges[u] = null;
        }
        if (idx != k) return new int[0][0];

        //all indegree = 0, all outEdges = null, queue is empty
        for (int[] colCondition : colConditions) {
            int u = colCondition[0] - 1, v = colCondition[1] - 1;
            indegree[v]++;
            if (outEdges[u] == null) outEdges[u] = new ArrayList<>();
            outEdges[u].add(v);
        }
        for (int i = 0; i < k; i++) if (indegree[i] == 0) queue.offer(i);

        idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            cols[u] = idx++;
            if (outEdges[u] == null) continue;
            for (Integer v : outEdges[u]) if (--indegree[v] == 0) queue.offer(v);
            outEdges[u] = null;
        }
        if (idx != k) return new int[0][0];

        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++) ans[rows[i]][cols[i]] = i + 1;
        return ans;
    }
}
