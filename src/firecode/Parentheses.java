package firecode;

import java.util.ArrayList;

public class Parentheses {
    public static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> ans = new ArrayList<>();
        if (pairs < 0) return ans;
        char[] tmp = new char[pairs * 2];
        dfs(tmp, 0, 0, pairs, ans);
        return ans;
    }

    private static void dfs(char[] tmp, int open, int closed, int pairs, ArrayList<String> ans) {
        if (closed == pairs) {
            ans.add(new String(tmp));
        } else {
            if (open < pairs) {
                tmp[open + closed] = '(';
                dfs(tmp, open + 1, closed, pairs, ans);
            }
            if (open > closed) {
                tmp[open + closed] = ')';
                dfs(tmp, open, closed + 1, pairs, ans);
            }
        }
    }
}
