package leetcode.leetcode13xx.leetcode1389;

public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = i;
        }
        helper(a, 0, n, index, new int[n]);
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[index[i]] = nums[i];
        }
        return result;
    }

    static void helper(int[] a, int i, int j, int[] index, int[] tmp) {
        if (j - i <= 1) {
            return;
        }
        int k = (i + j) >>> 1;
        helper(a, i, k, index, tmp);
        helper(a, k, j, index, tmp);
        int x = i;
        int y = k;
        int z = 0;
        int count = 0;
        while (x < k && y < j) {
            while (y < j && index[a[y]] <= index[a[x]] + count) {
                ++count;
                tmp[z++] = a[y++];
            }
            index[a[x]] += count;
            tmp[z++] = a[x++];
        }
        while (x < k) {
            index[a[x]] += count;
            tmp[z++] = a[x++];
        }
        while (y < j) {
            tmp[z++] = a[y++];
        }
        for (int p = i, q = 0; p < j; ++p, ++q) {
            a[p] = tmp[q];
        }
    }
}
