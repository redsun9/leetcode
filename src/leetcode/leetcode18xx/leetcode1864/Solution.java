package leetcode.leetcode18xx.leetcode1864;

public class Solution {
    public int minSwaps(String s) {
        int[] count = new int[2];
        int count010 = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            count[c]++;
            count010 += (i + c) % 2;
        }
        if (Math.abs(count[0] - count[1]) >= 2) return -1;
        if (n % 2 == 0) return Math.min(count010, n - count010) / 2;
        if (count[0] > count[1]) return count010 / 2;
        else return (n - count010) / 2;
    }
}
