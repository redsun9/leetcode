package leetcode.leetcode17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final char[][] mappings = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        char[] chars = digits.toCharArray();
        int[] a = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            a[i] = chars[i] - '2';
        }
        LinkedList<String> ans = new LinkedList<>();
        combination(a, 0, chars, ans);
        return ans;

    }


    private static void combination(
            int[] a, int i, char[] tmp, LinkedList<String> ans
    ) {
        if (i == a.length) {
            ans.add(new String(tmp));
        } else {
            for (char c : mappings[a[i]]) {
                tmp[i] = c;
                combination(a, i + 1, tmp, ans);
            }
        }
    }
}
