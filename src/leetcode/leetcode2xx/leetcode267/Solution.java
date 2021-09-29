package leetcode.leetcode2xx.leetcode267;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;
        int countOdd = 0;

        char[] tmp = new char[n];
        for (int i = 0; i < 26; i++) {
            int c = count[i];
            if ((c & 1) == 1) {
                countOdd++;
                tmp[n / 2] = (char) ('a' + i);
            }
            count[i] >>>= 1;
        }
        if (countOdd >= 2) return Collections.emptyList();
        List<String> ans = new ArrayList<>();
        dfs(0, n - 1, tmp, count, ans);
        return ans;

    }

    private static void dfs(int i, int j, char[] tmp, int[] count, List<String> ans) {
        if (i >= j) ans.add(new String(tmp));
        else {
            for (int c = 0; c < 26; c++) {
                if (count[c] == 0) continue;
                count[c]--;
                tmp[i] = (char) ('a' + c);
                tmp[j] = (char) ('a' + c);
                dfs(i + 1, j - 1, tmp, count, ans);
                count[c]++;
            }
        }
    }
}
