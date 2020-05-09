package leetcode.leetcode13xx.leetcode1347;

public class Solution {
    public int minSteps(String s, String t) {
        int[] count1 = new int[26];
        for (char c : s.toCharArray()) {
            count1[c - 'a']++;
        }
        int[] count2 = new int[26];
        for (char c : t.toCharArray()) {
            count2[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(count1[i] - count2[i]);
        }
        return diff / 2;
    }
}
