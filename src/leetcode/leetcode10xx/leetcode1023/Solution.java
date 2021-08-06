package leetcode.leetcode10xx.leetcode1023;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        int m = pattern.length();
        for (String query : queries) {
            int n = query.length();
            boolean ok = true;
            int i = 0, j = 0;
            while (ok && i < n && j < m) {
                char c1 = query.charAt(i++);
                char c2 = pattern.charAt(j++);
                if (c1 != c2) {
                    ok = c1 >= 'a' && c1 <= 'z';
                    j--;
                }
            }
            ok &= j == m;
            while (ok && i < n) {
                char c1 = query.charAt(i++);
                ok = c1 >= 'a' && c1 <= 'z';
            }
            ans.add(ok);
        }
        return ans;
    }
}
