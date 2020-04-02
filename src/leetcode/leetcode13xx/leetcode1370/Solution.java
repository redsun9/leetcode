package leetcode.leetcode13xx.leetcode1370;

public class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int n = s.length();

        int[] next = new int[53];
        int[] index = new int[53];
        for (int i = 0; i < 51; i++) {
            next[i] = i + 1;
        }
        for (int i = 0; i < 26; i++) {
            index[i] = i;
            index[51 - i] = i;
        }

        char[] ans = new char[n];
        int current = 52;
        int i = 0;
        while (i < n) {
            int tmp = next[current];
            while (count[index[tmp]] == 0) {
                tmp = next[tmp];
            }
            next[current] = tmp;
            current = next[current];
            ans[i] = (char) ('a' + index[current]);
            count[index[current]]--;
            i++;
        }
        return new String(ans);
    }
}
