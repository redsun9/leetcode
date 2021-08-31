package leetcode.leetcode8xx.leetcode854;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        return dfs(0, n, a, b);
    }

    private static int dfs(int start, int n, char[] a, char[] b) {
        for (int i = start; i < n; i++) {
            if (a[i] == b[i]) continue;
            List<Integer> matches = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                if (a[j] == b[i] && a[j] != b[j]) {
                    matches.add(j);
                    if (a[i] == b[j]) {
                        swap(a, i, j);
                        int ans = 1 + dfs(i + 1, n, a, b);
                        swap(a, i, j);
                        return ans;
                    }
                }
            }
            int best = n - start - 1;
            for (int j : matches) {
                swap(a, i, j);
                best = Math.min(best, 1 + dfs(i + 1, n, a, b));
                swap(a, i, j);
            }
            return best;
        }
        return 0;
    }

    private static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
