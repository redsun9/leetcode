package leetcode.leetcode17xx.leetcode1764;

public class Solution {
    private static int[] kmp(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 1, len = 0; i < n; ) {
            if (arr[i] == arr[len]) {
                ans[i++] = ++len;
            } else if (len != 0) {
                len = ans[len - 1];
            } else {
                ans[i++] = 0;
            }
        }
        return ans;
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        int m = nums.length;
        for (int[] group : groups) {
            int n = group.length;
            if (n == 0) continue;
            int[] kmp = kmp(group);
            int j = 0;
            while (i < m && j < n) {
                if (nums[i] == group[j]) {
                    i++;
                    j++;
                } else {
                    if (j != 0) j = kmp[j - 1];
                    else i++;
                }
            }
            if (j < n) return false;
        }
        return true;
    }
}
