package leetcode.leetcode8xx.leetcode832;

public class Solution {
    public int[][] flipAndInvertImage(int[][] a) {
        int n = a.length;
        for (int[] arr : a) {
            for (int i = 0, j = n - 1; i <= j; i++, j--) {
                int tmp = 1 - arr[i];
                arr[i] = 1 - arr[j];
                arr[j] = tmp;
            }
        }
        return a;
    }
}
