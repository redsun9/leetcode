package leetcode.leetcode22xx.leetcode2287;

public class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] count1 = new int[26], count2 = new int[26];
        int n1 = s.length(), n2 = target.length();
        for (int i = 0; i < n1; i++) count1[s.charAt(i) - 'a']++;
        for (int i = 0; i < n2; i++) count2[target.charAt(i) - 'a']++;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) if (count2[i] != 0) ans = Math.min(ans, count1[i] / count2[i]);
        return ans;
    }
}
