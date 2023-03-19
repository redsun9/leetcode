package leetcode.leetcode25xx.leetcode2531;

public class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = count(word1), cnt2 = count(word2);
        int distinct1 = 0, distinct2 = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != 0) distinct1++;
            if (cnt2[i] != 0) distinct2++;
        }
        int diff = distinct1 - distinct2;
        if (Math.abs(diff) > 2) return false;
        for (int a = 0; a < 26; a++) {
            if (cnt1[a] == 0) continue;
            for (int b = 0; b < 26; b++) {
                if (cnt2[b] == 0) continue;
                if (a == b) {
                    if (diff == 0) return true;
                } else {
                    int tmpDiff = diff;
                    if (cnt1[a] == 1) tmpDiff--;
                    if (cnt1[b] == 0) tmpDiff++;
                    if (cnt2[b] == 1) tmpDiff++;
                    if (cnt2[a] == 0) tmpDiff--;
                    if (tmpDiff == 0) return true;
                }
            }
        }
        return false;
    }

    private static int[] count(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a']++;
        return cnt;
    }
}
