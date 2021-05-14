package leetcode.leetcode8xx.leetcode816;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> f(String s, int l, int r) {
        List<String> ans = new ArrayList<>();
        if (s.charAt(l) == '0') {
            if (r - l == 1) ans.add(s.substring(l, r));
            else ans.add("0." + s.substring(l + 1, r));
        } else {
            ans.add(s.substring(l, r));
            if (r - l != 1 && s.charAt(r - 1) != '0') {
                for (int i = l + 1; i <= r - 1; i++) {
                    ans.add(s.substring(l, i) + "." + s.substring(i, r));
                }
            }
        }
        return ans;
    }

    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n - 2; i++) {
            if (
                    (s.charAt(1) != '0' || s.charAt(i - 1) != '0' || i == 2)
                            && (i == n - 2 || s.charAt(i) != '0' || s.charAt(n - 2) != '0')
            ) {
                List<String> l1 = f(s, 1, i);
                List<String> l2 = f(s, i, n - 1);
                for (String s1 : l1)
                    for (String s2 : l2)
                        ans.add("(" + s1 + ", " + s2 + ")");
            }
        }
        return ans;

    }
}
