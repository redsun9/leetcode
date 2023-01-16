package help_requests.max_walking_odd_sum;

import java.util.Arrays;

public class Solution {
    public static long maxOddSum(int[][] mat) {
        int n = mat[0].length;
        long[][] prev = new long[2][n], next = new long[2][n], tmp;
        Arrays.fill(prev[1], Long.MIN_VALUE);
        for (int[] row : mat) {
            Arrays.fill(next[0], Long.MIN_VALUE);
            Arrays.fill(next[1], Long.MIN_VALUE);
            for (int from = 0; from < n; from++) {
                for (int d = -1, to = from + d; d <= 1; d++, to++) {
                    if (to < 0 || to >= n) continue;
                    for (int oddityFrom = 0; oddityFrom <= 1; oddityFrom++) {
                        long sum = prev[oddityFrom][from] + row[to];
                        int oddityTo = (int) (sum & 1);
                        next[oddityTo][to] = Math.max(next[oddityTo][to], sum);
                    }
                }
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        long max = Long.MIN_VALUE;
        for (long val : prev[1]) max = Math.max(max, val);
        return max;
    }
}
