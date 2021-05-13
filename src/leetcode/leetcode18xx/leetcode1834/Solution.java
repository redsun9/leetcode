package leetcode.leetcode18xx.leetcode1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = tasks[i][0];
            arr[i][2] = tasks[i][1];
        }
        Arrays.sort(arr, Comparator.comparingInt(x -> x[1]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt((int[] x) -> x[2]).thenComparingInt(x -> x[0]));
        int[] ans = new int[n];
        int currentTime = 0;
        int pos1 = 0;
        int pos2 = 0;
        while (pos2 < n) {
            if (pq2.isEmpty()) currentTime = Math.max(currentTime, arr[pos1][1]);
            while (pos1 < n && arr[pos1][1] <= currentTime) pq2.offer(arr[pos1++]);
            int[] task = pq2.poll();
            ans[pos2++] = task[0];
            currentTime += task[2];
        }
        return ans;
    }
}
