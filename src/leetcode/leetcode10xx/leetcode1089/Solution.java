package leetcode.leetcode10xx.leetcode1089;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[i] == 0) j += 2;
            else j += 1;
            i++;
        }
        if (j == n + 1) {
            arr[n - 1] = 0;
            j = n - 1;
            i -= 1;
        }
        while (i > 0) {
            i--;
            if (arr[i] == 0) {
                arr[--j] = 0;
                arr[--j] = 0;
            } else {
                arr[--j] = arr[i];
            }
        }
    }
}
