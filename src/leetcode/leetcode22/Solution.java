package leetcode.leetcode22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> ans = new LinkedList<>();
        generate(0, n, 0, 0, new char[2 * n], ans);
        return ans;
    }

    private static void generate(int i, int n, int opened, int closed, char[] tmp, LinkedList<String> ans) {
        if (i == 2 * n) {
            ans.add(new String(tmp));
        } else {
            if (opened < n) {
                tmp[i] = '(';
                generate(i + 1, n, opened + 1, closed, tmp, ans);
            }
            if (closed < opened) {
                tmp[i] = ')';
                generate(i + 1, n, opened, closed + 1, tmp, ans);
            }
        }
    }
}
