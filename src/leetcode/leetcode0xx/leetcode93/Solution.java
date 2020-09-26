package leetcode.leetcode0xx.leetcode93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        int n = s.length();
        if (n < 4 || n > 12) return ans;
        for (int l1 = 1; l1 < 4; l1++) {
            if (n - l1 < 3 || !check(s, 0, l1)) continue;
            for (int l2 = 1; l2 < 4; l2++) {
                int l12 = l1 + l2;
                if (n - l12 < 2 || !check(s, l1, l12)) continue;
                for (int l3 = 1; l3 < 4; l3++) {
                    int l123 = l12 + l3;
                    if (n - l123 >= 1 && n - l123 <= 3 && check(s, l12, l123) && check(s, l123, n)) {
                        ans.add(s.substring(0, l1) + "." + s.substring(l1, l12) + "." + s.substring(l12, l123) + "." + s.substring(l123));
                    }
                }
            }
        }
        return ans;
    }

    boolean check(String s, int start, int end) {
        return (end - start == 1 || s.charAt(start) != '0') &&
                (end - start < 3 || Integer.parseInt(s, start, end, 10) <= 255);
    }
}
