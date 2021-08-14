package leetcode.leetcode5xx.leetcode547;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        int ans = 0, node;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                ans++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    node = queue.poll();
                    for (int j = i + 1; j < n; j++) {
                        if (!seen[j] && isConnected[node][j] == 1) {
                            seen[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
