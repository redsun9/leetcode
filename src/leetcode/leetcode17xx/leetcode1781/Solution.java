package leetcode.leetcode17xx.leetcode1781;

public class Solution {
    public static final int MAX_LENGTH = 500;

    private static int beautySum(String s, int start, int end) {
        int ans = 0;
        int[] cnt = new int[26];
        cnt[s.charAt(start) - 'a'] = 1;
        int[] cntCnt = new int[MAX_LENGTH + 1];
        cntCnt[1] = 1;
        int maxCnt = 1;
        int minCnt = 1;
        int minCntCnt = 1;
        for (int i = start + 1; i < end; i++) {
            int c = s.charAt(i) - 'a';
            int charCnt = ++cnt[c];
            maxCnt = Math.max(maxCnt, cnt[c]);
            cntCnt[charCnt]++;
            cntCnt[charCnt - 1]--;
            if (charCnt == minCnt) minCntCnt++;
            else if (charCnt < minCnt) {
                minCnt = 1;
                minCntCnt = 1;
            } else if (charCnt == minCnt + 1) {
                if (--minCntCnt == 0) minCntCnt = cntCnt[++minCnt];
            }
            ans += maxCnt - minCnt;
        }
        return ans;
    }

    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            ans += beautySum(s, i, n);
        }
        return ans;
    }
}
