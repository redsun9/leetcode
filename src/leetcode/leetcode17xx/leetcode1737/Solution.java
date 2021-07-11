package leetcode.leetcode17xx.leetcode1737;

public class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length(), n = b.length();
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < m; i++) count1[a.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++) count2[b.charAt(i) - 'a']++;

        int ans = m + n, prefA = 0, prefB = 0;
        for (int i = 0; i < 26; i++) {
            //i is maximum for a
            if (i < 25) ans = Math.min(ans, m - prefA - count1[i] + prefB + count2[i]);

            //i is minimum for a
            if (i > 0) ans = Math.min(ans, prefA + n - prefB);

            //i is the only distinct letter
            ans = Math.min(ans, m + n - count1[i] - count2[i]);
            prefA += count1[i];
            prefB += count2[i];
        }
        return ans;
    }
}
