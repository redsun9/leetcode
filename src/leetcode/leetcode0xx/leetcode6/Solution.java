package leetcode.leetcode0xx.leetcode6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length();
        char[] sChars = s.toCharArray();
        char[] aChars = new char[n];
        int mod = 2 * numRows - 2;
        int curPos = 0;
        for (int i = 0; i < n; i += mod) {
            aChars[curPos++] = sChars[i];
        }
        for (int curMod = 1; curMod < numRows - 1; curMod++) {
            int firstMod = curMod;
            int secMod = mod - curMod;
            while (secMod < n) {
                aChars[curPos++] = sChars[firstMod];
                aChars[curPos++] = sChars[secMod];
                firstMod += mod;
                secMod += mod;
            }
            if (firstMod < n) aChars[curPos++] = sChars[firstMod];
        }
        for (int i = numRows - 1; i < n; i += mod) {
            aChars[curPos++] = sChars[i];
        }
        return new String(aChars);
    }
}
