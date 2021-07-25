package leetcode.leetcode19xx.leetcode1944;

import java.util.ArrayDeque;

public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (!q.isEmpty() && heights[q.peekLast()] <= height) ans[q.pollLast()]++;
            if (!q.isEmpty()) ans[q.peekLast()]++;
            q.addLast(i);
        }
        return ans;
    }
}
