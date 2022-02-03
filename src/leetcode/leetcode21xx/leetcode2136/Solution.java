package leetcode.leetcode21xx.leetcode2136;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = growTime[i];
            arr[i][1] = plantTime[i];
        }
        Arrays.sort(arr, Comparator.comparingInt((int[] x) -> x[0]).thenComparing(x -> x[1]));
        int ans = 0;
        for (int[] plant : arr) ans = Math.max(ans, plant[0]) + plant[1];
        return ans;
    }
}
