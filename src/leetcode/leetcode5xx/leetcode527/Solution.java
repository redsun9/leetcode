package leetcode.leetcode5xx.leetcode527;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * @param dict: an array of n distinct non-empty strings
     * @return an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        int n = dict.length;
        String[] ans = new String[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.computeIfAbsent(dict[i].length(), ArrayList::new).add(i);
        map.forEach((m, list) -> solve(dict, ans, m, list));
        return ans;
    }

    private static void solve(
            String[] dict, String[] ans,
            int m, List<Integer> indices
    ) {
        int n = indices.size();
        if (m <= 3) for (Integer index : indices) ans[index] = dict[index];
        else if (n == 1) {
            Integer idx = indices.get(0);
            String word = dict[idx];
            ans[idx] = word.charAt(0) + Integer.toString(m - 2) + word.charAt(m - 1);
        } else {
            int maxNeeded = m * n + 1;
            int[][] child = new int[maxNeeded][26];
            int[] cnt = new int[maxNeeded];
            int nxt = 1, node, c;

            for (Integer idx : indices) {
                String str = dict[idx];
                node = 0;

                c = str.charAt(0) - 'a';
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
                cnt[node]++;

                c = str.charAt(m - 1) - 'a';
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
                cnt[node]++;

                for (int i = 1; i < m - 1; i++) {
                    c = str.charAt(i) - 'a';
                    if (child[node][c] == 0) child[node][c] = nxt++;
                    node = child[node][c];
                    cnt[node]++;
                }
            }

            for (Integer idx : indices) {
                String str = dict[idx];
                node = child[0][str.charAt(0) - 'a'];
                node = child[node][str.charAt(m - 1) - 'a'];

                int i = 1;
                while (cnt[node] != 1) node = child[node][str.charAt(i++) - 'a'];

                if (i >= m - 2) ans[idx] = str;
                else ans[idx] = str.substring(0, i) + (m - 1 - i) + str.charAt(m - 1);
            }
        }
    }
}
