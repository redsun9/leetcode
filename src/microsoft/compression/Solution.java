package microsoft.compression;

import java.util.Set;

public class Solution {
    public int solution(String s, int k) {
        Set<Integer> tens = Set.of(2, 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000);
        int n = s.length();
        if (n - k <= 1) return n - k;

        int[] leftGroupLen = new int[n];
        int[] leftCompress = new int[n + 1];
        char prevChar = s.charAt(0);
        int curGroupLen = 0;
        int curCompressionLen = 1;
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            if (curChar == prevChar) {
                curGroupLen++;
                if (tens.contains(curGroupLen)) curCompressionLen++;
            } else {
                curGroupLen = 1;
                curCompressionLen++;
            }
            prevChar = curChar;
            leftGroupLen[i] = curGroupLen;
            leftCompress[i + 1] = curCompressionLen;
        }

        int[] rightGroupLen = new int[n];
        int[] rightCompress = new int[n + 1];
        prevChar = s.charAt(n - 1);
        curGroupLen = 0;
        curCompressionLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            char curChar = s.charAt(i);
            if (curChar == prevChar) {
                curGroupLen++;
                if (tens.contains(curGroupLen)) curCompressionLen++;
            } else {
                curGroupLen = 1;
                curCompressionLen++;
            }
            prevChar = curChar;
            rightGroupLen[i] = curGroupLen;
            rightCompress[i] = curCompressionLen;
        }

        int ans = n - k;
        for (int l = 0, r = k; r <= n; l++, r++) {
            int tmp = leftCompress[l] + rightCompress[r];
            if (l != 0 && r != n && s.charAt(l - 1) == s.charAt(r)) {
                int lg = leftGroupLen[l - 1];
                int rg = rightGroupLen[r];
                tmp--; //same chars
                if (lg != 1) tmp -= 1 + (int) Math.log10(lg);
                if (rg != 1) tmp -= 1 + (int) Math.log10(rg);
                tmp += 1 + (int) Math.log10(lg + rg);
            }
            ans = Math.min(ans, tmp);
        }
        return ans;
    }
}
