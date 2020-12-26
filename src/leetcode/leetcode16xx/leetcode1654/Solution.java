package leetcode.leetcode16xx.leetcode1654;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int maxPos = 6000;
        int[][] dp = new int[2][maxPos];
        for (int i : forbidden) {
            dp[0][i] = -1;
            dp[1][i] = -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int fromDirection = node[0];
            int curPos = node[1];
            if (curPos == x) return dp[fromDirection][curPos];
            int nextVal = dp[fromDirection][curPos] + 1;
            int nextPos = curPos + a;
            if (nextPos < maxPos && dp[0][nextPos] != -1) {
                if (dp[0][nextPos] == 0 || dp[0][nextPos] > nextVal) {
                    dp[0][nextPos] = nextVal;
                    queue.offer(new int[]{0, nextPos});
                }
            }
            nextPos = curPos - b;
            if (fromDirection == 0 && nextPos > 0 && dp[1][nextPos] != -1) {
                if (dp[1][nextPos] == 0 || dp[1][nextPos] > nextVal) {
                    dp[1][nextPos] = nextVal;
                    queue.offer(new int[]{1, nextPos});
                }
            }
        }
        return -1;
    }
}
