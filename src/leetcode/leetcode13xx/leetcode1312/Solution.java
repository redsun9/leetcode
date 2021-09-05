package leetcode.leetcode13xx.leetcode1312;

public class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char[] a = s.toCharArray();

        int[] prev = new int[n + 1], next = new int[n + 1], tmp;
        for (int l = 0; l < n; l++) {
            for (int i = 0, r = n - 1; i < n; i++, r--)
                next[i + 1] = a[l] == a[r] ? prev[i] + 1 : Math.max(prev[i + 1], next[i]);
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return n - prev[n];
    }
}
