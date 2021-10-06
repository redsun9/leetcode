package leetcode.leetcode3xx.leetcode311;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    /**
     * @param a: a sparse matrix
     * @param b: a sparse matrix
     * @return the result of a * b
     */
    public int[][] multiply(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length, k = b.length;
        List<int[]>[] aNonZero = new List[m];

        for (int i = 0; i < m; i++) {
            List<int[]> list = new ArrayList<>();
            int[] row = a[i];
            for (int j = 0; j < k; j++) if (row[j] != 0) list.add(new int[]{j, row[j]});
            if (!list.isEmpty()) aNonZero[i] = list;
        }

        List<int[]>[] bNonZero = new List[n];
        for (int j = 0; j < n; j++) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < k; i++) if (b[i][j] != 0) list.add(new int[]{i, b[i][j]});
            if (!list.isEmpty()) bNonZero[j] = list;
        }

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (aNonZero[i] == null) continue;
            for (int j = 0; j < n; j++) {
                if (bNonZero[j] == null) continue;
                int tmp = 0;
                Iterator<int[]> it1 = aNonZero[i].iterator();
                Iterator<int[]> it2 = bNonZero[j].iterator();

                int[] f1 = it1.next(), f2 = it2.next();
                while (true) {
                    if (f1[0] == f2[0]) {
                        tmp += f1[1] * f2[1];
                        if (!it1.hasNext() || !it2.hasNext()) break;
                        f1 = it1.next();
                        f2 = it2.next();
                    } else if (f1[0] > f2[0]) {
                        if (!it2.hasNext()) break;
                        f2 = it2.next();
                    } else {
                        if (!it1.hasNext()) break;
                        f1 = it1.next();
                    }
                }
                ans[i][j] = tmp;
            }
        }
        return ans;
    }
}
