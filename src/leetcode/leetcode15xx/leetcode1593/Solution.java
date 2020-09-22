package leetcode.leetcode15xx.leetcode1593;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxUniqueSplit(String s) {
        return dfs(s, 0, s.length(), new HashSet<>());
    }

    private static int dfs(String s, int pos, int n, Set<String> set) {
        if (pos == n) return 0;
        int ans = -1;
        for (int i = pos + 1; i <= n; i++) {
            String str = s.substring(pos, i);
            if (set.add(str)) {
                int tmp = dfs(s, i, n, set);
                if (tmp > ans) ans = tmp;
                set.remove(str);
            }
        }
        return ans != -1 ? ans + 1 : -1;
    }
}
