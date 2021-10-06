package leetcode.leetcode3xx.leetcode311;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution2 {
    /**
     * @param a: a sparse matrix
     * @param b: a sparse matrix
     * @return the result of a * b
     */
    public int[][] multiply(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length, k = b.length;

        List<int[]>[] aNonZero = new List[k];
        for (int i = 0; i < k; i++) aNonZero[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] row = a[i];
            for (int j = 0; j < k; j++) if (row[j] != 0) aNonZero[j].add(new int[]{i, row[j]});
        }

        List<int[]>[] bNonZero = new List[k];
        for (int i = 0; i < k; i++) {
            List<int[]> list = new ArrayList<>();
            int[] row = b[i];
            for (int j = 0; j < n; j++) {
                if (row[j] != 0) list.add(new int[]{j, row[j]});
            }
            bNonZero[i] = list;
        }

        int[][] ans = new int[m][n];

        for (int i = 0; i < k; i++) {
            for (int[] an : aNonZero[i]) {
                for (int[] bn : bNonZero[i]) {
                    ans[an[0]][bn[0]] += an[1] * bn[1];
                }
            }
        }
        return ans;
    }
}
