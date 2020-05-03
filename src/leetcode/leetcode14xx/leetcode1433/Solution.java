package leetcode.leetcode14xx.leetcode1433;

public class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] a = new int[26], b = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            b[c - 'a']++;
        }
        return checkIfCanBreak(a, b) || checkIfCanBreak(b, a);
    }

    private static boolean checkIfCanBreak(int[] a, int[] b) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 26; i++) {
            sum1 += a[i];
            sum2 += b[i];
            if (sum2 > sum1) return false;
        }
        return true;
    }
}