package leetcode.leetcode7xx.leetcode786;

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int row = 0, col = n - 1;
        while (true) {
            int cnt = 0;
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j >= 0 && arr[i] * arr[n - 1 - col] > arr[n - 1 - j] * arr[row]) j--;
                cnt += (j + 1);
            }
            if (cnt == k) return new int[]{arr[row], arr[n - 1 - col]};
            if (cnt < k) row++;
            else col--;
        }
    }
}
