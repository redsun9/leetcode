package leetcode.leetcode8xx.leetcode845;

public class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 1, l = 0, m = 0, r = 0; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                l = i;
                m = i;
                r = i;
            } else if (arr[i] > arr[i - 1]) {
                l = r;
                m = i;
            } else {
                r = i;
                if (l != m) ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
