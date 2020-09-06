package leetcode.leetcode15xx.leetcode1574;

public class Solution {
    public int findLengthOfShortestSubarray(int[] a) {
        int n = a.length;
        int j = n - 1;
        while (j > 0 && a[j - 1] <= a[j]) j--;
        if (j == 0) return 0;
        int ans = j;
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i - 1] > a[i]) break;
            while (j < n && a[i] > a[j]) j++;
            ans = Math.min(ans, j - i - 1);
        }
        return ans;
    }
}
