package leetcode.leetcode4xx.leetcode464;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        int totalPositions = 1 << maxChoosableInteger;
        int[] dp = new int[totalPositions];
        int[] indegree = new int[totalPositions];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < totalPositions; i++) {
            int bitCount = Integer.bitCount(i);
            indegree[i] = maxChoosableInteger - bitCount;
            int s = 0;
            for (int j = 0; j < maxChoosableInteger; j++) if ((i & (1 << j)) != 0) s += (j + 1);
            if (s >= desiredTotal) {
                dp[i] = 2 - (bitCount & 1);
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int turn = 1 + (Integer.bitCount(poll) & 1);
            int result = dp[poll];
            if (turn == 1) {
                for (int i = 0; i < maxChoosableInteger; i++) {
                    int from = poll ^ (1 << i);
                    if ((poll & (1 << i)) != 0 && dp[from] == 0) {
                        if (result == 2) dp[from] = 2;
                        else if (--indegree[from] == 0) dp[from] = 1;
                        if (dp[from] != 0) queue.offer(from);
                    }
                }
            } else {
                for (int i = 0; i < maxChoosableInteger; i++) {
                    int from = poll ^ (1 << i);
                    if ((poll & (1 << i)) != 0 && dp[from] == 0) {
                        if (result == 1) dp[from] = 1;
                        else if (--indegree[from] == 0) dp[from] = 2;
                        if (dp[from] != 0) queue.offer(from);
                    }
                }
            }
        }
        return dp[0] == 1;
    }
}
