package leetcode.leetcode7xx.leetcode769;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int end = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, arr[i]);
            if (end == i) {
                ans++;
                end++;
            }
        }
        return ans;
    }
}
