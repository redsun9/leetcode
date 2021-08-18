package leetcode.leetcode7xx.leetcode712;

public class Solution2 {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int m = s1.length(), n = s2.length();

        int[] prev = new int[n + 1], next = new int[n + 1];

        for (int j = 0; j < n; j++) prev[j + 1] = prev[j] + s2.charAt(j);

        for (int i = 0; i < m; i++) {
            next[0] = prev[0] + s1.charAt(i);
            for (int j = 0; j < n; j++) {
                int c1 = s1.charAt(i), c2 = s2.charAt(j);
                if (c1 == c2) next[j + 1] = prev[j];
                else next[j + 1] = Math.min(c1 + prev[j + 1], c2 + next[j]);
            }
            int[] tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev[n];
    }
}
