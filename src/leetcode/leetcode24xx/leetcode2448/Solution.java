package leetcode.leetcode24xx.leetcode2448;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public long minCost(int[] nums, int[] costs) {
        long ans, sumLeft = 0, sumRight = 0, current = 0;
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = costs[i];
            sumRight += costs[i];
            current += (long) costs[i] * nums[i];
        }
        ans = current;
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        int prev = 0;
        for (int[] pair : arr) {
            // change meeting point from prev to pair[0]
            int num = pair[0];
            int cost = pair[1];
            int diff = num - prev;
            current -= diff * sumRight;
            current += diff * sumLeft;
            sumLeft += cost;
            sumRight -= cost;
            ans = Math.min(ans, current);
            prev = num;
        }
        return ans;
    }
}
