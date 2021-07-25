package leetcode.leetcode19xx.leetcode1941;

public class Solution {
    public boolean areOccurrencesEqual(String s) {
        int n = s.length();
        int[] count = new int[26];
        int distinct = 0;
        for (int i = 0; i < n; i++) if (count[s.charAt(i) - 'a']++ == 0) distinct++;
        if (distinct == 1) return true;
        if (n % distinct != 0) return false;
        int m = n / distinct;
        for (int i = 0; i < 26; i++) if (count[i] != 0 && count[i] != m) return false;
        return true;
    }
}
