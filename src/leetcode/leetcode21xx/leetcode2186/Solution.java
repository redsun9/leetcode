package leetcode.leetcode21xx.leetcode2186;

public class Solution {
    public int minSteps(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < n1; i++) count1[s.charAt(i) - 'a']++;
        for (int i = 0; i < n2; i++) count2[t.charAt(i) - 'a']++;
        int ans = 0;
        for (int i = 0; i < 26; i++) ans += Math.abs(count1[i] - count2[i]);
        return ans;
    }
}
