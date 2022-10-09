package leetcode.leetcode24xx.leetcode2433;

public class Solution {
    public int[] findArray(int[] pref) {
        for (int i = pref.length - 1; i > 0; i--) pref[i] ^= pref[i - 1];
        return pref;
    }
}
