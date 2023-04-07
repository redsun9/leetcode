package help_requests.sum_after_removing_col_and_row;

public class Solution {
    public static long minSumAfter(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        if (m == 1 || n == 1) return 0;

        long[] hSum = new long[n];
        long total = 0;
        for (int[] row : arr) for (int j = 0; j < n; j++) hSum[j] += row[j];
        for (long s : hSum) total += s;

        long maxCut = 0;
        for (int[] row : arr) {
            long rowSum = 0;
            for (int a : row) rowSum += a;
            for (int j = 0; j < n; j++) maxCut = Math.max(maxCut, rowSum + hSum[j] - row[j]);
        }
        return total - maxCut;
    }
}
