package leetcode.leetcode12xx.leetcode1252;

public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] countN = new int[n];
        int[] countM = new int[m];
        int oddN = 0;
        int oddM = 0;
        for (int[] index : indices) {
            oddN += 1 - 2 * (countN[index[0]]++ % 2);
            oddM += 1 - 2 * (countM[index[1]]++ % 2);
        }
        return oddN * (m - oddM) + oddM * (n - oddN);
    }
}
