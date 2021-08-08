package leetcode.leetcode19xx.leetcode1964;

public class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        for (int i = 0, max = 0; i < n; i++) {
            int v = obstacles[i];
            int lo = 0, hi = max;
            while (lo != hi) {
                int mid = lo + (hi - lo) / 2;
                if (obstacles[mid] <= v) lo = mid + 1;
                else hi = mid;
            }
            obstacles[lo] = v;
            if (lo == max) max++;
            ans[i] = lo + 1;
        }
        return ans;
    }
}
