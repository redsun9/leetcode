package leetcode.leetcode18xx.leetcode1846;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];
        for (int a : arr) count[Math.min(a, n)]++;
        int ans = 0;
        int left = n;
        int credit = 0;
        while (left != 0 && left > credit) {
            ans++;
            left -= count[ans];
            int used = Math.min(credit, count[ans]);
            credit -= used;
            count[ans] -= used;
            if (count[ans] == 0) credit++;
        }
        return ans;
    }
}
