package leetcode.leetcode3xx.leetcode322;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        mirror(coins);
        int maxCoin = coins[0];

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[amount] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        pq.add(new int[]{amount, 0, (amount + maxCoin - 1) / maxCoin});
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int prevAmount = poll[0];
            int prevDist = poll[1];
            int prevEstimatedDist = poll[2];
            if (prevEstimatedDist >= ans) break; //pruning

            if (prevDist != dp[prevAmount]) continue;
            if (prevAmount == 0) {
                ans = Math.min(ans, prevDist);
                continue;
            }
            for (int coin : coins) {
                int nextAmount = prevAmount - coin;
                int nextEstimatedDist = prevDist + 1 + (nextAmount + maxCoin - 1) / maxCoin;
                if (nextEstimatedDist >= ans) break; //pruning
                if (nextAmount >= 0 && prevDist + 1 < dp[nextAmount]) {
                    dp[nextAmount] = prevDist + 1;
                    pq.add(new int[]{nextAmount, prevDist + 1, nextEstimatedDist});
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static void mirror(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
