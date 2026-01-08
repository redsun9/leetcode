package leetcode.leetcode36xx.leetcode3675;

public class Solution {
    public int minOperations(String s) {
        int minNotA = 26, n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (c != 0 && minNotA > c) minNotA = c;
        }
        return minNotA != 26 ? 26 - minNotA : 0;
    }
}
