package leetcode.leetcode3xx.leetcode363;

import java.util.TreeSet;


// O(min(m,n)^2 * max(m,n)*log(max(m,n))
public class Solution {
    public int maxSumSubmatrix(int[][] t, int k) {
        int m = t.length;
        int n = t[0].length;
        int[][] a = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i + 1][j + 1] = a[i + 1][j] + a[i][j + 1] - a[i][j] + t[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        if (m <= n) {
            for (int endM = 1; endM <= m; endM++) {
                for (int startM = 0; startM < endM; startM++) {
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    for (int endN = 1; endN <= n; endN++) {
                        int val = a[endM][endN] - a[startM][endN];
                        Integer floor = set.ceiling(val - k);
                        if (floor != null) {
                            int tmp = val - floor;
                            if (tmp == k) return k;
                            ans = Math.max(ans, tmp);
                        }
                        set.add(val);
                    }
                }
            }
        } else {
            for (int endN = 1; endN <= n; endN++) {
                for (int startN = 0; startN < endN; startN++) {
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    for (int endM = 1; endM <= m; endM++) {
                        int val = a[endM][endN] - a[endM][startN];
                        Integer floor = set.ceiling(val - k);
                        if (floor != null) {
                            int tmp = val - floor;
                            if (tmp == k) return k;
                            ans = Math.max(ans, tmp);
                        }
                        set.add(val);
                    }
                }
            }
        }
        return ans;
    }
}
