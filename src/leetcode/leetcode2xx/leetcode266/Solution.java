package leetcode.leetcode2xx.leetcode266;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;
        int ans = 0;
        for (int c : count) ans += c & 1;
        return ans <= 1;
    }
}
